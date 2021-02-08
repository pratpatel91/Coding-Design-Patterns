package _2_Structural_Patterns;

//Name: Facade Design Pattern
//Function: facade hides task complexity by providing a simple interface.

public class _6_FacadePattern
{
	public static void main(String[] args)
	{
		FacadePC pcUser = new FacadePC();
		pcUser.pressStart();
	}
}

class FacadePC
{
	private CPU cpu;
	private BiosProgram bios;
	private BootLoader bootloader;

	public FacadePC()
	{
		this.cpu = new CPU();
		this.bios = new BiosProgram();
		this.bootloader = new BootLoader();
	}

	public void pressStart()
	{
		cpu.talkToBiosProgram();
		bios.initializeHardware();
		bios.talkToBootLoaderProgram();
		bootloader.readOSProgramFromHardDrive();
		bootloader.loadOSProgramIntoRAM();
		System.out.println("USER SEES THE OS LOGO INDICATING THE COMPUTER IS ON");
	}
}

class CPU
{
	public void talkToBiosProgram()
	{
		System.out.println(".......talkToBiosProgram()");
	}
}

class BiosProgram
{
	public void initializeHardware()
	{
		System.out.println(".......initializeHardware()");
	}

	public void talkToBootLoaderProgram()
	{
		System.out.println(".......talkToBootLoaderProgram()");
	}
}

class BootLoader
{
	public void readOSProgramFromHardDrive()
	{
		System.out.println(".......readOSProgramFromHardDrive()");
	}

	public void loadOSProgramIntoRAM()
	{
		System.out.println(".......loadOSProgramIntoRAM()");
	}
}