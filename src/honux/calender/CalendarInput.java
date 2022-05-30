package honux.calender;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarInput {
	
	//상수 선언
	private final static int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static int getMaxDaysOfMonth(int month) {
		
		return MAX_DAYS[month-1];
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("달을 입력하세요.");
		System.out.print("입력: ");
		int month = sc.nextInt();
		
		/*숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		 *Case1
		int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		System.out.println(month+"월은 "+maxDays[month-1]+"일까지 있습니다.");
		*/
		
		// Calendar cal = new Calendar(); -> Calendar는 추상 클래스라서 인스턴스화 불가
		Calendar cal = Calendar.getInstance();
		
		//Case2
		System.out.println(month+"월은 "+getMaxDaysOfMonth(month)+"일까지 있습니다.");//메소드 호출
		sc.close();
	}

}
