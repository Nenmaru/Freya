$(document).ready(function() {
	$('.sendMessage').click(function() {
		var text = $('#inputter').val();
		$.getJSON("ajaxAnswer", {
			"text" : text,
		}).done(function(response) {
			$('#inputter').val("");
			$("#redex").text(response.text);
		}).fail(function(response) {
			$('#inputter').val("FAIL");
			$("#redex").text("FAIL");
		});
	});
});