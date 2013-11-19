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
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			this.graphics.beginFill (0x00000);
			this.graphics.drawRect (0, 0, 30, 30);
			this.graphics.endFill();
			this.x = 50; 
			this.y = 50; 
			stage.addEventListener(Event.ENTER_FRAME, boxMove);
		}
		
		private function boxMove(e:Event):void 
		{
			
			if ((this.x >= 50 && this.x <= stage.stageWidth - 80) && (this.y == 50))
			{
				this.x += 10;
			}
			
			if ((this.x == stage.stageWidth - 80) && (this.y >= 50 && this.y <= stage.stageHeight - 80))
			{
				this.y += 10;
			}
			
			if ((this.x >= 50 && this.x <= stage.stageWidth - 80) && (this.y == stage.stageHeight - 80))
			{
				this.x -= 10;
			}
			
			if ((this.x == 50) && (this.y >= 50 && this.y <= stage.stageHeight - 80))
			{
				this.y -= 10;
			}
			
		}
		
	}
	
}