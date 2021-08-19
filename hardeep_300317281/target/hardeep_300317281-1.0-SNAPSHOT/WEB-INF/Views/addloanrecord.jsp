<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h1>Add an entry</h1>
  <h2 id="mes">${errorMessage}</h2>
  <form method="POST">
    <fieldset class="form-group">
      <label> Client number :</label>
      <input name="clientno" type="text" class="form-control" required />

    </fieldset>


    <fieldset class="form-group">
      <label> Client Name :</label>
      <input name="clientname" type="text" class="form-control" required />

    </fieldset>
    <fieldset class="form-group">
      <label> Loan Amount :</label>
      <input name="loanamount" type="text" class="form-control" required />

    </fieldset>
    <fieldset class="form-group">
      <label> Number of years :</label>
      <input name="years" type="text" class="form-control" required />

    </fieldset>
    <fieldset class="form-group">
      <label> Saving Type :</label>
      <select name="clientname" class="form-control" required>
        <option value="Business">Business</option>
        <option value="Personal">Personal</option>
      </select>

    </fieldset>
    <input class="btn btn-success" type="submit" value="Submit" />
  </form>

</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>

