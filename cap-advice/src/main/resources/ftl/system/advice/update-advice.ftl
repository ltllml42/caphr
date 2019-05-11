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

    <form id="subform" class="layui-form layui-form-pane"  action="updateAdvice" method="post">
      <input type="hidden" id="id" name="id" value="${capAdvice.id}"/>
    <#--<div style="width:100%;overflow: auto;">-->

        <#--<div class="layui-form-item ">
            <label for="title" class="layui-form-label" style="width: 200px">
                类型：意见建议
            </label>
            <label for="title" class="layui-form-label ">

            </label>
        </div>-->

        <div class="layui-form-item">
            <label for="name" class="layui-form-label " >
            <#--<span class="x-red">*</span>-->
            提交人姓名：
            </label>
            <div class="layui-col-xs2 ">
                <input type="text"  id="name" name="name"  lay-verify="name"value="${capAdvice.name}"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        <#--<div id="ms" class="layui-form-mid layui-word-aux">
          <span class="x-red">*</span><span id="ums">标题必填</span>
        </div>-->
        </div>

        <div class="layui-form-item">

            <label for="remark" class="layui-form-label ">
            <#--<span class="x-red">*</span>-->
            提交人电话：
            </label>
            <div class="layui-col-xs2 ">
                <input type="text" id="phone" name="phone" lay-verify="phone"  autocomplete="off" class="layui-input" value="${capAdvice.phone}" readonly="readonly">
            </div>

        </div>


        <div class="layui-form-item">

                <label for="remark" class="layui-form-label ">
                    <span class="x-red">*</span>
                 提交标题：
                </label>
                <div class="layui-col-xs2">
                    <input type="text" id="title" name="title" lay-verify="title"  autocomplete="off" class="layui-input" value="${capAdvice.title}" readonly="readonly">
                </div>

        </div>

        <div class="layui-form-item">

                <label for="remark" class="layui-form-label ">
                    <span class="x-red">*</span>
                    提交内容：
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

        <div class="layui-form-item">

                <label for="remark" class="layui-form-label">
                    <span class="x-red">*</span>
                    意见：
                </label>

                <div class="layui-col-xs8">
                    <textarea id="remark" name="remark" lay-verify="remark" class="layui-textarea" style="resize: none"></textarea>
                <#--<div id="ms" class="layui-form-mid layui-word-aux">
                    <span id="ums">剩余500字</span>
                </div>-->
                </div>



        </div>


    <#--</div>-->


  <#if !detail>
    <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 1px;margin-left:-20px;">
      <div class="layui-form-item" style="margin-right: 30px;margin-top: 8px;text-align: center">

        <button class="layui-btn layui-btn-warm" lay-filter="sub" lay-submit>
          确认
        </button>
        <button class="layui-btn layui-btn-primary" id="back">
          返回
        </button>
      </div>
    </div>
  </#if>
  </form>
</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
                ,layer = layui.layer;

        //自定义验证规则
        form.verify({
            remark: function(value){
                if(value.trim()==""){
                    return "意见为空";
                }
            }
        });

        $('#back').click(function(){
            /*var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);*/
            location.href="dealAdvice";
        });
        //监听提交
        form.on('submit(add)', function(data){
            $("#subform").submit();
            /*layerAjax('addRole',data.field,'adviceList');
            return false;*/
        });
    });
</script>


</body>

</html>
