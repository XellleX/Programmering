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
		private var randomHeight:Number;
		private var rectangle:Sprite = new Sprite;
		private var spawnX:int = 0;
		private var reset:int = 0;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			stage.addEventListener(KeyboardEvent.KEY_DOWN, onKeyDown);
		}
		
		
		
		private function onKeyDown(event:KeyboardEvent):void 
		{
			switch (event.keyCode) 
			{
				case Keyboard.SPACE:
					for (var i:int = 0; i < 10; i++) 
					{
						if (reset == 10)
						{
							rectangle.graphics.clear();
							spawnX = 0;
							reset = 0;
						}
						
						if (i > 0)
						{
							spawnX += 87;
							
							if (spawnX > stage.stageWidth - 20)
							{
								spawnX = stage.stageWidth - 20;
							}
							
						}
						
						randomHeight = (Math.random() * -100) - 10;
						
						reset ++;
						
						rectangle.graphics.beginFill (0x00000);
						rectangle.graphics.drawRect (spawnX, stage.stageHeight, 20, randomHeight);
						rectangle.graphics.endFill();
						addChild(rectangle);
					}
					break;
				default:
					break;
			}
		}
		
	}
	
}