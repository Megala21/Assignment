<%@ page import = "cse.maven.sample.Initializing" %>
<%@ page import = "cse.maven.sample.NicInterpreter" %>
<%@ page import = "cse.maven.exception.InvalidNicException" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Nic Interpretation</title>
		<h1>Results of the Nic interpretation</h1>
	<%
		String nic = request.getParameter("nic");

		NicInterpreter interpreter = new NicInterpreter();

	try {
		Initializing init = interpreter.getDetails(nic);
		out.println("Birthday: [year = " + init.getYear() + ", month = "
				+ init.getMonth() + ", date = " + init.getDate()
				+ "]<br>");
		out.println("Gender: " + init.getGender() + "<br>"); 
		out.println("isVoter: " + init.isVote());
	} catch (InvalidNicException ex) {
		out.println(ex.getMessage());
	}
%>
</head>
<body>

</body>
</html>