package _2_Structural_Patterns;

//Name: Bridge Design Pattern
//Function: allows the Abstraction and the Implementation to be developed independently
//The abstraction is an interface or abstract class
//The implementor is also an interface or abstract class.

public class _11_BridgePattern
{
	public static void main(String[] args)
	{
		TV sonyOldRemote = new Sony(new OldRemote());
		sonyOldRemote.on();
		sonyOldRemote.off();
		System.out.println();

		TV sonyNewRemote = new Sony(new NewRemote());
		sonyNewRemote.on();
		sonyNewRemote.off();
		System.out.println();
	}
}

abstract class TV
{
	RemoteInterface remote;

	TV(RemoteInterface remoteType)
	{
		this.remote =remoteType;
	}
	
	abstract void on();
	abstract void off();
}

class Sony extends TV
{
	RemoteInterface remoteType;

	Sony(RemoteInterface remoteType)
	{
		super(remoteType);
		this.remoteType = remoteType;
	}

	public void on()
	{
		System.out.print("Same Sony TV ON: ");
		remoteType.on();
	}

	public void off()
	{
		System.out.print("Same Sony TV OFF: ");
		remoteType.off();
	}
}

interface RemoteInterface
{
	public void on();

	public void off();
}

class OldRemote implements RemoteInterface
{
	@Override
	public void on()
	{
		System.out.println("ON with Old Remote");
	}

	@Override
	public void off()
	{
		System.out.println("OFF with Old Remote");
	}
}

class NewRemote implements RemoteInterface
{
	@Override
	public void on()
	{
		System.out.println("ON with New Remote");
	}

	@Override
	public void off()
	{
		System.out.println("OFF with New Remote");
	}
}