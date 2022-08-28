<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lOGIN title here</title>
</head>
<body style="background-color: cyan">
    <h2 style="color:red;">Training</h2>
      <hr style="position: absolute; bottom:0;">
    <hr>
    <h4>Login</h4>
    <div style="position: absolute; top: 200px;left:650px;width:255px;">
       <h2 style="color:blue;margin-left:80px;">Login</h2>
       <span>
       
         <%
           if(request.getAttribute("errorMessage") != null)
              out.print(request.getAttribute("errorMessage"));
       %>
       </span>
     
       <form action="T001" method="post">
              <div>
         User Id : <input type="text" name="userId" style="margin-bottom: 10px;">
         Password : <input type="password" name="password">
       </div>
       <div>
          <input type="submit" value="Login" >
          <input type="reset" value="Clear">
       </div>
       </form>

    </div>
   
    <div style="position:absolute;bottom:0;">
   
     <div>
       <h3>aaaaaaa</h3>
     </div>
     
    </div>
</body>
</html>