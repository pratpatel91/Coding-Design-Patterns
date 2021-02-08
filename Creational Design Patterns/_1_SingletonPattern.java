package _1_Creational_Patterns;

//Name: Singleton Design Pattern
//Function: doesnt allow more than 1 object to be created
//Uses: logging, cache, session, drivers

public class _1_SingletonPattern
{
	public static void main(String[] args)
	{
		// non static way of accessing a classes method (class.method)
		SingletonLazy obj1 = SingletonLazy.getTheCreatedObject();
		System.out.println(obj1);
		SingletonLazy obj2 = SingletonLazy.getTheCreatedObject();
		System.out.println(obj2);
		System.out.println("");
		
		SingletonSynchronized obj5 = SingletonSynchronized.getTheCreatedObject();
		System.out.println(obj5);
		SingletonSynchronized obj6 = SingletonSynchronized.getTheCreatedObject();
		System.out.println(obj6);
		System.out.println("");
	}
}

class SingletonLazy
{
	// Eager= declaration of the object is done in advance
	// private object declaration
	private static SingletonLazy onlyOneObject;

	// Default No Arguments constructor
	private SingletonLazy()
	{
	}

	// Method for returning the single object
	public static SingletonLazy getTheCreatedObject()
	{
		if (onlyOneObject == null)
		{
			System.out.println("Creating the object for the 1st time");
			onlyOneObject = new SingletonLazy();
			System.out.println("Returning the 1st created object");
			return onlyOneObject;
		} else
		{
			System.out.println("reusing the 1st object (no need to create a 2nd object)");
		}
		return onlyOneObject;
	}
}

//Synchronization let only 1 user create an object at a time
// prevents multiple users from creating objects at the same time.
class SingletonSynchronized
{
	// private object declaration
	private static SingletonSynchronized onlyOneObject;

	// Default No Arguments constructor
	private SingletonSynchronized()
	{
	}

	// Method is synchronized here
	//both read and write access of the object are synchronized
	public static synchronized SingletonSynchronized getTheCreatedObject()
	{
		if (onlyOneObject == null)
		{
			System.out.println("Creating the 2nd object for the 1st time");
			onlyOneObject = new SingletonSynchronized();
			System.out.println("Returning the 2nd object");
			return onlyOneObject;
		} else
		{
			System.out.println("reusing the 1st object (no need to create a 2nd object)");
		}
		return onlyOneObject;
	}
}