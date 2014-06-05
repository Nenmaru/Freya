$(document).ready(
		function() {
			$('.sendMessage').click(
					function() {
						var uno_texto = $('#inputter').val();
						$.get("ajaxAnswer", {
							"uno_texto" : uno_texto,
						}, function(result) {
							if(result=="Очень приятно! А я чат-бот Freya."){
								$('#username').text($('#inputter').val());
							}
							$('#inputter').val("");
							$("#redex").append(
									"Вы: " + uno_texto + '\nFreya: ' + result
											+ '\n');
							$("#redex").scrollTo("max", 1);
						});
					});
		});
$(document).ready(function() {
	$('.name').click(function() {
		var id  = $(this).attr('id');
		$.get("textLearn", {
			"id" : id,
		}, function(result) {
			$('#inputter').val("");
			$("#redex").append('Freya: ' + result + '\n');
			$("#redex").scrollTo("max", 1);
		});
	});
});
$(document).ready(function() {
	$('.theme').click(function() {
		var id  = $(this).attr('id');
		$.get("textInput", {
			"id" : id,
		}, function(result) {
			$('#inputter').val("");
			$("#redex").append('Freya: ' + result + '\n');
			$("#redex").scrollTo("max", 1);
		});
	});
});