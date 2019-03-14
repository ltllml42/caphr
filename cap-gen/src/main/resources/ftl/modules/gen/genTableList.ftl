<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/lenos/main.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js"
            charset="utf-8"></script>

</head>

<body>
<div class="lenos-search">
    <div class="select">
        标题：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="title" autocomplete="off">
        </div>
        提要：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="description" autocomplete="off">
        </div>
        <button class="select-on layui-btn layui-btn-sm" data-type="select"><i class="layui-icon"></i>
        </button>
        <button class="layui-btn layui-btn-sm icon-position-button" id="refresh" style="float: right;"
                data-type="reload">
            <i class="layui-icon">ဂ</i>
        </button>
    </div>

</div>
<div class="layui-col-md12" style="height:40px;margin-top:3px;">
    <div class="layui-btn-group">
        <button class="layui-btn layui-btn-normal" data-type="add">
            <i class="layui-icon">&#xe608;</i>新增
        </button>
        <button class="layui-btn layui-btn-normal" data-type="update">
            <i class="layui-icon">&#xe642;</i>编辑
        </button>
        <button class="layui-btn layui-btn-normal" data-type="detail">
            <i class="layui-icon">&#xe605;</i>查看
        </button>
    </div>
</div>

</body>

</html>
