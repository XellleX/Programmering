package  
{
	/**
	 * ...
	 * @author Elias
	 */
	public class BattleShip 
	{
		public var shipStartX:int;
		public var shipStartY:int;
		
		public var verticalOrHorizontal:int;
		public var shipBody:Vector.<int> = new Vector.<int>();
		public var ships:Vector.<Vector.<int>> = new Vector.<Vector.<int>>();
		
		public function BattleShip() 
		{
			
		}
		
		public function shipPlacement(shipLength:int):void 
		{	
			shipStartX = Math.random() * 9;
			shipStartY = Math.random() * 9;
			
			verticalOrHorizontal = Math.round(Math.random() * 1);
			
			if (verticalOrHorizontal == 0)
			{
				shipBody.push (shipStartX);
				
				if (shipStartY <= 5)
				{
					for (var i:int = 0; i < shipLength; i++) 
					{
						shipBody.push (shipStartY);
						shipStartY ++;
					}
				}
				
				else
				{
					for (var j:int = 0; j < shipLength; j++) 
					{
						shipBody.push (shipStartY);
						shipStartY --;
					}
				}
				
				ships.push (shipBody);
			}
			
			else if (verticalOrHorizontal == 1)
			{
				shipBody.push (shipStartY);
				
				if (shipStartX <= 5)
				{
					for (var i:int = 0; i < shipLength; i++) 
					{
						shipBody.push (shipStartX);
						shipStartX ++;
					}
				}
				
				else
				{
					for (var j:int = 0; j < shipLength; j++) 
					{
						shipBody.push (shipStartX);
						shipStartX --;
					}
				}
				
				ships.push (shipBody);
			}
		}
	}

}