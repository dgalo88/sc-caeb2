<%@page import="com.caeb2.util.Constants"%>

<div class="container-fluid text-center">
	<nav>
		<ul class="pagination">
			<li>
				<a href="#" id="prev" aria-label="<%=Constants.JSP_PREV%>">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			<li><a href="page_1.jsp" id="page_1">1</a></li>
			<li><a href="page_2.jsp" id="page_2">2</a></li>
			<li><a href="page_3.jsp" id="page_3">3</a></li>
			<li><a href="page_4.jsp" id="page_4">4</a></li>
			<li><a href="page_5.jsp" id="page_5">5</a></li>
			<li><a href="page_6.jsp" id="page_6">6</a></li>
			<li><a href="page_7.jsp" id="page_7">7</a></li>
			<li><a href="page_8.jsp" id="page_8">8</a></li>
			<li><a href="page_9.jsp" id="page_9">9</a></li>
			<li>
				<a href="#" id="next" aria-label="<%=Constants.JSP_NEXT%>">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</ul>
	</nav>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		var pageNum = <%=pageNumber%>;
		var pageId = '#page_' + pageNum;

		console.log('page = ' + pageId);

		if (pageNum == 1) {
			console.log('page 1');
			$('#prev').parent().addClass('disabled');
			$('#prev').attr('href', '#');
			$('#next').attr('href', 'page_' + (pageNum + 1) + '.jsp');
		} else if (pageNum == 9) {
			console.log('page 9');
			$('#next').parent().addClass('disabled');
			$('#next').attr('href', '#');
			$('#prev').attr('href', 'page_' + (pageNum - 1) + '.jsp');
		} else {
			$('#prev').attr('href', 'page_' + (pageNum - 1) + '.jsp');
			$('#next').attr('href', 'page_' + (pageNum + 1) + '.jsp');
		}

		$(pageId).attr('href', '#').append('<span class="sr-only">(current)</span>');
		$(pageId).parent().addClass('active');

	});
</script>