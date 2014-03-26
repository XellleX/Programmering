package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.MouseEvent;
	import flash.geom.Point;
	import flash.text.TextField;
	import flash.ui.Keyboard;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var tile:Tile;
		private var numberOfTiles:int = 0;
		private var battlefieldLines:Vector.<Tile>;
		private var battlefield:Vector.<Vector.<Tile>> = new Vector.<Vector.<Tile>>();
		
		private var scoreBoard:TextField = new TextField();
		
		private var shipPosition:Point;
		private var shipHorizontal:Boolean; //will tell if the ship should be horizontal or not (vertical).
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			resetboard(); //To put out the battlefield at start
			
			stage.addEventListener (KeyboardEvent.KEY_DOWN, onKeyDown);
			
			scoreBoard.x = 600;
			scoreBoard.y = 300;
			scoreBoard.selectable = false;
			scoreBoard.background = true;
			scoreBoard.backgroundColor = 0xC0C0C0;
			scoreBoard.border = true;
			addChild (scoreBoard);
		}
		
		private function shipPlacement(battleShipLength:int):void //Puts out ships. I have it because 
		{
			shipHorizontal = Math.round(Math.random());
			
			var i:int;
			
			if (shipHorizontal) //So it know if it supposed to be horizontal or vertical.
			{
				shipPosition = new Point(Math.round(Math.random() * (10 - battleShipLength)), Math.round(Math.random() * 9)); 
				//Here it makes the startposition of the ship, and the X position is * 10 - battleshiplength so it can't be outside the battlefield
				
				for (i = 0; i < battleShipLength; i++) 
				{
					battlefield[shipPosition.x + i][shipPosition.y].tileType = Tile.SHIP; //tells the tile that it is a ship
				}
			}
			
			else if (!shipHorizontal)
			{
				shipPosition = new Point(Math.round(Math.random() * 9), Math.round(Math.random() * (10 - battleShipLength)));
				
				for (i = 0; i < battleShipLength; i++) 
				{
					battlefield[shipPosition.x][shipPosition.y + i].tileType = Tile.SHIP;
				}
			}
		}
		
		private function resetboard():void //This function resets everything and puts out the battlefield. I have this so i dont have to write the code more than once.
		{
			Tile.misses = 0;
			Tile.hits = 0;
			Tile.shotsFired = 0;
			scoreBoard.text = "Shots Fired: " + Tile.shotsFired.toString() + "\n\nHits: " + Tile.hits.toString() + "\n\nMisses: " + Tile.misses.toString();
			
			while (numberOfTiles > 0) //removes all the tiles so it can reset
			{
				numberOfTiles --;
				removeChild(battlefield[0].shift());
				
				if (numberOfTiles % 10 == 0)
				{
					battlefield.shift();
				}
			}
			
			for (var i:int = 0; i < 10; i++) //Puts out the battlefield.
			{	
				battlefieldLines = new Vector.<Tile>(); //will contain lines of tiles (10 in each)
				
				for (var j:int = 0; j < 10; j++) //makes 10 tiles for one line
				{	
					tile = new Tile();
					
					tile.y += 50 + j * (Tile.TILE_SIDE + 5); //So they are in line vertical
					tile.x += 50 + i * (Tile.TILE_SIDE + 5); //So they are in line horizontal
					
					battlefieldLines.push (tile);
					addChild (battlefieldLines[j]);
					
					tile.addEventListener (MouseEvent.CLICK, onClick);
					
					numberOfTiles ++;
				}
				
				battlefield.push (battlefieldLines); //contains all the lines (the whole battlefield)
			}
			
			shipPlacement(4); //Puts out a ship that has the length you tell in the parameter.
			shipPlacement(2);
			shipPlacement(3);
		}
		
		private function onKeyDown(k:KeyboardEvent):void //So you can press a key
		{
			switch (k.keyCode) 
			{
				case Keyboard.SPACE: //So it resets when you press space.
					
					resetboard();
					break;
				default:
			}
		}
		
		private function onClick(m:MouseEvent):void //So i can click on tiles
		{
			Tile(m.target).clicked(); //So the tile becomes a ship or a miss
			scoreBoard.text = "Shots Fired: " + Tile.shotsFired.toString() + "\n\nHits: " + Tile.hits.toString() + "\n \nMisses: " + Tile.misses.toString();
		}
		
	}
	
}