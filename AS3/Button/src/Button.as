package  
{
	import flash.display.Sprite;
	import flash.text.TextField;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Button extends Sprite 
	{
		/*
		this.graphics.beginFill (0xC0C0C0);
		this.graphics.drawCircle (100, 100, 20);
		this.x = 200;
		this.y = 250;
		this.graphics.endFill();
		*/
		private var text:TextField = new TextField();
		
		public function Button() 
		{
			text.text = "MY BUTTON";
			text.selectable = false;
			text.wordWrap = true;
			text.x = 100;
			text.y = 100;
			addChild(text);
			this.graphics.beginFill (0x808080);
			this.graphics.drawRect (100, 100, 70, 70);
			this.x = 200;
			this.y = 250;
			this.graphics.endFill();
		}
		
	}

}