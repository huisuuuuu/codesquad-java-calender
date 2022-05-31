package honux.calender;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class CalendarAndSearch {
	
	private final static int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final static int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//윤년
	
	public static boolean isLeapYear(int year) {
		
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {//년도를 4나 400으로 나눴을때 0이면 윤년, 0으로 나눴을때 0이면 평년
			return true;
		}else {
			return false;
		}
	}
	
	public static int getMaxDaysOfMonth(int year, int month) {
		
		if(isLeapYear(year)) {//참이면 윤년
			return LEAP_MAX_DAYS[month-1]; //배열은 0부터 시작하므로 1월의 최대일수는 0 인덱스에 저장되어있으므로, 달에서 1을 빼서 해당하는 달의 인덱스를 찾음
		}else{
			return MAX_DAYS[month-1];
		}
	}
	
	public static int parseDay(int year, int month) {
		
		LocalDate date = LocalDate.of(year, month, 1);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekNum = dayOfWeek.getValue();
		
		if(dayOfWeekNum == 7) {
			return 0;
		}else {
			return dayOfWeekNum;
		}
	}
	
	public static void simplePrintCalendar(int year, int month) {
		
		System.out.printf("   << %d년%2d월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		
		int count = 7-parseDay(year, month);
		int maxDay = getMaxDaysOfMonth(year,month);
		
		for(int i=1; i<=parseDay(year, month); i++) {
			System.out.print("   ");
		}
		
		for(int i=1; i<=count; i++) {
			System.out.printf("%3d",i);
		}
		
		System.out.println();
		
		for(int i=count+1; i<=maxDay; i++) {
			
			System.out.printf("%3d",i);
			
			if(count==7) {
				if(i % 7 == 0) {
					System.out.println();
				}
			}else if(i % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
	}
	
	public static void printMenu() {
		
		Scanner sc = new Scanner(System.in);
		HashMap map = new HashMap();
		
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
		
		while(true) {
		System.out.println("명령 (1, 2, 3, h, q)");
		System.out.print(">");
		String userChoice = sc.next();
		
		switch(userChoice) {
			case "1": 
				System.out.println("[일정 등록] 날짜를 입력하세요.");
				System.out.print(">");
				String date = sc.next();
				
				if(map.get(date) != null) {
					System.out.println("이미 일정이 등록되어있습니다.\n일정을 변경하시겠습니까?");//변경 가능하도록 바꿔보기
					System.out.print("1.예 / 2.아니오");
					int num = sc.nextInt();
					
					
					if(num==1) {
						System.out.println("일정을 입력하세요.");
						System.out.print(">");
						String plan = sc.next();
						map.put(date, plan);
						System.out.println("일정이 등록되었습니다.");
						break;
					}
					
					break;
				}
			
				System.out.println("일정을 입력하세요.");
				System.out.print(">");
				String plan = sc.next();
				
				map.put(date, plan);
				
				System.out.println("일정이 등록되었습니다.");
				break;
				
			case "2": 
				System.out.println("[일정 검색] 날짜를 입력하세요.");
				System.out.print(">");
				String planSearch = sc.next();
				
				if(map.get(planSearch) != null) {
					System.out.println("1개의 일정이 있습니다.");
					System.out.println("1. "+map.get(planSearch));
				}else {
					System.out.println("등록된 일정이 없습니다.");
				}
				
				break;
			case "3": 
				
				System.out.println("년도를 입력하세요.");
				System.out.print("YEAR>");
				int year = sc.nextInt();
				
				System.out.println("달을 입력하세요.");
				System.out.print("MONTH>");
				int month = sc.nextInt();
				
				simplePrintCalendar(year, month);
				
				break;
			case "h": 
				System.out.println("도움말");
				break			;
			case "q": 
				System.out.println("Bye");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
				break;
			}
		}

	}
	
	public static void main(String[] args) {
		
		printMenu();
	}
	
}
