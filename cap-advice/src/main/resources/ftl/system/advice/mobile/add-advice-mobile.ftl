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
  <link rel="stylesheet" href="${re.contextPath}/plugin/dist/amazeui.min.css">
  <link rel="stylesheet" href="${re.contextPath}/plugin/dist/app.css">
  <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
  <script type="text/javascript" src="${re.contextPath}/plugin/dist/lrz.all.bundle.js"></script>


    <style>

        label {
            width: 160px !important;
            font-size: 16px;
            font-weight: bold !important;
            text-align: left !important;
        }

        #outer {
            margin: 0 auto;
            margin-top: 30%;
        }
        .bg {
            background: url('${re.contextPath}/plugin/background/bg2.png') no-repeat;
            background-size:cover;
        }
        .star {
            color: red;
            align-items: center;
        }
        .logoDiv {
            position: absolute;
            right: 10px;
            top: 30px;
        }
    </style>

</head>

<body class="bg">
<div class="logoDiv" >
    <img src="${re.contextPath}/plugin/background/logo.png">
</div>


<div id="outer" class="x-body " >
  <form class="layui-form layui-form-pane" style="margin-left: 20px;" method="post" action="addAdvice" id="subform">
      <input type="hidden" id="pageType" name="pageType" value="${pageType}"/>
    <#if pageType=='addProblem'>
        <input type="hidden" name="type" id="type" value="1"/>

        <input type="hidden" name="reportType" id="reportType" value="${reportType}"/>
    </#if>
    <#if pageType=='addAdvice'>
        <input type="hidden" name="type" value="2"/>
    </#if>

    <div style="width:100%;overflow: auto;">
    <div class="layui-form-item">
      <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
        <legend style="font-size:30px;color:red;font-weight: bold">
            <#if pageType=='addProblem'>
            举报问题
            </#if>
            <#if pageType=='addAdvice'>
            意见建议
            </#if>
        </legend>
      </fieldset>
    </div>
    <div class="layui-form-item">
      <label for="roleName" class="layui-form-label ">
            <#if reportType == '1'>
                <span class="star">*</span>
            </#if>

            <#if pageType=='addProblem'>
            举报人姓名：
            </#if>
            <#if pageType=='addAdvice'>
            提交人姓名：
            </#if>
      </label>
      <div class="layui-col-xs7">
        <input type="text"  id="name" name="name"  lay-verify="name" placeholder="请输入姓名"
               autocomplete="off" class="layui-input" >
      </div>
    </div>

    <div class="layui-form-item">
      <label for="remark" class="layui-form-label ">
            <#if reportType == '1'>
                <span class="star">*</span>
            </#if>
            <#if pageType=='addProblem'>
            举报人电话：
            </#if>
            <#if pageType=='addAdvice'>
            提交人电话：
            </#if>
      </label>
      <div class="layui-col-xs7">
        <input type="text" id="phone" name="phone"  autocomplete="off" lay-verify="subphone" class="layui-input" placeholder="请输入电话" >
      </div>
    </div>
    <#if pageType=='addProblem'>
    <div class="layui-form-item">
            <label for="remark" class="layui-form-label ">
            <span class="star">*</span>被举报人姓名：
            </label>
            <div class="layui-col-xs7">
                <input type="text" id="reportedperson" name="reportedperson" lay-verify="reportedperson"  autocomplete="off" class="layui-input" placeholder="请输入被举报人姓名" >
            </div>
    </div>

    <div class="layui-form-item">
            <label for="remark" class="layui-form-label ">
                <span class="star">*</span>被举报人部门：
            </label>
            <div class="layui-col-xs7">
                <input type="text" id="reporteddept" name="reporteddept" lay-verify="reporteddept"  autocomplete="off" class="layui-input" placeholder="请输入被举报人部门" >
            </div>
    </div>
    </#if>

    <div class="layui-form-item">
            <label for="remark" class="layui-form-label ">
                <span class="star">*</span>
                <#if pageType=='addProblem'>
                举报标题：
                </#if>
                <#if pageType=='addAdvice'>
                 提交标题：
                </#if>
            </label>
            <div class="layui-col-xs7">
                <input type="text" id="title" name="title" lay-verify="title"  autocomplete="off" class="layui-input" placeholder="请输入举报标题" >
            </div>
    </div>

        <div class="layui-form-item">
                <label for="remark" class="layui-form-label " style="height: 150px">
                    <span class="star">*</span>
                    <#if pageType=='addProblem'>
                    举报内容：
                    </#if>
                    <#if pageType=='addAdvice'>
                    提交内容：
                    </#if>
                </label>

                <div class="layui-col-xs7">
                    <textarea id="content" name="content" lay-verify="content" class="layui-textarea" placeholder="20字以上，500字以内"   style="resize: none;height: 150px;" ></textarea>
                    <div id="ms" class="layui-form-mid layui-word-aux">
                        <span id="ums">剩余500字</span>
                    </div>
                </div>
        </div>

        <input type="hidden" name="fileBase64" id="fileBase64" value="">
        <input type="hidden" name="fileName" id="fileName"/>
        <div class="layui-form-item">
        <#--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
            <legend style="font-size:16px;">附件上传</legend>
        </fieldset>-->
            <label for="remark" class="layui-form-label ">
                附件上传：
            </label>
            <div class="am-form-group am-form-file">
                <div>
                    <button type="button" class="am-btn am-btn-default am-btn-sm" style="height: 38px">
                    <#--<i class="am-icon-cloud-upload"></i>--> 选择要上传的文件</button>
                    <span id="fileNameSpan" style="height: 38px"></span>
                </div>
                <input type="file"  accept="image/*" name="logo" id="file">
            </div>

        </div>


        <div class="layui-form-item">
            <label for="remark" class="">
                标有<span class="star">*</span>的必须填写
            </label>
        </div>


        <#--<div class="layui-form-item">

            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend style="font-size:16px;">附件上传</legend>
            </fieldset>
            <div class="layui-input-inline">
                <div class="layui-upload-drag" style="margin-left:10%;" id="test10">
                    <i style="font-size:30px;" class="layui-icon"></i>
                    <p style="font-size: 10px">点击上传</p>
                </div>
            </div>
            <div class="layui-input-inline">

                <div  id="demo2" style="margin-top: 20px;margin-left: 50px">
                    <img src="${re.contextPath}/plugin/x-admin/images/bg.png" width="100px" height="100px" class="layui-upload-img layui-circle">
                </div>

            </div>

        </div>-->

        <#--<div id="imgView"></div>-->


        <div class="layui-form-item " style="margin-right: 30px;margin-top: 8px;text-align:center">

            <button  class="layui-btn layui-btn-warm" lay-filter="add" lay-submit>
                提交
            </button>
            <#--<button  class="layui-btn layui-btn-primary" id="back">
                返回
            </button>-->
        </div>


    </div>

      <#--<input id="file" name="file" type="hidden">-->
  <#--<div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 1px;margin-left:-20px;">-->
    <#--<div class="layui-form-item " style="margin-right: 30px;margin-top: 8px;text-align:center">

      <button  class="layui-btn layui-btn-warm" lay-filter="add" lay-submit>
        提交
      </button>
      <button  class="layui-btn layui-btn-primary" id="back">
        返回
      </button>
    </div>-->
  <#--</div>-->
  </form>
