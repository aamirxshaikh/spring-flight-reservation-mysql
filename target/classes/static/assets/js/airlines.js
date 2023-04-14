console.log('airline');

$(document).ready(function () {
	var customerPath = "http://localhost:1111/airline";
	
	$('#register').click(function () {
		var airlineName = $('#airline-name').val();

		$.ajax({
			type : 'POST',
			url : customerPath + "/save",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify({ "airline-name" : airlineName}),
			cache : false,
			success : function (result) {
				console.log('insert success');
			},
			error : function (error) {
				console.log('insert failed');
			}
			
		});
		
	});
	
	$.ajax({
		type : 'GET',
		url : customerPath + "/list"
	}).then(function(json) {
		console.log(json);
		var airlines = [];
			
		for (var i = 0; i < json.length; i ++) {
			
			airlines.push('<tbody>');
			
			airlines.push('<tr>');
						
			airlines.push('<td>' + json[i].airlineName + '</td>');
						
			airlines.push('<td><button id=\'edit\' value=\'' + json[i].airlineId + '\' class=\"btn btn-warning\">Edit</button></td>');
			airlines.push('<td><button type="submit" id=\'delete\' value=\'' + json[i].airlineId + '\' class=\"btn btn-danger\">Delete</button></td>');
						
			airlines.push('</tr>');
						
			airlines.push('</tbody>');
		}
		
		$('#airlines').append($(airlines.join('')));
		
	});
	
	$(document).delegate('#edit', 'click', function () {
		var airlineId = $(this).val();
		
		console.log(airlineId);
		
		var uri = customerPath + "/" + airlineId;
		
		$.ajax({
			type : 'GET',
			url : uri
		}).then(function (data) {
			console.log(data);
			$('#airline-name').val(airlineName);
		});
	});
	
	$('#update').click(function () {
		var airlineName = $('#airline-name').val();

		$.ajax({
			type : 'PATCH',
			url : customerPath + "/update",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify({ "airlineName" : airlineName}),
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
		var airlineId = $(this).val();
		var airlineName = "";
		
		console.log(airlineId);
		
		var uri = customerPath + "/delete";
		
		$.ajax({
			type : 'DELETE',
			url : uri,
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify({ "airlineId" : airlineId, "airlineName" : airlineName}),
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