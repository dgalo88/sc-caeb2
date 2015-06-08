$(document).ready(function() {
	$('body').on('click', function() {
		hideNotification();
	});
});

function hideNotification() {
	$('#notification').removeClass('show')
						.removeClass('alert-success')
						.removeClass('alert-info')
						.removeClass('alert-warning')
						.removeClass('alert-danger')
						.addClass('hidden');
	$('#notification #messageDiv').remove();
}

function showNotification(message, type) {
	$('#notification').removeClass('hidden')
						.addClass('show')
						.addClass(type);
	$('#notification').append('<div id="messageDiv">' + message + '</div>');
}

function showSuccess(message) {
	showNotification(message, 'alert-success');
}

function showInfo(message) {
	showNotification(message, 'alert-info');
}

function showWarning(message) {
	showNotification(message, 'alert-warning');
}

function showError(message) {
	showNotification(message, 'alert-danger');
}
