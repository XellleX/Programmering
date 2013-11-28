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
		private var tile:Sprite;
		
		private var tileX:int = 50; //Placement of the tile on the x coordinate
		private const TILE_SIDE:int = 45;
		private var tileY:int = 50; //Placement of the tile on the y coordinate
		private var numberOfTiles:int = 0; //Knows the amount of tiles that is on the screen
		
		private var battlefieldX:Vector.<Vector.<Sprite>> = new Vector.<Vector.<Sprite>>(); //this vector is for putting in battlefieldY
		private var battlefieldY:Vector.<Sprite>; //Tiles vertical
		
		private var navigationTile:Sprite;
		
		private var navigation:Vector.<Sprite> = new Vector.<Sprite>();
		
		private var tileChange:Tile = new Tile();
		
		private var color:ColorTransform = new ColorTransform();
		
		private var scoreboard:TextField = new TextField();
		
		private var navigationField:TextField;
		private var navFields:Vector.<TextField> = new Vector.<TextField>();
		private var navigationNumbers:int;
		private var navigationLetters:Array = new Array("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
		private var navigationImprovement:TextFormat = new TextFormat();
		
		private var battleShipPlacement:BattleShip = new BattleShip();
		
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
				tile = new Sprite();
				tile.graphics.beginFill(0x00FFFF);
				tile.graphics.drawRect (tileX, tileY, TILE_SIDE, TILE_SIDE);
				tile.graphics.endFill();
				
				tileY += TILE_SIDE + 5; //So they will have 5 margin between each other
				
				tile.addEventListener (MouseEvent.CLICK, onClick);
				
				numberOfTiles ++;
			}
			
			else if (navTileOrTile == "navTile")
			{	
				navigationTile = new Sprite();
				navigationTile.graphics.beginFill(0x000000);
				navigationTile.graphics.drawRect (tileX, tileY, TILE_SIDE, TILE_SIDE);
				navigationTile.graphics.endFill();
				
				navigation.push (navigationTile);
				
				navigationField = new TextField();
				navigationField.x = tileX;
				navigationField.y = tileY;
				navigationField.width = TILE_SIDE;
				navigationField.height = TILE_SIDE;
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
				
				tileY += TILE_SIDE + 5;
			}
		}
		
		private function resetBoard():void //A function that reset everything, score, tiles and so on.
		{
			battleShipPlacement.shipPlacement(3);
			navigationNumbers = 0;
			tileX = 50; 
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
					battlefieldY = new Vector.<Sprite>();
				}
				
				for (var j:int = 0; j < 11; j++) 
				{	
					if (i == 0)
					{	
						drawTile("navTile");
						addChild(navigation[j]);
						addChild(navFields[j]);
					}
					
					else if (j == 0)
					{
						drawTile("navTile");
						addChild(navigation[j + 10 + i]);
						addChild(navFields[j + 10 + i]);
					}
					
					else
					{
						drawTile("tile");
						battlefieldY.push (tile);
						addChild(battlefieldY[j - 1]);
					}
				}
				
				if (i != 0)
				{
					battlefieldX.push (battlefieldY);
				}
				tileX += TILE_SIDE + 5;
				tileY = 50;
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
			if (m.target == battlefieldX[battleShipPlacement.shipBody[0]][battleShipPlacement.shipBody[0]])
			{
				tileChange.shipTile = true;
			}
			
			else 
			{
				tileChange.shipTile = false;
			}
			
			tileChange.hitAndMiss();
			m.target.transform.colorTransform = tileChange.tileColor; //So it changes color when you click
			scoreboard.text = "Hits: " + tileChange.hits.toString() + "\n \n \n" + "Misses: " + tileChange.misses.toString();
		}
		
		
	}
	
}

//jag tycker att min kod har en hyfsat bra prestanda. 27:de november