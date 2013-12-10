package  
{
	import adobe.utils.CustomActions;
	/**
	 * ...
	 * @author Elias
	 */
	public class BattleShip 
	{
		public var shipPositionX:int;
		public var shipPositionY:int;
		
		public var shipHorizontal:Boolean;
		
		public function BattleShip() 
		{
			
		}
		
		public function shipPlacement(battleShipLength:int):void 
		{	
			shipHorizontal = Math.round(Math.random());
			
			if (shipHorizontal)
			{	
				for (var i:int = 0; i < battleShipLength; i++) 
				{
					if (i == 0)
					{
						shipPositionX = Math.random() * (10 - battleShipLength);
						shipPositionY = Math.random() * 9;
					}
					
					else
					{
						shipPositionX ++;
					}
				}
			}
			
			else if (!shipHorizontal)
			{
				for (var i:int = 0; i < battleShipLength; i++) 
				{
					if (i == 0)
					{
						shipPositionX = Math.random() * 9;
						shipPositionY = Math.random() * (10 - battleShipLength);
					}
					
					else
					{
						shipPositionY ++;
					}
				}
			}
			
		}
		
	}

}