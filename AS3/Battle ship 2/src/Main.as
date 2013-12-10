package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.MouseEvent;
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
			addChild (scoreBoard);
		}
		
		private function resetboard():void 
		{
			scoreBoard.text = Tile.hits.toString();
			
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
					
					tile.y += 50 + (i * (Tile.TILE_SIDE + 5));
					tile.x += 50 + (j * (Tile.TILE_SIDE + 5));
					battlefieldLines.push (tile);
					addChild (battlefieldLines[j]);
					tile.addEventListener (MouseEvent.CLICK, onClick);
					
					numberOfTiles ++;
				}
				
				battlefield.push (battlefieldLines);
			}
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
			scoreBoard.text = Tile.hits.toString();
		}
		
	}
	
}