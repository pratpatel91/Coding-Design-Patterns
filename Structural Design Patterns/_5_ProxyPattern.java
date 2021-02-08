package _2_Structural_Patterns;


//Name: Proxy Design Pattern
//Function: creates a placeholder object to hide the real object

public class _5_ProxyPattern
{
	public static void main(String[] args)
	{
		Replacable replacableProxy = new Replacable();
		replacableProxy.turnOn(); // hides the precious object
		replacableProxy.turnOff(); // hides the precious object
	}
}

interface Functions
{
	public void turnOn();

	public void turnOff();
}

class Irreplacable implements Functions
{
	public void turnOn()
	{
		System.out.println("accessing the irreplacable object to turn on");
	}

	public void turnOff()
	{
		System.out.println("accessing the irreplacable object to turn off");
	}
}

class Replacable implements Functions
{
	private Functions irreplacableObject;

	public Replacable()
	{

		this.irreplacableObject = new Irreplacable();
	}

	public Replacable(Functions customer)
	{
		this.irreplacableObject = customer;
	}

	public void turnOn()
	{
		this.irreplacableObject.turnOn();
	}

	public void turnOff()
	{
		this.irreplacableObject.turnOff();
	}

}