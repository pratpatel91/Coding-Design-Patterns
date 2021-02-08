package _1_Creational_Patterns;

//Name: Abstract Factory Design Pattern
//Function: allows us the find the correct subclass when M Subclasses:1 Superclass

public class _2_AbstractFactoryPattern
{
	public static void main(String[] args)
	{
		SuperClass car = SuperClassFactory.getObject("SubClass1", "prat");
		System.out.println(car);

		System.out.println("");
		
		SuperClass bike = SuperClassFactory.getObject("SubClass2", "pratiksh");
		System.out.println(bike);
	}
}

//abstract superclass
abstract class SuperClass
{
	// abstract method
	public abstract String getNum();

	// concrete method
	public String toString()
	{
		return this.getNum();
	}
}

class SubClass1 extends SuperClass
{
	// global variable
	String name;

	// constructor
	SubClass1(String arg)
	{
		System.out.println("in the constructor of subclass1");
		this.name = arg;
	}

	// MUST IMPLEMENT THE ABSTRACT CLASSES ABSTRACT METHOD
	@Override
	public String getNum()
	{
		System.out.println("in the overridden constructor of subclass1");
		return this.name;
	}
}

class SubClass2 extends SuperClass
{
	// global variable
	String name;

	// constructor
	SubClass2(String arg)
	{
		System.out.println("in the constructor of subclass2");
		this.name = arg;
	}

	// MUST IMPLEMENT THE ABSTRACT CLASSES ABSTRACT METHOD
	@Override
	public String getNum()
	{
		System.out.println("in the overridden constructor of subclass2");
		return this.name;
	}
}

class SuperClassFactory
{
	//method for returning the correct subclass object
	public static SuperClass getObject(String subclassName, String arg)
	{
		System.out.println("Returning the correct subclass object");
		if (subclassName == "SubClass1")
		{
			System.out.println("Create/return the subclass1 object");
			return new SubClass1(arg);
		} else if (subclassName == "SubClass2")
		{
			System.out.println("Create/return the subclass2 object");
			return new SubClass2(arg);
		}
		else //dont create/return any subclass objects
		{
			System.out.println("Not creating/returning any subclass object");
			return null;
		}
	}
}