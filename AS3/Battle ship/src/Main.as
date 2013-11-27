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
		private var tile:Sprite;
		
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
			addChild(scoreboard);
			
			stage.addEventListener (KeyboardEvent.KEY_DOWN, onSpaceKeyDown);
		}
		
		private function onClick(m:MouseEvent):void 
		{
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
		}
		
	}
	
}