import java.util.Scanner;


public class MakeRectangle {
	//G�r inte bara rektanglar.
	
	
	public static void main(String[] args) 
	{
		Rektangel rekt = new Rektangel(4, 40);
		Rektangel e = new Rektangel(3.5, 35.9);
		
		Fan hej = new Fan();
		
		hej.setColor("vit");
		hej.setOn(false);
		hej.setSpeed(50);
		hej.setRad(50);
		//System.out.println(hej);
		
		QuadraticEquation ingaL�sningar = new QuadraticEquation(3, 2, 3);
		QuadraticEquation enL�sning = new QuadraticEquation(3, 6, 3);
		QuadraticEquation tv�L�sningar = new QuadraticEquation(3, 10, 3);
		
		System.out.println(ingaL�sningar);
		System.out.println(enL�sning);
		System.out.println(tv�L�sningar);
	}
}
