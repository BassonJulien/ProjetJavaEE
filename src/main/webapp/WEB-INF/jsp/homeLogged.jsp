<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
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
}
#news {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#news td, #news th {
	border: 1px solid #ddd;
	padding: 8px;
}

#news tr:nth-child(even) {
	background-color: #f2f2f2;
}

#news tr:hover {
	background-color: #ddd;
}

#news th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

#news {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#news td, #news th {
	border: 1px solid #ddd;
	padding: 8px;
}

#news tr:nth-child(even) {
	background-color: #f2f2f2;
}

#news tr:hover {
	background-color: #ddd;
}

#news th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

img {
  display: block;
  max-width:230px;
  max-height:95px;
  width: auto;
  height: auto;
}
</style>

</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="row">
  <div class="column side">
    <h2>About the School</h2>
    <p>L'ESME Sudria, anciennement École spéciale de mécanique et d'électricité,
     est l'une des grandes écoles d'ingénieurs françaises habilitées à délivrer un diplôme d'ingénieur.

Elle forme des ingénieurs dans les domaines du génie électrique, de l'électronique, des télécommunications 
et de l'informatique. Reconnue par l'État depuis 1922 et, habilitée par la Commission des titres d'ingénieur
 (CTI) depuis sa création en 1936 à délivrer le diplôme d'ingénieur, elle est aussi membre de la Conférence des grandes 
 écoles et fait partie de l'Union des grandes écoles indépendantes.

La CTI a récompensé l'ESME Sudria pour la qualité de son enseignement en lui décernant le label EUR-ACE4
 (European Accreditation for Engineering Programmes).</p>
    <img src="http://blogs.ionis-group.com/esme/assets_c/2010/10/3619310110_91fcb6e7a2_o-thumb-250x166-24547.jpg">
  </div>
  <div class="column middle">
    <h2>Fresh news</h2>
    <table id="news">
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Image</th>
			</tr>
			<c:forEach items="${news}" var="news">
				<tr>
					<td>${news.title}</td>
					<td>${news.description}</td>
					<td><img width=100 height="100" src="${news.image}">
					</td>
					
				</tr>
			</c:forEach>
		</table>
  </div>
</div>

</body>
</html>