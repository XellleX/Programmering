package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.text.*;
	
	public class Main extends Sprite 
	{
		private const MAX_WIDTH:int = 100;
		private const MAX_HEIGHT:int = 50;
		private const DISTANCE:int = 10;
		private const TEXTBOX_BACKGROUND_COLOR:uint = 0xC0C0C0;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			var hej:TextField = new TextField();
			hej = makeTextBox("hej");
			addChild(hej);
			
			var glada:TextField = new TextField();
			glada = makeTextBox("glada" + MAX_HEIGHT + DISTANCE);
			addChild(glada);
			
			// gör två till bredvid de första två så det står 
			// 
			// hej    alla
			// glada  barn
			
		}
		
		// private function vad ska det stå?
		private function makeTextBox():TextField
		{
			var t:TextField = new TextField();
			t.width = MAX_WIDTH;
			t.height = MAX_HEIGHT;
			
			t.x = 50;
			t.y = 50;
			
			t.border = true;
			t.background = true;
			t.backgroundColor = TEXTBOX_BACKGROUND_COLOR;
			t.text = "s";
			
			var tf:TextFormat = new TextFormat();
			tf.size = 20;
			tf.align = TextFormatAlign.CENTER;
			t.setTextFormat(tf);
			
			return t;
		}
	}
}