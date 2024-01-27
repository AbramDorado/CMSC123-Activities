
public class ClockDriver 
{
	public static void main(String[] args) 
	{
//		Clock defaultClock = new Clock();
//		defaultClock.printTime();
//		
//		System.out.println();
//		Clock clockWithTime = new Clock (12, 24, 48);
//		clockWithTime.printTime();
//		int hour = clockWithTime.getHours();
//		int minute = clockWithTime.getMinutes();
//		int second = clockWithTime.getSeconds();
//		System.out.println("\nShowing the different members of the clock:");
//		System.out.println("Hours: " + hour);
//		System.out.println("Minutes: " + minute);
//		System.out.println("Seconds: " + second);
//		
//		Clock clockCopy = clockWithTime.getCopy();
//		System.out.println("Are the 2 clocks equal? " + clockCopy.equals(clockWithTime) );
//		
//		System.out.println("Changing the clock...");
//		clockCopy.setTime(1, 58, 59);
//		System.out.println("Are the 2 clocks equal? " + clockCopy.equals(clockWithTime) );
//		System.out.println("Incremeting time...");
//		clockCopy.incrementHours();
//		clockCopy.printTime();
//		System.out.println();
//		
//		clockCopy.incrementSeconds();
//		clockCopy.printTime();
//		System.out.println();
//		
//		clockCopy.incrementMinutes();
//		clockCopy.printTime();
//		
//		System.out.println("Final time of the 3 clocks:");
//		System.out.println(defaultClock);
//		System.out.println(clockWithTime);
//		System.out.println(clockCopy);
		
//		Clock clock = new Clock(0, 0, 0);
//		System.out.println(clock);
		
		Clock clock = new Clock(25, 0, 0);
		System.out.print(clock);
		System.out.println();
		clock.printTimeAMPM();
		System.out.println("\n");
		
	} 
}
