<%@ page
	import="com.michael.model.*, java.util.*, java.sql.SQLException"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Management</h1>
	<%
		String sid=request.getParameter("id");  
    	int id=Integer.parseInt(sid); 
		Product e = new Product();
		try {
			e = ProductDAO.selectProduct(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out.print("<form action='UpdateProduct' method='post'>");
		out.print("<table>");
		out.print("<tr><td>Product ID:</td><td><input type='number' name='id' value='" + e.getProductId()
				+ "'/></td></tr>");
		out.print("<tr><td>Product Name:</td><td><input type='text' name='name' value='" + e.getProductName()
				+ "'/> </td></tr>");
		out.print("<tr><td>Product Price:</td><td><input type='number' name='price' value='" + e.getProductPrice()
				+ "'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Update & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
	%>
	<div>
		<%
			out.println("<h1>Product List</h1>");

			List<Product> list = null;
			try {
				list = ProductDAO.selectAllProducts();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			out.print("<table border='1' width='100%'");
			out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Edit</th><th>Delete</th></tr>");
			for (Product a : list) {
				out.print("<tr><td>" + a.getProductId() + "</td><td>" + a.getProductName() + "</td><td>"
						+ a.getProductPrice() + "</td> <td><a href='updatemain.jsp?id=" + a.getProductId()
						+ "'>edit</a></td><td><a href='DeleteProduct?id=" + a.getProductId()
						+ "'>delete</a></td></tr>");
			}
			out.print("</table>");

			out.close();
		%>
	</div>
</body>
</html>