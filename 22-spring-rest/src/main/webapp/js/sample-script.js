$(document).ready(function() {
	$("#getUser").click(function() {
		alert('start json jquery');
		console.log("Calling user");
		$.getJSON("service/users/user/John", function(user) {
			console.log(user);
			alert(user.name + " " + user.age);
		});
	});
	$("#listUsers").click(function() {
		alert('start json jquery');
		console.log("Calling users");
		$.getJSON("service/users/list", function(users) {
			console.log(users);
			$.each(users, function(pos, user) {
				alert(user.name + " " + user.age);
			});
		});
	});
});