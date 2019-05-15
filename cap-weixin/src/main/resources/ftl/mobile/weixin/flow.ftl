<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>检测项目</title>
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
	<#list cvstList as cvst>
		<div class="cd-timeline-block">
            <div class="cd-timeline-img cd-picture">
                <img src="${re.contextPath}/plugin/images/${cvst.iconImg}" alt="摄像头">
            </div><!-- cd-timeline-img -->
            <div class="cd-timeline-content">
                <h2>${cvst.taskName}</h2>
                <span class="cd-date">开始时间：${(cvst.startTime?string("yyyy-MM-dd"))!}</span>
                <span class="cd-date">结束时间：${(cvst.endTime?string("yyyy-MM-dd"))!}</span>
                <p class="cd-date">${cvst.nowStatuStr} 消耗时长:${cvst.duration}</p>
            </div> <!-- cd-timeline-content -->
        </div> <!-- cd-timeline-block -->
	</#list>
</section> <!-- cd-timeline -->

	
<script type="text/javascript">
$(function(){

    var win = window,
            doc = document;
    function setFontSize() {
        var winWidth = $(window).width();

        //750这个数字是根据你的设计图的实际大小来的，所以值具体根据设计图的大小
        var size = (winWidth / 750) * 100;
        doc.documentElement.style.fontSize = (size < 100 ? size : 100) + 'px';
    };

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
