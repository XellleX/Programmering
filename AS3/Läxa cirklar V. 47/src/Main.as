package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.MouseEvent;
	import flash.external.ExternalInterface;
	import flash.text.TextField;
	import flash.ui.Keyboard;
	import flash.text.TextFormat;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var circle:Sprite;
		private var gameOverScreen:Sprite = new Sprite();		
		
		private var circles:Vector.<Sprite> = new Vector.<Sprite>();
		
		private var circleSpawnX:int = 0;
		private var circleSpawnY:int = 50;
		private var numberOfCircles:int = 0;		//så att jag kan hålla koll på antalet cirklar jag har
		private var score:int = 0;					//spelarens poäng
		private var circleOfDoom:int;				//cirkeln som gör så att man förlorar
		
		private var scoreBoard:TextField = new TextField();
		private var gameOverText:TextField = new TextField();		//texten som skrivs när man förlorar
		private var startText:TextField = new TextField();			//texten som står innan man startar
		
		private var textSize:TextFormat = new TextFormat();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			stage.addEventListener (KeyboardEvent.KEY_DOWN, spawnCircles);
			
			scoreBoard.selectable = false;
			
			gameOverScreen.graphics.beginFill(0x000000);
			gameOverScreen.graphics.drawRect (0, 0, stage.stageWidth, stage.stageHeight);
			gameOverScreen.graphics.endFill();
			
			gameOverText.textColor = 0xFFFFFF;
			gameOverText.x = stage.stageWidth / 2;		//för att hamna i mitten
			gameOverText.y = stage.stageHeight / 2;		//för att hamna i mitten
			gameOverText.wordWrap = true;
			gameOverText.selectable = false;
			
			startText.x = stage.stageWidth / 2;
			startText.y = stage.stageHeight / 2;
			startText.selectable = false;
			startText.text = "Press space to begin";
			addChild(startText);
		}
		
		private function spawnCircles(e:KeyboardEvent):void   
		{
			switch (e.keyCode) 
			{
				case Keyboard.SPACE:
					
					addChild(scoreBoard);
					startText.visible = false;		//för att texten inte ska vara i mitten av skärmen när man spelar
					
					while (numberOfCircles > 0) 	//tar bort cirklarna
					{
						removeChild (circles [0]);
						circles.shift();
						numberOfCircles --;
					}
					
					for (var i:int = 0; i < 20; i++) 	
					{
						score = 0;
						scoreBoard.text = "Points: " + score.toString();
						
						circleOfDoom = 20 * Math.random();		//för att "circleOfDoom" ska bli olika varje gång, använder talet mellan 0-20 för att vectorn har så många element.
						
						circle = new Sprite();
						
						circleSpawnX = stage.stageWidth * Math.random();		//så cirkeln får en random x position
						circleSpawnY = stage.stageHeight * Math.random();		//så cirkeln får en random y position
						
						circle.graphics.beginFill(0xFFFF00);
						circle.graphics.drawCircle (circleSpawnX, circleSpawnY, 20);
						circle.graphics.endFill();
						
						circles.push (circle);
						addChild (circles [i]);
						
						numberOfCircles ++;		//så att jag vet antalet cirklar
						
						circle.addEventListener (MouseEvent.CLICK, clickOnCircle);		//så att jag sedan kan klicka på cirklarna
					}
					
					gameOverScreen.visible = false;		//för att man inte ska ha den svarta skärmen om man vill spela igen
					break;
				default:
					break;
			}
		}
		
		private function clickOnCircle(m:MouseEvent):void 
		{
			for (var i:int = 0; i < 20; i++)
			{
				if (m.target == circles [i])	//kollar vilken cirkel man klicka på
				{
					if (i == circleOfDoom) //kollar om det är den förlorar cirkeln man klickat på
					{
						addChild(gameOverScreen);		//gör så att man ser en annan "sida"
						gameOverScreen.visible = true;	//gör så att den syns
						
						if (score <= 3)
						{
							gameOverText.text = "You ONLY got " + score.toString() + " Point(s)?!?!?! \n" + "Sooo baad... \n" + "Press Space to play again";
							addChild(gameOverText);
						}
						
						else if (score <= 8 && score > 3)
						{
							gameOverText.text = "You got " + score.toString() + " Points. That's not good... \n" + "Press Space to play again";
							addChild(gameOverText);
						}
						
						else if (score <= 15 && score > 8)
						{
							gameOverText.text = "You got " + score.toString() + " Points. That's really good! \n" + "Press Space to play again";
							addChild(gameOverText);
						}
						
						else if (score < 19 && score > 15)
						{
							gameOverText.text = "YOU GOT " + score.toString() + " POINTS!! YOU ARE THE BEST! \n" + "Press Space to play again";
							addChild (gameOverText);
						}
						
						else if (score == 19)
						{
							gameOverText.text = "You won the game! Congratulations my friend :) \n" + "Press Space to play again";
							addChild(gameOverText);
						}
					}
					
					else 
					{
						circles [i].visible = false;	//för att göra så att man inte kan klicka på den igen, och att den inte ska synas
						score ++;						//gör så att spelaren får poäng om den klickar på rätt cirkel
						scoreBoard.text = "Points: " + score.toString();	//för att visa spelaren vad den har för poäng
					}
				}
			}
		}
	}
	
}