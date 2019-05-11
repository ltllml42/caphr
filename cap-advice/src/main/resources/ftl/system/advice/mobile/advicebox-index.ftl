<#--Created by IntelliJ IDEA.
User: zxm
Date: 2017/12/20
Time: 10:00
To change this template use File | Settings | File Templates.-->

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>添加意见</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
  <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
  <link rel="stylesheet" href="${re.contextPath}/plugin/ztree/css/metroStyle/metroStyle.css">
  <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.core.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.excheck.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>

    <script>

        function addProblem() {
            location.href="chooseProblemType";
        }

        function addAdvice() {
            location.href="addAdvice";
        }

        function adviceQuery() {
            location.href="adviceQuery";
        }

    </script>
    <style>

        .outer {
            text-align: center;
            margin: 0 auto;
            margin-top: 40%;
        }

        .bg {
            background: url('${re.contextPath}/plugin/background/bg.png') no-repeat;
            background-size:cover;
        }

        .button {
            height: 70px;
            width: 240px;
            border-radius: 10px;
            color:black;
            font-size: 30px;
            font-weight: bold;
        }

    </style>
</head>

<body class="bg">
<div class="x-body">

    <#--<form>-->

        <div class="outer" style="text-align:center;">

            <h1 style="color:red">呼叫中心党支部</h1>
            <h1 style="color:red">党建工作意见箱</h1>

            <div style="margin-top: 40px">
            <div class="layui-form-item" >

                <button  class="layui-btn layui-btn-lg button" lay-filter="add" id="add" onclick="addProblem()" style="background-color: #f5e3f7">
                    <i class="layui-icon">&#xe702;</i>我要举报
                </button>
            </div>

            <div class="layui-form-item" >

                <button  class="layui-btn layui-btn-lg button" lay-filter="addAdvice" onclick="addAdvice()" style="background-color: #f5e5b0">
                    <i class="layui-icon">&#xe6b2;</i>意见建议
                </button>
            </div>

            <div class="layui-form-item" >

                <button  class="layui-btn layui-btn-lg button" lay-filter="select" onclick="adviceQuery()" style="background-color: #b8ddf9">
                    <i class="layui-icon">&#xe615;</i>进度查询
                </button>
            </div>
            </div>

        </div>


    <#--</form>-->


</div>
<script>

    layui.use(['form','layer','upload'], function(){

        /*$('#add').click(function(){
            location.href="addAdviceMobile";

        });*/


    })


</script>
</body>

</html>
