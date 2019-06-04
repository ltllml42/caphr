<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=5">
    <title></title>
    <link rel="stylesheet" href="${re.contextPath}/plugin/jmq/css/jquery.mobile-1.4.5.css"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/jmq/css/jquery.mobile.theme-1.4.5.css"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/jmq/css/jqm-demos.css"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
</head>
<body>

<div data-role="page" id="login">
    <div data-role="header" data-position="fixed" data-theme="b">
        <h1>车检管理系统</h1>
        <button class="layui-btn layui-btn-sm icon-position-button" id="refreshData" ><i class="layui-icon">ဂ</i></button>
        <a class="layui-btn layui-btn-sm icon-position-button" href="/logout"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
        <#--<ul class="layui-nav layui-layout-right kit-nav">
            <button class="layui-btn layui-btn-sm icon-position-button" id="refreshData"><i class="layui-icon">ဂ</i></button>
            <li class="layui-nav-item"><a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a></li>
        </ul>-->

    </div>
    <div data-role="main" class="ui-content">
        <h2>
            <#assign currentUser = Session["curentUser"]>${currentUser.realName}
            <@shiro.hasPermission name="car:gas">尾气检查消息列表</@shiro.hasPermission>
            <@shiro.hasPermission name="car:online">上线检测消息列表</@shiro.hasPermission>
            <@shiro.hasPermission name="car:pay">缴费核算消息列表</@shiro.hasPermission>
            <@shiro.hasPermission name="car:light">车灯复检消息列表</@shiro.hasPermission>
        </h2>
        <form class="ui-filterable">
            <input id="myFilter" data-type="search" placeholder="根据名称搜索.."/>
        </form>
        <ol id="dataEx" class="charList" data-role="listview" data-filter="true" data-input="#myFilter"  data-inset="true">
        </ol>
    </div>

    <div data-role="panel" id="adelePage" data-display="overlay"></div>
</div>
</div>
</body>

<script src="${re.contextPath}/plugin/mp/js/jquery.min.js"></script>
<script type="text/javascript" src="${re.contextPath}/plugin/jmq/js/jquery.mobile-1.4.5.js"></script>
<script type="text/javascript" src="${re.contextPath}/plugin/jmq/js/laytpl.js"></script>

<script src="/webjars/sockjs-client/1.0.2/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>

