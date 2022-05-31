package honux.calender;

import java.util.Scanner;

public class Calendar_Ex6 {

	private final static int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final static int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static boolean isLeapYear(int year) {
		
		if(year % 4 == 0 && (year % 100 !=0 || year % 400 == 0)) {
			return true;
		}else{
			return false;
		}
	}
	
	public static int getMaxDaysOfMonth(int year, int month) {
		
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
		}else {
			return MAX_DAYS[month-1];
		}
			
	}
	
	public static int parseDay(String weekday) {
		
		switch(weekday) {
		
		case "SU": return 0;
		case "MO": return 1;
		case "TU": return 2;
		case "WE": return 3;
		case "TH": return 4;
		case "FR": return 5;
		case "SA": return 6;
		default: return 0;
		}
		
	}
	
	public static void printCalendar(int year, int month, String weekday) {
		
		System.out.printf("  <<%d년%3d월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		
		//print blank space
		for(int i=0; i<parseDay(weekday); i++) {
			
			System.out.print("   ");
		}
		
		int count = 7-parseDay(weekday);
		//print first line
		for(int i=1; i<=count; i++) {
			System.out.printf("%3d",i);
		}
		
		System.out.println();
		
		int maxDay = getMaxDaysOfMonth(year, month);
		
		for(int i=count+1; i<=maxDay; i++) {
			
			System.out.printf("%3d",i);
			
			if(weekday.equals("SU")){
				if(i% 7 == 0) {
					System.out.println();
				}
			}
			else if(i % 7 == count) {//디버깅
				System.out.println();
			}
		}
		System.out.println();	
	}
	
	public static void runPrompt() {
		
		Scanner sc = new Scanner(System.in);
		
		int year = 0; //임시 값
		int month = 1;
		
		while(year != -1 && month != -1 ) {
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR>");
			year = sc.nextInt();
			
			if(year == -1) {
				System.out.println("Bye~");
				sc.close();
				break;
			}
			
			System.out.println("달을 입력하세요.");
			System.out.print("MONTH>");
			month = sc.nextInt();
			
			if(month == -1) {
				System.out.println("Bye~");
				sc.close();
				break;
			}
			
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
			System.out.print("WEEKDAY>");
			String weekday = sc.next();
			
			printCalendar(year, month, weekday);
		}
	}
	
	public static void main(String[] args) {
		runPrompt();
	}

}
