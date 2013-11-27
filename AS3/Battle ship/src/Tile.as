package  
{
<<<<<<< HEAD
	import flash.display.Sprite;
=======
	import flash.geom.ColorTransform;
>>>>>>> 78fd7ee69507dc9ff82f9f738f4e1ca8ba36c21b
	/**
	 * ...
	 * @author Elias
	 */
<<<<<<< HEAD
	public class Tile
	{
=======
	public class Tile 
	{
		public var color:ColorTransform = new ColorTransform();
		public var shipTile:Boolean;
>>>>>>> 78fd7ee69507dc9ff82f9f738f4e1ca8ba36c21b
		
		public function Tile() 
		{
			
		}
		
<<<<<<< HEAD
		public function tileColor():void 
		{
			
=======
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
>>>>>>> 78fd7ee69507dc9ff82f9f738f4e1ca8ba36c21b
		}
		
	}

}