<script type="text/javascript">
    var countOk = 0;
    var countNotOk = 0;
    var countLight = 0;
    var countFree = 0;

    function subUp(v, buisId, flowStatus) {
        countOk++;
        if (countOk == 1) {
            //$(v).text("再点击一次确认");
            $("#okText").text("再点击一次确认");
            reNotOk();
            return false;
        } else {
            //$(v).text("通过");
            $("#okText").text("通过");
            reOk();
            reNotOk();
            //提交表单
            var url = "";
            if (flowStatus != "缴费核算") {
                url = "/vehicle/completeVehicleMobile";
            } else {
                url = "/vehicle/endVehicle";
            }
            var data = {};
            data.id=buisId;
            data.status="pass";
            if (flowStatus == '尾气检测') {
                data.free='0';
            }
            var jsonStr = JSON.stringify(data);
            if (jsonStr != null || jsonStr != [{}]) {
                $.ajax({
                    url: url,
                    dataType: "json",
                    data: jsonStr,
                    type : 'post',
                    contentType: "application/json", //必须有
                    success: function (data) {
                        if(data.flag){
                            //alert("success");
                            loadData();
                        } else {
                            //window.location.href="/wx/message/fail";
                            //alert("fail");
                        }
                        $("#adelePage").panel("close");
                    }
                });
            }

        }
    }

    function subNotOk(v, buisId, flowStatus) {
        countNotOk++;
        if (countNotOk == 1) {
            //$(v).text("再点一次确认");
            $("#notOkText").text("再点一次确认");
            reOk();
        } else {
            //$(v).text("不通过");
            $("#notOkText").text("不通过");
            reOk();
            reNotOk();
            var url = "";
            if (flowStatus != "缴费核算") {
                url = "/vehicle/completeVehicleMobile";
            } else {
                url = "/vehicle/endVehicle";
            }
            var data = {};
            data.id=buisId;
            data.status="nopass";
            if (flowStatus == '尾气检测') {
                data.free='0';
            }
            var jsonStr = JSON.stringify(data);
            if (jsonStr != null || jsonStr != [{}]) {
                $.ajax({
                    url: url,
                    dataType: "json",
                    data: jsonStr,
                    type : 'post',
                    contentType: "application/json", //必须有
                    success: function (data) {
                        if(data.flag){
                            //alert("success");
                            loadData();
                        } else {
                            //window.location.href="/wx/message/fail";
                            //alert("fail");
                        }
                        $("#adelePage").panel("close");
                    }
                });
            }
            //$("#adelePage").panel("close");
        }
    }

    function checkLight(v, buisId, flowStatus) {
        countLight++;
        if (countLight == 1) {
            //$(v).text("再点一次确认");
            $("#lightText").text("再点一次确认");
            reOk();
        } else {
            //$(v).text("只复检车灯");
            $("#lightText").text("只复检车灯");
            reOk();
            reNotOk();
            reLight();
            var data = {};
            data.id=buisId;
            data.status="nopasslight";
            var jsonStr = JSON.stringify(data);
            if (jsonStr != null || jsonStr != [{}]) {
                $.ajax({
                    url: '/vehicle/completeVehicleMobile',
                    dataType: "json",
                    data: jsonStr,
                    type : 'post',
                    contentType: "application/json", //必须有
                    success: function (data) {
                        if(data.flag){
                            //alert("success");
                            loadData();
                        } else {
                            //window.location.href="/wx/message/fail";
                            //alert("fail");
                        }
                        $("#adelePage").panel("close");
                    }
                });
            }
        }
    }

    function subFree(v, buisId) {
        countFree++;
        if (countFree == 1) {
            //$(v).text("再点一次确认");
            $("#freeText").text("再点一次确认");
            reOk();
        } else {
            //$(v).text("免检");
            $("#freeText").text("新能源免检");
            reOk();
            reNotOk();
            reFree();
            var data = {};
            data.id=buisId;
            data.status="pass";
            data.free="1";
            var jsonStr = JSON.stringify(data);
            if (jsonStr != null || jsonStr != [{}]) {
                $.ajax({
                    url: '/vehicle/completeVehicleMobile',
                    dataType: "json",
                    data: jsonStr,
                    type : 'post',
                    contentType: "application/json", //必须有
                    success: function (data) {
                        if(data.flag){
                            //alert("success");
                            loadData();
                        } else {
                            //window.location.href="/wx/message/fail";
                            //alert("fail");
                        }
                        $("#adelePage").panel("close");
                    }
                });
            }
        }

    }



    function reOk() {
        countOk = 0;
        //$("#ok").text("通过");
        $("#okText").text("通过");
    }

    function reNotOk() {
        countNotOk = 0;
        //$("#notOk").text("不通过");
        $("#notOkText").text("不通过");
    }

    function reLight() {
        countLight = 0;
        //$("#onlylight").text("只复检车灯");
        $("#lightText").text("只复检车灯");
    }
    
    function reFree() {
        countFree = 0;
        //$("#free").text("新能源免检");
        $("#freeText").text("新能源免检");
    }

    function revokeProgram() {
        reOk();
        reNotOk();
        reLight();
        reFree();
    }

    //加载这个用户角色对应下所有的数据
    function loadData() {

        $.ajax({
            url: '/vehicle/loadData',
            dataType: "json",
            type : 'post',
            contentType: "application/json", //必须有
            success: function (data) {
                if(data.flag){
                    //循环拿到的数组
                    var arr = data.data;
                    //console.log(arr);
                    $("#dataEx").empty();
                    for(var i = 0; i < arr.length; i++) {
                        /*var str = "<li id='channel_"+arr[i].buisId+"' flag='empty' >"
                        +"<a href='javascript:void(0);' onclick='showPanel('"+arr[i].procInstId+"','"+arr[i].plateNo+"','"+arr[i].detectionState+"','"+arr[i].buisId+"')' data-swipe-close='false' data-dismissible='false'>"
                        +"<span class='ui-listview-inset'>"+arr[i].plateNo+"</span>"
                        +"<span class='ui-listview-inset' style='margin-left: 50px;'>"+arr[i].detectionState+"</span>"
                        +"<span class='ui-listview-inset "+arr[i].statusCss+"' style='margin-left: 50px;'>"+arr[i].nowStatus+"</span>"
                        +"<span class='ui-listview-inset' style='margin-left: 50px;'>"+arr[i].flowStatus+"</span>"
                        +"<span class='ui-li-count'>"+arr[i].newIcon+"</span>"
                        +"</a>"
                        +"</li>";
                        $("#dataEx").append(str);*/
                        var gettpl = document.getElementById('channel').innerHTML;
                        laytpl(gettpl).render(arr[i], function (html) {
                            $("#dataEx").append(html);
                            $("#channel_"+arr[i].buisId).slideDown();
                            $("#channel_"+arr[i].buisId).attr("flag",arr[i].flag);
                        });
                    }
                    $('#dataEx').listview('refresh');
                } else {
                    //window.location.href="/wx/message/fail";
                }
                $("#adelePage").panel("close");
            }
        });

    }



