import java.util.*;

public class InputViaConsole
{

	public static void main(String[] args)
	{
		Scanner keyboardInput = new Scanner(System.in);
		System.out.print("What is your name?: ");
		String name = keyboardInput.nextLine();
		System.out.print("Hello " + name + ". How old are you?: " );
		int age = keyboardInput.nextInt();
		System.out.print("You're " + age + " years old.");
		age = age + 10;
		System.out.print(" 10 years from now, you will be " + age + " years old!");
		keyboardInput.close();
	}

}
