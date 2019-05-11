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

    <style>

        label {
            width: 150px !important;

        }

        #outer {
            text-align: center;
            margin: 0 auto;
            margin-top: 35%;
        }

        .bg {
            background: url('${re.contextPath}/plugin/background/bg.png') no-repeat;
            background-size:cover;
        }
    </style>
    <script>


        $(document).ready(function(){
            var selectCode = '${selectCode}';
            if (selectCode) {
                $("#adviceCode").val(selectCode);
                getAdviceByCode();
            }

        });


    </script>

</head>

<body class="bg">
<div id="outer" class="x-body">
    <div class="lenos-search">
        <div class="select">
            案件查询码：
            <div class="layui-inline">
                <input type="text"  id="adviceCode" name="adviceCode"
                       autocomplete="off" class="layui-input" >
            </div>
            <button class="select-on layui-btn layui-btn-sm layui-btn-warm" onclick="getAdviceByCode()"><i class="layui-icon"></i>
            </button>
        </div>
    </div>

    <div style="display: none;margin-top: 20px" id="resultDiv">

        <div class="layui-form layui-form-pane" style="margin-left: 20px;">
            <input type="hidden" id="capAdviceId" name="capAdviceId" value="0"/>

                <div class="layui-form-item">
                    <label for="type"  class="layui-form-label">
                        类型：
                    </label>
                    <div class="layui-col-xs7">
                        <input type="text"  id="type" name="type"  lay-verify="type"
                               autocomplete="off" class="layui-input" readonly="readonly">
                    </div>
                </div>

                <div class="layui-form-item" id="reportTypeDiv" style="display: none">
                    <label for="type"  class="layui-form-label">
                        举报类型：
                    </label>
                    <div class="layui-col-xs7">
                        <input type="text"  id="reportType" name="reportType"  lay-verify="reportType"
                               autocomplete="off" class="layui-input" readonly="readonly">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label for="roleName" class="layui-form-label ">
                    提交人姓名：
                    </label>
                    <div class="layui-col-xs7">
                        <input type="text"  id="name" name="name"  lay-verify="name"
                               autocomplete="off" class="layui-input" readonly="readonly">
                    </div>
                <#--<div id="ms" class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span><span id="ums">标题必填</span>
                </div>-->
                </div>

                <div class="layui-form-item">
                    <label for="remark" class="layui-form-label ">
                        提交人电话：
                    </label>
                    <div class="layui-col-xs7">
                    <input type="text" id="phone" name="phone" lay-verify="phone"  autocomplete="off" class="layui-input"  readonly="readonly">
                </div>
                </div>

                <div id="problemDiv" style="display: none;">

                <div class="layui-form-item">
                        <label for="remark" class="layui-form-label ">
                            被举报人姓名：
                        </label>
                        <div class=" layui-col-xs7">
                            <input type="text" id="reportedperson" name="reportedperson" lay-verify="reportedperson"  autocomplete="off" class="layui-input"  readonly="readonly">
                        </div>
                </div>

                <div class="layui-form-item">
                        <label for="remark" class="layui-form-label ">
                            被举报人部门：
                        </label>
                        <div class="layui-col-xs7">
                            <input type="text" id="reporteddept" name="reporteddept" lay-verify="reporteddept"  autocomplete="off" class="layui-input"  readonly="readonly">
                        </div>
                </div>
                </div>

                <div class="layui-form-item">
                        <label for="remark" class="layui-form-label ">
                         提交标题：
                        </label>
                        <div class="layui-col-xs7">
                            <input type="text" id="title" name="title" lay-verify="title"  autocomplete="off" class="layui-input"  readonly="readonly">
                        </div>
                </div>

                <div class="layui-form-item">
                        <label for="remark" class="layui-form-label">
                            提交内容：
                        </label>

                        <div class="layui-col-xs7">
                            <textarea id="content" name="content" lay-verify="content" class="layui-textarea" placeholder="20字以上，500字以内" readonly="readonly" style="resize: none"></textarea>
                        <#--<div id="ms" class="layui-form-mid layui-word-aux">
                            <span id="ums">剩余500字</span>
                        </div>-->
                        </div>
                </div>

            <div class="layui-form-item" id="remarkDiv" style="display: none">
                <label for="remark" class="layui-form-label">
                    处理内容：
                </label>

                <div class="layui-col-xs7">
                    <textarea id="remark" name="remark"  class="layui-textarea"  readonly="readonly" style="resize: none"></textarea>
                <#--<div id="ms" class="layui-form-mid layui-word-aux">
                    <span id="ums">剩余500字</span>
                </div>-->
                </div>
            </div>



                <div class="layui-input-inline" id="imgDiv" style="display: none;">

                    <div  id="demo2" style="margin-top: 20px;margin-left: 50px">
                        <img id="file" src="/images/${re.contextPath}/${capAdvice.file}" width="100px" height="100px" class="layui-upload-img layui-circle">
                    </div>

                </div>



            <div style="overflow:auto;display: none" id="problemTableDiv">
                <table id="adviceDealList" class="layui-hide" lay-filter="user"></table>
                <#--<script type="text/html" id="toolBar">
                    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                </script>-->
            </div>
                <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
              position: fixed;bottom: 1px;margin-left:-20px;">
                    <div class="layui-form-item" style="margin-right: 30px;margin-top: 8px;text-align: center">


                        <button class="layui-btn layui-btn-primary" id="back">
                            返回
                        </button>
                    </div>
                </div>
        </div>




    </div>

