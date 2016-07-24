<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="jqv/css/validationEngine.jquery.css" type="text/css"/>
<link rel="stylesheet" href="jqv/css/template.css" type="text/css"/>
<script src="jqv/js/jquery-1.8.2.min.js" type="text/javascript">
	</script>
	<script src="jqv/js/languages/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8">
	</script>
	<script src="jqv/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8">
	</script>
	<script>
		jQuery(document).ready( function() {
			// binds form submission and fields to the validation engine
			jQuery("#formID").validationEngine();
		});
	</script>
</head>
<body>
<br>
<br>
<br>
<br>
<form id="formID"  method="post" action="">

Enter Name : <input class="validate[required] text-input" type="text" name="name" /><br>
Enter a URL : <input value="http://" class="validate[required,custom[url]] text-input" type="text" name="url" id="url" /><br>
Enter a Email : <input class="validate[required,custom[email]] text-input" type="text" name="email" id="email" /><br>
Select Multiple : <select name="sport2" id="sport2" multiple="true" class="validate[required]">
					<option value="">Choose a sport</option>
					<option value="option1">Tennis</option>
					<option value="option2">Football</option>
					<option value="option3">Golf</option>
				</select>			
<input class="submit" type="submit" value="Validate &amp; Send the form!"/>
</form>
</body>
</html>