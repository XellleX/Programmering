package  
{
	import flash.display.Sprite;
	import flash.geom.ColorTransform;
	
	/**
	 * ...
	 * @author Elias
	 */
	
	public class Tile 
	{
		public var tileColor:ColorTransform = new ColorTransform();
		public var shipTile:Boolean;
		public var hits:int = 0;
		public var misses:int = 0;
		private var hit:Boolean = false;
		
		public function Tile() 
		{
			
		}
		
		public function hitAndMiss():void 
		{
			if (shipTile)
			{
				tileColor.color = 0xC0C0C0;
				hits ++;
			}
			
			else 
			{
				tileColor.color = 0xFF0000;
				misses ++;
			}
		}
		
	}

}