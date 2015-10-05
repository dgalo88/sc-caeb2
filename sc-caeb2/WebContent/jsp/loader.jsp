
<div class="modal fade" id="loader" align="center">
	<div class="modal-dialog">
		<div class="modal-content modal-sm" >
			<div class="modal-body" align="center">
				<span>Espere por favor</span>
				<br>
				<img src="/sc-caeb2/images/loader.gif"
						width="32" height="32" alt="logoccaeb2">
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function showLoader() {
		$('#loader').modal('show');
	}

	function hideLoader() {
		$('#loader').modal('hide');
	}

	$('.modal').on('show.bs.modal', function() {

		var h_window = window.innerHeight;
		var child = $(this).children().children();
		var h_pop = (h_window / 2) - (child.height() / 2) - 50;

		child.css({
			'margin-top': h_pop + 'px'
		});

	});
</script>
