<%--
  Created by IntelliJ IDEA.
  User: kimyeongung
  Date: 14/02/2020
  Time: 5:25 오후
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
    <title>File Upload</title>
</head>
<body>
    <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>
