<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="style.css" />
		<title>Registrera</title>
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
				<h2>Registrera dig</h2>

<?php

$host = "localhost";
$dbname = "elev_plattform";
$username = "elev_plattform";
$password = "12345";

$show_form = true;

$lastname_error = "";
$firstname_error = "";
$firstname = "";
$lastname = "";

$dsn = "mysql:host=$host; dbname=$dbname; charset=utf8mb4";
$attr = array(PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC);

$pdo = new PDO($dsn, $username, $password, $attr);

if($pdo)
{
	if(!empty($_POST))
	{
		$_POST=null;
		$show_form = false;

		$firstname = filter_input(INPUT_POST, 'firstname', FILTER_SANITIZE_STRING);
		$lastname = filter_input(INPUT_POST, 'lastname', FILTER_SANITIZE_STRING);

		if(empty($firstname))
		{
			$firstname_error = "Fel";
			$show_form = true;
		}

		if(empty($lastname))
		{
			$lastname_error = "Fel";
			$show_form = true;
		}

		if(!$show_form)
		{
			$statement = $pdo->prepare("INSERT INTO users (firstname, lastname) VALUES (:firstname, :lastname)");
			$statement->bindParam (":firstname", $firstname);
			$statement->bindParam (":lastname", $lastname);
			$statement->execute();
		}
	}

	if($show_form)
	{
		echo <<<FORM

		<form action="" method="POST">

			<p>
				<input id="test" type="text" name="firstname" placeholder="Förnamn" value="$firstname" />
				<strong>$firstname_error</strong>
			</p>

			<p>
				<input type="text" name="lastname" placeholder="Efternamn" value="$lastname" />
				<strong>$lastname_error</strong>
			</p>

			<p><input type="submit" value="Registrera" /></p>
		</form>

FORM;
	}

	else
	{
		?>
		<script>
			location.replace ("index.php");
		</script>
		<?php
	}
}

else
{
	echo "AH";
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