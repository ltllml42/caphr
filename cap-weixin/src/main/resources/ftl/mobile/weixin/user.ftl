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
<body ontouchstart>
<header class="wy-header">
    <a href="http://www.baidu.com">
        <div class="wy-header-icon-back"><span></span></div>
    </a>
    <div class="wy-header-title"><h3>车辆绑定</h3></div>
</header>


<form id="个人信息绑定">
    <div class="weui-cells weui-cells_form">
        <div class="weui-cells__title">个人信息</div>
        <div class="weui-cells">
            <a class="weui-cell weui-cell_access" href="#">
                <div class="weui-cell__hd"><img height="80px" width="80px" src="${fans.headImgUrl}"></div>
                <div class="weui-cell__bd">
                    <p>${fans.nickName}</p>
                    <p class="weui-footer__text">${fans.province}&nbsp;&nbsp;${fans.city} &</p>
                </div>
                <div class="weui-cell__ft">
                </div>
            </a>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="name" maxlength="20" name="name" type="text" value="${fans.name}"
                       pattern="^[\u4E00-\u9FA5\uf900-\ufa2d·s]{1,20}$" required="required"
                       placeholder="必须为汉字或者·不能超过20个汉字">
            </div>
            <div class="weui-cell__ft">
                <i class="weui-icon-warn"></i>
            </div>
        </div>

        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">性别</label></div>
            <div class="weui-cell__bd">
                <input id="sex" class="weui-input" id="sex" type="text" value="${fans.sexDesc}" data-values="${fans.sex}" readonly
                       placeholder="性别">
            </div>
        </div>
        <!--weui-cell_vcode-->
        <div class="weui-cell ">

            <div class="weui-cell__hd"><label class="weui-label">手机</label></div>
            <div class="weui-cell__bd">
                <input id="telphone" class="weui-input" maxlength="11" name="telphone" required="true" type="tel"
                      value="${fans.telphone}" placeholder="手机号码(11位)">

            </div>
            <div class="weui-cell__ft">
                <i class="weui-icon-warn"></i>
            </div>
        </div>
    </div>

    <div class="weui-cells weui-cells_form">
        <div class="weui-cells__title">车辆信息</div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">车牌号</label>
            </div>
            <div class="weui-label_hz">

                <input class="weui-input" type="text" id="lpnChar" name="lpnChar" msg="输入有误" required="required"
                     value="${cvInfo.lpnChar}"  placeholder="汉字字母">
            </div>
            <div class="weui-cell__bd" style="display: flex;">
                <label class="weui-label_spot">&#8226</label>
                <input class="weui-input" type="text" id="lpnNumber" name="lpnNumber" maxlength="6" max="6" msg="输入有误"
                      value="${cvInfo.lpnNumber}" required="required" pattern="^((([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})$" placeholder="字母需大写">
            </div>
            <div class="weui-cell__ft">
                <i class="weui-icon-warn"></i>
            </div>
        </div>
        <div class="weui-cells__tips">
            <label class="weui-label_exc"> <font color="red">例如:</font> 京A &#8226 KB126(能源车为6位) 字母需大写</label>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">年检分类</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" id="njType" name="njType" readonly="readonly" placeholder="选择分类">
            </div>
            <div class="weui-cell__ft">
                <i class="weui-icon-warn"></i>
            </div>
        </div>


        <div class="weui-cell ">
            <div class="weui-cell__hd">
                <label class="weui-label">购车日期</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" required="required" id="buyTime" name="buyTime" type="text" value="${cvInfo.buyTime}"
                       readonly="readonly" data-toggle='date' placeholder="购买车的时间">
            </div>
            <div class="weui-cell__ft">
                <i class="weui-icon-warn"></i>
            </div>
        </div>

        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label">验车日期</label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" id="lastTestTime" name="lastTestTime" type="text" value="${cvInfo.lastTestTime}" readonly="readonly"
                       placeholder="最后一次年检时间">
            </div>
            <div class="weui-cell__ft">
                <i class="weui-icon-warn"></i>
            </div>
        </div>

        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" href="javascript:" id="vehiclebindingForm">确定</a>
        </div>


    </div>

</form>

<div class="weui-footer">
    <p class="weui-footer__links">
        <a href="#" class="weui-footer__link">北京兴通爱民机动车检测有限公司</a>
    </p>
    <p class="weui-footer__text">@版权所有 电话(010)80519721</p>
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