</script>


<script id="freeLocation" type="text/html">
    <a href="#adelePage" data-swipe-close="false" data-dismissible="false">空闲</a>
</script>

<script id="channel" type="text/html">
    <li id="channel_{{d.buisId}}" flag="empty" >
        <a href="javascript:void(0);" onclick="showPanel('{{d.procInstId}}','{{d.plateNo}}','{{d.detectionState}}','{{d.buisId}}','{{d.flowStatus}}')" data-swipe-close="false" data-dismissible="false">
            <span class="ui-listview-inset">{{d.plateNo}}</span>
            <span class="ui-listview-inset" style="margin-left: 20px;">{{d.detectionState}}</span>
            <span class="ui-listview-inset {{d.statusCss}} " style="margin-left: 20px;">{{d.nowStatus}}</span>
            <span class="ui-listview-inset" style="margin-left: 20px;">{{d.flowStatus}}</span>
            <span class="ui-li-count">{{d.newIcon}}</span>
        </a>
    </li>
</script>

<script id="updateChannel" type="text/html">
        <a href="javascript:void(0);" onclick="showPanel('{{d.procInstId}}','{{d.plateNo}}','{{d.detectionState}}','{{d.buisId}}','{{d.flowStatus}}')" data-swipe-close="false" data-dismissible="false">
            <span class="ui-listview-inset">{{d.plateNo}}</span>
            <span class="ui-listview-inset" style="margin-left: 20px;">{{d.detectionState}}</span>
            <span class="ui-listview-inset {{d.statusCss}} " style="margin-left: 20px;">{{d.nowStatus}}</span>
            <span class="ui-listview-inset" style="margin-left: 20px;">{{d.flowStatus}}</span>
            <span class="ui-li-count">{{d.newIcon}}</span>
        </a>
</script>
<script id="updateChannelNoClick" type="text/html">
    <a href="javascript:void(0);"  data-swipe-close="false" data-dismissible="false">
        <span class="ui-listview-inset">{{d.plateNo}}</span>
        <span class="ui-listview-inset" style="margin-left: 20px;">{{d.detectionState}}</span>
        <span class="ui-listview-inset {{d.statusCss}} " style="margin-left: 20px;">{{d.nowStatus}}</span>
        <span class="ui-listview-inset" style="margin-left: 20px;">{{d.flowStatus}}</span>
        <span class="ui-li-count">{{d.newIcon}}</span>
    </a>
