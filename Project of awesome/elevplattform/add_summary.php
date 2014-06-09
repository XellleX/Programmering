<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Lägg till</title>
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

			<section class="form">

				<?php

				//Visa form

				//Spara i databas om info skickats

				$host = "localhost";
				$dbname = "elev_plattform";
				$username = "elev_plattform";
				$password = "12345";

				$user_id = "";
				$title = "";
				$course_id = "";
				$content = "";

				$title_error = "";
				$user_id_error = "";
				$course_id_error = "";
				$content_error = "";

				$show_form = true;

				$dsn = "mysql:host=$host; dbname=$dbname; charset=utf8mb4";
				$attr = array(PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC);

				$pdo = new PDO($dsn, $username, $password, $attr);

				if($pdo)
				{

					if(!empty($_POST))
					{
						$_POST=null;
						$show_form = false;

						$user_id = filter_input(INPUT_POST, 'user_id', FILTER_VALIDATE_INT);
						$course_id = filter_input(INPUT_POST, 'course_id', FILTER_VALIDATE_INT);
						$title = filter_input(INPUT_POST, 'title', FILTER_SANITIZE_STRING);
						$content = filter_input(INPUT_POST, 'content', FILTER_SANITIZE_STRING);

						if(empty($title))
						{
							$title_error = "Du fyllde inte i en titel!";
							$show_form = true;
						}

						if($user_id === 0)
						{
							$user_id_error = "Du glömde välja användare!";
							$show_form = true;
						}

						if($course_id === 0)
						{
							$course_id_error = "Du glömde välja kurs!";
							$show_form = true;
						}

						if(empty($content))
						{
							$content_error = "Du har inte skrivit något!";
							$show_form = true;
						}

						if(!$show_form)
						{
							$statement = $pdo->prepare("INSERT INTO summary (title, content, date, course_id, user_id) VALUES (:title, :content, NOW(), :course_id, :user_id)");
							$statement->bindParam (":title", $title);
							$statement->bindParam (":content", $content);
							$statement->bindParam (":course_id", $course_id);
							$statement->bindParam (":user_id", $user_id);
							$statement->execute();
						}
					}

					if($show_form)
					{
						echo <<<FORM

						<form action="" method="POST">

							<p>
								<label for="user_id">Användare: </label>
								<select name="user_id" value="$user_id">
									<option value="0">---Välj användare---</option>
FORM;
									foreach ($pdo->query("SELECT * FROM users ORDER BY firstname") as $row) 
									{
										echo "<option value=\"{$row['ID']}\">{$row['firstname']} {$row['lastname']}</option>";
									}

									echo <<<FORM
								</select>
								<span class="form_error">$user_id_error</span>
							</p>

							<p>
								<label for="course">Kurs: </label>
								<select name="course_id" value="$course_id">
									<option value="0">---Välj kurs---</option>
FORM;
									foreach ($pdo->query("SELECT * FROM courses ORDER BY name") as $row) 
									{
										echo "<option value=\"{$row['ID']}\">{$row['name']}</option>";
									}

									echo <<<FORM
								</select>
								<span class="form_error">$course_id_error</span>
							</p>

							<p>
								<input id="titlefield" type="text" name="title" placeholder="Titel" maxlength="64" value="$title"/>
								<span class="form_error">$title_error</span>
							</p>

							<p>
								<textarea id="textfield" name="content">$content_error</textarea>
								<span class="form_error">$content_error</span>
							</p>

							<input type="Submit" value="Skicka in din sammanfattning" />
						</form>
						
FORM;

					}

					else
					{	
						?>
						<script>
							location.replace ("view_summaries.php?page=1");
						</script>
						<?php
					}

				}
				else
				{
					echo "MATTAFAKKA";
				}

				?>
			</section>
		</div>
	</div>

	<footer>
		<p>&copy Copyright Elias Axelsson</p>
	</footer>

</body>
</html>