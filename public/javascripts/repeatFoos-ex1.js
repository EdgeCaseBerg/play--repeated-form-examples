jQuery(document).ready(function() {
	var clearedRowTemplate = $('[ui="row"]:first').clone();
	clearedRowTemplate.find('input').val('');

	var nextNameIndex = $('[ui="row"]').length;
	function newNameIndex(element, index) {
		element.name = element.name.replace(/\[.*?\]/, '[' + index + ']');
		element.setAttribute('id', element.getAttribute('id').replace(/_.?_/, '_' + index + '_'));
	}

	function newLabelIndex(element, index) {
		element.textContent = element.textContent.replace(/\..*?\./, '.' + index + '.');
		element.setAttribute('for', element.getAttribute('for').replace(/_.?_/, '_' + index + '_'));
	}

	newAddRemove({
		newRow: function() {
			clearedRowTemplate.find('input').each(function() {
				newNameIndex(this, nextNameIndex);
				clearedRowTemplate.find('label').each(function() {
					newLabelIndex(this, nextNameIndex);
				});
			});
			nextNameIndex = nextNameIndex + 1;
			var newId = generateUUID();
			clearedRowTemplate.find('input[name*="id"]').val(newId);
			return clearedRowTemplate.clone();
		}
	});
});