

##FreeMarker开发备注 ##

```text
  ##获取shiro用户信息  <#assign currentUser = Session["curentUser"]>
  ##获取shiro微信Oauth2鉴权信息    <#assign wxUser = Session["weiXinUser"]>

   ##获取list 
  <#list customerList as cl>
  <option value="${cl.id}" <#if cl.id == declare.customerId>selected = selected"</#if> >${cl.customerName}</option>
  </#list>  
    
``` 


cd-icon-movie.svg

cd-icon-pad.svg


判断是否为空
```text
freemarker中显示某对象使用${name}.

 

但如果name为null，freemarker就会报错。如果需要判断对象是否为空：

<#if name??>

……

</#if>

 

当然也可以通过设置默认值${name!''}来避免对象为空的错误。如果name为空，就以默认值（“!”后的字符）显示。

 

对象user，name为user的属性的情况，user，name都有可能为空，那么可以写成${(user.name)!''},表示user或者name为null，都显示为空。判断为空

<#if (user.name)??>

……

</#if>
```
```text
 <#if orgList?? && (orgList?size > 0) >




<#if student.studentAge lt 12>
  	${student.studentName}不是一个初中生
<#elseif student.studentAge lt 15>
  	${student.studentName}不是一个高中生
<#elseif student.studentAge lt 18>
  	${student.studentName}不是一个大学生
<#else>
  	${student.studentName}是一个大学生
</#if>


可以使用lt代替<，lte代替<=，gt代替>，gte代替>=

时间类型
${(foundDate?string("yyyy-MM-dd"))!} 

```



