public class Clock 
{
	private int hours;		
	private int minutes;	
	private int seconds;	
	
	public Clock()
	{
		setTime(0, 0, 0);
	}
	
	public Clock(int hours, int minutes, int seconds)
	{
		setTime(hours, minutes, seconds);
	}
	
	public void setTime(int hours, int minutes, int seconds)
	{
		if (0 <= hours && hours < 24)
		{
			this.hours = hours;
		}
		else
		{
			this.hours = 0;
		}
		
		this.minutes = (0 <= minutes && minutes < 60) ? minutes : 0;
		this.seconds = (0 <= seconds && seconds < 60) ? seconds : 0;
	}
	
	public int getHours()
	{
		return hours;
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	
	public int getSeconds()
	{
		return seconds;
	}
	
	public void printTime()
	{
		if (hours < 10)
		{
			System.out.print("0");			
		}
		System.out.print(hours + ":");
		
		if (minutes < 10)
		{
			System.out.print("0");
		}
		System.out.print(minutes + ":");
		
		if (seconds < 10)
		{
			System.out.print("0");
		}
		System.out.print(seconds);
	}
	
	public void incrementHours()
	{
		hours++;			
		if (hours > 23)		
		{
			hours = 0;		
		}
	}
	
	public void incrementMinutes()
	{
		minutes++;				
		if (minutes > 59)		
		{
			minutes = 0;		
			incrementHours();	
		}
	}
	
	public void incrementSeconds()
	{
		seconds++;				
		if (seconds > 59)		
		{
			seconds = 0;		
			incrementMinutes();	
		}
	}
	
	public boolean equals(Clock otherClock)
	{
		return (hours == otherClock.hours 
				&& minutes == otherClock.minutes
				&& seconds == otherClock.seconds );
	}
	
	public void makeCopy(Clock otherClock)
	{
		hours = otherClock.hours;
		minutes = otherClock.minutes;
		seconds = otherClock.seconds;
	}
	
	public Clock getCopy()
	{
		Clock temp = new Clock();
		
		temp.hours = hours;
		temp.minutes = minutes;
		temp.seconds = seconds;
		
		return temp;
	}
	
	public String toString()
	{
		String str = "";
		
		if (hours < 10)
		{
			str = "0";
		}
		str = str + hours + ":";
		
		if (minutes < 10)
		{
			str += "0";
		}
		str += minutes + ":";
		
		if (seconds < 10)
		{
			str += "0";
		}
		str += seconds;
		
		return str;
	}
	
	
//Here is my code	
	public void printTimeAMPM(){ //method
		String time ="";
		
		if (hours < 10 && hours >0){time = "0";} //set the hours
		String condition = (hours < 12) ? " AM" : " PM"; //condition if AM/PM
		
		this.hours = (hours == 0 || hours == 12) ? 12 : hours % 12; //convert military time to standard time
		if (hours != 12 && hours < 10) {time = "0";}
		time = time + hours + ":";
		
		if (minutes < 10){time += "0";} //set the minutes
		time += minutes + ":";
		
		if (seconds < 10){time += "0";} //set the seconds
		time += seconds;
		
		System.out.print(time + condition); //combine
	} 
}