</div>
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

    layui.use([ 'layer', 'table'], function () {
        $ = layui.jquery;
        var layer = layui.layer;
        var table = layui.table;

        //方法级渲染
        table.render({
            id: 'adviceDealList',
            elem: '#adviceDealList'
            , url: 'showAdviceDealList'
            , cols: [[
                {field: 'content', title: '处理情况', width: '70%'}
                , {field: 'createDate', title: '提交时间', width: '30%',templet: '<div>{{ layui.laytpl.toDateString(d.createDate,"yyyy-MM-dd") }}</div>'}
            ]]
            , page: false
        });

        var $ = layui.$, active = {
            select: function () {
                var title = $('#title').val();
                var content = $('#content').val();
                table.reload('adviceDealList', {
                    where: {
                        title: null,
                        content: null
                    }
                });
            },
            reload:function(){
                $('#title').val('');
                $('#content').val('');
                table.reload('adviceDealList', {
                    where: {
                        title: null,
                        content: null
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
                detail('编辑角色', 'showUpdateDeal?id=' + data.id, 700, 450);
            } else if (obj.event === 'del') {
                layer.confirm('确定删除角色[<label style="color: #00AA91;">' + data.roleName + '</label>]?', function(){
                    del(data.id);
                });
            } else if (obj.event === 'edit') {
                update('编辑角色', 'showUpdateDeal?id=' + data.id, 700, 450);
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




        $('#back').click(function () {
            /*var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);*/
            location.href="adviceIndex";
        });
        //监听提交

    });


    function del(id) {
        $.ajax({
            url: "delAdviceDeal",
            type: "post",
            data: {id: id},
            success: function (d) {
                if(d.msg){
                    layer.msg(d.msg,{icon:6,offset: 'rb',area:['120px','80px'],anim:2});
                    layui.table.reload('adviceDealList');
                }else{
                    layer.msg(d.msg,{icon:5,offset: 'rb',area:['120px','80px'],anim:2});
                }
            }
        });
    }
    function detail(title, url, w, h) {
        var number = 1;
        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "/error/404";
        }
        ;
        if (w == null || w == '') {
            w = ($(window).width() * 0.9);
        }
        ;
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        ;
        layer.open({
            id: 'user-detail',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url + '&detail=true',
            // btn:['关闭']
        });
    }
    /**
     * 更新用户
     */
    function update(title, url, w, h) {
        if (title == null || title == '') {
            title = false;
        }
        if (url == null || url == '') {
            url = "/error/404";
        }
        if (w == null || w == '') {
            w = ($(window).width() * 0.9);
        }
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        layer.open({
            id: 'user-update',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: false,
            shade: 0.4,
            title: title,
            content: url + '&detail=false'
        });
    }



    /*弹出层*/
    /*
     参数解释：
     title   标题
     url     请求的url
     id      需要操作的数据id
     w       弹出层宽度（缺省调默认值）
     h       弹出层高度（缺省调默认值）
     */
    function addDeal(title, url, w, h) {
        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "/error/404";
        }
        ;
        if (w == null || w == '') {
            w = ($(window).width() * 0.9);
        }
        ;
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        ;
        layer.open({
            id: 'deal-add',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: false,
            shade: 0.4,
            title: title,
            content: url
        });
    }
    
    
    function getAdviceByCode() {
        var code = $("#adviceCode").val();
        if (code == "") {
            alert('查询码为空');
        } else {
            $.ajax({
                url: "queryAdviceByCode",
                type: "post",
                data: {code: code},
                success: function (data) {
                    if (data.flag) {
                        //给每个input赋值，然后把div显示，然后把处理结果的列表查询一遍
                        console.log(data);
                        console.log(data.data);
                        $("#name").val(data.data.name);
                        $("#phone").val(data.data.phone);
                        $("#title").val(data.data.title);
                        $("#content").val(data.data.content);
                        if (data.data.file != '') {
                            $("#file").attr("src", "/images/${re.contextPath}/"+data.data.file);
                            $("#imgDiv").show();
                        } else {
                            $("#imgDiv").hide();
                        }
                        if (data.data.type == '1') {
                            $("#type").val('举报问题');
                            $("#reportedperson").val(data.data.reportedperson);
                            $("#reporteddept").val(data.data.reporteddept);
                            $("#problemDiv").show();
                            $("#reportTypeDiv").show();
                            if (data.data.reportType == '1') {
                                $("#reportType").val('实名举报');
                            } else {
                                $("#reportType").val('匿名举报');
                            }
                            $("#remarkDiv").hide();
                            //$("#capAdviceId").val(data.data.id);
                            $("#problemTableDiv").show();
                            layui.table.reload('adviceDealList', {
                                where: {
                                    adviceId: data.data.id
                                }
                            });

                        } else {
                            $("#type").val('意见建议');
                            $("#problemDiv").hide();
                            $("#reportTypeDiv").hide();
                            $("#problemTableDiv").hide();
                            $("#remarkDiv").show();
                            $("#remark").val(data.data.remark);
                        }
                        $("#resultDiv").show();
                    } else {
                        layer.msg(data.msg,{icon:5,offset: 'rb',area:['120px','80px'],anim:2});
                        $("#resultDiv").hide();
                    }
                }
            });
        }
    }
    
    
</script>
</body>

</html>
