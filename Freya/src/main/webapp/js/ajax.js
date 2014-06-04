$(document).ready(function() {
	$('.message').click(function() {
		var id = $(this).attr('good_id');
		$.getJSON("basket_handle", {
			"action" : "addGood",
			"good_id" : id,
		}, function(result) {
			$("#basketCount").text(result.count);
			$("#basketPrice").text(result.price);
			$("#count" + id).text(result.number);
			$("#price" + id).text(result.cost);
		});
	});
});