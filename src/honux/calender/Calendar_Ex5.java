package honux.calender;

import java.util.Scanner;

public class Calendar_Ex5 {

	//상수 선언
	private final static int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static int getMaxDaysOfMonth(int month) {
			
	return MAX_DAYS[month-1];
			
	}
	
	public static void printCalendar(int month) {
		
		month = getMaxDaysOfMonth(month);
		int day = 1;
		
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

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String prompt = ">";
		int month = 1;
		
		while(month != -1) {
			System.out.println("월을 입력하세요.");
			System.out.print(prompt);
			month = sc.nextInt();
			if(month != -1) {
				printCalendar(month);
			}else {
				System.out.println("Bye~");
				sc.close();
			}
		}
}
}