<script type="text/javascript">
    $(function () {
        //weui-cell_warn
        $('#vehiclebindingForm').click(function () {
            var name = document.getElementById("name");
            var sex = document.getElementById("sex");
            var telphone = document.getElementById("telphone");
            var lpnChar = document.getElementById("lpnChar");
            var lpnNumber = document.getElementById("lpnNumber");
            var njType = document.getElementById("njType")
            var buyTime = document.getElementById("buyTime");
            var lastTestTime = document.getElementById("lastTestTime");

            if (!html5Validate(document.getElementById("name"), "'姓名不能为空，并必须为汉字或者·不能超过20个汉字'")) {
                return;
            };

            if (!html5Validate(document.getElementById("telphone"), "手机号码不正确")) {
                return;
            };

            if (!lpNoValidate(document.getElementById("lpnChar"), document.getElementById("lpnNumber"), "车牌号码填写有误，请检查")) {
                return;
            }

            if (!selectValidate(document.getElementById("njType"))) {
                return;
            }

            if (!selectValidate(document.getElementById("buyTime"))) {
                return;
            }

            if (!selectValidate(document.getElementById("lastTestTime"))) {
                return;
            }

            var data = {};
            data.fansId = "${fans.id}";
            data.carId = "${cvInfo.id}";
            data.name = name.value;
            data.sex = $(sex).attr("data-values");
            data.telPhone = telphone.value;
            data.plateNo = lpnChar.value + "@" + lpnNumber.value;
            data.njType = $(njType).attr("data-values");
            data.buyTimeStr = buyTime.value;
            data.lastTestTimeStr = lastTestTime.value;
            var jsonStr = JSON.stringify(data);
            $.showLoading("数据提交中...");
            if (jsonStr != null || jsonStr != [{}]) {
                $.ajax({
                    url: '/oauth2/${appid}/saveOrUpdateCar',
                    dataType: "json",
                    data: jsonStr,
                    type : 'post',
                    contentType: "application/json", //必须有
                    success: function (data) {
                        $.hideLoading();
                        if(data.flag=="success"){
                            window.location.href="/oauth2/${appid}/success?msg=车辆绑定成功";
                        } else {
                            $.toptip('绑定失败：'+data.msg, 'error');
                        }
                    }
                });

            }
        });

        $("#name").blur(function () {
            html5Validate(this);
        });
        $("#telphone").blur(function () {
            html5Validate(this);
        });

        $("#lpnNumber").blur(function () {
            lpNoValidate(document.getElementById("lpnChar"), document.getElementById("lpnNumber"), "车牌号码填写有误，请检查");
        });

        $("#njType").change(function () {
            selectValidate(this)
        });

        $("#buyTime").change(function () {
            selectValidate(this)
        });

        $("#lastTestTime").change(function () {
            selectValidate(this)
        });

        function html5Validate(v, msg) {
            var phtml = $(v).parent().parent();
            //alert(v.validity.valueMissing);

            var checkName = v.checkValidity();
            if (!checkName) {
                phtml.addClass("weui-cell_warn");
                if (msg != "") {
                    $.toptip(msg);
                }
                return false;
            } else {
                phtml.removeClass("weui-cell_warn");
                phtml.find("i").removeClass("weui-icon-warn");
                phtml.find("i").addClass("weui-icon-success");
                return true;
            }
        }


        function selectValidate(code, msg) {
            var vvlidate = isNull(code.value);
            var phtml = $(code).parent().parent();
            if (vvlidate) {
                phtml.removeClass("weui-cell_warn");
                phtml.find("i").removeClass("weui-icon-warn");
                phtml.find("i").addClass("weui-icon-success");
                return true;
            } else {
                phtml.addClass("weui-cell_warn");
                $.toptip(msg);
                return false;
            }
        }


        function lpNoValidate(code, num, msg) {
            var codeVali = isNull(code.value);
            var phtml = $(code).parent().parent();
            if (codeVali) {
                phtml.removeClass("weui-cell_warn");
                phtml.find("i").removeClass("weui-icon-warn");
                phtml.find("i").addClass("weui-icon-success");
                return html5Validate(num, msg);
            } else {
                phtml.addClass("weui-cell_warn");
                $.toptip(msg);
                return false;
            }
        }

        function isNull(v) {
            if (v !== "") {
                return true;
            } else {
                return false;
            }
        }

        //
        $("#lpnChar").carnumPicker({
            showDistrict: false,
            title: "请选择车牌号"
        });

        FastClick.attach(document.body);
    });
</script>


<script type="text/javascript">
    //weui-cell_warn
    //		$("#sex").select({
    //			title: "请选择性别",
    //			items: ['男','女']
    //		});
    //

    //		$("#sex").picker({
    //		  title: "请选择性别",
    //		  cols: [
    //		    {
    //		      textAlign: 'center',
    //		      values: ['男','女']
    //		      //如果你希望显示文案和实际值不同，可以在这里加一个displayValues: [.....]
    //		    }
    //		  ]
    //		});
    $.ajax({
        url: '/wx/message/sex',
        dataType: "json",
        success: function (data) {
            if (data) {
                $("#sex").select({
                    title: "请选择性别",
                    items: data
                });
            }
        }
    });


    $.ajax({
        url: '/wx/message/njType',
        dataType: "json",
        success: function (data) {
            if (data) {
                $("#njType").select({
                    title: "选择年检的类型",
                    items: data
                });
            }
        }
    });


    $("#buyTime").calendar({
        dateFormat: 'yyyy年mm月dd日'
    });


    $("#lastTestTime").calendar({
        dateFormat: 'yyyy年mm月dd日'
    });


</script>
</body>

</html>
