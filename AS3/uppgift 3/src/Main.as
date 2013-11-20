package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var box:Sprite = new Sprite();
		private var box2:Sprite = new Sprite();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			box.graphics.beginFill (0x00000);
			box.graphics.drawRect (0, 0, 30, 30);
			box.graphics.endFill();
			box2.graphics.beginFill (0x00000);
			box2.graphics.drawRect (0, 0, 30, 30);
			box2.graphics.endFill();
			box2.x = 50;
			
			addChild(box);
			addChild(box2);
		}
		
	}
	
}