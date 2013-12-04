package  
{
	import flash.display.Sprite;
	import flash.events.MouseEvent;
	import flash.geom.ColorTransform;
	
	/**
	 * ...
	 * @author Elias
	 */
	
	public class Tile extends Sprite
	{
		public const TILE_SIDE:int = 45;
		
		public var tileColor:ColorTransform = new ColorTransform();
		
		public var shipTile:Boolean;
		
		public var hits:int = 0;
		public var misses:int = 0;
		
		public function Tile() 
		{
			this.graphics.beginFill(0x00FFFF);
			this.graphics.drawRect(0, 0, TILE_SIDE, TILE_SIDE);
			this.graphics.endFill();
		}
		
		public function hitAndMiss():void 
		{
			if (shipTile)
			{
				tileColor.color = 0xC0C0C0;
			}
			
			else 
			{
				tileColor.color = 0xFF0000;
			}
		}
		
	}

}