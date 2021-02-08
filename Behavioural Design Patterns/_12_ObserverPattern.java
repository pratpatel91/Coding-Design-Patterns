package _3_Behaviour_Patterns;

import java.util.ArrayList;
import java.util.List;

//Name: Observer Design Pattern
//Function: Establishes 1:M object updates such that 
//when one object changes state then all the other objects
//are notified/updated automatically


public class _12_ObserverPattern
{
	public static void main(String[] args)
	{
		Publisher serviceProvider = new Publisher();

		Observer paidCustomers = new Observer_1();
		Observer unpaidCustomers = new Observer_2();

		serviceProvider.addObservers(paidCustomers);
		serviceProvider.addObservers(unpaidCustomers);
		
		serviceProvider.addContent("free content");
		
		serviceProvider.unregisterObservers(unpaidCustomers);

		serviceProvider.addContent("paid content");
	}
}

interface BusinessRules
{
	void addObservers(Observer obj);
	void unregisterObservers(Observer obj);
	void notifyObservers();
}

class Publisher implements BusinessRules
{

	private List<Observer> customers;
	private String content;

	public Publisher()
	{
		this.customers = new ArrayList<>();
	}

	@Override
	public void addObservers(Observer obj)
	{
		customers.add(obj);
	}

	@Override
	public void unregisterObservers(Observer obj)
	{
		customers.remove(obj);
	}

	@Override
	public void notifyObservers()
	{
		for (Observer obj : customers)
		{
			obj.update(content);
		}
	}

	public void addContent(String topic)
	{
		this.content = topic;
		notifyObservers();
		System.out.println();
	}

	public String getLocation()
	{
		return "YPlace";
	}
}

interface Observer
{
	public void update(String location);
}

class Observer_1 implements Observer
{
	private String content;

	@Override
	public void update(String location)
	{
		this.content = location;
		showLocation();
	}

	public void showLocation()
	{
		System.out.println("Hello Paid Customer, you can see" + content);
	}
}

class Observer_2 implements Observer
{
	private String content;

	@Override
	public void update(String location)
	{
		this.content = location;
		showLocation();
	}

	public void showLocation()
	{
		System.out.println("Notification at Warehouse - Current Location: " + content);
	}
}
