<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- ENCODING HTML 5, necessary for bootstrap -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example Application Spring and Bootstrap</title>


<script src="resources/js/jquery-2.2.3.min.js"></script>
<script src="resources/js/bootstrap/js/bootstrap.js"></script>
<script src="resources/js/bootstrap/js/moment.js"></script>
<script src="resources/js/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<link rel="stylesheet" href="resources/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
<script src="resources/jsRocket/bootstrapSpringGrid.js"></script>
 



</head>
<body>

<div class="container">
	<h2>Clients list</h2>

	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" placeholder="Name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastname">Last name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="lastname" placeholder="Last Name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="dateBirth">Date of Birth:</label>
			<div class="col-sm-10">
				<div class="input-group date" id="pickerDateBirth">
                    <input type='text' id="dateBirth" class="form-control" placeholder="dd/MM/yyyy" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="register">Register:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="register" placeholder="Register">
			</div>
		</div>
		<div class="form-group">
			<button type="button" id="buttonSearch" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Search
			</button>
			<button type="button" id="buttonInsert" class="btn btn-success">
				<span class="glyphicon glyphicon-plus-sign"></span> Insert
			</button>
			<button type="button" id="buttonDelete" class="btn btn-warning">
				<span class="glyphicon glyphicon-minus-sign"></span> Delete
			</button>
		</div>
		<div>
			<table id="tableClient" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th class="col-sm-1" data-field="id">Id</th>
						<th class="col-sm-1" data-field="checkDelete"></th>
						<th class="col-sm-3" data-field="name">Name</th>
						<th class="col-sm-3" data-field="lastname">Lastname</th>
						<th class="col-sm-2" data-field="dateBirth">Date of birth</th>
						<th class="col-sm-2" data-field="register">Register</th>
					</tr>
				</thead>
			</table>
		</div>
	</form>
</div>


</body>
</html>