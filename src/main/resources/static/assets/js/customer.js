console.log('customer');

$(document).ready(function () {
	var customerPath = "http://localhost:1111/customer";
	
	$.ajax({
		type : 'GET',
		url : customerPath + "/list"
	}).then(function(json) {
		console.log(json);
		var customers = [];
			
		for (var i = 0; i < json.length; i ++) {
			
			customers.push('<tbody>');
			
			customers.push('<tr>');
						
			customers.push('<td>' + json[i].title + '</td>' + '<td>' + json[i].firstName + '</td>' + '<td>' + json[i].surname + '</td>' + '<td>' + json[i].dob + '</td>' + '<td>' + json[i].mobile + '</td>' + '<td>' + json[i].email + '</td>' + '<td>' + json[i].packages + '</td>' + '<td>' + json[i].charges + '</td>');
						
			customers.push('<td><button id=\'edit\' value=\'' + json[i].customerId + '\' class=\"btn btn-warning\">Edit</button></td>');
			customers.push('<td><button type="submit" id=\'delete\' value=\'' + json[i].customerId + '\' class=\"btn btn-danger\">Delete</button></td>');
						
			customers.push('</tr>');
						
			customers.push('</tbody>');
		}
		
		$('#customers').append($(customers.join('')));
		
	});
	
	$(document).delegate('#edit', 'click', function () {
		var customerId = $(this).val();
		
		console.log(customerId);
		
		var uri = customerPath + "/" + customerId;
		
		$.ajax({
			type : 'GET',
			url : uri
		}).then(function (data) {
			console.log(data);
			$('#customer-id').val(customerId);
			$('#title').val(data.title);
			$('#first-name').val(data.firstName);
			$('#surname').val(data.surname);
			$('#dob').val(data.dob);
			$('#mobile').val(data.mobile);
			$('#email').val(data.email);
			$('#packages').val(data.packages);
		
		});
	});
	
	$('#update').click(function () {
		var customerId = $('#customer-id').val();
		var title = $('#title').val();
		var firstName = $('#first-name').val();
		var surname = $('#surname').val();
		var dob = $('#dob').val();
		var mobile = $('#mobile').val();
		var email = $('#email').val();
		var packages = $('#packages').val();
		var charges = packages * 100;
		
		$.ajax({
			type : 'PATCH',
			url : customerPath + "/update",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify({ "customerId" : customerId, "title" : title, "firstName" : firstName, "surname" : surname, "dob" : dob, "mobile" : mobile, "email" : email, "packages" : packages, "charges" : charges }),
			cache : false,
			success : function (result) {
				console.log('update success');
			},
			error : function (error) {
				console.log('update failed');
			}
			
		});
		
	});
	
	$(document).delegate('#delete', 'click', function () {
		var customerId = $(this).val();
		var title = "";
		var firstName = "";
		var surname = "";
		var dob = "";
		var mobile = "";
		var email = "";
		
		console.log(customerId);
		
		var uri = customerPath + "/delete";
		
		$.ajax({
			type : 'DELETE',
			url : uri,
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify({ "customerId" : customerId, "title" : title, "firstName" : firstName, "surname" : surname, "dob" : dob, "mobile" : mobile, "email" : email }),
			cache : false,
			success : function (result) {
				console.log('delete success');
				window.setTimeout(function() {  location.reload() },500);
			},
			error : function (error) {
				console.log('delete failed');
			}
			
		});
	});
	
});