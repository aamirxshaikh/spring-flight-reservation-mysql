console.log('index');

$(document).ready(function () {
	var customerPath = "http://localhost:1111/customer";
	var checkinPath = "http://localhost:1111/checkin";
	
	$('#register').click(function () {
		var title = $('#title').val();
		var firstName = $('#first-name').val();
		var surname = $('#surname').val();
		var dob = $('#dob').val();
		var mobile = $('#mobile').val();
		var email = $('#email').val();
		var packages = $('#packages').val();
		var charges;
		
		if (packages >= 2) {
			charges = packages * 100;
		} else {
			charges = 0;
		}
		
		$.ajax({
			type : 'POST',
			url : customerPath + "/save",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify({ "title" : title, "firstName" : firstName, "surname" : surname, "dob" : dob, "mobile" : mobile, "email" : email, "packages" : packages, "charges" : charges }),
			cache : false,
			success : function (result) {
				console.log('insert success');
			},
			error : function (error) {
				console.log('insert failed');
			}
			
		});
		
	});

	
});