var count = 0;
function changeText()
{
	
	var g = document.getElementById("greeting");
	g.innerHTML = count;
	count ++;
	
	var b = document.getElementById("bilden");
	
	if(b.src == "carl.jpg")
	{
		b.src = "c.png";
	}
	else
	{
		b.src = "carl.jpg";
	}

}

