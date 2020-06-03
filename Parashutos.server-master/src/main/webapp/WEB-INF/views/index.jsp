<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>

  <style>
     #contentId {
     	margin: 10px;
     	width:1000px;
     	height:1000px

      	margin-left: auto;
  		margin-right: auto;
  		max-width: 100000px;
  		max-height: 100000px;

     }

    </style>
</head>

<body>
<spring:form method="post" modelAttribute="jsonDTO"  action="model">
  Name: <spring:input id = "nameId" path = "name"/>   <br/>
  Content:<br/> <spring:textarea  rows="50" cols="700" id = "contentId" path = "content"/>   <br/>
  <spring:button>SAVE THIS SHIT NOW!!!</spring:button>

  <table id="loginFormTable" class="dark">
  	 	<tr>
  	 		<td>Name: </td>
  	 		<td> <spring:input id = "nameId" path = "name"/> </td>
  	 		<td rowspan="2"> <spring:button>SAVE THIS SHIT NOW!!!</spring:button> </td>
  	 	</tr>
  	 	<tr>
  	  		<td>Content: </td>
  	  		<td> <spring:textarea  rows="50" cols="700" id = "contentId" path = "content"/></td>
  	  	</tr>
  	  </table>
</spring:form>

</body>

</html>