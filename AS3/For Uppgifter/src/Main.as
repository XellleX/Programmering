package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.TextEvent;
	import flash.text.TextField;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var test:TextField = new TextField();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			addChild(test);
			test.width = 300;
			test.height = stage.stageHeight;
			
			
			for (var i:int = 1; i <= 19; i++) 
			{
				if (i < 18)
				{
					test.appendText ("Du är bara " + i + " år och för liten \n");
				}
				else 
				{
					test.appendText ("Du är " + i + " år: Välkommen \n");
				}
			}
		}
		
	}
	
}