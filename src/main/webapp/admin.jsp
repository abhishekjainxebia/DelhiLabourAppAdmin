<!DOCTYPE html>
<html>
<head>
<style>
.login {

height:110px;

width:190px;

margin:auto;

border:1px #CCC solid;

padding:10px;

}



.login input {

padding:5px;

margin:5px

}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">




$( document ).ready(function() {

	// SUBMIT FORM
    $("#loginform").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});


    function ajaxPost(){

    	// PREPARE FORM DATA
    	var formData = {
    		username : $("#username").val(),
    		password :  $("#password").val()
    	}

    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/login",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				window.location.href = "dashboard.jsp";
			},
			error : function(e) {
				window.location.href = "dashboard.jsp";
			}
		});

    	// Reset FormData after Posting
    	resetData();

    }

    function resetData(){
    	$("#username").val("");
    	$("#password").val("");
    }
})


 </script>
</head>
<body>
<div class="login">
<form id="loginform">
<input id="username" placeholder="Username" type="text" name="username"> <br>
<input id="password" placeholder="Password" type="password" name="password"><br>
<button type="submit">Sign In</button>
</form>
</div>
</body>
</html>
