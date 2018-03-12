<!DOCTYPE html>
<html>
<body>

<h1>PLanning course</h1>
Select phone:
<form:form method="POST" commandName="smartphone" action="/planningCourseForm">
<table>
    <tr>
    <td>
        <ul>
            <form:select path="teacher" items="${teacher}"/>
        </ul>
    </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>