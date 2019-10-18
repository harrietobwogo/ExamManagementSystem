<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 10/14/2019
  Time: 7:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD EXAM RESULTS</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand" href="#">ADD EXAMS FORM</a>
</nav>
<br><br><br>
<div class="container">
<form action="exam-api/results/add-exam-result">
    <div class="form-group row">
        <label for="registration-number" class="col-xs-3 col-form-label mr-2">Registration Number</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="registration-number" name="registration-number">
        </div>
    </div>
    <div class="form-group row">
        <label for="unit-code" class="col-xs-2 col-form-label mr-2">Unit Code</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="unit-code" name="unit-code">
        </div>
    </div>
    <div class="form-group row">
        <label for="exam-id" class="col-xs-3 col-form-label mr-2">Exam id</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="exam-id" name="exam-id">
        </div>
    </div>
    <div class="form-group row">
        <label for="marks" class="col-xs-3 col-form-label mr-2">Marks</label>
        <div class="col-xs-9">
            <input type="text" class="form-control" id="marks" name="marks">
        </div>
    </div>
    <div class="form-group row">
        <div class="offset-xs-3 col-xs-9">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form>
</div>
<style>
    * {margin:0;padding:0;}
    fieldset {
        padding:0.5em;
    }
    label {
        width:40%;
        display:block;
    }
</style>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