</script>



<script id="message" type="text/html">
        <h2>检测完成确认!</h2>
        <p>车牌号：</p>
        <p>{{d.plateNo}}
        <p>{{d.flowStatus}}</p>
        <br>{{d.detectionState}}
        </p>
        <p>双击确认！！</p>
        <div  data-role="controlgroup" data-type="vertical">

            <a href="#" data-role="button" id="ok" onclick="subUp(this,'{{d.buisId}}','{{d.flowStatus}}')"
               class="ui-btn ui-mini ui-shadow  ui-icon-check ui-btn-icon-left" style="padding-top: 1.4em;padding-bottom: 1.4em"><p id="okText" style="font-size: 22px">通过</p></a>
            {{#if(d.flowStatus != '缴费核算'){ }}
            <a href="#" data-role="button" id="notOk" onclick="subNotOk(this,'{{d.buisId}}','{{d.flowStatus}}')"
               class="ui-btn ui-mini ui-shadow  ui-icon-delete ui-btn-icon-left" style="padding-top: 1.4em;padding-bottom: 1.4em"><p id="notOkText" style="font-size: 22px">不通过</p></a>
            {{# } }}
            {{#if(d.flowStatus == '上线检测'){ }}
            <a href="#" data-role="button" id="onlylight" onclick="checkLight(this,'{{d.buisId}}')"
               class="ui-btn ui-mini ui-shadow  ui-icon-delete ui-btn-icon-left" style="padding-top: 1.4em;padding-bottom: 1.4em"><p id="lightText" style="font-size: 22px">只复检车灯</p></a>
            {{# } }}
            {{#if(d.flowStatus == '尾气检测'){ }}
            <a href="#" data-role="button" id="free" onclick="subFree(this,'{{d.buisId}}','{{d.flowStatus}}')"
               class="ui-btn ui-mini ui-shadow  ui-icon-delete ui-btn-icon-left" style="padding-top: 1.4em;padding-bottom: 1.4em"><p id="freeText" style="font-size: 22px">新能源免检</p></a>
            {{# } }}
            <a href="#" data-role="button" id="re" onclick="revokeProgram(this,'{{d.buisId}}')"
               class="ui-btn ui-mini ui-shadow ui-icon-back ui-btn-icon-left" style="padding-top: 1.4em;padding-bottom: 1.4em"><p id="reText" style="font-size: 22px">撤销</p></a>
        </div>
</script>

<div id="tts">
</div>

<script type="text/javascript">

    $(document).ready(function() {
        loadData();

        $("#refreshData").click(function () {
            loadData();
        });
    })

    var stompClient = null;
    $(function () {
        var socket = new SockJS('/endpoint-websocket'); //连接上端点(基站)
        stompClient = Stomp.over(socket);			//用stom进行包装，规范协议
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/flow/${currentUser.id}', function (result) {
                console.log(result.body);
                var json = JSON.parse(result.body);
                var data = $.parseJSON( json.content );
                var nowStatus = data.nowStatus;
                console.log(data);
                if(data.action=='add'){
                    if(selectOne(data.buisId)){
                        var uptpl = "";
                        if (nowStatus == "未检测" ) {
                            uptpl = document.getElementById('updateChannel').innerHTML;
                        } else {
                            uptpl = document.getElementById('updateChannelNoClick').innerHTML;
                        }
                        //var uptpl = document.getElementById('updateChannel').innerHTML;
                        laytpl(uptpl).render(data, function (html) {
                            $("#channel_"+data.buisId).html(html);
                            $("#channel_"+data.buisId).slideDown();
                            $("#channel_"+data.buisId).attr("flag",data.flag);
                            $('#dataEx').listview('refresh');
                        });
                        return;
                    }
                    var eId = isEmpty();
                    if(eId==''){//哪里有空的位置插入到哪里
                        voiceTTs(data.plateNo + "加入尾气检测队列")
                        var gettpl = document.getElementById('channel').innerHTML;
                        laytpl(gettpl).render(data, function (html) {
                            $("#dataEx").append(html);
                            $("#channel_"+data.buisId).slideDown();
                            $("#channel_"+data.buisId).attr("flag",data.flag);
                            $('#dataEx').listview('refresh');
                        });
                    }else{
                        voiceTTs(data.plateNo + "状态变更为"+data.nowStatus)
                        //var uptpl = document.getElementById('updateChannel').innerHTML;
                        var uptpl = "";
                        if (nowStatus == "未检测") {
                            uptpl = document.getElementById('updateChannel').innerHTML;
                        } else {
                            uptpl = document.getElementById('updateChannelNoClick').innerHTML;
                        }
                        laytpl(uptpl).render(data, function (html) {
                            $(eId).html(html)
                            //$("#channel_"+data.buisId).html(html);
                            $(eId).slideDown();
                            $(eId).attr("flag",data.flag);
                            $("#channel_"+data.buisId).attr("id","#channel_"+data.buisId);//更换新的Id
                            $('#dataEx').listview('refresh');
                        });
                    }


                }else if(data.action=='up'){
                    if(!selectOne(data.buisId)){
                        return;
                    };
                    voiceTTs(data.plateNo + "状态变更为"+data.nowStatus)
                    var uptpl = "";
                    if (nowStatus == "未检测") {
                        uptpl = document.getElementById('updateChannel').innerHTML;
                    } else {
                        uptpl = document.getElementById('updateChannelNoClick').innerHTML;
                    }
                    //var uptpl = document.getElementById('updateChannel').innerHTML;
                    laytpl(uptpl).render(data, function (html) {
                        $("#channel_"+data.buisId).html(html);
                        $("#channel_"+data.buisId).slideDown();
                        $("#channel_"+data.buisId).attr("flag",data.flag);
                        $('#dataEx').listview('refresh');
                    });
                    //alert(data.plateNo+"up");
                }else if(data.action=='del'){//暂时没有删除
                    // var eId = isEmpty();
                    // if(eId==''){//哪里有空的位置插入到哪里
                    //     console.log(data.busiId+"列表中没有显示");
                    //     return;//没有要删除的del
                    // }else{
                    //
                    // }
                } else if (data.action=='msg') {
                    //定时器传的数据。保证socket一直存在
                }
            });
        });


        //前台写一个每隔多少分钟轮询的方法

    });


    function sendMessage() {
        stompClient.send("",JSON.stringify({'page':'main'}));

    }



    function selectOne(busiId){
        //dataEx
        var flag = false;

        $("#dataEx li").each(function(){
            if($(this).attr("id")=='channel_'+busiId){
                flag = true;
                return true;
            };
        });
        return flag;
    }



    function isEmpty(){
        var id = "";
        $("#dataEx li").each(function(){
            if($(this).attr("flag")=='empty'){//如果是空则表示可以插入
                id = $(this).attr("id");
                return true;
            };
        })
        return "";
    }



    function showContent(data){
        voiceTTs(data.content);
    }



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
    //showPanel('{{d.procInstId}}','{{d.plateNo}}','{{d.detectionState}}')
    function showPanel(procInstId,plateNo,detectionState,buisId,flowStatus){
        var data = {procInstId:procInstId,plateNo:plateNo,detectionState:detectionState,buisId:buisId,flowStatus:flowStatus};
        var gettpl2 = document.getElementById('message').innerHTML;
        laytpl(gettpl2).render(data, function (html) {
            $("#adelePage").html(html);
            $("#adelePage").panel("open");
        });

    }


</script>


</html>