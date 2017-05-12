<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Random Sort</title>
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<script type="text/javascript" src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<br> <b>Random Number Sorter App</b>
		<form action='/index/generaterandomnumbers' method='post'>
			<table class='table table-hover table-responsive table-bordered'>
				<tr height=30px>
					<td width=50% bgcolor="#C0C0C0"><b>Please input the no. of random numbers to be
							generated</b></td>
					<td width=50%><input type='text' name='number' class='form-control'
						required /></td>
				</tr>

				<tr height=30px>
					<td></td>
					<td align=center>
						<button type="submit" class="btn btn-primary">Generate</button>
					</td>
				</tr>
			</table>
		</form>

		<b>Generated Random Numbers</b>
		<br>
		<form name="sortForm" id="sortForm" action='/index/sort' method='post'>
			<table class='table table-hover table-responsive table-bordered'>
				<tr>
					<td bgcolor="#C0C0C0"><b>Random Numbers</b></td>
					<td><input type="text" class='form-control'
						name="generatedRandomNumbers" value="${randomNumbers}"></td>
				</tr>

				<tr>
					<td></td>
					<td align=center>
						<button type="submit" form="sortForm" class="btn btn-primary">Sort</button>
					</td>
				</tr>
			</table>
		</form>

		<b>History of the Sortings Done</b>
		<br>
		<table class="table table-hover table-responsive table-bordered">
			<thead>
				<tr bgcolor="#C0C0C0">
					<th class="col-md-5"><b>Unsorted Numbers</b></th>
					<th class="col-md-5"><b>Sorted Numbers</b></th>
					<th class="col-md-2"><b>No. Of Positions Changed</b></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${randomNumbersList}" var="randomNumber">
					<tr>
						<td class="col-md-5"><c:out value="${randomNumber.input}"></c:out></td>
						<td class="col-md-5"><c:out value="${randomNumber.output}"></c:out></td>
						<td class="col-md-2"><c:out value="${randomNumber.count}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<footer class="footer">
		<div class="container">
			<p class="text-muted">Welcome to my demo!!</p>
		</div>
	</footer>
</body>
</html>