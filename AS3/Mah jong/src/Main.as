package 
{
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.events.*;
	import flash.text.*;
	import flash.ui.Keyboard;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var inputField:TextField = new TextField();
		private var test:TextField = new TextField();
		
		private var player:int = 0;
		private var names:Array = new Array();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			inputField.type = TextFieldType.INPUT;
			inputField.border = true;
			addChild (inputField);
			
			stage.addEventListener (KeyboardEvent.KEY_DOWN, onKeyDown);
			
			test.x = 250;
			
		}
		
		private function onKeyDown(k:KeyboardEvent):void 
		{
			switch (k.keyCode) 
			{
				case Keyboard.ENTER:
					
					player ++;
					
					if (player >= 4)
					{
						
					}
					names.push (inputField.text);
					
					inputField.text = "";
					
					break;
				default:
			}
		}
		
	}
	
}