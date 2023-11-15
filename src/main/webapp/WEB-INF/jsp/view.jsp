<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>${petition.getPetitionName()}</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   </head>
   <body class="container">
      <h2>${petition.getPetitionName()}</h2>
      <br/>
      <h4>Our Message:</h4>
      ${petition.getText()}
      <h4>Created By:</h4>
      ${petition.getName()} (${petition.getEmail()})
      <br/>
      <br/>
      <h4>Sign Petition:</h4>
      
        <table class="table">
        <colgroup>
          <col style="width: 20%;">
          <col style="width: 80%;">
        </colgroup>
        <form:form action="signPetition" method="post" modelAttribute="signature">
        <form:input type="hidden" path="petitionId" value="${petition.getPetitionId()}" />
        <tr>
            <td><form:label path="petitionerName">Your Name:</form:label></td>
            <td><form:input path="petitionerName" style="width: 100%;"/></td>
        </tr>
        <tr>
            <td><form:label path="petitionerEmail">Your Email:</form:label></td>
            <td><form:input path="petitionerEmail" style="width: 100%;"/></td>
        </tr>
        <tr>
            <td><br/><a href="<c:url value="home"/>" class="btn btn-danger" >Cancel</a></td>
            <td><br/><form:button class="btn btn-primary" >Submit</form:button></td>
        </tr>
        </form:form>
        </table>
        
      <h4><b>${signatures.size()} signatures</b> and counting:</h4>
      <table class="table">
         <tbody>
            <c:forEach var="signature" items="${signatures}">
               <tr>
                  <td><c:out value="${signature.getPetitionerName()}"/></td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
      
   </body>
</html>