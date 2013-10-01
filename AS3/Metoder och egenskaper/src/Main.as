package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.text.TextField;
	import flash.text.TextFieldType;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var text:TextField = new TextField();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			text.type = TextFieldType.INPUT;
			text.text = "Hej skriv vad du vill här."; 
			text.x = 189;
			text.y = 200;
			text.border = true;
			text.wordWrap = true;
			text.height = 300;
			text.width = 300;
			text.multiline = true;
			addChild(text);
		}
		
		
	}
	
}