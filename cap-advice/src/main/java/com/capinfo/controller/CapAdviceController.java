package com.capinfo.controller;


import com.capinfo.base.BaseController;
import com.capinfo.entity.CapAdvice;
import com.capinfo.entity.CapAdviceDeal;
import com.capinfo.exception.MyException;
import com.capinfo.service.CapAdviceDealService;
import com.capinfo.service.CapAdviceService;
import com.capinfo.util.BeanUtil;
import com.capinfo.util.JsonUtil;
import com.capinfo.util.ReType;
import com.capinfo.util.UploadUtil;
import com.capinfo.utils.AdviceConstant;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/advice")
public class CapAdviceController extends BaseController {

    @Autowired
    private CapAdviceService capAdviceService;
    @Autowired
    private CapAdviceDealService capAdviceDealService;
    @Autowired
    UploadUtil uploadUtil;



    @GetMapping(value = "tsAdvice")
    @RequiresPermissions("advice:show")
    public String tsAdvice(Model model) {
        return "/system/advice/adviceList";
    }


    /**
     * 举报问题的查询方法。页面上加载列表的时候加入type条件
     * @param model
     * @return
     */
    @GetMapping(value = "dealProblem")
    @RequiresPermissions("advice:show")
    public String dealProblem(Model model) {
        //type:1举报问题    2：意见建议
        model.addAttribute("type", "1");
        return "/system/advice/adviceList";
    }


    /**
     * 意见建议的查询方法。页面上加载列表的时候加入type条件
     * @param model
     * @return
     */
    @GetMapping(value = "dealAdvice")
    @RequiresPermissions("advice:show")
    public String dealAdvice(Model model) {
        //type:1举报问题    2：意见建议
        model.addAttribute("type", "2");
        return "/system/advice/adviceList";
    }


    /**
     * 意见列表list的接口
     * @param capAdvice
     * @param model
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "/showAdviceList", httpMethod = "GET", notes = "意见列表")
    @GetMapping(value = "showAdviceList")
    @ResponseBody
    @RequiresPermissions("advice:show")
    public ReType showAdviceList(CapAdvice capAdvice, Model model, String page, String limit) {
        return capAdviceService.show(capAdvice, Integer.valueOf(page), Integer.valueOf(limit));
    }


    /**
     * 跳转到添加意见页面
     * @param model
     * @return
     */
    @GetMapping(value = "showAddAdvice")
    public String goAddAdvice(Model model) {
        /*JSONArray jsonArray = menuService.getTreeUtil(null);
        model.addAttribute("menus", jsonArray.toJSONString());*/
        return "/system/advice/add-advice";
    }


