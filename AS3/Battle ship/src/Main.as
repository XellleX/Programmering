package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.geom.ColorTransform;
	import flash.text.TextField;
	import mx.core.FlexApplicationBootstrap;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{
		private var tile:Sprite;
		private var battlefieldX:Vector.<Vector.<Sprite>> = new Vector.<Vector.<Sprite>>();
		private var battlefieldY:Vector.<Sprite>;
		private var tileX:int = 30;
		private var tileSide:int = 50;
		private var tileY:int = 30;
		private var text:TextField = new TextField();
		private var color:ColorTransform = new ColorTransform();
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			// entry point
			
			for (var i:int = 0; i < 10; i++) 
			{	
				battlefieldY = new Vector.<Sprite>();
				
				for (var j:int = 0; j < 10; j++) 
				{	
					tile = new Sprite();
					tile.graphics.beginFill(0x00FFFF);
					tile.graphics.drawRect (tileX, tileY, tileSide, tileSide);
					tile.graphics.endFill();
					
					tileY += tileSide + 5;
					battlefieldY.push (tile);
					addChild(battlefieldY[j]);
					
					tile.addEventListener (MouseEvent.CLICK, onClick);
				}
				
				battlefieldX.push (battlefieldY);
				tileX += tileSide + 5;
				tileY = 30;
			}
		}
		
		private function onClick(m:MouseEvent):void 
		{
			color.color = 0x008000;
			m.target.transform.colorTransform = color;
		}
		
	}
	
}