</div>
<script>
  layui.use(['form','layer'], function(){
    $ = layui.jquery;
    var form = layui.form
        ,layer = layui.layer;

    var reportType = '${reportType}';
    var type = $("#type").val();
    //自定义验证规则
    form.verify({
        title: function(value){
        if(value.trim()==""){
          return "标题不能为空";
        }
      },
        name: function (value) {
            if (type == '1' && reportType == '1') {
                //举报问题，实名举报的时候
                if (value.trim()=="") {
                    return "举报人姓名不能为空";
                }
            }
        },
        subphone: function (value) {
            var reg = /^1\d{10}$/;
            if (type == '1' && reportType == '1') {
                if (value.trim()=="") {
                    return "举报人电话不能为空";
                } else {
                    if (!reg.test(value)) {
                        return "请输入正确格式电话";
                    }
                }
            } else {
                if (value.trim()!="") {
                    if (!reg.test(value)) {
                        return "请输入正确格式电话";
                    }
                }
            }
        },
        reportedperson: function (value) {
            if (type == '1') {
                if(value.trim()==""){
                    return "被举报人不能为空";
                }
            }
        },
        reporteddept: function (value) {
            if (type == '1') {
                if(value.trim()==""){
                    return "被举报人部门不能为空";
                }
            }
        },
        content: function (value) {
            var len = value.length;
            if (value.trim()=="") {
                return "内容不能为空";
            }
            if (len<=20 || len>500) {
                return "内容应在20字到500字之间";
            }
        }
    });

   $('#back').click(function(){
     location.href="adviceIndex";
     return false;
   });
    //监听提交
    form.on('submit(add)', function(data){

      //layerAjax('addAdvice',data.field,'adviceList');
      //return false;
        /*$.ajax({
            url: 'addAdvice',
            method: 'post',
            data: data.field,
            dataType: 'JSON',
            success: function (res) {
                /!*if (res.code == '0') {
                    alert('提交成功');
                    location.href='addAdviceResult';
                } else {
                    alert(res.msg);
                }*!/
                alert('提交成功');
                location.href='addAdviceResult?id='+res.msg+"&pageType="+;

            }
        })*/
        $("#subform").submit();
    });

  });

  function searchLength(maxLen, obj) {
      var txt = $(obj).val().length;
      var len = maxLen - txt;
      if (len>0) {
          $("#ms").html("剩余"+len+"字");
      } else {
          obj.value = obj.value.substring(0, maxLen);
      }
  }
  
  $("#content").on('input propertychange', function () {
      var userDesc = $(this).val();
      var len;
      if (userDesc) {
          len = searchLength(500, this);
      }
  })
  
  

