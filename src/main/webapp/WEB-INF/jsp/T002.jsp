<%@page import="java.util.List"%>
<%@page import="dto.MstCustomerDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Search System Customer</title>

<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: white;
}

.next {
	position: absolute;
	right: 0;
	top: 328px
}


</style>
</head>
<body style="background-color: cyan;">
	<h2 style="color: red;">Traning</h2>
	<hr style="height: 30px; background: blue;">
	<h4>Login > Search</h4>
	<div>
		<h2>
			<%
			HttpSession session2 = request.getSession();
			out.print("Hello " + session2.getAttribute("userId"));
			%>
		</h2>

		<h2
			style="position: absolute; right: 0; top: 150px; margin-left: -20px">Logout</h2>
	</div>

	<div
		style="position: absolute; left: 250px; top: 200px; height: 100px; background-color: yellow">

		<div style="margin-top: 40px;">

			<form action="T200?action=search" method="post">

				Customer Name <input type="text" name="txtCustomerName">
				Gender <select>
					<option>Choose see Gender</option>
					<option value="0">Male</option>
					<option value="1">FEMALE</option>
				</select> BirthDay : <input type="text" name="formBirthDay"> ~ <input
					type="text" name="toBirthDay"> <input type="submit"
					value="Search">
			</form>
		</div>




	</div>

	<div style="margin-top: 150px;">

     <c:forEach begin="1" end="${endP}" var="i">
         <a href="T002?index=${i}">${i}</a>
     </c:forEach>
		<form action="T002?action=delete" method="post">
			<div class="previous">
				<a href="#" class="btn btn-primary"> <<< </a> 
				<a href="#"	class="btn btn-primary"> <<</a>
			</div>


			<div class="next">
				<a href="#" class="btn btn-primary "> >> </a>
				 <a href="#"class="btn btn-primary "> >>></a>
			</div>

			<table>
				<tr>
					<th><input type="checkbox"></th>
					<th>Customer Id</th>
					<th>Customer Name</th>
					<th>Gender</th>
					<th>Address</th>
					<th>Email</th>
				</tr>




				<%
				List<MstCustomerDTO> cus = (List) request.getAttribute("CustomerList");
				for (MstCustomerDTO customer : cus) {
				%>
				<tr>
					<th><input type="checkbox"
						value="<%=customer.getCUSTOMER_PCD_ID() + "f"%>" name="cbCustomer"></th>
					<td><%=customer.getCUSTOMER_PCD_ID()%></td>
					<td><%=customer.getCustomerName()%></td>
					<td><%=customer.getGender()%></td>
					<td><%=customer.getAddress()%></td>
					<td><%=customer.getEmail()%></td>

				</tr>
				<%
				}
				%>
			</table>
			<a href="T003">Add</a> <input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>