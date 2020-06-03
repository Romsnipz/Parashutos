<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <script src="/jquery-min.js"></script>
    <title>Index Page</title>
</head>

<body>
    <p>name: <input type="text" id="nameId"></p>
    <p>name: <input type="text" id="contentId"></p>

    <button type="button" onclick="send()">DO IT!!!</button>


<script>
    function send() {
        var person = {
            name: $("#nameId").value,
            address:$("#contentId").value,
        }

        $('#target').html('sending..');

        $.ajax({
            url: '/json',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                $('#target').html(data.msg);
            },
            data: JSON.stringify(person)
        });
    }
</script>
</body>

</html>