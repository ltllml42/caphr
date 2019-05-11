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
  <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery.qrcode.min.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.core.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/ztree/js/jquery.ztree.excheck.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>


    <style>

        .bg {
            background: url('${re.contextPath}/plugin/background/bg.png') no-repeat;
            background-size:cover;
        }

        label {
            width: 160px !important;
            font-size: 16px;
            font-weight: bold !important;
            text-align: left !important;
        }


        .text {
            margin-top: 40%;
            width: 80%;
        }

    </style>
    <script>
        $(document).ready(function(){
           $("#qrcode").qrcode("${prodAddress}/adviceMobile/adviceQuery?selectCode=${capAdvice.adviceCode}");
        });

    </script>

</head>

<body class="bg">
<div class="x-body text">

    <h1 style="color:red">举报问题</h1>

    <div class="layui-form-item">
        <label>
            感谢您对党支部工作的支持
        </label>
    </div>
    <div class="layui-form-item">
        <label>
            请您牢记查询码：<span style="color: red">${capAdvice.adviceCode}</span>，或使用二维码查询结果
        </label>
    </div>

    <div id="qrcode" style="text-align: center">
    </div>


</div>
<script>


</script>
</body>

</html>
