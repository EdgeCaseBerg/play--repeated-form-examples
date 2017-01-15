jQuery(document).ready(function() {
	var clearedRowTemplate = $('[ui="row"]:first').clone();
	clearedRowTemplate.find('input').val('');
	clearedRowTemplate.find('input').attr('name', 'strings[]');

	newAddRemove({
		newRow: function() {
			return clearedRowTemplate.clone();
		}
	});
});