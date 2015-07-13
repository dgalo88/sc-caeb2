<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<div class="container-fluid text-center">
	<nav>
		<ul class="pagination">
			<li>
				<a href="#" id="prev" aria-label="<%=Constants.JSP_PREV%>">
					<span aria-hidden="true"><%=Constants.JSP_PREV%></span>
				</a>
			</li>
			<%
				for (int i = 1; i < 10; i++) {
					out.print("<li><a href=\"/sc-caeb2/jsp/page_"
						+ i + ".jsp\" id=\"page_" + i + "\">" + i + "</a></li>");
				}
			%>
<!-- 			<li><a href="/sc-caeb2/jsp/page_1.jsp" id="page_1">1</a></li> -->
<!-- 			<li><a href="/sc-caeb2/jsp/page_2.jsp" id="page_2">2</a></li> -->
<!-- 			<li><a href="/sc-caeb2/jsp/page_3.jsp" id="page_3">3</a></li> -->
<!-- 			<li><a href="/sc-caeb2/jsp/page_4.jsp" id="page_4">4</a></li> -->
<!-- 			<li><a href="/sc-caeb2/jsp/page_5.jsp" id="page_5">5</a></li> -->
<!-- 			<li><a href="/sc-caeb2/jsp/page_6.jsp" id="page_6">6</a></li> -->
<!-- 			<li><a href="/sc-caeb2/jsp/page_7.jsp" id="page_7">7</a></li> -->
<!-- 			<li><a href="/sc-caeb2/jsp/page_8.jsp" id="page_8">8</a></li> -->
<!-- 			<li><a href="/sc-caeb2/jsp/page_9.jsp" id="page_9">9</a></li> -->
			<li>
				<a href="#" id="next" aria-label="<%=Constants.JSP_NEXT%>">
					<span aria-hidden="true"><%=Constants.JSP_NEXT%></span>
				</a>
			</li>
		</ul>
	</nav>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		pageNum = <%=Parameters.getPageNumber()%>;
		var pageId = '#page_' + pageNum;
		var formId = '#form_' + pageNum;

		if (pageNum == 1) {
			$('#prev').parent().addClass('disabled');
			$('#prev').attr('href', '#');
// 			$('#next').attr('href', '/sc-caeb2/jsp/page_' + (pageNum + 1) + '.jsp');
		} else if (pageNum == 9) {
			$('#next').parent().addClass('disabled');
// 			$('#next').attr('href', '#');
			$('#prev').attr('href', '/sc-caeb2/jsp/page_' + (pageNum - 1) + '.jsp');
		} else {
			$('#prev').attr('href', '/sc-caeb2/jsp/page_' + (pageNum - 1) + '.jsp');
// 			$('#next').attr('href', '/sc-caeb2/jsp/page_' + (pageNum + 1) + '.jsp');
		}

		$(pageId).attr('href', '#').append('<span class="sr-only">(current)</span>');
		$(pageId).parent().addClass('active');

		$('#next').on('click', function() {
			nextPage(formId);
			return false;
		});

	});

	function nextPage(formId) {
		$('#submitBtn<%=Parameters.getPageNumber()%>').trigger('click');
	}
</script>