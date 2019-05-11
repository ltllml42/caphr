<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=5">
    <title></title>
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/jquery.mobile-1.4.5.css"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/jquery.mobile.theme-1.4.5.css"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/jqm-demos.css"/>
</head>
<body>

<div data-role="page" id="login">
    <div data-role="header" data-position="fixed" data-theme="b">
        <h1>车检管理系统</h1>
    </div>
    <div data-role="main" class="ui-content">
        <h2>尾气检测等待队列</h2>
        <form class="ui-filterable">
            <input id="myFilter" data-type="search">
        </form>
        <ol class="charList" data-role="listview" data-filter="true" data-input="#myFilter" placeholder="根据名称搜索.."
            data-inset="true">
            <li id="channelOne" flag="empty">
            </li>
            <li id="channelTwo" flag="empty">
                <a href="#adelePage" data-swipe-close="false" data-dismissible="false">
                    <span class="ui-listview-inset">京A-CS236</span>
                    <span class="ui-listview-inset" style="margin-left: 50px;">首检</span>
                    <span class="ui-listview-inset colorGreen" style="margin-left: 50px;">已通过</span>
                    <span class="ui-li-count">新</span>
                </a>
            </li>
            <li id="channelThree" flag="full">
                <a href="#adelePage" data-swipe-close="false" data-dismissible="false">
                    <span class="ui-listview-inset">京A-CS236</span>
                    <span class="ui-listview-inset" style="margin-left: 50px;">复检</span>
                    <span class="ui-listview-inset colorRed" style="margin-left: 50px;">待检</span>
                    <span class="ui-li-count">新</span>
                </a>
            </li>
            <li id="channelFour" flag="full">
                <a href="#adelePage" data-swipe-close="false" data-dismissible="false">
                    <span class="ui-listview-inset">京A-CS236</span>
                    <span class="ui-listview-inset" style="margin-left: 50px;">复检</span>
                    <span class="ui-listview-inset colorRed" style="margin-left: 50px;">未通过</span>
                    <span class="ui-li-count">新</span>
                </a>
            </li>
            <li id="channelFive" flag="full">
                <a href="#adelePage" data-swipe-close="false" data-dismissible="false">空闲</a>
            </li>
            <li id="channelSix" flag="full">
                <a href="#adelePage" data-swipe-close="false" data-dismissible="false">空闲</a>
            </li>
        </ol>
    </div>


    <div data-role="panel" id="adelePage" data-display="overlay">
    </div>
</div>
</div>
</body>

<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.mobile-1.4.5.js"></script>
<script type="text/javascript" src="js/laytpl.js"></script>

<script type="text/javascript">
    var countOk = 0;
    var countNotOk = 0;

    function subUp(v) {
        countOk++;
        if (countOk == 1) {
            $(v).text("再点击一次");
            reNotOk();
            return false;
        } else {
            $(v).text("通过");
            reOk();
            reNotOk();
            //提交表单
            $("#adelePage").panel("close");
        }
    }

    function subNotOk(v) {
        countNotOk++;
        if (countNotOk == 1) {
            $(v).text("再点一次确认");
            reOk();
        } else {
            $(v).text("不通过");
            reOk();
            reNotOk();
            $("#adelePage").panel("close");
        }
    }

    function reOk() {
        countOk = 0;
        $("#ok").text("通过");
    }

    function reNotOk() {
        countNotOk = 0;
        $("#notOk").text("不通过");
    }

    function revokeProgram() {
        reOk();
        reNotOk();
    }
</script>


<script id="freeLocation" type="text/html">
    <a href="#adelePage" data-swipe-close="false" data-dismissible="false">空闲</a>
</script>

<script id="channel" type="text/html">
    <a href="#adelePage" data-swipe-close="false" data-dismissible="false">
        <span class="ui-listview-inset">{{d.name}}</span>
        <span class="ui-listview-inset" style="margin-left: 50px;">{{d.examin}}</span>
        <span class="ui-listview-inset colorRed" style="margin-left: 50px;">未通过</span>
        <span class="ui-li-count">新</span>
    </a>
</script>

<script id="message" type="text/html">
    <h2>检测完成确认</h2>
    <p>车牌号：</p>
    <p>{{d.name}}
        <br>在尾气检测环节 {{d.examin}} 状态中</p>
    <p>双击确认！！</p>
    <div id="ccc" data-role="controlgroup" data-type="vertical">
        <a href="#" data-role="button" id="ok" onclick="subUp(this)"
           class="ui-btn ui-mini ui-shadow  ui-icon-check ui-btn-icon-left">通过</a>
        <a href="#" data-role="button" id="notOk" onclick="subNotOk(this)"
           class="ui-btn ui-mini ui-shadow  ui-icon-delete ui-btn-icon-left">不通过</a>
        <a href="#" data-role="button" id="re" onclick="revokeProgram(this)"
           class="ui-btn ui-mini ui-shadow ui-icon-back ui-btn-icon-left">撤销</a>
    </div>
</script>

<div id="tts">
</div>

<script type="text/javascript">

    var data = {name: '京A-NB126', examin: '首检', flag: "full"};
    var gettpl = document.getElementById('channel').innerHTML;
    laytpl(gettpl).render(data, function (html) {
        $("#channelOne").slideDown();
        $("#channelOne").html(html);
        $("#channelOne").attr("flag", data.flag);
    });

    var gettpl2 = document.getElementById('message').innerHTML;
    laytpl(gettpl2).render(data, function (html) {
        $("#adelePage").html(html);
        voiceTTs(data.name + "进入尾气检测阶段")

    });

    function voiceTTs(content) {

        $('#tts').children().remove();
        var url = "http://tts.baidu.com/text2audio/text2audio?lan=zh&ie=UTF-8&spd=&text="
        //添加audio标签
        var f = document.createDocumentFragment()
        var audio = document.createElement("audio")
        audio.style = "display:none"
        audio.id = "cs"
        audio.controls = "controls"
        audio.autoplay = "autoplay"
        var source = document.createElement("source")
        source.id = "tts_source"
        source.type = "audio/mpeg"
        source.src = url
        audio.appendChild(source)
        f.appendChild(audio)
        document.getElementById("tts").appendChild(f)
        var sorce = document.querySelector("#tts_source")
        source.src = url + content;
        sorce.parentNode.load();
    }
</script>


</html>