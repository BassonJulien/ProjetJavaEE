<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>

/* Create three unequal columns that floats next to each other */
.column {
    float: left;
    padding: 10px;
}

/* Left and right column */
.column.side {
    width: 25%;
}

/* Middle column */
.column.middle {
    width: 50%;
}
/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media (max-width:600px) {
    .column {
        width: 100%;
    }
}</style>

</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="row">
  <div class="column side">
    <h2>About the School</h2>
    <p>Loremt scelerisque tortor sed accumsan convallis.</p>
    <img src="http://blogs.ionis-group.com/esme/assets_c/2010/10/3619310110_91fcb6e7a2_o-thumb-250x166-24547.jpg">
  </div>
  <div class="column middle">
    <h2>Fresh news</h2>
    <p>les dernieres news</p>
  </div>
</div>

</body>
</html>