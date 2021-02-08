package _1_Creational_Patterns;

//Name: Builder Design Pattern
//Function: allows the constructors to handle varying arguments

public class _3_BuilderPattern
{
	public static void main(String[] args)
	{
		Outer obj1 = new Outer.NestedBuilder("Req1","Req2").setOptional("Optional").getObject();
		System.out.println(obj1.getReq1());
		System.out.println(obj1.getReq2());
		System.out.println(obj1.getOptional());
		
		System.out.println("");
		
		Outer obj2 = new Outer.NestedBuilder("Req1","Req2").getObject();		
		System.out.println(obj2.getReq1());
		System.out.println(obj2.getReq2());
		System.out.println(obj2.getOptional());
	}
}

class Outer
{
	//required global variables
	private String req1;
	private String req2;
	
	//optional global variable
	private String optional;

	//getter methods for all global variables
	public String getReq1()
	{
		return this.req1;
	}

	public String getReq2()
	{
		return this.req2;
	}

	public String getOptional()
	{
		return this.optional;
	}

	private Outer(NestedBuilder builder)
	{
		System.out.println("Calling the outer private constructor(1 args)");
		this.req1 = builder.engine;
		this.req2 = builder.wheel;
		this.optional = builder.airbags;
	}
	
	public static class NestedBuilder
	{
		//contains the outerclasses required & optional global variables
		private String engine;
		private String wheel;
		private String airbags;
		
		public NestedBuilder(String engine, String wheel)
		{
			System.out.println("calling the public inner builder constructor(2 args)");
			this.engine = engine;
			this.wheel = wheel;
		}
		
		//setter method for all the optional global variables
		public NestedBuilder setOptional(String airbags)
		{
			System.out.println("Calling the public inner builder constructor(1 args)");
			this.airbags = airbags;
			return this;
		}

		public Outer getObject()
		{
			return new Outer(this);
		}
	}
}
