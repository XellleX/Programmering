package  
{
	import flash.geom.ColorTransform;
	/**
	 * ...
	 * @author Elias
	 */
	public class Tile 
	{
		public var color:ColorTransform = new ColorTransform();
		public var shipTile:Boolean;
		
		public function Tile() 
		{
			
		}
		
		public function hitAndMiss():void 
		{
			if (shipTile)
			{
				color.color = 0xC0C0C0;
			}
			
			else 
			{
				color.color = 0x00FF00;
			}
		}
		
	}

}