package honux.calender;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Calendar_AutoWeekday {

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
	
	//자동으로 년월에 해당하는 요일 구하기
	public static int parseDay(int year, int month) {
		
		//1. LocalDate 생성
		LocalDate date = LocalDate.of(year, month, 1);
		//System.out.println(date);
		
		//2.DayOfWeek 객체 구하기
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		//System.out.println(dayOfWeek);
		
		//3. 숫자 요일 구하기
		int dayOfWeekNumber = dayOfWeek.getValue();
		//월~일 : 1~7 ex) 일요일: 7
		
		if(dayOfWeekNumber == 7) {
			return 0;
		}else {
			return dayOfWeekNumber;
		}
		
	}
	
	public static void printCalendar(int year, int month) {
		
		int count = 7-parseDay(year, month);
		
		System.out.printf("  <<%d년%3d월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		
		//print blank space
		for(int i=0; i<parseDay(year, month); i++) {
			
			System.out.print("   ");
		}
		
		//print first line
		for(int i=1; i<=count; i++) {
			System.out.printf("%3d",i);
		}
		
		System.out.println();

		int maxDay = getMaxDaysOfMonth(year, month);
		
		for(int i=count+1; i<=maxDay; i++) {
			
			System.out.printf("%3d",i);
			
			if(count == 7){
				if(i % 7 == 0) {
					System.out.println();
				}
			}
			else if(i % 7 == count) {
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
			
			printCalendar(year, month);
			
		}
	}
	
	public static void main(String[] args) {
		runPrompt();
	}

}
