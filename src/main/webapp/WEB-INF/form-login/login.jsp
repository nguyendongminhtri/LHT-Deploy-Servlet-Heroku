<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/30/2021
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js">

</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Form LOGIN</h1>
<form id="loginForm" action="/login" method="post">
  ${message}<br>
  <label>Username:</label>
  <input id="username" name="username"><br>
  <label>Password:</label>
  <input id="password" type="password" name="password"><br>
  <button type="submit">Login</button>
</form>
<script type="text/javascript">
  $(document).ready(function (){
    $("#loginForm").validate({
      rules: {
        username: {
          required: true
        },
        password: "required",
      },
      messages: {
        username: {
          required: "The username is required!"
        },
        password: "The password is required"
      }
    })
  })
</script>
</body>
</html>
