package _2_Structural_Patterns;

import java.util.ArrayList;
import java.util.List;

//Name: Composite Design Pattern
//Function: creates a hierarchical tree 

public class _7_CompositePattern
{
	public static void main(String[] args) 
	{
	    CompositeAccount component = new CompositeAccount();
	    component.addAccount(new DepositeAccount("DA1", 100));
	    component.addAccount(new DepositeAccount("DA2", 150));
	    component.addAccount(new SavingAccount("SA1", 200));

	    System.out.println("Total Balance : " + component.getBalance());
	  }
}

//Composite Class
class CompositeAccount extends Account 
{
	private float totalBalance;
	private List<Account > accountList = new ArrayList<Account >(); //Aggregation 1 CompAccount to M Accounts

	//MUST IMPLEMENT INHERITED METHOD
	public float getBalance()
	{
		totalBalance = 0;
		for (Account  f : accountList)
		{
			totalBalance = totalBalance + f.getBalance();
		}
		return totalBalance;
	}

	public void addAccount(Account  acc)
	{
		accountList.add(acc);
	}

	public void removeAccount(Account  acc)
	{
		accountList.add(acc);
	}
}

//Component Class
abstract class Account 
{
	public abstract float getBalance();
}

//Leaf Class
class DepositeAccount extends Account 
{
	private String accountNo;
	private float accountBalance;

	public DepositeAccount(String accountNo, float accountBalance)
	{
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
	}
	
	//MUST IMPLEMENT INHERITED METHOD
	public float getBalance()
	{
		return accountBalance;
	}
}

//Leaf Class
class SavingAccount extends Account 
{
	private String accountNo;
	private float accountBalance;

	public SavingAccount(String accountNo, float accountBalance)
	{
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
	}

	//MUST IMPLEMENT INHERITED METHOD
	public float getBalance()
	{
		return accountBalance;
	}
}
