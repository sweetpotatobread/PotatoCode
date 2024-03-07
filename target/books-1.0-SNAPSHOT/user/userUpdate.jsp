<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2023/2/20
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="/userServlet" method="post">
        <ul class="forminfo">
            <input type="hidden" name="type" value="save">
            <li><label>账号</label><input name="userName" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
            <li><label>密码</label><input name="password" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
            <li><label>手机</label><input name="phoneNum" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
            <li><label>邮箱</label><input name="email" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>
    </form>


</div>


<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

