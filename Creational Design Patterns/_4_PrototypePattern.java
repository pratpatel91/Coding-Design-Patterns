package _1_Creational_Patterns;

import java.util.ArrayList;
import java.util.List;

//Name: Prototype Design Pattern
//Function: doesnt allow multiple objects to be connected to the same class instance

public class _4_PrototypePattern
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		ConcreteClass originalData = new ConcreteClass();
		originalData.insertData();
		
		ConcreteClass copy_PastedData = originalData.clone();
		List<String> clonedData = copy_PastedData.getData();
		clonedData.add("new_3");
		clonedData.add("new_4");
		//DISPLAYING THE OBJECTS DATA
		System.out.println("original objects data: " +originalData.getData());
		System.out.println("new cloned objects data:" +clonedData);
		
		//UPDATING THE OBJECT DATA
		copy_PastedData.getData().remove("new_4");
		System.out.println("");
		
		//REDISPLAYING THE OBJECTS DATA
		System.out.println("original objects data: " +originalData.getData());
		System.out.println("new cloned objects data:" +clonedData);
	}
}

class ConcreteClass implements Cloneable
{
	private List<String> data;

	public ConcreteClass()
	{
		this.data = new ArrayList<String>();
	}

	public ConcreteClass(List<String> list)
	{
		this.data = list;
	}

	public void insertData()
	{
		data.add("old_1");
		data.add("old_2");
	}

	public List<String> getData()
	{
		return this.data;
	}

	@Override
	public ConcreteClass clone() throws CloneNotSupportedException
	{
		List<String> clonedData = new ArrayList<String>();

		for (String s : this.getData())
		{
			clonedData.add(s);
		}

		return new ConcreteClass(clonedData);
	}
}


