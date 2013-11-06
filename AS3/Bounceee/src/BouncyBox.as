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
		
		private var randomBoxColor:uint = 0xFFFFFF * (Math.random() * 200);
		private var stageWidth:int;
		private var stageHeight:int;
		private var boxSpeedX:Number;
		private var boxSpeedY:Number;
		
		public function BouncyBox(w:int, h:int) 
		{
			stageWidth = w;
			stageHeight = h;
			this.graphics.beginFill(randomBoxColor);
			this.graphics.drawRect (0, 0, BOX_SIDELENGTH, BOX_SIDELENGTH);
			this.graphics.endFill();
		}
		
		private function handleCollision():void 
		{
			if (this.x + BOX_SIDELENGTH  >= stage.stageWidth)
			{
				boxSpeedX = Math.random() * -10;
				boxSpeedY = (Math.random() * 10) + (Math.random() * 10);
			}
			else if (this.x <= 0)
			{
				boxSpeedX = Math.random() * 10;
				boxSpeedY = (Math.random() * 10) + (Math.random() * -10);
			}
			else if (this.y + BOX_SIDELENGTH >= stage.stageHeight)
			{
				boxSpeedY = Math.random() * -10;
				boxSpeedX = (Math.random() * -10) + (Math.random() * 10);
			}
			else if (this.y <= 0)
			{
				boxSpeedY = Math.random() * 10;
				boxSpeedX = (Math.random() * -10) + (Math.random() * 10);
			}
			
		}
		
		public function update():void
		{
			handleCollision();
			this.x += boxSpeedX;
			this.y += boxSpeedY;
		}
		
		public function spawnBox():void 
		{
			this.x = (Math.random() * (stageWidth - BOX_SIDELENGTH - 5)) + 5;
			this.y = (Math.random() * (stageHeight - BOX_SIDELENGTH - 5)) + 5;
			setBoxSpeed ((Math.random() * 10) + (Math.random() * -10), (Math.random() * 10) + (Math.random() * -10));
		}
		
		public function setBoxSpeed(x:Number, y:Number):void 
		{
			boxSpeedX = x;
			boxSpeedY = y;
		}
		
	}

}