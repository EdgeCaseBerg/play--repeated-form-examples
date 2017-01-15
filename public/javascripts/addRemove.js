/**
 * args.scoped (optional) Scope all bindings to a jQuery selector, such as #id or .class, if not passed provided defautls to body
 * args.onRemove (optional) Callback to call when row removals occur. The callback is called before the removal of the element, and is passed the element that was clicked
 * args.onAdd (optional) Callback to call when row additions occur. The callback is called after the adding of the new element, and is passed the new element that was created
 * args.newRow (required) Callback that should return the new HTML that will be added as a row
 */
function newAddRemove(args) {
	var selectorContext = 'body';
	if (args.scoped) {
		selectorContext = args.scoped;
	}

	jQuery(selectorContext).on('click', '[ui="remove"]', function(e) {
		e.preventDefault();

		if (args.onRemove) {
			args.onRemove(this);
		}

		jQuery(this).closest('[ui="row"]').remove();
	});

	jQuery(selectorContext).on('click', '[ui="add"]', function(e) {
		e.preventDefault();

		var newHTML = args.newRow();
		jQuery(selectorContext + ' [ui="container"]').append(newHTML);

		if (args.onAdd) {
			args.onAdd(jQuery(selectorContext + ' [ui="container"]').last().get(0));
		}
	});
}