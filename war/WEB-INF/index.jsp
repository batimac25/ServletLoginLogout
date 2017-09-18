<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<html>
<body>
<form action ="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
<input type="file" name = "myFile" required="required"> 
<input type="file" name = "myVideo" required="required">
<input type="submit" value = "upload">
</form></body></html>