    /**
     * 保存insert意见
     * @param capAdvice
     * @return
     */
    @ApiOperation(value = "/addAdvice", httpMethod = "POST", notes = "添加意见")
    @PostMapping(value = "addAdvice")
    @ResponseBody
    public JsonUtil addAdvice(CapAdvice capAdvice) {
        if (StringUtils.isEmpty(capAdvice.getTitle())) {
            JsonUtil.error("标题不能为空");
        }
        JsonUtil j = new JsonUtil();
        try {
            capAdviceService.insertSelective(capAdvice);
            j.setMsg("保存成功");
        } catch (MyException e) {
            j.setMsg("保存失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }


    /**
     * 修改意见的页面跳转。举报问题和意见建议到两个页面
     * @param id
     * @param model
     * @param detail
     * @return
     */
    @GetMapping(value = "updateAdvice")
    public String updateAdvice(String id, Model model, boolean detail) {
        CapAdvice capAdvice = capAdviceService.selectByPrimaryKey(id);
        model.addAttribute("capAdvice", capAdvice);
        model.addAttribute("detail", detail);
        if ("1".equals(capAdvice.getType())) {
            return "system/advice/update-problem";
        } else if ("2".equals(capAdvice.getType())) {
            return "system/advice/update-advice";
        }
        return "system/advice/update-advice";
    }


    /**
     * 意见处理情况list的接口
     * @param capAdvice
     * @param request
     * @param model
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "/showAdviceDealList", httpMethod = "GET", notes = "意见处理列表")
    @GetMapping(value = "showAdviceDealList")
    @ResponseBody
    @RequiresPermissions("advice:show")
    public ReType showAdviceDealList(CapAdvice capAdvice, HttpServletRequest request, Model model, String page, String limit) {
        String adviceId = request.getParameter("adviceId");
        CapAdviceDeal deal = new CapAdviceDeal();
        deal.setCapAdviceId(adviceId);
        return capAdviceDealService.show(deal, Integer.valueOf(page), Integer.valueOf(limit));
    }

    /**
     * 处理情况添加的页面
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = "showAddDeal")
    public String showAddDeal(HttpServletRequest request, Model model) {
        CapAdviceDeal capAdviceDeal = new CapAdviceDeal();
        capAdviceDeal.setCapAdviceId(request.getParameter("adviceId"));
        model.addAttribute("capAdviceDeal", capAdviceDeal);
        return "system/advice/advice-deal/update-advicedeal";
    }


    /**
     * 保存意见处理情况
     * @param capAdviceDeal
     * @return
     */
    @ApiOperation(value = "/saveDeal", httpMethod = "POST", notes = "更新意见处理")
    @PostMapping(value = "saveDeal")
    @ResponseBody
    public JsonUtil saveDeal(CapAdviceDeal capAdviceDeal) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (capAdviceDeal == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            capAdviceDealService.saveDeal(capAdviceDeal);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (Exception e) {
            jsonUtil.setMsg("修改失败");
            e.printStackTrace();
        }
        return jsonUtil;
    }


    /**
     * 意见处理     修改、查看的跳转页面
     * @param id
     * @param model
     * @param detail
     * @return
     */
    @GetMapping(value = "showUpdateDeal")
    public String showUpdateDeal(String id, Model model, boolean detail) {
        CapAdviceDeal capAdviceDeal = capAdviceDealService.selectByPrimaryKey(id);
        model.addAttribute("capAdviceDeal", capAdviceDeal);
        model.addAttribute("detail", detail);
        return "system/advice/advice-deal/update-advicedeal";
    }


    /**
     * 修改的接口
     * @param
     * @return
     */
    /*@ApiOperation(value = "/updateAdvice", httpMethod = "POST", notes = "更新意见")
    @PostMapping(value = "updateAdvice")
    @ResponseBody
    public JsonUtil updateAdvice(CapAdvice capAdvice) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (capAdvice == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            CapAdvice oldCapAdvice = capAdviceService.selectByPrimaryKey(capAdvice.getId());
            BeanUtil.copyNotNullBean(capAdvice, oldCapAdvice);
            capAdviceService.updateByPrimaryKeySelective(oldCapAdvice);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (MyException e) {
            jsonUtil.setMsg("修改失败");
            e.printStackTrace();
        }
        return jsonUtil;
    }*/

    /**
     * 修改   status暂定    举报问题里的2已结案      意见建议里的3已回复
     * @param capAdvice
     * @return
     */
    @PostMapping(value = "updateAdvice")
    public String updateAdvice(CapAdvice capAdvice) {
        CapAdvice oldCapAdvice = capAdviceService.selectByPrimaryKey(capAdvice.getId());
        BeanUtil.copyNotNullBean(capAdvice, oldCapAdvice);
        if ("1".equals(oldCapAdvice.getType())) {
            oldCapAdvice.setStatus(AdviceConstant.ADVICE_STATUS_FINISH);
            capAdviceService.updateByPrimaryKeySelective(oldCapAdvice);
            return "redirect:dealProblem";
        } else {
            oldCapAdvice.setStatus(AdviceConstant.ADVICE_STATUS_REPLY);
            capAdviceService.updateByPrimaryKeySelective(oldCapAdvice);
            return "redirect:dealAdvice";
        }
    }

    /**
     * 举报问题的提交按钮跳转。不知道为啥页面里面带表格，最外层用form标签就有问题了。
     * 暂时这样需要显示table的form页面提交只改一个状态，直接这样跳转
     * @param id
     * @return
     */
    @RequestMapping(value = "updateProblemSubmit")
    public String updateProblemSubmit(String id) {
        CapAdvice oldCapAdvice = capAdviceService.selectByPrimaryKey(id);
        oldCapAdvice.setStatus("2");
        capAdviceService.updateByPrimaryKeySelective(oldCapAdvice);
        return "redirect:dealProblem";
    }


    @ApiOperation(value = "/checkDealBeforeProblemSubmit", httpMethod = "GET", notes = "验证处理情况信息")
    @GetMapping(value = "checkDealBeforeProblemSubmit")
    @ResponseBody
    public JsonUtil checkDealBeforeProblemSubmit(String id) {
        if (StringUtils.isEmpty(id)) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        CapAdviceDeal deal = new CapAdviceDeal();
        deal.setCapAdviceId(id);
        List<CapAdviceDeal> allList = capAdviceDealService.selectByCondition(deal);
        CapAdviceDeal finishDeal = new CapAdviceDeal();
        finishDeal.setCapAdviceId(id);
        finishDeal.setStatus("2");
        List<CapAdviceDeal> finishList = capAdviceDealService.selectByCondition(finishDeal);
        if (finishList.size() == allList.size() && finishList.size() != 0) {
            j.setFlag(true);
            j.setMsg("全部处理情况处理完成");
        } else {
            j.setFlag(false);
            if (allList.size() == 0) {
                j.setMsg("未添加处理情况");
            } else {
                j.setMsg("请确认是否已提交全部处理情况");
            }
        }
        return j;
    }






    /**
     * 删除处理情况的接口
     * @param id
     * @return
     */
    @ApiOperation(value = "/delAdviceDeal", httpMethod = "POST", notes = "删除意见处理信息")
    @PostMapping(value = "delAdviceDeal")
    @ResponseBody
    @RequiresPermissions("advice:del")
    public JsonUtil delAdviceDeal(String id) {
        if (StringUtils.isEmpty(id)) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        try {
            capAdviceDealService.deleteByPrimaryKey(id);
            j.setMsg("删除成功");
        } catch (MyException e) {
            j.setMsg("删除失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }




    @ApiOperation(value = "/del", httpMethod = "POST", notes = "删除意见")
    @PostMapping(value = "del")
    @ResponseBody
    @RequiresPermissions("advice:del")
    public JsonUtil del(String id) {
        if (StringUtils.isEmpty(id)) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        try {
            capAdviceService.deleteByPrimaryKey(id);
            j.setMsg("删除成功");
        } catch (MyException e) {
            j.setMsg("删除失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }




    @PostMapping(value = "upload")
    @ResponseBody
    public JsonUtil imgUpload(HttpServletRequest req, @RequestParam("file") MultipartFile file,
                              ModelMap model) {
        String fileName=uploadUtil.upload(file);
        JsonUtil j = new JsonUtil();
        j.setMsg(fileName);
        return j;
    }


}
