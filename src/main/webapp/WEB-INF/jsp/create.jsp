<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Create a petition</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   </head>
   <body class="container">
      <h2>Create a petition</h2>
      <br/>
        <table class="table">
        <colgroup>
          <col style="width: 20%;">
          <col style="width: 80%;">
        </colgroup>
        <form:form action="submitPetition" method="post" modelAttribute="petition">
        <tr>
            <td><form:label path="petitionName">Petition Title:</form:label></td>
            <td><form:input path="petitionName" style="width: 100%;"/></td>
        </tr>
        <tr>
            <td><form:label path="text">Petition Description:</form:label></td>
            <td><form:textarea path="text" cols="25" rows="5" style="width: 100%;"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Contact Name:</form:label></td>
            <td><form:input path="name" style="width: 100%;"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Contact Email:</form:label></td>
            <td><form:input path="email" style="width: 100%;"/></td>
        </tr>
        <tr>
            <td><br/><a href="<c:url value="home"/>" class="btn btn-danger" >Cancel</a></td>
            <td><br/><form:button class="btn btn-primary" >Submit</form:button></td>
        </tr>
        </form:form>
        </table>
   </body>
</html>