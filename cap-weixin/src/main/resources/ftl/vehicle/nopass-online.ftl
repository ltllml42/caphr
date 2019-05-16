<#--Created by IntelliJ IDEA.
User: zxm
Date: 2017/12/20
Time: 10:00
To change this template use File | Settings | File Templates.-->

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>车辆</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
  <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
  <link rel="stylesheet" href="${re.contextPath}/plugin/ztree/css/metroStyle/metroStyle.css">
  <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.core.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.excheck.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>

</head>

<body>
<div class="x-body">
  <div class="layui-form layui-form-pane" style="margin-left: 20px;">
    <div style="width:100%;height:400px;overflow: auto;">
        <input type="hidden" id="id" name="id" value="${capWorkOrderRecord.id}"/>


    </div>
  <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 1px;margin-left:-20px;">
    <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">

      <button  class="layui-btn layui-btn-normal" id="nopass">
          不通过
      </button>
      <button class="layui-btn layui-btn-normal" id="onlylight">
          只复检灯光
      </button>
      <button  class="layui-btn layui-btn-primary" id="close">
        取消
      </button>
    </div>
  </div>
  </div>
</div>
<script>
  layui.use(['form','layer'], function(){
    $ = layui.jquery;
    var form = layui.form
        ,layer = layui.layer;

    form.render();
    //自定义验证规则
    /*form.verify({
        plateNo: function(value){
        if(value.trim()==""){
          return "角色名不能为空";
        }
      }
    });*/

   $('#close').click(function(){
     var index = parent.layer.getFrameIndex(window.name);
     parent.layer.close(index);
   });

   $("#nopass").click(function () {
       layerAjax('completeVehicle',{"id": "${capWorkOrderRecord.id}","status": "nopass","onlylight": "no"},'vehicleList');
       var index = parent.layer.getFrameIndex(window.name);
       parent.layer.close(index);
       return false;
   });
   $("#onlylight").click(function () {
       layerAjax('completeVehicle',{"id": "${capWorkOrderRecordy.id}","status": "nopass","onlylight":"yes"},'vehicleList');
       var index = parent.layer.getFrameIndex(window.name);
       parent.layer.close(index);
       return false;
   })


    //监听提交
    /*form.on('submit(add)', function(data){

      layerAjax('completeVehicle',data.field,'vehicleList');
      return false;
    });*/
  });
</script>
</body>

</html>
