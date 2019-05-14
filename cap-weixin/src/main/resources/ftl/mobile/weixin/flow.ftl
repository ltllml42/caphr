<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>检测项目</title>
<link rel="stylesheet" href="${re.contextPath}/plugin/lib/weui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/jquery-weui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/css/demos.css">
<link href="${re.contextPath}/plugin/css/timeline.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${re.contextPath}/plugin/js/modernizr.js"></script>
<script type="text/javascript" src="${re.contextPath}/plugin/js/jquery-1.8.3.min.js"></script>

</head>
<body>
<#assign wxUser = Session["weiXinUser"]>
<header class="wy-header">
    <a href="javascript:void(0);"><div class="wy-header-icon-back"><span></span></div></a>
    <div class="wy-header-title"><h3>历史记录详情</h3></div>
</header>

<div class="weui-cells weui-cells_form">
    <div class="weui-cells__title">验车时间</div>
    <div class="weui-cells">
		<a class="weui-cell weui-cell_access" href="javascript:void(0);">
			<div class="weui-cell__bd">
				<p>${cwor.endTime}</p>
			</div>
			<div class="weui-cell__ft">
			</div>
		</a>
    </div>
</div>
<div class="weui-cells weui-cells_form">
    <div class="weui-cells__title">时间线</div>
    <section id="cd-timeline" class="cd-container">
	<#list cvst as cvstList>
		<div class="cd-timeline-block">
				<div class="cd-timeline-img cd-picture">
					<img src="${re.contextPath}/plugin/images/${cvst.iconImg}" alt="摄像头">
				</div><!-- cd-timeline-img -->
				<div class="cd-timeline-content">
					<h2 class="cd-date">${cvst.endTime}</h2>
					<p>${cvst.taskName}</p>
                    <p>${cvst.nowStatuStr}</p>
					<span class="cd-date">消耗时长:${cvst.duration}</span>
				</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->
	</#list>
	</section> <!-- cd-timeline -->
</div>

	
<script type="text/javascript">
$(function(){
	var $timeline_block = $('.cd-timeline-block');
	//hide timeline blocks which are outside the viewport
	$timeline_block.each(function(){
		if($(this).offset().top > $(window).scrollTop()+$(window).height()*0.75) {
			$(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden');
		}
	});
	//on scolling, show/animate timeline blocks when enter the viewport
	$(window).on('scroll', function(){
		$timeline_block.each(function(){
			if( $(this).offset().top <= $(window).scrollTop()+$(window).height()*0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) {
				$(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
			}
		});
	});
});
</script>

</body>
</html>
