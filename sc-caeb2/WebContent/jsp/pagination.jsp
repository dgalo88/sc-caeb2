<%@page import="com.caeb2.util.Parameters"%>
<%@page import="com.caeb2.util.Constants"%>

<%
	int numPages = 10;

	Integer curr = (Integer) session.getAttribute(Constants.ATT_CURR_PAGE);
%>

<div class="container-fluid text-center">
	<nav>
		<ul class="pagination">
			<li>
				<a href="#" id="prev" aria-label="<%=Constants.JSP_PREV%>">
					<span aria-hidden="true"><%=Constants.JSP_PREV%></span>
				</a>
			</li>
			<%
				for (Integer i = 1; i < numPages + 1; i++) {
					out.print("<li " + (i > curr ? "class=\"disabled\"" : "")
							+ "><a href=\"#\" id=\"page_" + i 
							+ "\" class=\"goToPage\" data-src=\"" + i + "\""
							+ (i > curr ? "style=\"pointer-events: none;\"" : "")
							+ ">" + i + "</a></li>");
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
	$(document).on('ready', function() {

		var pageNum = parseInt(<%=Parameters.getPageNumber()%>);
		var pageId = '#page_' + pageNum;
		var formId = '#form_' + pageNum;

		if (pageNum == 1) {
			$('#prev').parent().addClass('disabled');
			$('#prev').attr('href', '#');
		} else if (pageNum == <%=numPages%>) {
			$('#next').text('<%=Constants.JSP_FINISH%>').attr('aria-label', '<%=Constants.JSP_FINISH%>');
		}

		$(pageId).attr('href', '#').append('<span class="sr-only">(current)</span>');
		$(pageId).parent().addClass('active');

		$('#prev').on('click', function() {
			changePage(formId, (pageNum - 1));
			return false;
		});

		$('#next').on('click', function() {
			changePage(formId, (pageNum + 1));
			return false;
		});

		$('.goToPage').on('click', function() {
			changePage(formId, $(this).attr('data-src'));
			return false;
		});

	});

	function changePage(formId, tgt) {

		var action = $(formId).attr('action');
		var index = action.indexOf('&tgt=');

		action = index == -1 ? action : action.substring(0, index);
		action += '&tgt=' + tgt;

		$(formId).attr('action', action);

		$('#submitBtn<%=Parameters.getPageNumber()%>').trigger('click');

	}
</script>