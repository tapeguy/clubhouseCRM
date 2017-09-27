<%@ tag description="Page Header Template" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="page_meta_tags" required="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="shortcut icon" href="/images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/js/jquery-1.9.1.js"></script>
<script src="/js/jquery-ui-1.10.3.custom.min.js"></script>
${page_meta_tags}
</head>
<body class="no-js">
<script>
var el = document.getElementsByTagName("body")[0];
el.className = "";
</script>
