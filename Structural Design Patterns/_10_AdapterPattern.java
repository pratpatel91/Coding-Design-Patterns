package _2_Structural_Patterns;

//Name: Adapter Design Pattern
//Function: create a reusable class that talks to unrelated classes with incompatible interfaces.

public class _10_AdapterPattern
{
	public static void main(String[] args)
	{
		Apple apple = new Apple();
		apple.getApplesColor("red");

		Orange orange = new Orange();
		orange.getOrangesColor("orange");

		AppleToOrangeAdapter convertedOrange = new AppleToOrangeAdapter(orange);
		convertedOrange.getApplesColor("red");
	}
}

//ADAPTER converts an apple into an orange
class AppleToOrangeAdapter extends Apple
{
	private Orange orange;

	public AppleToOrangeAdapter(Orange orange)
	{
		this.orange = orange;
	}

	public void getApplesColor(String str)
	{
		orange.getOrangesColor(str);
	}
}

class Apple
{
	public void getApplesColor(String str)
	{
		System.out.println("Apples color is " + str);
	}
}

class Orange
{
	public void getOrangesColor(String str)
	{
		System.out.println("Oranges color is " + str);
	}
}