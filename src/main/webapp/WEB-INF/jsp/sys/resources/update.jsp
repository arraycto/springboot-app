<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<title>My JSP 'updateUser.jsp' starting page</title>
	</head>

	<body>
		<form action="<%=path %>/sys/resources/update.do" method="POST">
			<input type="hidden" name="id" value="${resources.id }">
			<table>
				<tr>
					<td>
						pid: 
					</td>
					<td>
					
					
					
					
						<select name="pId" >
							<c:forEach items="${list}" var="pId">
								
								<c:choose>
										<c:when test="${pId.selected == true}">
											<option value ="${pId.id }" selected="${pId.selected}">${pId.name }</option>
										</c:when>  
										<c:otherwise>  
											<option value ="${pId.id }" >${pId.name }</option>
										</c:otherwise>
									</c:choose>
						  	</c:forEach>
						</select>
						
					</td>
				</tr>
				<tr>
					<td>
						name: 
					</td>
					<td>
						<input type="text" name="name" value="${resources.name }">
					</td>
				</tr>
				<tr>
					<td>
						url: 
					</td>
					<td>
						<input type="text" name="url" value="${resources.url }">
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit" value="Update">
					</td>
					<td>
						<input type="reset" value="Reset">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
