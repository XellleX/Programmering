package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	import flash.text.TextFormat;
	import flash.text.TextFormatAlign;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var playButton:TextField = new TextField();
		private var textStyling:TextFormat = new TextFormat();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			
			playButton.border = true;
			playButton.height = 50;
			playButton.width = 150;
			playButton.text = "Play";
			playButton.selectable = false;
			addChild(playButton);
			
			textStyling.color = 0x80FF00;
			textStyling.align = TextFormatAlign.CENTER;
			textStyling.size = 35;
			playButton.setTextFormat(textStyling);
			
			playButton.addEventListener (MouseEvent.CLICK, startGame);
		}
		
		private function startGame(m:MouseEvent):void 
		{
			
		}
		
	}
	
}