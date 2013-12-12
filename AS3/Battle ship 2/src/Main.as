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
		private var shipHorizontal:Boolean;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			resetboard();
			
			stage.addEventListener (KeyboardEvent.KEY_DOWN, onKeyDown);
			
			scoreBoard.x = 600;
			scoreBoard.y = 300;
			scoreBoard.selectable = false;
			scoreBoard.background = true;
			scoreBoard.backgroundColor = 0xC0C0C0;
			addChild (scoreBoard);
		}
		
		private function shipPlacement(battleShipLength:int):void 
		{
			shipHorizontal = Math.round(Math.random());
			
			var i:int;
			
			if (shipHorizontal)
			{
				shipPosition = new Point(Math.round(Math.random() * (10 - battleShipLength)), Math.round(Math.random() * 9));
				trace(shipPosition.x, ",", shipPosition.y);
				
				for (i = 0; i < battleShipLength; i++) 
				{
					battlefield[shipPosition.x + i][shipPosition.y].tileType = Tile.SHIP;
				}
			}
			
			else if (!shipHorizontal)
			{
				shipPosition = new Point(Math.round(Math.random() * 9), Math.round(Math.random() * (10 - battleShipLength)));
				trace(shipPosition.x, ",", shipPosition.y);
				
				for (i = 0; i < battleShipLength; i++) 
				{
					battlefield[shipPosition.x][shipPosition.y + i].tileType = Tile.SHIP;
				}
			}
		}
		
		private function resetboard():void 
		{
			Tile.misses = 0;
			Tile.hits = 0;
			scoreBoard.text = "Hits: " + Tile.hits.toString() + "\n \n \n" + "Misses: " + Tile.misses.toString();
			
			while (numberOfTiles > 0) 
			{
				numberOfTiles --;
				removeChild(battlefield[0].shift());
				
				if (numberOfTiles % 10 == 0)
				{
					battlefield.shift();
				}
			}
			
			for (var i:int = 0; i < 10 ; i++) 
			{
				battlefieldLines = new Vector.<Tile>();
				
				for (var j:int = 0; j < 10; j++) 
				{	
					tile = new Tile();
					
					tile.y += 50 + (j * (Tile.TILE_SIDE + 5));
					tile.x += 50 + (i * (Tile.TILE_SIDE + 5));
					
					battlefieldLines.push (tile);
					addChild (battlefieldLines[j]);
					
					tile.addEventListener (MouseEvent.CLICK, onClick);
					
					numberOfTiles ++;
				}
				
				battlefield.push (battlefieldLines);
			}
			
			shipPlacement(4);
			shipPlacement(2);
			shipPlacement(2);
			shipPlacement(10);
		}
		
		private function onKeyDown(k:KeyboardEvent):void 
		{
			switch (k.keyCode) 
			{
				case Keyboard.SPACE:
					
					resetboard();
					break;
				default:
			}
		}
		
		private function onClick(m:MouseEvent):void 
		{
			Tile(m.target).clicked();
			scoreBoard.text = "Hits: " + Tile.hits.toString() + "\n \n \n" + "Misses: " + Tile.misses.toString();
		}
		
	}
	
}