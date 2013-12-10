package  
{
	import flash.display.Sprite;
	import flash.events.WeakFunctionClosure;
	import flash.geom.ColorTransform;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Tile extends Sprite
	{
		public static const TILE_SIDE:int = 45;
		
		public var isClicked:Boolean = false;
		
		public var tileType:int;
		public const SHIP:int = 1;
		public const MISS:int = 2;
		
		public static var hits:int = 0;
		
		public var colors:ColorTransform = new ColorTransform();
		
		public function Tile() 
		{
			this.graphics.beginFill(0x00FFFF);
			this.graphics.drawRect(0, 0, TILE_SIDE, TILE_SIDE);
			this.graphics.endFill();
		}
		
		public function clicked():void 
		{	
			colors.color = 0x008000;
			this.tileType = SHIP;
			
			if (!this.isClicked)
			{
				if (tileType == SHIP)
				{
					this.transform.colorTransform = colors;
					hits ++;
				}
				
				else if (tileType == MISS)
				{
					
				}
			}
			
			this.isClicked = true;
		}
		
	}

}