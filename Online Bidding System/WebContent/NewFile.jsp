<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>jQuery UI Slider - Range slider</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#slider-range" ).slider({
      range: true,
      min: 0,
      max: 1000,
      values: [ 75, 300 ],
      slide: function( event, ui ) {
        $( "#amount" ).val( "Rs" + ui.values[ 0 ] + " - Rs" + ui.values[ 1 ] );
      }
    });
    $( "#amount" ).val( "$" + Rs( "#slider-range" ).slider( "values", 0 ) +
      " - $" + Rs( "#slider-range" ).slider( "values", 1 ) );
  })
  </script>
</head>
<body>
 <form action="GetRangeServlet">
<p>
  <label for="amount">Price range:</label>
  <input type="text"  name="range" id="amount" style="border:0; color:#f6931f; font-weight:bold;">
</p>
 
<div id="slider-range"></div>
<input type="submit" name="submit" value="GO">
 </form>
 
</body>
</html>