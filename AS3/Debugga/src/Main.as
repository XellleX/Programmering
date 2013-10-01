package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.text.TextField;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		var t:TextField = new TextField;
		var antal:int = 12;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			var tmp:int = summa(3,8);
			t.wordWrap = true;
			hejsan();
			t.text = tmp.toString();
			t.x = getRandomXPos();
			t.y = getRandomYPos();
			const MAX_WIDTH:int = 200;
			const MAX_HEIGHT:int = 100;
			changeWidthAndHeight();
			t.border = true;
			var msg:TextField = new TextField;
			msg = makeMsgBox("Test");
			addChild(msg);
			addChild(t);
		}
		private function hejsan():void 
		{
			t.text = "Hejsan";
		}
		
		private function summa(x:int, y:int):int
		{
			return x + y;
		}
		
		private function text():void
		{
			t.text = "du har " + antal.toString() + " stycken";
		}
		
		private function getRandomXPos():int 
		{
			return Math.random() * stage.stageWidth;
		}
		
		private function getRandomYPos():int
		{
			return Math.random() * stage.stageHeight;
		}
		
		private function changeWidthAndHeight():void
		{
			t.width = 200, t.height = 100;
		}
		
		private function makeMsgBox(hej:String):TextField
		{
			var my:TextField = new TextField;
			my.border = true;
			my.width = 200;
			my.height = 100;
			my.borderColor = 0x000000;
			my.backgroundColor = 0xC0C0C0;
			return my;
		}
		
	}
	
}