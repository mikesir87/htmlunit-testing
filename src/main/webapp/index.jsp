<!DOCTYPE html>
<html>
<head>
  <title>Broken Test Page Helper Thing-a-ma-jig</title>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript">
  var ajaxLog;
  $(function() {
    ajaxLog = $("#ajaxLog");
    
    $("#fireAjaxRequest").click(function() {
      $.ajax({
        url: "ui/ajax",
        type: "POST",
        dataType: "html",
        data: "wait=" + $("#wait").val(),
        success: function(response) {
          console.log("Received response" + response);
          ajaxLog.append("<li>Received " + response + "</li>");
        }
      });
    });
  });
  </script>
</head>
<body>
  <h1>Test Page</h1>
  
  <input type="text" id="wait" /> seconds wait - 
  <button id="fireAjaxRequest">Fire Ajax Request</button>
  
  <h3>Ajax Response Log</h3>
  <ul id="ajaxLog"></ul>
</body>
</html>