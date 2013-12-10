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
		public static var misses:int = 0;
		
		public var tileColor:ColorTransform = new ColorTransform();
		
		public function Tile() 
		{
			this.graphics.beginFill(0x00FFFF);
			this.graphics.drawRect(0, 0, TILE_SIDE, TILE_SIDE);
			this.graphics.endFill();
		}
		
		public function clicked():void 
		{
			if (!this.isClicked)
			{
				if (this.tileType == SHIP)
				{
					tileColor.color = 0x008000;
					this.transform.colorTransform = tileColor;
					hits ++;
				}
				
				else if (this.tileType == MISS)
				{
					tileColor.color = 0x000000;
					this.transform.colorTransform = tileColor;
					misses ++;
				}
			}
			
			this.isClicked = true;
		}
		
	}

}