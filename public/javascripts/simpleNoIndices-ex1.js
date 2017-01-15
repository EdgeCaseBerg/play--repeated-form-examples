jQuery(document).ready(function() {
	var clearedRowTemplate = $('[ui="row"]:first').clone();
	clearedRowTemplate.find('input').val('');

	newAddRemove({
		newRow: function() {
			return clearedRowTemplate.clone();
		}
	});
});