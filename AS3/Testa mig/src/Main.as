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
		private var debugField:TextField = new TextField();
		private var rectangle:Sprite = new Sprite;
		private var spawnX:int = 20;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			debugField.width = stage.stageWidth;
			debugField.height = stage.stageHeight;
			debugField.selectable = false;
			addChild(debugField);
			addEventListener(KeyboardEvent.KEY_DOWN, onKeyDown);
			addEventListener(KeyboardEvent.KEY_UP, onKeyUp);
		}
		
		private function onKeyDown(event:KeyboardEvent):void 
		{
			switch (event.keyCode) 
			{
				case Keyboard.SPACE:
					for (var i:int = 0; i < 10; i++) 
					{
						
						randomHeight = (Math.random() * -100) - 10;
						spawnX += 40;
						
						rectangle.graphics.beginFill (0x00000);
						rectangle.graphics.drawRect (spawnX, stage.stageHeight - 200, 20, randomHeight);
						rectangle.graphics.endFill()
						addChild(rectangle);
					}
					break;
				default:
					break;
			}
		}
		
		private function onKeyUp(event:KeyboardEvent):void 
		{
			switch (event.keyCode) 
			{
				case Keyboard.SPACE:
					
					break;
				default:
					break;
			}
		}
		
	}
	
}