</script>
<script>
    document.querySelector('input[type=file]').addEventListener('change', function () {
        var that = this;
        lrz(that.files[0], {
            width: 800
        }).then(function (rst) {
                    //如果是ajax请求到后台的话，代码也在这里写，具体写法请参考自带的例子，

                    //这里是通过submit将数据统一提交，所以只保存到隐藏域中即可
                    /*var imgView = document.getElementById("imgView");
                    img = new Image(),
                            div = document.createElement('div'),
                            p = document.createElement('p'),
                            sourceSize = toFixed2(that.files[0].size / 1024),
                            resultSize = toFixed2(rst.fileLen / 1024),
                            scale = parseInt(100 - (resultSize / sourceSize * 100));
                    img.width = 500;
                    img.height =500;
                    img.className='image';*/
                    /*imgView.innerHTML = "";//先清空原先数值
                    p.style.fontSize = 13 + 'px';
                    p.innerHTML      = '源文件大小：<span>' +
                            sourceSize + 'KB' +
                            '</span> <br />' +
                            '上传后大小：<span>' +
                            resultSize + 'KB (省' + scale + '%)' +
                            '</span> ';*/
                    /*div.className = '';
                    div.appendChild(img);
                    div.appendChild(p);
                    img.onload = function () {

                        document.querySelector('#imgView').appendChild(div);
                    };*/
                    //img.src = rst.base64;
                    //progress.done();
                    //保存到隐藏域中。
                    //document.getElementById("fileBase64").value = rst.base64;
                    $("#fileBase64").val(rst.base64);
                    $("#fileName").val(that.files[0].name);
                    $("#fileNameSpan").html(that.files[0].name);
                    return rst;
                });
    });

    function toFixed2 (num) {
        return parseFloat(+num.toFixed(2));
    }


</script>



</body>

</html>
