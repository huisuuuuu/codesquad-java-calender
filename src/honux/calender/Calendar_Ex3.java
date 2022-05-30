package honux.calender;

import java.util.Scanner;

public class Calendar_Ex3 {
	
	//상수 선언
	private final static int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
	public static int getMaxDaysOfMonth(int month) {
			
	return MAX_DAYS[month-1];
			
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("달의 최대일수를 출력하고자하는 반복 횟수를 입력하세요.");
		System.out.print("반복 횟수 입력: ");
		int repeatNum = sc.nextInt();
		
		int[] month = new int[repeatNum];
		
		for(int i=0; i<month.length; i++) {
			System.out.print((i+1)+"번째 달 입력: ");
			month[i] = sc.nextInt();
		}
		
		for(int i=0; i<month.length; i++) {
			System.out.println(month[i]+"월은 "+getMaxDaysOfMonth(month[i])+"일까지 있습니다.");
			
		}
		
		System.out.println("출력 끝");
		sc.close();
		
	}

}
