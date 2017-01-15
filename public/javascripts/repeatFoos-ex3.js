jQuery(document).ready(function() {
	var clearedRowTemplate = $('[ui="row"]:first').clone();
	clearedRowTemplate.find('input').val('');

	newAddRemove({
		newRow: function() {
			var newId = generateUUID();
			clearedRowTemplate.find('input[name*="id"]').val(newId);
			return clearedRowTemplate.clone();
		}
	});
});