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
		
		private var circle:Sprite;
		private var circles:Vector.<Sprite> = new Vector.<Sprite>();
		private var circleSpawnX:int = 0;
		private var circleSpawnY:int = 50;
		private var reset:int = 0;
		private var score:TextField = new TextField();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			stage.addEventListener (KeyboardEvent.KEY_DOWN, spawnCircle);
		}
		
		private function clickOnCircle(m:MouseEvent):void 
		{
			for (var i:int = 0; i < 20; i++) 
			{
				if (m.target == circles [i])
				{
					removeChild(circles [i]);
				}
			}
		}
		
		private function spawnCircle(e:KeyboardEvent):void 
		{
			switch (e.keyCode) 
			{
				case Keyboard.SPACE:
					while (reset > 0) 
					{
						removeChild (circles [0]);
						circles.shift();
						reset --;
					}
					
					for (var i:int = 0; i < 20; i++) 
					{	
						circle = new Sprite();
						
						circleSpawnX = stage.stageWidth * Math.random();
						circleSpawnY = stage.stageHeight * Math.random();
						
						circle.graphics.beginFill(0xFFFF00);
						circle.graphics.drawCircle (circleSpawnX, circleSpawnY, 20);
						circle.graphics.endFill();
						
						circles.push (circle);
						addChild (circles [i]);
						
						reset ++;
						
						circle.addEventListener (MouseEvent.CLICK, clickOnCircle);
					}
					break;
				default:
					break;
			}
		}
	}
	
}