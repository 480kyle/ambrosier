<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
var host = document.location.hostname;
alert("다시 시도해 주시기 바랍니다.");
switch (host)
{
        case 'ambrosier.com':
			location.href = '/ambrosia/'; break;
        case 'localhost' :
        	location.href = '/tasting/'; break;
        case '192.168.0.5' :
        	location.href = '/tasting/'; break;
        default :  // set whatever you want
}
</script>
</head>
</html>