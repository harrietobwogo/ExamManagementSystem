<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

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
    <a class="navbar-brand" href="#">EXAM RESULTS FORM</a>
</nav>
    <br><br><br>
    <div class="container">
    <form action="exam-api/exam/add-exam">
        <div class="form-group row">
            <label for="exam-type" class="col-xs-3 col-form-label mr-2">Exam Type</label>
            <div class="col-xs-9">
                <select id="exam-type" class="form-control" required name="examType">
                    <option>Choose Exam Type</option>
                    <option>MAIN_EXAM</option>
                    <option>SUPPLEMENTARY_EXAM</option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="start-date" class="col-xs-3 col-form-label mr-2">Start Date</label>
            <div class="col-xs-9">
                <input type="date" class="form-control" id="start-date" name="start-date">
            </div>
        </div>
        <div class="form-group row">
            <label for="end-date" class="col-xs-3 col-form-label mr-2">End Date</label>
            <div class="col-xs-9">
                <input type="date" class="form-control" id="end-date" name="end-date">
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
</body>

</html>
