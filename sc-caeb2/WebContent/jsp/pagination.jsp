<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%int numPages = 10;%>

<div class="container-fluid text-center">
	<nav>
		<ul class="pagination">
			<li>
				<a href="#" id="prev" aria-label="<%=Constants.JSP_PREV%>">
					<span aria-hidden="true"><%=Constants.JSP_PREV%></span>
				</a>
			</li>
			<%
				for (int i = 1; i < numPages + 1; i++) {
					out.print("<li><a href=\"/sc-caeb2/jsp/page_"
						+ i + ".jsp\" id=\"page_" + i + "\">" + i + "</a></li>");
				}
			%>
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
		} else if (pageNum == <%=numPages%>) {
			$('#next').text('<%=Constants.JSP_FINISH%>').attr('aria-label', '<%=Constants.JSP_FINISH%>');
			$('#prev').attr('href', '<%=Constants.PATH_JSP%>/page_' + (pageNum - 1) + '.jsp');
		} else {
			$('#prev').attr('href', '<%=Constants.PATH_JSP%>/page_' + (pageNum - 1) + '.jsp');
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