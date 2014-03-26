package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.text.TextField;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var narrator:TextField = new TextField();
		
		private const POJKE_NAME:String = "Swagster Man";
		private var pojkeHp:int = 100;
		private const POJKE_ATK:int = 13;
		private const POJKE_DEF:int = 7;
		private var pojkeDmg:int;
		private var pojkeCurrentDef:int;
		
		private const FLICKA_NAME:String = "Bella";
		private var flickaHp:int = 100;
		private const FLICKA_ATK:int = 15;
		private const FLICKA_DEF:int = 4;
		private var flickaDmg:int;
		private var flickaCurrentDef:int;
		
		private var round:int = 0;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			narrator.width = stage.stageWidth;
			narrator.height = stage.stageHeight;
			addChild(narrator);
			
			while(flickaHp > 0 && pojkeHp > 0) 
			{
				round++;
				flickaCurrentDef = FLICKA_DEF * Math.random();
				pojkeCurrentDef = POJKE_DEF * Math.random();
				
				pojkeDmg = (POJKE_ATK * Math.random()) + (POJKE_ATK / 2) - flickaCurrentDef;
				flickaDmg = (FLICKA_ATK * Math.random()) + (FLICKA_ATK / 2) - pojkeCurrentDef;
				
				if (pojkeDmg < 0)
				{
					pojkeDmg = 0;
				}
				
				if (flickaDmg < 0)
				{
					flickaDmg = 0;
				}
				
				pojkeHp -= flickaDmg;
				flickaHp -= pojkeDmg;
				
				narrator.appendText ("Round " + round.toString() + "\n");
				narrator.appendText (FLICKA_NAME + " damaged " + POJKE_NAME + " " + flickaDmg + ", " + POJKE_NAME + " got " + pojkeHp + " Hp left \n");
				narrator.appendText (POJKE_NAME + " damaged " + FLICKA_NAME + " " + pojkeDmg + ", " + FLICKA_NAME + " got " + flickaHp + " Hp left \n\n");
				
				/*
				if (round == 5)
				{
					break;
				}
				Om det bara ska vara 5 rundor. 
				*/
			}
			
			if (flickaHp <= 0)
			{
				narrator.appendText (POJKE_NAME + " WON");
			}
			
			else if (pojkeHp <= 0)
			{
				narrator.appendText (FLICKA_NAME + " WON");
			}
		}
		
	}
	
}