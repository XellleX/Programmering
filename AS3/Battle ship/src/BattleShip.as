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
		
		public function BattleShip() 
		{
			
		}
		
		public function shipPlacement(shipLength:int):void 
		{
			while (shipBody.length > 0) 
			{
				shipBody.shift();
			}
			
			shipStartX = Math.random() * 10;
			shipStartY = Math.random() * 10;
			
			verticalOrHorizontal = Math.random() * 1;
			
			if (verticalOrHorizontal == 0)
			{
				shipBody.push (shipStartX);
				
				if (shipStartY > 5)
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
			}
			
			else if (verticalOrHorizontal == 1)
			{
				shipBody.push (shipStartY);
				
				if (shipStartX > 5)
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
			}
		}
	}

}