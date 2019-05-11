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
  <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
  <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
  <link rel="stylesheet" href="${re.contextPath}/plugin/ztree/css/metroStyle/metroStyle.css">
  <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.core.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.excheck.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>

    <script>

        function addProblem(type) {
            location.href="addProblem?reportType="+type;
        }
    </script>

    <style>

        .outer {
            width: 90%;
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
            font-size: 30px;
            font-weight: bold;
        }

    </style>

</head>

<body class="bg">
<div class="x-body">


        <div class="outer" style="text-align:center;">

            <h1 style="color:red">呼叫中心党支部</h1>
            <h1 style="color:red">党建工作意见箱</h1>

            <div class="layui-form-item" style="margin-top: 40px">

                <button  class="layui-btn layui-btn-normal button" lay-filter="add" id="add" onclick="addProblem('1')" style="background-color: red">
                    实名举报
                </button>
            </div>

            <div class="layui-form-item" >

                <button  class="layui-btn layui-btn-normal button" lay-filter="addAdvice" onclick="addProblem('2')" style="background-color: grey">
                    匿名举报
                </button>
            </div>



            <#--<div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 1px;margin-left:-20px;">
                <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">

                    <button  class="layui-btn layui-btn-primary" id="back">
                        返回
                    </button>
                </div>
            </div>-->


        </div>




</div>
<script>
    $('#back').click(function(){
        location.href="adviceIndex";
        return false;
    });



</script>
</body>

</html>
