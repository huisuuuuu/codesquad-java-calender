package honux.calender;

import java.util.Scanner;

public class Calendar_LeapYear {//윤년 적용
	
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
	
	public static void printCalendar(int year, int userInputMonth) {
		
		int month = getMaxDaysOfMonth(year, userInputMonth);
		int day = 1;
		
		System.out.println("   << "+year+"년  "+userInputMonth+"월 >>  ");
		System.out.println(" 일 월  화  수  목 금 토");
		System.out.println("----------------------");
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<7; j++) {
				
				if(month<day) {
					break;
				}
				
				if(day<10) {
					System.out.print(" "+day+" ");
				}else {
					System.out.print(day+" ");
				}
				day++;
			}
			System.out.println();
		}
	}
	
	public static void runPrompt() {
		
		Scanner sc = new Scanner(System.in);
		
		String prompt = ">";
		int year = 0; //임시
		int month = 1;
		
		while(year != -1 && month != -1 ) {
			System.out.println("년도를 입력하세요.");
			System.out.print(prompt);
			year = sc.nextInt();
			
			if(year == -1) {
				System.out.println("Bye~");
				sc.close();
				break;
			}
			
			System.out.println("월을 입력하세요.");
			System.out.print(prompt);
			month = sc.nextInt();
			
			if(month == -1) {
				System.out.println("Bye~");
				sc.close();
				break;
			}
			
			printCalendar(year, month);
		}
	}
	
	
	public static void main(String[] args) {
		
		runPrompt();
		
	}

}
