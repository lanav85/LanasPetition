<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Petitions</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   </head>
   <body class="container">
      <h2>Lanas Petitions</h2>
      <h5>Found ${petitions.size()} Petitions:</h5>
      <input class="form-control" id="searchInput" type="text" placeholder="Search..">
      <br/>
      <table class="table table-striped">
         <thead class="thead-dark">
            <tr>
               <th scope="col">#</th>
               <th scope="col">Petition</td>
               <th scope="col" style="width: 40%">Description</td>
               <th scope="col">Email</td>
               <th scope="col">Owner</td>
               <th scope="col"> </td>
            </tr>
         </thead>
         <tbody id="petitionTable">
            <c:forEach var="petition" items="${petitions}">
               <tr>
                  <th style="vertical-align: middle;" scope="row">${petitions.indexOf(petition) + 1}</th>
                  <td style="vertical-align: middle;">
                     <c:out value="${petition.getPetitionName()}"/>
                  </td>
                  <td style="vertical-align: middle;">
                     <c:out value="${petition.getText()}"/>
                  </td>
                  <td style="vertical-align: middle;">
                     <c:out value="${petition.getEmail()}"/>
                  </td>
                  <td style="vertical-align: middle;">
                     <c:out value="${petition.getName()}"/>
                  </td>
                  <td style="vertical-align: middle;">
                      <a href="<c:url value="view">
                                   <c:param name="id" value="${petition.getPetitionId()}" />
                               </c:url>" 
                         class="btn btn-info" >View</a>
                  </td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
   </body>
   
   <a href="<c:url value="create"/>" class="btn btn-primary" >Create Petition</a>
          
   <!-- https://www.w3schools.com/bootstrap/bootstrap_filters.asp -->
   <script>
    $(document).ready(function(){
      $("#searchInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#petitionTable tr").filter(function() {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
    </script>
             
</html>