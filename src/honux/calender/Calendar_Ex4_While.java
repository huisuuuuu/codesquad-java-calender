package honux.calender;

import java.util.Scanner;

public class Calendar_Ex4_While {

		//상수 선언
		private final static int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		public static int getMaxDaysOfMonth(int month) {
				
		return MAX_DAYS[month-1];
				
		}

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			String prompt = ">";
			int month = 0;
			
			while(month != -1) {
				System.out.println("월을 입력하세요.");
				System.out.print(prompt);
				month = sc.nextInt();
				if(month != -1) {
				System.out.println(month+"월은 "+getMaxDaysOfMonth(month)+"일까지 있습니다.");
				}else {
					System.out.println("Have a Nice Day!");
					sc.close();
				}
			}
	}
}
