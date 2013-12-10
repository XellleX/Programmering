package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.MouseEvent;
	import flash.geom.ColorTransform;
	import flash.text.engine.EastAsianJustifier;
	import flash.text.TextField;
	import flash.text.TextFormat;
	import mx.core.FlexApplicationBootstrap;
	import flash.ui.Keyboard;
	import flash.text.TextFormatAlign;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var tile:Tile;
		
		private var numberOfTiles:int = 0; //Knows the amount of tiles that is on the screen
		
		private var battlefieldX:Vector.<Vector.<Tile>> = new Vector.<Vector.<Tile>>(); //this vector is for putting in battlefieldY
		private var battlefieldY:Vector.<Tile>; //Tiles vertical
		
		private var navigationTile:Sprite;
		
		private var navigation:Vector.<Sprite> = new Vector.<Sprite>();
		
		private var tileChange:Tile = new Tile();
		
		private var scoreboard:TextField = new TextField();
		
		private var navigationField:TextField;
		private var navFields:Vector.<TextField> = new Vector.<TextField>();
		private var navigationNumbers:int;
		private var navigationLetters:Array = new Array("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
		private var navigationImprovement:TextFormat = new TextFormat();
		
		private var battleShipPlacement:BattleShip = new BattleShip();
		
		//public var hits:int = 0;
		//public var misses:int = 0;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			scoreboard.x = 600;
			scoreboard.y = 200;
			scoreboard.selectable = false;
			addChild(scoreboard);
			
			navigationImprovement.align = "center";
			navigationImprovement.size = 20;
			navigationImprovement.color = 0xFF8040;
			
			stage.addEventListener(KeyboardEvent.KEY_DOWN, onKeyDown);
			
			resetBoard();
		}
		
		private function drawTile(navTileOrTile:String):void 
		{
			if (navTileOrTile == "tile")
			{
				tile = new Tile();
				
				tile.addEventListener (MouseEvent.CLICK, onClick);
				
				numberOfTiles ++;
			}
			
			else if (navTileOrTile == "navTile")
			{	
				navigationTile = new Sprite();
				navigationTile.graphics.beginFill(0x000000);
				navigationTile.graphics.drawRect (0, 0, Tile.TILE_SIDE, Tile.TILE_SIDE);
				navigationTile.graphics.endFill();
				
				navigation.push (navigationTile);
				
				navigationField = new TextField();
				
				navigationField.width = Tile.TILE_SIDE;
				navigationField.height = Tile.TILE_SIDE;
				navigationField.selectable = false;
				
				if (navigationNumbers == 0)
				{
					navigationField.text = "";
				}
				
				else if (navigationNumbers <= 10)
				{
					navigationField.text = "" + navigationNumbers.toString();
				}
				
				if (navigationNumbers > 10)
				{
					navigationField.text = "" + navigationLetters[navigationNumbers - 11];
				}
				
				navigationNumbers ++;
				navigationField.setTextFormat(navigationImprovement);
				navFields.push (navigationField);
				
				//tile.y += Tile.TILE_SIDE + 5;
			}
		}
		
		private function resetBoard():void //A function that reset everything, score, tiles and so on.
		{
			for (var k:int = 0; k < battleShipPlacement.ships.length;) 
			{
				while (battleShipPlacement.ships[k].length > 0) 
				{
					battleShipPlacement.ships[k].shift();
				}
				
				battleShipPlacement.ships.shift();
				battleShipPlacement.clickVerticalOrHorizontal.shift();
			}
			
			battleShipPlacement.shipPlacement(3);
			battleShipPlacement.shipPlacement(2);
			battleShipPlacement.shipPlacement(4);
			
			navigationNumbers = 0;
			
			//tile.x = 0; 
			
			tileChange.hits = 0;
			tileChange.misses = 0;
			scoreboard.text = "Hits: " + tileChange.hits.toString() + "\n \n \n" + "Misses: " + tileChange.misses.toString();
			
			while (numberOfTiles > 0) //removes the tiles, and the battlefieldY vectors
			{
				numberOfTiles --;
				removeChild(battlefieldX[0].shift());
				
				if (numberOfTiles % 10 == 0)
				{
					battlefieldX.shift();
				}
				
				if (numberOfTiles >= 79)
				{
					removeChild(navFields[0]);
					navFields.shift();
					removeChild(navigation[0]);
					navigation.shift();
				}
			}
			
			for (var i:int = 0; i < 11; i++) //make new tiles and vectors
			{	
				if (i != 0)
				{
					battlefieldY = new Vector.<Tile>();
				}
				
				for (var j:int = 0; j < 11; j++) 
				{	
					if (i == 0)
					{	
						drawTile("navTile");
						addChild(navigation[j]);
						addChild(navFields[j]);
						navigationTile.y += j * (Tile.TILE_SIDE + 5);
						navigationField.y += j * (Tile.TILE_SIDE + 5);
					}
					
					else if (j == 0)
					{
						drawTile("navTile");
						addChild(navigation[j + 10 + i]);
						addChild(navFields[j + 10 + i]);
						navigationTile.x += i * (Tile.TILE_SIDE + 5);
						navigationField.x += i * (Tile.TILE_SIDE + 5);
					}
					
					else
					{
						drawTile("tile");
						tile.y += j * (Tile.TILE_SIDE + 5);
						tile.x += i * (Tile.TILE_SIDE + 5);
						battlefieldY.push (tile);
						addChild(battlefieldY[j - 1]);
					}
				}
				
				if (i != 0)
				{
					battlefieldX.push (battlefieldY);
				}
				
			}
		}
		
		private function onKeyDown(k:KeyboardEvent):void 
		{
			switch (k.keyCode) 
			{
				case Keyboard.SPACE:
					
					resetBoard(); //To reset the game
					
					break;
				default:
			}
			
		}
		
		private function onClick(m:MouseEvent):void 
		{
			Tile(m.target).clicked();
			
			// return 
			
			tileChange.shipTile = false;
			
			for (var j:int = 0; j < battleShipPlacement.ships.length; j++) 
			{
				for (var i:int = 0; i < battleShipPlacement.ships[j].length - 1; i++) 
				{
					if (battleShipPlacement.clickVerticalOrHorizontal[j] == 0)
					{
						if (m.target == battlefieldX[battleShipPlacement.ships[j][0]][battleShipPlacement.ships[j][i + 1]])
						{
							tileChange.shipTile = true;
						}
					}
					
					else if (battleShipPlacement.clickVerticalOrHorizontal[j] == 1)
					{
						if (m.target == battlefieldX[battleShipPlacement.ships[j][i + 1]][battleShipPlacement.ships[j][0]])
						{
							tileChange.shipTile = true;
						}
					}
					
				}
			}
			
			tileChange.hitAndMiss();
			m.target.transform.colorTransform = tileChange.tileColor; //So it changes color when you click
			scoreboard.text = "Hits: " + tileChange.hits.toString() + "\n \n \n" + "Misses: " + tileChange.misses.toString();
		}
		
		
	}
	
}

//jag tycker att min kod har en hyfsat bra prestanda. 27:de november