package com.capinfo.controller;

import com.capinfo.entity.JsGenTable;
import com.capinfo.service.JsGenTableService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName JsGenTableController
 * @Description
 * @Author QJH
 * @Date 2019/3/14 15:41
 **/
@Controller
@RequestMapping(value = "/gen")
public class JsGenTableController {

    @Autowired
    private JsGenTableService jsGenTableService;

    @ResponseBody
    @GetMapping(value="sal")
    public List<JsGenTable> selectAll(){
        return jsGenTableService.selectAll();
    }

    @ApiOperation(value = "/showGenTable", httpMethod = "GET", notes = "展示代码生成器操作列表")
    @GetMapping(value = "showGenTable")
    //@RequiresPermissions("menu:show")
    public String showGenTable(Model model) {

        return "/modules/gen/genTableList";
    }

}
