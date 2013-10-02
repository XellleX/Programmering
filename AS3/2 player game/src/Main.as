package 
{
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.TextEvent;
	import flash.text.TextField;
	import flash.ui.Keyboard;
	
	/**
	 * ...
	 * @author Elias
	 */
	public class Main extends Sprite 
	{	
		private var player1:Player1 = new Player1(0x00FF00);
		private var player2:Player1 = new Player1(0xFF0000);
		
		private const GRAVITATION:Number = 1.3;
		
		private var player1JumpSpeed:Number = 0;
		private var player2JumpSpeed:Number = 0;
		
		private var player1OnGround:Boolean = true;
		private var player2OnGround:Boolean = true;
		
		private var leftKeyDown:Boolean = false;
		private var rightKeyDown:Boolean = false;
		private var upKeyDown:Boolean = false;
		private var wKeyDown:Boolean = false;
		private var aKeyDown:Boolean = false;
		private var dKeyDown:Boolean = false;
		
		private var collision:Boolean = false;
		private var collision2:Boolean = false; //Collision from the other way
		private var collision3:Boolean = false; //So they can stand on top of each other
		
		private var debugField:TextField = new TextField;
		
		public function Main():void 
		{
			if (stage) init();
			else addEventListener(Event.ADDED_TO_STAGE, init);
		}
		
		private function init(e:Event = null):void 
		{
			removeEventListener(Event.ADDED_TO_STAGE, init);
			addEventListener(KeyboardEvent.KEY_DOWN, onKeyDown);
			addEventListener(KeyboardEvent.KEY_UP, onKeyUp);
			this.addEventListener(Event.ENTER_FRAME, onEnterFrame);
			// entry point
			
			player1.x = stage.stageWidth - player2.PLAYER_SIDELENGTH;
			player1.y = stage.stageHeight - player1.PLAYER_SIDELENGTH;
			player2.x = 0;
			player2.y = stage.stageHeight - player2.PLAYER_SIDELENGTH;
			debugField.width = stage.stageWidth;
			debugField.height = stage.stageHeight;
			debugField.selectable = false;
			debugField.background = true;
			debugField.backgroundColor = 0xFFFF00;
			addChild(debugField);
			addChild(player1);
			addChild(player2);
		}
		
		private function onEnterFrame(event:Event):void 
		{
			move();
			/*
			if ((player1.y + player1.PLAYER_SIDELENGTH >= player2.y || player2.y + player2.PLAYER_SIDELENGTH >= player1.y) && (player1.x >= player2.x + player2.PLAYER_SIDELENGTH && player1.x <= player2.x + player2.PLAYER_SIDELENGTH))
			{
				player1JumpSpeed = 0;
				player2JumpSpeed = 0;
			}
			*/
			
			if (collision3)
			{
				
			}
			
			if (!player1OnGround)
			{
				player1JumpSpeed += GRAVITATION;
			}
			
			if (!player2OnGround)
			{
				player2JumpSpeed += GRAVITATION;
			}
			
			if (player1.y >= stage.stageHeight - player1.PLAYER_SIDELENGTH)
			{
				player1OnGround = true;
				player1.y = stage.stageHeight - player1.PLAYER_SIDELENGTH;
				player1JumpSpeed = 0;
			}
			
			if (player2.y >= stage.stageHeight - player2.PLAYER_SIDELENGTH)
			{
				player2OnGround = true;
				player2.y = stage.stageHeight - player2.PLAYER_SIDELENGTH;
				player2JumpSpeed = 0;
			}
			
			
		}
		
		
		private function move():void 
		{
			
			if (leftKeyDown)
			{
				if (collision)
				{
					player1.moveSpeed (0, 0);
				}
				else 
				{
					player1.moveSpeed( -5, 0);
				}
				
				if (player1.x <= -player1.PLAYER_SIDELENGTH)
				{
					player1.x = stage.stageWidth;
				}
				
			}
			
			if (rightKeyDown)
			{
				if (collision2)
				{
					player1.moveSpeed(0, 0);
				}
				else 
				{
					player1.moveSpeed(5, 0);
				}
				
				if (player1.x >= stage.stageWidth)
				{
					player1.x = -player1.PLAYER_SIDELENGTH;
				}
			}
			
			if (upKeyDown)
			{
				player1Jump();
			}
			
			if (aKeyDown)
			{
				if (collision2)
				{
					player2.moveSpeed (0, 0);
				}
				else 
				{
					player2.moveSpeed (-5, 0);
				}
				
				if (player2.x == 0 - player2.PLAYER_SIDELENGTH)
				{
					player2.x = stage.stageWidth;
				}
			}
			
			if (dKeyDown)
			{
				
				if (collision)
				{
					player2.moveSpeed (0, 0);
				}
				else 
				{
					player2.moveSpeed (5, 0);
				}
				
				if (player2.x == stage.stageWidth)
				{
					player2.x = 0 - player2.PLAYER_SIDELENGTH;
				}
			}
			
			if (wKeyDown)
			{
				player2Jump();
			}
			
			player2.moveSpeed(0, player2JumpSpeed);
			player1.moveSpeed(0, player1JumpSpeed);
			
			//Collisions
			if ((player1.x == player2.x + player2.PLAYER_SIDELENGTH || player1.x == player2.x + player2.PLAYER_SIDELENGTH - 1 ||  player1.x == player2.x + player2.PLAYER_SIDELENGTH - 2 ||  player1.x == player2.x + player2.PLAYER_SIDELENGTH - 3 ||  player1.x == player2.x + player2.PLAYER_SIDELENGTH - 4 ||  player1.x == player2.x + player2.PLAYER_SIDELENGTH - 5) && player1.y + player1.PLAYER_SIDELENGTH > player2.y && player2.y + player2.PLAYER_SIDELENGTH > player1.y)
			{
				collision = true;
			}
			else 
			{
				collision = false;
			}
			
			if ((player2.x == player1.x + player1.PLAYER_SIDELENGTH || player2.x == player1.x + player1.PLAYER_SIDELENGTH - 1 ||  player2.x == player1.x + player1.PLAYER_SIDELENGTH - 2 ||  player2.x == player1.x + player1.PLAYER_SIDELENGTH - 3 ||  player2.x == player1.x + player1.PLAYER_SIDELENGTH - 4 ||  player2.x == player1.x + player1.PLAYER_SIDELENGTH - 5) && player1.y + player1.PLAYER_SIDELENGTH > player2.y && player2.y + player2.PLAYER_SIDELENGTH > player1.y)
			{
				collision2 = true;
			}
			else 
			{
				collision2 = false;
			}
			
			if (collision)
			{
				player1.x = player2.x + player2.PLAYER_SIDELENGTH;
			}
			
			if (collision2)
			{
				player1.x = player2.x - player2.PLAYER_SIDELENGTH;
			}
			
			if ((player1.y + player1.PLAYER_SIDELENGTH >= player2.y || player2.y + player2.PLAYER_SIDELENGTH >= player1.y) && (player1.x >= player2.x + player2.PLAYER_SIDELENGTH && player1.x <= player2.x + player2.PLAYER_SIDELENGTH))
			{
				collision3 = true;
			}
			else 
			{
				collision3 = false;
			}
			
			/*
			if (player2.x + player2.PLAYER_SIDELENGTH >= player1.x && player2.y + player1.PLAYER_SIDELENGTH > player1.y && player2.x < player1.x + player1.PLAYER_SIDELENGTH)
			{
				Player2 collides with player1
				player2.x = player1.x - player1.PLAYER_SIDELENGTH;
			}
			*/
		}
		
		private function player1Jump():void 
		{
			if (player1OnGround)
			{
				player1JumpSpeed = -15.0;
				player1OnGround = false;
			}
			
		}
		
		private function player2Jump():void 
		{
			if (player2OnGround)
			{
				player2JumpSpeed = -15.0;
				player2OnGround = false;
			}
		}
		
		private function onKeyDown(event:KeyboardEvent):void
		{
			switch (event.keyCode) 
			{
				case Keyboard.LEFT:
					leftKeyDown = true;
					break;
					
				case Keyboard.RIGHT:
					rightKeyDown = true;
					break;
					
				case Keyboard.UP:
					upKeyDown = true;
					break;
					
				case Keyboard.W:
					wKeyDown = true;
					break;
					
				case Keyboard.A:
					aKeyDown = true;
					break;
					
				case Keyboard.D:
					dKeyDown = true;
					break;
					
				default:
					break;
			}
			
		}
		
		private function onKeyUp(event:KeyboardEvent):void 
		{
			switch (event.keyCode)
			{
				case Keyboard.LEFT:
					leftKeyDown = false;
					break;
					
				case Keyboard.RIGHT:
					rightKeyDown = false;
					break;
				
				case Keyboard.UP:
					upKeyDown = false;
					break;
					
				case Keyboard.W:
					wKeyDown = false;
					break;
					
				case Keyboard.A:
					aKeyDown = false;
					break;
					
				case Keyboard.D:
					dKeyDown = false;
					break;
					
				default:
					break;
				
			}
		}
	}
	
}