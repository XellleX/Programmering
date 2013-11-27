package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.MouseEvent;
	import flash.geom.ColorTransform;
	import flash.text.TextField;
	import mx.core.FlexApplicationBootstrap;
	import flash.ui.Keyboard;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var testX:int;
		private var testY:int;
		
		private var tile:Sprite;
<<<<<<< HEAD
		
		private var battlefieldX:Vector.<Vector.<Sprite>> = new Vector.<Vector.<Sprite>>();
		private var battlefieldY:Vector.<Sprite>;
		
		private var tileX:int = 30;
		private var tileY:int = 30;
		private var tileSide:int = 50;
		
		private var numberOfTiles:int = 0;
		
		private var scoreboard:TextField = new TextField();
		private var hits:int = 0;
		private var misses:int = 0;
		
		private var color:ColorTransform = new ColorTransform();
=======
		private var hej:Tile = new Tile();
		
		private var battlefieldX:Vector.<Vector.<Sprite>> = new Vector.<Vector.<Sprite>>(); //tiles horizontal
		private var battlefieldY:Vector.<Sprite>; //Tiles vertical
		
		private var tileX:int = 50; //Placement of the tile on the x coordinate
		private const TILE_SIDE:int = 45;
		private var tileY:int = 50; //Placement of the tile on the y coordinate
		
		private var scoreboard:TextField = new TextField();
		
		private var hits:int = 0;
		private var misses:int = 0;
		private var numberOfTiles:int = 0; //Knows the amount of tiles that is on the screen
>>>>>>> 78fd7ee69507dc9ff82f9f738f4e1ca8ba36c21b
		
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
<<<<<<< HEAD
			addChild(scoreboard);
			
			stage.addEventListener (KeyboardEvent.KEY_DOWN, onSpaceKeyDown);
=======
			scoreboard.selectable = false;
			addChild(scoreboard);
			
			stage.addEventListener(KeyboardEvent.KEY_DOWN, onKeyDown);
			
		}
		
		private function resetBoard():void //A function that reset everything, score, tiles and so on.
		{
			testX = Math.random() * 10;
			testY = Math.random() * 10;
			tileX = 50; 
			hits = 0;
			misses = 0;
			scoreboard.text = "Hits: " + hits.toString();
			
			while (numberOfTiles > 0) //removes the tiles, and the battlefieldY vectors
			{
				numberOfTiles --;
				removeChild(battlefieldX[0].shift());
				
				if (numberOfTiles % 10 == 0)
				{
					battlefieldX.shift();
				}
			}
			
			for (var i:int = 0; i < 10; i++) //make new tiles and vectors
			{	
				battlefieldY = new Vector.<Sprite>();
				
				for (var j:int = 0; j < 10; j++) 
				{	
					tile = new Sprite();
					tile.graphics.beginFill(0x00FFFF);
					tile.graphics.drawRect (tileX, tileY, TILE_SIDE, TILE_SIDE);
					tile.graphics.endFill();
					
					tileY += TILE_SIDE + 5; //So they will have 5 margin between each other
					battlefieldY.push (tile);
					addChild(battlefieldY[j]);
					
					tile.addEventListener (MouseEvent.CLICK, onClick);
					numberOfTiles ++;
				}
				
				battlefieldX.push (battlefieldY);
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
>>>>>>> 78fd7ee69507dc9ff82f9f738f4e1ca8ba36c21b
		}
		
		private function onClick(m:MouseEvent):void 
		{
<<<<<<< HEAD
			color.color = 0x8080FF;
			m.target.transform.colorTransform = color;
			hits ++;
			scoreboard.text = "Hits: " + hits.toString();
		}
		
		private function onSpaceKeyDown(k:KeyboardEvent):void 
		{
			switch (k.keyCode) 
			{
				case Keyboard.SPACE:
					
					while (numberOfTiles > 0) 
					{
						removeChild (battlefieldX[0].shift());
						numberOfTiles --;
						
						if (numberOfTiles == 90 || numberOfTiles == 80 || numberOfTiles == 70 || numberOfTiles == 60 || numberOfTiles == 50 || numberOfTiles == 40 || numberOfTiles == 30 || numberOfTiles == 20 || numberOfTiles == 10 || numberOfTiles == 0)
						{
							battlefieldX.shift();
						}
					}
					
					tileX = 30;
					hits = 0;
					scoreboard.text = "Hits: " + hits.toString();
					
					for (var i:int = 0; i < 10; i++) 
					{	
						battlefieldY = new Vector.<Sprite>();
						
						for (var j:int = 0; j < 10; j++) 
						{	
							tile = new Sprite();
							tile.graphics.beginFill(0x00FFFF);
							tile.graphics.drawRect (tileX, tileY, tileSide, tileSide);
							tile.graphics.endFill();
							
							tileY += tileSide + 5;
							battlefieldY.push (tile);
							addChild(battlefieldY[j]);
							
							tile.addEventListener (MouseEvent.CLICK, onClick);
							numberOfTiles ++;
						}
						
						tileX += tileSide + 5;
						tileY = 30;
						
						battlefieldX.push (battlefieldY);
					}
					
					break;
				default:
			}
=======
			if (m.target == battlefieldX[testX][testY])
			{
				hej.shipTile = true;
			}
			
			else 
			{
				hej.shipTile = false;
			}
			hej.hitAndMiss();
			m.target.transform.colorTransform = hej.color; //So it changes color when you click
			hits ++;
			scoreboard.text = "Hits: " + hits.toString();
>>>>>>> 78fd7ee69507dc9ff82f9f738f4e1ca8ba36c21b
		}
		
	}
	
}