<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file='../jspf/lib/taglib.jspf'%>
<%@ attribute name="page" required="true" type="java.lang.Integer"%>
<%@ attribute name="itemsCount" required="true" type="java.lang.Integer"%>
<%@ attribute name="itemOnPage" required="true" type="java.lang.Integer"%>
<%@ attribute name="pages" required="true" type="java.lang.Integer"%>
<c:choose>
	<c:when test="${fn:contains(pageContext.request.queryString, 'page=')}">
		<c:set var="query"
			value="${fn:substringBefore(pageContext.request.queryString, '&page=')  }&page="></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="query" value="${pageContext.request.queryString  }&page="></c:set>
	</c:otherwise>
</c:choose>
<c:set var="prev" value="goods.page?${query }${page-1}" />
<c:set var="next" value="goods.page?${query }${page+1}" />
<c:set var="first" value="goods.page?${query }1" />
<c:set var="last" value="goods.page?${query }${pages }" />
<c:set var="start" value="${page<3 ? 1 : page-1 }" />


<ul>
	<li class=${page eq 1 ? "disabled" : ""}><a
		href=${page eq 1 ? "#" : first}><<-</a></li>
	<li class=${page eq 1 ? "disabled" : ""}><a
		href=${page eq 1 ? "#" : prev}><-</a></li>
	<c:forEach begin="${start }"
		end="${start+2 gt pages-1 ? pages-1 : start+2 }" var="i">
		<li class=${page eq i ? "active" : ""}><a
			href="goods.page?${query }${i}">${i }</a></li>
	</c:forEach>
	<c:if test="${page<pages-2}">
		<li class="disabled"><a>...</a></li>
	</c:if>
	<li class=${page eq pages ? "active" : ""}><a
		href="goods.page?${query }${pages}">${pages }</a></li>
	<li class=${page eq pages ? "disabled" : ""}><a
		href=${page eq pages ? "#" : next}>-></a></li>
	<li class=${page eq pages ? "disabled" : ""}><a
		href=${page eq pages ? "#" : last}>->></a></li>
</ul>
