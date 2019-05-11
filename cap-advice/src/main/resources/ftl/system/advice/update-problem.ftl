<#--Created by IntelliJ IDEA.
User: zxm
Date: 2017/12/20
Time: 10:00
To change this template use File | Settings | File Templates.-->

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>编辑意见</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport"
        content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
  <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
  <link rel="stylesheet" href="${re.contextPath}/plugin/ztree/css/metroStyle/metroStyle.css">
  <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js"
          charset="utf-8"></script>
  <script type="text/javascript"
          src="${re.contextPath}/plugin/ztree/js/jquery.ztree.core.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.excheck.js"
          charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/tools/update-setting.js"></script>
    <#--<script type="text/javascript">
        $(document).ready(function() {
            var flag='${detail}';
            if(flag){
                $("form").disable();
            }
        });
    </script>-->

  <script type="text/javascript">
    $(document).ready(function () {
      var flag = '${detail}';
      if (flag) {
        $("form").disable();
      }
    });
  </script>

    <style>

        label {
            width: 200px !important;

        }

    </style>
</head>

<body>
<div class="x-body">

    <div class="layui-form-item">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
            <legend style="font-size:16px;">意见信息</legend>
        </fieldset>
    </div>

  <div class="layui-form layui-form-pane" style="margin-left: 20px;">
      <input type="hidden" id="id" name="id" value="${capAdvice.id}"/>
    <#--<div style="width:100%;overflow: auto;">-->

        <#--<div class="layui-form-item">
            <label for="title" class="layui-form-label">
                类型：
            </label>
            <div class="layui-input-inline layui-col-xs8">
                <label for="title" class="layui-form-label">
                 举报问题
                </label>
            </div>
        </div>-->

        <div class="layui-form-item">
            <label for="name" class="layui-form-label ">
            <#--<span class="x-red">*</span>-->
            举报人姓名：
            </label>
            <div class="layui-col-xs2">
                <input type="text"  id="name" name="name"  lay-verify="name"value="${capAdvice.name}"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        <#--<div id="ms" class="layui-form-mid layui-word-aux">
          <span class="x-red">*</span><span id="ums">标题必填</span>
        </div>-->
        </div>

        <div class="layui-form-item">
                <label for="phone" class="layui-form-label ">
                <#--<span class="x-red">*</span>-->
            举报人电话：
                </label>
                <div class="layui-col-xs2">
                    <input type="text" id="phone" name="phone" lay-verify="phone"  autocomplete="off" class="layui-input" value="${capAdvice.phone}" readonly="readonly">
                </div>
        </div>
    <div class="layui-form-item">
            <label for="reportedperson" class="layui-form-label ">
                <span class="x-red">*</span>被举报人姓名：
            </label>
            <div class="layui-col-xs2">
                <input type="text" id="reportedperson" name="reportedperson" lay-verify="reportedperson"  autocomplete="off" class="layui-input" value="${capAdvice.reportedperson}" readonly="readonly">
            </div>
    </div>

    <div class="layui-form-item">
            <label for="reporteddept" class="layui-form-label ">
                <span class="x-red">*</span>被举报人部门：
            </label>
            <div class="layui-col-xs2">
                <input type="text" id="reporteddept" name="reporteddept" lay-verify="reporteddept"  autocomplete="off" class="layui-input" value="${capAdvice.reporteddept}" readonly="readonly">
            </div>
    </div>

        <div class="layui-form-item">
                <label for="title" class="layui-form-label ">
                    <span class="x-red">*</span>
                举报标题：
                </label>
                <div class="layui-col-xs2">
                    <input type="text" id="title" name="title" lay-verify="title"  autocomplete="off" class="layui-input" value="${capAdvice.title}" readonly="readonly">
                </div>
        </div>

        <div class="layui-form-item">
                <label for="remark" class="layui-form-label ">
                    <span class="x-red">*</span>
                    举报内容：
                </label>

                <div class="layui-col-xs8">
                    <textarea id="content" name="content" lay-verify="content" class="layui-textarea" placeholder="20字以上，500字以内" readonly="readonly" style="resize: none">${capAdvice.content}</textarea>
                    <#--<div id="ms" class="layui-form-mid layui-word-aux">
                        <span id="ums">剩余500字</span>
                    </div>-->
                </div>
        </div>

        <#if capAdvice.file != ''>
              <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                  <legend style="font-size:16px;">附件上传</legend>
              </fieldset>
                <div class="layui-input-inline">

                    <div  id="demo2" style="margin-top: 20px;margin-left: 50px">
                        <img src="/images/${re.contextPath}/${capAdvice.file}" width="100px" height="100px" class="layui-upload-img ">
                    </div>

                </div>
        </#if>
    <#--</div>-->
        <#if !detail>
              <div class="layui-col-md12" style="height:40px;margin-top:3px;">
                  <button class="layui-btn layui-btn-warm" data-type="addDeal">添加处理情况</button>
              </div>
        </#if>
      <div style="width:100%;height:300px;overflow:auto">
      <table id="adviceDealList" class="layui-hide" lay-filter="user"></table>
      <script type="text/html" id="toolBar">
          <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
          {{#if(d.status == '1'){ }}
          <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="edit">编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
          {{# } }}
      </script>
      </div>
  <#if !detail>
    <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 1px;margin-left:-20px;">
      <div class="layui-form-item" style="margin-right: 30px;margin-top: 8px;text-align: center">

        <button class="layui-btn layui-btn-warm" id="sub">
          确认
        </button>
        <button class="layui-btn layui-btn-primary" id="back">
          返回
        </button>
      </div>
    </div>
  </#if>
  </div>
</div>
<script>
    layui.laytpl.toDateString = function(d, format){
        var date = new Date(d || new Date())
                ,ymd = [
            this.digit(date.getFullYear(), 4)
            ,this.digit(date.getMonth() + 1)
            ,this.digit(date.getDate())
        ]
                ,hms = [
            this.digit(date.getHours())
            ,this.digit(date.getMinutes())
            ,this.digit(date.getSeconds())
        ];

        format = format || 'yyyy-MM-dd HH:mm:ss';

        return format.replace(/yyyy/g, ymd[0])
                .replace(/MM/g, ymd[1])
                .replace(/dd/g, ymd[2])
                .replace(/HH/g, hms[0])
                .replace(/mm/g, hms[1])
                .replace(/ss/g, hms[2]);
    };

    //数字前置补零
    layui.laytpl.digit = function(num, length, end){
        var str = '';
        num = String(num);
        length = length || 2;
        for(var i = num.length; i < length; i++){
            str += '0';
        }
        return num < Math.pow(10, length) ? str + (num|0) : num;
    };

  layui.use([ 'layer', 'table'], function () {
    $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;

      //方法级渲染
      table.render({
          id: 'adviceDealList',
          elem: '#adviceDealList'
          , url: 'showAdviceDealList?adviceId=${capAdvice.id}'
          , cols: [[
               {field: 'content', title: '处理情况', width: '20%', sort: true}
              , {field: 'createDate', title: '提交时间', width: '20%',templet: '<div>{{ layui.laytpl.toDateString(d.createDate,"yyyy-MM-dd") }}</div>'}
              , {field: 'remark', title: '操作', width: '60%', toolbar: "#toolBar"}
          ]]
          , page: false
          ,  height: 'full-83'
      });

      var $ = layui.$, active = {
          select: function () {
              var title = $('#title').val();
              var content = $('#content').val();
              table.reload('adviceDealList', {
                  where: {
                      title: null,
                      content: null
                  }
              });
          },
          reload:function(){
              $('#title').val('');
              $('#content').val('');
              table.reload('adviceDealList', {
                  where: {
                      roleName: null,
                      remark: null
                  }
              });
          },
          addDeal: function () {
              addDeal('添加处理情况', 'showAddDeal?adviceId=${capAdvice.id}', 700, 450);
          },
          update: function () {
              var checkStatus = table.checkStatus('adviceDealList')
                      , data = checkStatus.data;
              if (data.length != 1) {
                  layer.msg('请选择一行编辑', {icon: 5});
                  return false;
              }
              update('编辑角色', 'updateAdvice?id=' + data[0].id, 700, 450);
          },
          detail: function () {
              var checkStatus = table.checkStatus('adviceDealList')
                      , data = checkStatus.data;
              if (data.length != 1) {
                  layer.msg('请选择一行查看', {icon: 5});
                  return false;
              }
              detail('查看角色信息', 'updateAdvice?id=' + data[0].id, 700, 450);
          }
      };


      //监听表格复选框选择
      table.on('checkbox(user)', function (obj) {
          //console.log(obj)
      });
      //监听工具条
      table.on('tool(user)', function (obj) {
          var data = obj.data;
          if (obj.event === 'detail') {
              detail('查看', 'showUpdateDeal?id=' + data.id, 700, 450);
          } else if (obj.event === 'del') {
              layer.confirm('确定删除处理情况?', function(){
                  del(data.id);
              });
          } else if (obj.event === 'edit') {
              update('编辑', 'showUpdateDeal?id=' + data.id, 700, 450);
          }
      });

      $('.layui-col-md12 .layui-btn').on('click', function () {
          var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
      });
      $('.select .layui-btn').on('click', function () {
          var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
      });



    //自定义验证规则
    /*form.verify({
        title: function (value) {
        if (value.trim() == "") {
          return "标题不能为空";
        }
      }
    });*/

    $('#back').click(function () {
      /*var index = parent.layer.getFrameIndex(window.name);
      parent.layer.close(index);*/
      location.href="dealProblem";
    });
    //监听提交
    $("#sub").click(function () {
        //先ajax验证是否至少有一条提交完的处理信息并且有的情况下全部都是处理完的。
        var id = $("#id").val();
        $.ajax({
            url: "checkDealBeforeProblemSubmit",
            type: "get",
            data: {id: id},
            success: function (d) {
                if (d.flag) {
                    location.href="updateProblemSubmit?id=${capAdvice.id}";
                } else {
                    layer.msg(d.msg,{icon:5,offset: 'rb',area:['120px','80px'],anim:2});
                }
            }
        });
    })

  });


    function del(id) {
        $.ajax({
            url: "delAdviceDeal",
            type: "post",
            data: {id: id},
            success: function (d) {
                if(d.msg){
                    layer.msg(d.msg,{icon:6,offset: 'rb',area:['120px','80px'],anim:2});
                    layui.table.reload('adviceDealList');
                }else{
                    layer.msg(d.msg,{icon:5,offset: 'rb',area:['120px','80px'],anim:2});
                }
            }
        });
    }
    function detail(title, url, w, h) {
        var number = 1;
        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "/error/404";
        }
        ;
        if (w == null || w == '') {
            w = ($(window).width() * 0.9);
        }
        ;
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        ;
        layer.open({
            id: 'user-detail',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url + '&detail=true',
            // btn:['关闭']
        });
    }
    /**
     * 更新用户
     */
    function update(title, url, w, h) {
        if (title == null || title == '') {
            title = false;
        }
        if (url == null || url == '') {
            url = "/error/404";
        }
        if (w == null || w == '') {
            w = ($(window).width() * 0.9);
        }
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        layer.open({
            id: 'user-update',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: false,
            shade: 0.4,
            title: title,
            content: url + '&detail=false'
        });
    }



  /*弹出层*/
  /*
   参数解释：
   title   标题
   url     请求的url
   id      需要操作的数据id
   w       弹出层宽度（缺省调默认值）
   h       弹出层高度（缺省调默认值）
   */
  function addDeal(title, url, w, h) {
      if (title == null || title == '') {
          title = false;
      }
      ;
      if (url == null || url == '') {
          url = "/error/404";
      }
      ;
      if (w == null || w == '') {
          w = ($(window).width() * 0.9);
      }
      ;
      if (h == null || h == '') {
          h = ($(window).height() - 50);
      }
      ;
      layer.open({
          id: 'deal-add',
          type: 2,
          area: [w + 'px', h + 'px'],
          fix: false,
          maxmin: true,
          shadeClose: false,
          shade: 0.4,
          title: title,
          content: url
      });
  }
</script>
</body>

</html>
