package  
{
	/**
	 * ...
	 * @author Elias
	 */
	public class BattleShip 
	{
		private var shipStartX:int;
		private var shipStartY:int;
		
		public var verticalOrHorizontal:int;
		public var shipBody:Vector.<int>;
		public var ships:Vector.<Vector.<int>> = new Vector.<Vector.<int>>();
		public var clickVerticalOrHorizontal:Vector.<int> = new Vector.<int>();
		
		public function BattleShip() 
		{
			
		}
		
		public function shipPlacement(shipLength:int):void 
		{	
			shipBody = new Vector.<int>();
			shipStartX = Math.random() * 9;
			shipStartY = Math.random() * 9;
			
			verticalOrHorizontal = Math.round(Math.random() * 1);
			clickVerticalOrHorizontal.push (verticalOrHorizontal);
			
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
				
				//shipsVertical.push (shipBody);
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
				
				//shipsHorizontal.push (shipBody);
			}
			ships.push (shipBody);
		}
	}

}