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
    <div class="layui-form-item">
      <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
        <legend style="font-size:16px;">车辆信息</legend>
      </fieldset>
    </div>
    <div class="layui-form-item">
      <label for="plateNo" class="layui-form-label">
        车牌号
      </label>
      <div class="layui-input-inline">
        <input type="text"  id="plateNo" name="plateNo"  lay-verify="plateNo"
               autocomplete="off" class="layui-input" value="${capWorkOrderRecord.plateNo}" readonly="readonly"/>
      </div>
    </div>

    <div class="layui-form-item">
        <label for="plateNo" class="layui-form-label">
            检测费用
        </label>
        <div class="layui-input-inline">
            <input type="text" id="totalMoney" name="totalMoney" class="layui-input" value="${capWorkOrderRecord.totalMoney}" readonly="readonly"/>
        </div>
    </div>

        <#-- 这个页面，加载一个对应的处理步骤的表信息 -->

        <table id="spendtimeList" class="layui-hide" lay-filter="user"></table>


    </div>
      <#if !detail>
  <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 1px;margin-left:-20px;">
    <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">

      <button  class="layui-btn layui-btn-normal" id="pass">
          完成结算
      </button>
      <#--<button class="layui-btn layui-btn-normal" id="nopass">
          检测不通过
      </button>-->
      <button  class="layui-btn layui-btn-primary" id="close">
        取消
      </button>
    </div>
  </div>
      </#if>
  </div>
</div>
<script type="text/html" id="isrepeatTemp">
    {{#  if(d.isrepeat =='0'){ }}
    首检
    {{# }if(d.isrepeat =='1') { }}
    复检
    {{#  } }}

</script>
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




  layui.use(['form','layer','table'], function(){
    $ = layui.jquery;
    var form = layui.form
        ,layer = layui.layer;
    var table = layui.table;

    //自定义验证规则
    form.verify({
        plateNo: function(value){
        if(value.trim()==""){
          return "车牌号不能为空";
        }
      }
    });

   $('#close').click(function(){
     var index = parent.layer.getFrameIndex(window.name);
     parent.layer.close(index);
   });

   $("#pass").click(function () {
       layerAjax('endVehicle',{"id": "${capWorkOrderRecord.id}","status": "pass"},'vehicleList');
       return false;
   });
   $("#nopass").click(function () {
       layerAjax('endVehicle',{"id": "${capWorkOrderRecord.id}","status": "nopass"},'vehicleList');
       return false;
   })


    //监听提交
    /*form.on('submit(add)', function(data){

      layerAjax('completeVehicle',data.field,'vehicleList');
      return false;
    });*/

      //方法级渲染
      table.render({
          id: 'spendtimeList',
          elem: '#spendtimeList'
          , url: 'showSpendtimeList?recordId=${capWorkOrderRecord.id}'
          , cols: [[
              {field: 'taskName', title: '检测环节', width: '20%'}
              , {field: 'startTime', title: '检测时间', width: '60%',templet: '<div>{{ layui.laytpl.toDateString(d.createDate,"yyyy-MM-dd HH:mm:ss") }}</div>'}
              , {field: 'isrepeat', title: '是否为复检', width: '20%', templet: '#isrepeatTemp'}
          ]]
          , page: false
          ,  height: 'full-83'
      });

      var $ = layui.$, active = {
          select: function () {
              var title = $('#title').val();
              var content = $('#content').val();
              table.reload('spendtimeList', {
                  where: {
                      title: null,
                      content: null
                  }
              });
          },
          reload:function(){
              $('#title').val('');
              $('#content').val('');
              table.reload('spendtimeList', {
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



  });
</script>
</body>

</html>
