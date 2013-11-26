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
		private var pojkeHp:int = 80;
		private const POJKE_ATK:int = 17;
		private const POJKE_DEF:int = 7;
		private var pojkeDmg:int;
		private var pojkeCurrentDef:int;
		
		private const FLICKA_NAME:String = "Bella";
		private var flickaHp:int = 80;
		private const FLICKA_ATK:int = 20;
		private const FLICKA_DEF:int = 6;
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
			narrator.height = stage.stageHeight;
			narrator.width = stage.stageWidth;
			addChild(narrator);
			
			while (pojkeHp > 0 && flickaHp > 0) 
			{
				round++;
				
				pojkeDmg = POJKE_ATK * Math.random() - flickaCurrentDef;
				pojkeCurrentDef = POJKE_DEF * Math.random();
				pojkeHp -= flickaDmg;
				
				flickaDmg = FLICKA_ATK * Math.random() - pojkeCurrentDef;
				flickaCurrentDef = FLICKA_DEF * Math.random();
				flickaHp -= pojkeDmg;
				
				if (pojkeDmg < 0)
				{
					pojkeDmg = 0;
					flickaHp += pojkeDmg;
				}
				
				if (flickaDmg < 0)
				{
					flickaDmg = 0;
					pojkeHp += flickaDmg;
				}
				
				narrator.appendText ("Round " + round.toString() + "\n");
				narrator.appendText (FLICKA_NAME + " damaged " + POJKE_NAME + " " + flickaDmg + ", " + POJKE_NAME + " got " + pojkeHp + " Hp left \n");
				narrator.appendText (POJKE_NAME + " damaged " + FLICKA_NAME + " " + pojkeDmg + ", " + FLICKA_NAME + " got " + flickaHp + " Hp left \n\n");
			}
			/*
			for (pojkeHp && flickaHp; pojkeHp && flickaHp > 0;) 
			{
				round++;
				
				pojkeDmg = POJKE_ATK * Math.random() - flickaCurrentDef;
				pojkeCurrentDef = POJKE_DEF * Math.random();
				pojkeHp -= flickaDmg;
				
				flickaDmg = FLICKA_ATK * Math.random() - pojkeCurrentDef;
				flickaCurrentDef = FLICKA_DEF * Math.random();
				flickaHp -= pojkeDmg;
				
				if (pojkeDmg < 0)
				{
					pojkeDmg = 0;
					flickaHp += pojkeDmg;
				}
				
				if (flickaDmg < 0)
				{
					flickaDmg = 0;
					pojkeHp += flickaDmg;
				}
				
				narrator.appendText ("Round " + round.toString() + "\n");
				narrator.appendText (FLICKA_NAME + " damaged " + POJKE_NAME + " " + flickaDmg + ", " + POJKE_NAME + " got " + pojkeHp + " Hp left \n");
				narrator.appendText (POJKE_NAME + " damaged " + FLICKA_NAME + " " + pojkeDmg + ", " + FLICKA_NAME + " got " + flickaHp + " Hp left \n\n");
				/*
				if (round == 5)
				{
					break;
				}
				Om det bara ska vara 5 rundor.
				*
			}
			*/
			if (flickaHp <= 0)
			{
				narrator.appendText (POJKE_NAME + " WON");
			}
			
			if (pojkeHp <= 0)
			{
				narrator.appendText (FLICKA_NAME + " WON");
			}
		} 
		
	}
	
}