package  
{
	import flash.display.Sprite;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class BouncyBox extends Sprite 
	{
		public const BOX_SIDELENGTH:int = 40;
		
		public var stageWidth:int;
		public var stageHeight:int;
		
		public function BouncyBox(w:int, h:int) 
		{
			stageWidth = w;
			stageHeight = h;
			this.graphics.beginFill(0x00FF40);
			this.graphics.drawRect (0, 0, BOX_SIDELENGTH, BOX_SIDELENGTH);
			this.graphics.endFill();
		}
		
		public function spawnBox():void 
		{
			this.x = (Math.random() * stageWidth) - BOX_SIDELENGTH;
			this.y = (Math.random() * stageHeight) - BOX_SIDELENGTH;
		}
		
		public function boxSpeed(x:Number, y:Number):void 
		{
			this.x += x;
			this.y += y;
		}
		
	}

}