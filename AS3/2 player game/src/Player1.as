package  
{
	import flash.display.Sprite;
	import flash.events.KeyboardEvent;
	import flash.events.Event;
	import flash.ui.Keyboard;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Player1 extends Sprite 
	{
		
		public const PLAYER_SIDELENGTH:int = 50;
		
		public function Player1(color:uint) 
		{
			this.graphics.beginFill(color);
			this.graphics.drawRect(0, 0, PLAYER_SIDELENGTH, PLAYER_SIDELENGTH)
			this.graphics.endFill();
			
		}
		
		
		public function moveSpeed(x:int, y:int):void 
		{
			this.x += x;
			this.y += y;
		}
		
	}

}