<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>大屏显示</title>

    <!-- Bootstrap -->
    <link href="${re.contextPath}/plugin/mp/css/bootstrap.css" rel="stylesheet">
    <link href="${re.contextPath}/plugin/mp/css/liMarquee.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
	<script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="jumbotron">
    <div class="container">
        <div class="row">
            <h2>验车流程</h2>
            <p>检查车辆消息列表（测试版1.1）</p>
            <ol id="largeScreen" class="list-group">
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
                <li class="list-group-item" flag="empty">暂无消息</li>
            </ol>
        </div>
        <div class="row">
            <h2>即时消息通道</h2>
            <div class="dowebok">

            </div>
        </div>
    </div>
</div>
<div id="tts">




</div>

</body>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${re.contextPath}/plugin/mp/js/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${re.contextPath}/plugin/mp/js/bootstrap.js"></script>
<script src="${re.contextPath}/plugin/mp/js/jquery.liMarquee.js"></script>
<script src="/webjars/sockjs-client/1.0.2/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>

<script type="text/javascript">
    /**
     *
     * 获取当前时间
     */
    function getNow(s) {
        return s < 10 ? '0' + s: s;
    }

    function getTime(){
        var myDate = new Date();
        //获取当前年
        var year=myDate.getFullYear();
        //获取当前月
        var month=myDate.getMonth()+1;
        //获取当前日
        var date=myDate.getDate();
        var h=myDate.getHours();       //获取当前小时数(0-23)
        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
        var s=myDate.getSeconds();
        return year+'-'+getNow(month)+"-"+getNow(date)+" "+getNow(h)+':'+getNow(m)+":"+getNow(s);
    }




    var stompClient = null;

    $(function () {
        var socket = new SockJS('/endpoint-websocket'); //连接上端点(基站)
        stompClient = Stomp.over(socket);			//用stom进行包装，规范协议
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/gcc', function (result) {
                console.log(result.body);
                showContent(JSON.parse(result.body));
                showLargeScreen(JSON.parse(result.body));

            });
        });
    });

    var full = 9;
    var index = 0;//从零开始
    function showLargeScreen(data){
        var fullFalg = true;
        $($("#largeScreen li").toArray().reverse()).each(function(index,item){
            debugger;
            var flag = $(item).attr("flag");
            if(flag=="empty"){
                $(item).html(data.content+"<span class=\"badge\">"+getTime()+"</span>");
                $(item).attr("flag","full");
                fullFalg = false;
                return false;
            }
        });
        if(fullFalg){
            $("#largeScreen").children().get(0).remove();
            $("#largeScreen").append("<li class=\"list-group-item\" flag=\"full\">"+data.content5+"<span class=\"badge\">"+getTime()+"</span></li>")
        }
    }


    function showContent(data){
        $('.dowebok').children().remove();
        $('.dowebok').append("<h1 style=\"color:red;\">"+data.content+"</h1>");
        $('.dowebok').liMarquee({
            direction: 'left',
            scrollamount: 200
        });
        voiceTTs(data.content);
    }







    // var mycars = new Array();
    // mycars[0] = "京G-B1387 入场进行年检";
    // mycars[1] = "京A-FB123 入场进行年检";
    // mycars[2] = "京F-GC123 入场进行年检";
    // mycars[3] = "京G-B1387 入场进行年检";
    // mycars[4] = "京A-FB123 外观检测通过";
    // mycars[5] = "京F-GC123 外观检测通过";
    // mycars[6] = "京G-B1387 外观检测通过";
    // mycars[7] = "京A-FB123 尾气检测通过";
    // mycars[8] = "京F-GC123 尾气检测通过";
    // mycars[9] = "京G-B1387 上线检测通过";
    // mycars[10] = "京A-FB123上线检测通过";
    // mycars[11] = "京F-GC123 上线检测通过";
    // mycars[12] = "京G-B1387 进入停车场";
    // mycars[13] = "京A-FB123 进入停车场";
    // mycars[14] = "京F-GC123 进入停车场";
    // mycars[15] = "京F-GC123 车检完成";
    // mycars[16] = "京F-GC123 车检完成";
    // var count = 0;
    // $(function(){
    //     // $('.dowebok').children().remove();
    //     // $('.dowebok').append("<h1 style=\"color:#ff0800;\">欢迎领导前来视察工作</h1>");
    //     // $('.dowebok').liMarquee({
    //     //     direction: 'left',
    //     //     scrollamount: 200
    //     // });
    //     // voiceTTs("欢迎领导前来视察工作");
    // });

    // setInterval("showTime()",10000);
    // function showTime(){
    //     if(count>=mycars.length){
    //         count=0;
    //     }
    //     count++;
    //     $('.dowebok').children().remove();
    //     $('.dowebok').append("<h1 style=\"color:red;\">"+mycars[count]+"</h1>");
    //     $('.dowebok').liMarquee({
    //         direction: 'left',
    //         scrollamount: 200
    //     });
    //     voiceTTs(mycars[count]);
    //
    // }

    function voiceTTs(content){

        $('#tts').children().remove();
        var url = "http://tts.baidu.com/text2audio/text2audio?lan=zh&ie=UTF-8&spd=8&text="
        //添加audio标签
        var f = document.createDocumentFragment()
        var audio = document.createElement("audio")
        audio.style = "display:none"
        audio.id = "cs"
        audio.controls="controls"
        audio.autoplay="autoplay"
        var source = document.createElement("source")
        source.id = "tts_source"
        source.type="audio/mpeg"
        source.src= url
        audio.appendChild(source)
        f.appendChild(audio)
        document.getElementById("tts").appendChild(f)
        var sorce = document.querySelector("#tts_source")
        source.src = url + content;
        sorce.parentNode.load();
    }

</script>




</body>
</html>