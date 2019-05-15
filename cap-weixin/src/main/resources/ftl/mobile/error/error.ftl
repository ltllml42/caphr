<!DOCTYPE html>
<html>
<head>
    <title>车辆绑定</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <meta name="description" content="">


    <link rel="stylesheet" href="${re.contextPath}/plugin/lib/weui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/jquery-weui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/demos.css">

</head>
<body onload="closeWindow();">
<div class="weui-msg">
    <div class="weui-msg__icon-area"><i class="weui-icon-warn weui-icon_msg"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">鉴权失败</h2>
        <!--p class="weui-msg__desc">内容详情，可根据实际需要安排，如果换行则不超过规定长度，居中展现<a href="javascript:void(0);">文字链接</a></p-->
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
        <div id="show">
            将倒计时5秒后关闭当前窗口，返回公众号窗口
        </div>
        </p>
    </div>
    <div class="weui-msg__extra-area">
        <div class="weui-footer">
            <p class="weui-footer__links">
                <a href="javascript:void(0);" class="weui-footer__link">北京兴通爱民机动车检测有限公司</a>
            </p>
            <p class="weui-footer__text">@版权所有 电话(010)80519721</p>
        </div>
    </div>
</div>

<style>
    .weui-footer {
        margin: 25px 0 10px 0;
    }
</style>


<script src="${re.contextPath}/plugin/lib/jquery-2.1.4.js"></script>
<script src="${re.contextPath}/plugin/js/jquery-weui.js"></script>
<script src="${re.contextPath}/plugin/js/carnum-picker.js"></script>
<script src="${re.contextPath}/plugin/lib/fastclick.js"></script>


<script>
    $(function() {
        FastClick.attach(document.body);
    });

    var time=5;
    function closeWindow(){
        window.setTimeout('closeWindow()',1000);
        if(time>0){
            document.getElementById("show").innerHTML=" 将倒计时<font color=red>"+time+"</font>秒后关闭当前窗口,返回微信公众号窗口";
            time--;
        }else{
            WeixinJSBridge.call('closeWindow');
//this.window.opener=null; //关闭窗口时不出现提示窗口
//window.close();
        }
    }


</script>


</body>

</html>
