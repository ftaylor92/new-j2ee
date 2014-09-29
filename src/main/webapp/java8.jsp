<%@ page language="java" import="java.sql.*,java.util.*"%>
<html>
<body>
<%
Map<String, String> mp= new HashMap<String,String>();

mp.put("one","111");
mp.put("two","222");

mp.forEach((k,v)->System.out.println(k+"="+v));

%>
See console output to prove this worked.  See web.xml for 1.8 compiler directive.
</body>
</html>