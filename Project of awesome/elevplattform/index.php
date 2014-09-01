<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="Stylesheet" type="text/css" href="style.css" />
		<title>Startsida</title>
	</head>

<body>
	<header>
		<h1>Elev plattform</h1>
		<a href="register.php"><button id="register" type="button">Registrera</button></a>
	</header>

	<div id="style">

		<div id="content">
			<nav id="navigation">
				<ul>
					<a href="index.php"><li class="buttons">Hem</li></a>
					<a href="view_summaries.php?page=1"><li class="buttons">Sammanfattningar</li></a>
				</ul>
			</nav>

			<section id="container">
				<?php

				$host = "localhost";
				$dbname = "elev_plattform";
				$username = "elev_plattform";
				$password = "12345";

				$numberOfSummaries = 0;
				$ah = 0;

				$dsn = "mysql:host=$host; dbname=$dbname; charset=utf8mb4";
				$attr = array(PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC);

				$pdo = new PDO($dsn, $username, $password, $attr);

				//visa alla eller en

				if($pdo)
				{
					//Räkna antalet sammanfattningar per kurs
					foreach ($pdo->query("SELECT * FROM courses") as $row) 
					{
						${$row['name']} = 0;
						$course_id = $row['ID'];
						//SELECT COUNT(*) FROM courses JOIN summary ON courses.ID=summary.course_id GROUP BY courses.ID
							foreach ($pdo->query("SELECT summary.*, summary.ID AS sum_ID, users.firstname, users.lastname, courses.* FROM summary JOIN courses
							ON summary.course_id=$course_id AND summary.course_id=courses.id JOIN users ON summary.user_id=users.id ORDER BY date DESC") as $row)
						{
							${$row['name']} ++;
						}
					}
					

					?>
					<ul id="courses_list">

					<?php

					//Skriva ut kurserna och hur många sammanfattningar de har
					foreach($pdo->query("SELECT * FROM courses ORDER BY name") as $row)
					{
						echo "<a href=\"view_summaries.php?course_id={$row['ID']}\"><li>{$row['name']} - ${$row['name']}</li></a>";
					}
					?>

					</ul>

					<div id="news_feed">
						<h2>News feed</h2>
						<p>De tre senaste sammanfattningarna:</p>
					<?php

					foreach ($pdo->query("SELECT summary.*, summary.ID AS sum_ID, users.firstname, users.lastname, courses.* 
					FROM summary JOIN users ON users.id=summary.user_id JOIN courses ON summary.course_id=courses.id ORDER BY date DESC LIMIT 3") as $row) 
					{
						echo "<div class=\"news_feed_summary\"> <a href=\"view_summaries.php?summary_id={$row['sum_ID']}\"> <div class=\"title\">{$row['title']}</div></a></div>";
					}

					foreach ($pdo->query("SELECT * FROM summary") as $row) 
					{
						$numberOfSummaries ++;
					}

					echo "<p>Det finns nu sammanlagt $numberOfSummaries sammanfattningar.</p>";
					echo "</div>";
				}
				?>
			</section>
		</div>

	</div>

	<footer>
		<p>&copy Copyright Elias Axelsson</p>
	</footer>
</body>