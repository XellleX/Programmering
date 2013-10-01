package 
{
	import flash.automation.MouseAutomationAction;
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var text:TextField = new TextField();
		
		private var playAgain:TextField = new TextField();
		
		private var purpleCircle:Sprite = new Sprite();
		
		private var playAgainBox:Sprite = new Sprite();
		
		private var circle_radius = 50;
		
		private var circle_Speed = 3;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			addChild(purpleCircle);
			drawPurpleCircle();
			purpleCircle.x = circle_Placement();
			stage.addEventListener (Event.ENTER_FRAME, circle_Falling);
			purpleCircle.addEventListener (MouseEvent.CLICK, change_Speed);
			text.wordWrap = true;
			text.x = 300;
			text.y = 250;
			text.selectable = false;
			playAgain.selectable = false;
			addChild(text);
			addChild(playAgain);
			addChild(playAgainBox);
		}
		
		private function drawPurpleCircle():void 
		{
			purpleCircle.graphics.clear();
			purpleCircle.graphics.beginFill (0x000080);
			purpleCircle.graphics.drawCircle(20, 0, circle_radius);
			purpleCircle.graphics.endFill();
		}
		
		private function circle_Placement():int
		{
			return Math.random() * (stage.stageWidth - circle_radius * 2);
		}
		
		
		private function circle_Falling(h:Event):void 
		{
			purpleCircle.y += circle_Speed;
			if (purpleCircle.y > stage.stageHeight)
			{
				text.text = "GAAAAAAAME OVEEEEEEEER";
				text.border = true;
				text.height = 45;
				playAgainBox.graphics.beginFill(0x808080);
				playAgainBox.graphics.drawRect(0, 0, 50, 30);
				playAgainBox.graphics.endFill();
				playAgain.text = "Play again?";
				playAgain.wordWrap = true;
				//playAgainBox.addEventListener(MouseEvent.CLICK, ); 
			}
		}
		
		private function change_Speed(m:MouseEvent):void
		{
			purpleCircle.y = 0;
			purpleCircle.x = circle_Placement();
			circle_Speed ++;
			circle_radius-=3;
			drawPurpleCircle();
		}
	}
	
}