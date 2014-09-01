<?php

$post_error = "";
$user_name_error = "";


// värden för pdo
$host = "localhost";
$dbname = "guestbook";
$username = "guestbook";
$password = "123456";

// göra pdo
$dsn = "mysql:host=$host;dbname=$dbname";
$attr = array(PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC);

$pdo = new PDO($dsn, $username, $password, $attr);

if($pdo)
{
	// har något postats? skriv till databas
	if (!empty($_POST)) 
	{
		if(isset($_POST['post']))
		{
			$_POST = null;

			$user_id = filter_input(INPUT_POST, 'user_id', FILTER_VALIDATE_INT);
			$post    = filter_input(INPUT_POST, 'post', FILTER_SANITIZE_SPECIAL_CHARS, FILTER_FLAG_STRIP_LOW);

			if(empty($post))
			{
				$post_error = "Goddamn";
			}

			else
			{
				$statement = $pdo->prepare("INSERT INTO posts (date, user_id, post) VALUES (NOW(), :user_id, :post)");
				$statement->bindParam(":user_id", $user_id);
				$statement->bindParam(":post", $post);
				$statement->execute();
			}
		}

		elseif (isset($_POST['user_name'])) 
		{
			$_POST = null;
			
			$user_name = filter_input(INPUT_POST, 'user_name', FILTER_SANITIZE_SPECIAL_CHARS, FILTER_FLAG_STRIP_LOW);

			if(empty($user_name))
			{
				$user_name_error = "Fyll i nåt";
			}

			else
			{
				$statement = $pdo->prepare("INSERT INTO users (name) VALUES (:user_name)");
				$statement->bindParam(":user_name", $user_name);
				$statement->execute();
			}
		}

		
	}

	// visa post-formulär för att skriva inlägg
	?>

	<form action="index.php" method="POST">
		<p>
			<label for="user_name">Username: </label>
			<input type="text" name="user_name" />
			<?php echo $user_name_error; ?>
		</p>

		<input type="submit" value="Register" />
	</form>

	<hr />

	<form action="index.php" method="POST">
		<p>
			<label for="user_id">User: </label>
			<select name="user_id">
				<?php
					// <option value=0>test</option>
					foreach ($pdo->query("SELECT * FROM users ORDER BY name") as $row) 
					{
						echo "<option value=\"{$row['id']}\">{$row['name']}</option>";
					}

				?>
			</select>
		</p>

		<p>
			<label for="post">Post: </label>
			<input type="text" name="post"/>
			<?php echo $post_error; ?>
		</p>

		<input type="submit" value="Post" />
	</form>
	<hr />

	<?php
	//visa alla användare (ul)
	echo "<ul>";
	echo "<li><a href=\"index.php\">all users</a></li>";

	foreach ($pdo->query("SELECT * FROM users ORDER BY name") as $row) 
	{
		echo "<li><a href=\"?user_id={$row['id']}\">{$row['name']}</a></li>";
	}

	echo "</ul>";
	echo "<hr />";

	if(!empty($_GET))
	{
		// om user klickat på ett namn, visa dess inlägg
		$_GET = null;
		$user_id = filter_input(INPUT_GET, 'user_id', FILTER_VALIDATE_INT);
		$statement = $pdo->prepare("SELECT posts.*, users.name FROM posts JOIN users ON users.id=posts.user_id WHERE user_id=:user_id ORDER BY date");
		$statement->bindParam(":user_id", $user_id);

		if ($statement->execute())
		{
			while($row = $statement->fetch())
			{
				echo "<p>{$row['date']} by {$row['name']} <br /> {$row['post']}</p>";
			}
		}

	}

	else
	{
		// annars visa alla inlägg
		foreach ($pdo->query("SELECT posts.*, users.name AS user_name FROM posts JOIN users ON users.id=posts.user_id ORDER BY date") as $row) 
		{
			echo "<p>{$row['date']} by {$row['user_name']} <br /> {$row['post']}</p>";
		}
	}
}
else
{
	echo "Not connected";
}
	
?>