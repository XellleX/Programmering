package 
{
	import flash.automation.Configuration;
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.TextEvent;
	import flash.text.TextField;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		var t:TextField = new TextField();
		Math.random();
		var viking:String = "Viking";
		var king:String = "King";
		var vikHealthPoints:int = 60;
		var kinghealthPoints:int = 60;
		var kingATK:Number = 4;
		var kingDEF:Number = 2;
		var vikingATK:Number = 3;
		var vikingDEF:Number = 4;
		var kingdmg:int;
		var vikingdmg:int;
		var dmg:int = 10 * Math.random() + 3;
		var def:int = 3 * Math.random();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			
			var log:String = "";
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			
			kingATK = kingATK + Math.random();
			
			vikingATK = vikingATK + Math.random();
			
			kingDEF = kingDEF + Math.random();
			
			vikingDEF = vikingDEF + Math.random();
			
			kingdmg = kingATK * dmg - vikingDEF * def;
			
			vikingdmg = vikingATK * dmg - kingDEF * def;
			
			
			
			t.width = 256;
			t.height = 256;
			t.text = log;
			//fight();
			t.x = 250
			t.y = 250
			t.wordWrap = true;
			t.background = true
			t.backgroundColor = uint(0x000000);
			t.textColor = 0xFF80FF;
			addChild(t);
			
		}
		
		private function kingsTurn():String
		{
			vikHealthPoints = vikHealthPoints - kingdmg;
			return t.text = "King damaged " + kingdmg + " to Viking. Viking has " + vikHealthPoints + " health left\n\n";
		}
		
		private function vikingsTurn():String
		{
			kinghealthPoints = kinghealthPoints - vikingdmg;
			return t.text = "Viking damaged " + vikingdmg + " to King. King has " + kinghealthPoints + " health left\n\n";
		}
		/*
		private function fight():Boolean
		{
			while (vikHealthPoints > 0 || kinghealthPoints > 0) 
			{
				kingsTurn();
				vikingsTurn();
			}
			
		}*/
	}
	
}