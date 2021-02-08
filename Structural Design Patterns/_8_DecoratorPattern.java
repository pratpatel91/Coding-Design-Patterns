package _2_Structural_Patterns;

//Name: Decorator Design Pattern
//Function: modifies functionality of an object at runtime

public class _8_DecoratorPattern
{
	public static void main(String[] args)
	{
		System.out.println("junior dev");
		jobTitle juniorDev = new JuniorDev();
		juniorDev.work(); 
		
		System.out.println();
		System.out.println("Upgraded from junior dev to lead dev");
		juniorDev = new LeadDev(juniorDev);
		juniorDev.work(); //INDIVIDUAL OBJECT IS UPDATED DURING RUNTIME
		System.out.println();
		
		System.out.println("Upgraded from lead dev to senior dev");
		juniorDev  = new SeniorDev(juniorDev);
		juniorDev.work(); //INDIVIDUAL OBJECT IS UPDATED DURING RUNTIME
		System.out.println();
		
		//OTHER OBJECTS ARENT AFFECTED
		System.out.println("another junior dev");
		jobTitle juniorDev_2 = new JuniorDev();
		juniorDev_2.work();
	}
}

interface jobTitle
{
	public abstract void work();
}

class JuniorDev implements jobTitle
{
	@Override
	public void work()
	{
		System.out.println("\t...junior dev work");
	}
}

class DecoratorCorpLadder implements jobTitle
{
	private jobTitle job;

	public DecoratorCorpLadder(jobTitle job)
	{
		super();
		this.job = job;
	}

	@Override
	public void work()
	{
		job.work();
	}
}

class LeadDev extends DecoratorCorpLadder
{
	public LeadDev(jobTitle job)
	{
		super(job);
	}

	@Override
	public void work()
	{
		super.work();
		System.out.println("\t...lead dev work");
	}
}

class SeniorDev extends DecoratorCorpLadder
{
	public SeniorDev(jobTitle job)
	{
		super(job);
	}

	@Override
	public void work()
	{
		super.work();
		System.out.println("\t...senior dev work");
	}
}