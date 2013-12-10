package  
{
	import adobe.utils.CustomActions;
	/**
	 * ...
	 * @author Elias
	 */
	public class BattleShip 
	{
		public var shipStartX:int;
		public var shipStartY:int;
		
		public var shipHorizontal:Boolean;
		
		public function BattleShip() 
		{
			
		}
		
		public function shipPlacement(battleShipLength:int):void 
		{	
			shipHorizontal = Math.round(Math.random());
			
			if (shipHorizontal)
			{
				shipStartX = Math.random() * (10 - battleShipLength);
				shipStartY = Math.random() * 9;
			}
			
			else if (!shipHorizontal)
			{
				shipStartX = Math.random() * 9;
				shipStartY = Math.random() * (10 - battleShipLength);
			}
			
		}
		
	}

}