<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Sammanfattningar</title>
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

			<section>
				<?php

				$host = "localhost";
				$dbname = "elev_plattform";
				$username = "elev_plattform";
				$password = "12345";

				$user_error = ""; //Variabel för felmeddelande om man glömt välja användare
				$commentText_error = "";

				$numberOfSummaries = 0; //Variabel för antalet sammanattningar
				$pageLink = 0; //Variabel som håller koll på hur många linkar det ska finnas till en ny sida med sammanfattningar

				$dsn = "mysql:host=$host; dbname=$dbname; charset=utf8mb4";
				$attr = array(PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC);
				$pdo = new PDO($dsn, $username, $password, $attr);

				//visa sammanfattningar

				if($pdo)
				{
					if(!empty($_POST))
					{
						$_POST = null;

						$commentText = filter_input(INPUT_POST, 'commentText', FILTER_SANITIZE_STRING);
						$user_id = filter_input(INPUT_POST, 'user_id', FILTER_VALIDATE_INT);
						$summary_id = filter_input(INPUT_GET, 'summary_id', FILTER_VALIDATE_INT);

						if($user_id === 0)
						{
							$user_error = "Du glömde välja användare!";
						}

						if(empty($commentText))
						{
							$commentText_error = "Du har inte skrivit något!";
						}

						if($user_id !== 0 && !empty($commentText))
						{
							echo "hej";
							$statement = $pdo->prepare("INSERT INTO comments (comment_text, date, user_id, summary_id) VALUES (:commentText, NOW(), :user_id, :summary_id)");
							$statement->bindParam (":commentText", $commentText);
							$statement->bindParam (":user_id", $user_id);
							$statement->bindParam (":summary_id", $summary_id);
							$statement->execute();
						}
					}
					
					if(!empty($_GET))
					{
						$_GET = null;
						$summary_id = filter_input(INPUT_GET, 'summary_id', FILTER_VALIDATE_INT);
						$course_id = filter_input(INPUT_GET, 'course_id', FILTER_VALIDATE_INT);
						$page = filter_input(INPUT_GET, 'page', FILTER_VALIDATE_INT);

						//visa kursens sammanfattningar
						if(!empty($course_id))
						{
							foreach ($pdo->query("SELECT summary.*, summary.ID AS sum_ID, users.firstname, users.lastname, courses.* FROM summary JOIN courses
							ON summary.course_id=$course_id AND summary.course_id=courses.id JOIN users ON summary.user_id=users.id ORDER BY date DESC") as $row)
							{
								echo "<div class=\"posts\"> <a href=\"view_summaries.php?summary_id={$row['sum_ID']}\"> <div class=\"title\">{$row['title']}</div> 
								<div class=\"userAndDate\">Posted by {$row['firstname']} {$row['lastname']} - {$row['date']} - {$row['name']}</div></a></div>"; 
							}
						}
						
						//Visa en sammanfattning
						if(!empty($summary_id))
						{
							foreach ($pdo->query("SELECT summary.*, users.firstname, users.lastname, courses.* FROM summary JOIN users ON summary.id=$summary_id
							AND users.id=summary.user_id JOIN courses ON summary.course_id=courses.id") as $row) 
							{
								echo "<div class=\"postheader\"> <div class=\"title\">{$row['title']}</div>
								<div class=\"userAndDate\">Posted by {$row['firstname']} {$row['lastname']} - {$row['date']} - 
								<a class=\"course_link\"href=\"view_summaries.php?course_id={$row['ID']}\">{$row['name']}</a></div>
								</div> <div class=\"content\">{$row['content']}</div>";
							}

							//För att kunna kommentera
							echo <<<FORM
							<form id="comment_form" action="" method="POST">
								<p class="comment_form_content">
									<select name="user_id">
										<option value="0">---Välj användare---</option>
FORM;
										foreach ($pdo->query("SELECT * FROM users ORDER BY firstname") as $row) 
										{
											echo "<option value=\"{$row['ID']}\">{$row['firstname']} {$row['lastname']}</option>";
										}
										echo <<<FORM
									</select>
									<span class="form_error">$user_error</span>
								</p>

								<p class="comment_form_content">
									<textarea id="commentField" name="commentText">$commentText</textarea>
									<span class="form_error">$commentText_error</span>
									<input type="submit" value="Kommentera" />
								</p>
							</form>
FORM;
	
							foreach ($pdo->query("SELECT * FROM comments JOIN users ON users.id=comments.user_id WHERE comments.summary_id=$summary_id
							ORDER BY date DESC") as $row)
							{
								echo "<div class=\"comment\"><div class=\"comment_userAndDate\">{$row['firstname']} {$row['lastname']} - {$row['date']}</div> 
								<div class=\"comment_content\">{$row['comment_text']}</div></div>";
							}
						}

						//Visa alla sammanfattningar som får plats på en sida
						if(!empty($page))
						{
							$start = 10;
							$count = 10;

							$start *= ($page - 1);

							?>
							<a href="add_summary.php"><button type="button">Lägg till sammanfattning</button></a>
							
							<div id="summaries">
								<?php
								foreach ($pdo->query("SELECT summary.*, summary.ID AS sum_ID, users.firstname, users.lastname, courses.* FROM summary JOIN users
								ON users.id=summary.user_id JOIN courses ON summary.course_id=courses.id ORDER BY date DESC LIMIT $start, $count") as $row) 
								{
									echo "<div class=\"posts\"> <a href=\"view_summaries.php?summary_id={$row['sum_ID']}\"> <div class=\"title\">{$row['title']}</div> 
									<div class=\"userAndDate\">Posted by {$row['firstname']} {$row['lastname']} - {$row['date']} - {$row['name']}</div></a></div>";
								}
								?>
							</div>
							<?php

							foreach ($pdo->query("SELECT * FROM summary") as $row) 
							{
								$numberOfSummaries ++;
							}

							echo "<div id=\"page_links_style\">";
							for ($i = 0; $i < $numberOfSummaries; $i += $count)
							{
								$pageLink ++;
								echo "<a href=\"view_summaries.php?page=$pageLink\"><p class=\"page_link\">$pageLink</p></a>";
							}
							echo "</div>";
						}

					}

					//Visa alla sammanfattningar						
						
				}
				?>
			</section>
		</div>

	</div>
	<footer>
		<p>&copy Copyright Elias Axelsson</p>
	</footer>

</body>