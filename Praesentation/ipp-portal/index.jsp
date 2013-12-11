<%@page import="com.infinity.bpm.portal.common.InfinityStartup"%>
<%@ page session="true" contentType="text/html;charset=utf-8"%>
<%
    InfinityStartup infinityStartup = new InfinityStartup(pageContext.getServletContext(),
          request, response);
    infinityStartup.createSession();
    infinityStartup.showPage();
%>