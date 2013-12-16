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
		public static const TILE_SIDE:int = 45; //The side length of the tile
		
		public var isClicked:Boolean = false; //So the tile knows if its clicked or not
		
		public var tileType:int; //So the tile knows if it is supposed to be a ship or miss when you click it
		public static const SHIP:int = 1; //So tileType has a number for being a ship
		public static const WATER:int = 2; //So tileType has a number for being water
		
		public static var hits:int = 0; //This variable is to tell the player how many hits she/he have gotten
		public static var misses:int = 0; //This variable is to tell the player how many misses she/he have gotten
		public static var shotsFired:int = 0; //This variable is to tell the player how many shots she/he have fired
		
		public var tileColor:ColorTransform = new ColorTransform(); //So the tile can change color when it gets clicked.
		
		public function Tile() //Draws a tile
		{
			this.graphics.beginFill(0x00FFFF);
			this.graphics.drawRect(0, 0, TILE_SIDE, TILE_SIDE);
			this.graphics.endFill();
			
			this.tileType = WATER; //Tells the tile that it is going to be miss if i click it until i say something else (The shipPlacement funtion tells som tiles to be ships instead).
		}
		
		public function clicked():void //I have this function so the tiles knows what to do when they are clicked
		{	
			if (!this.isClicked)
			{				
				if (this.tileType == SHIP) //To make the tile "shipcolor" and tell that you got a hit.
				{
					tileColor.color = 0x808080;
					this.transform.colorTransform = tileColor;
					hits ++;
				}
				
				else if (this.tileType == WATER) //To make the tile "misscolor" and tell that you got a miss.
				{
					tileColor.color = 0x0000A0;
					this.transform.colorTransform = tileColor;
					misses ++;
				}
				
				shotsFired ++; 
			}
			
			this.isClicked = true; //tells the tile that it have been clicked so it doesnt do anything the next time you click it.
		}
		
		public function reset():void 
		{
			this.graphics.clear();
			tileColor.color = 0x00FFFF;
			this.transform.colorTransform = tileColor;
			this.isClicked = false;
		}
		
	}

}