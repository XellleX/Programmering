package 
{
	import flash.display.SpreadMethod;
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.text.TextField;
	import flash.ui.Keyboard;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{	
		private var box:BouncyBox;
		
		private var debugField:TextField = new TextField();
		private var boxes:Array = new Array();
		
		private var randomBoxSpeed:Number = (Math.random() * 13);
		private var spaceKeyDown:Boolean = false;
		private var numberOfBoxes:int = 0;
		
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
			debugField.wordWrap = true;
			debugField.selectable = false;
			addChild(debugField);
			
			this.addEventListener (Event.ENTER_FRAME, onEnterFrame);
			addEventListener (KeyboardEvent.KEY_DOWN, onKeyDown);
			addEventListener (KeyboardEvent.KEY_UP, onKeyUp);
			
			for (var i:int = 0; i < numberOfBoxes;) 
			{
				box = new BouncyBox(stage.stageWidth, stage.stageHeight);
				boxes.push (box);
				addChild(box);
				i++;
			}
		}
		
		private function onEnterFrame(event:Event):void 
		{
			//box.boxSpeed(randomBoxSpeed, randomBoxSpeed);
			
			if (spaceKeyDown)
			{
				numberOfBoxes++;
			}
		}
		
		private function onKeyDown(key:KeyboardEvent):void 
		{
			switch (key.keyCode) 
			{
				case Keyboard.SPACE:
					spaceKeyDown = true;
					break;
					
				default:
					break;
			}
		}
		
		private function onKeyUp(key:KeyboardEvent):void 
		{
			switch (key.keyCode) 
			{
				case Keyboard.SPACE:
					spaceKeyDown = false;
					break;
					
				default:
					break;
			}
		}
	}
	
}