<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Random Sort</title>
	    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	    <script type="text/javascript" src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script language="javascript">
            function submitSortforms() {
                document.getElementById("sortForm").submit();
            }
        </script>
	</head>
	<body>
		<div class="container">
			<h3>Random Sort</h3>
			<br>
			<form action='/index/generaterandomnumbers' method='post'>
			    <table class='table table-hover table-responsive table-bordered'>
			        <tr>
			            <td><b>Enter a number</b></td> 
			            <td><input type='text' name='number' class='form-control' required/></td>
			        </tr>
			 
			        <tr>
			            <td></td>
			            <td>
			                <button type="submit" class="btn btn-primary">Generate</button>
			            </td>
			        </tr>
			    </table>
			</form>
		
			<h3>Generated Random Numbers</h3>
			<br>
			<form name="sortForm" id="sortForm" action='/index/sort' method='post'>
				<table class='table table-hover table-responsive table-bordered'>
					<tr>
					    <td><b>Random Numbers</b></td> 
					    <td><input type="text" class='form-control' name="generatedRandomNumbers" value="${randomNumbers}"></td>
					</tr>
				
				  	<tr>
						<td></td>
						<td>
						    <button type="button" onclick="submitSortforms();" class="btn btn-primary">Sort</button>
						</td>
				  	</tr>
				</table>
			</form>
			
			<h3>Sorted Numbers</h3>
			<br>
			<table class="table table-hover">
				<thead>
					<tr>
				        <th><b>Random Numbers</b></th>
				        <th><b>Sorted Numbers</b></th>
				        <th><b>Count</b></th>
			      	</tr>
			   	</thead>
			    <tbody>
				    <c:forEach items="${randomNumbersList}" var="randomNumber">
						<tr>
					       	<td><c:out value="${randomNumber.input}"></c:out></td>
							<td><c:out value="${randomNumber.output}"></c:out></td>
							<td><c:out value="${randomNumber.count}"></c:out></td>
						</tr>
					</c:forEach>
			  	</tbody>
			</table>
		</div>

		<footer class="footer">
		    <div class="container">
		        <p class="text-muted">Welcome to Spring Boot</p>
		    </div>
		</footer>
	</body>
</html>