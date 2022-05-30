package honux.calender;

public class Ex1 {

	public static void main(String[] args) {
		
		System.out.println(" 일 월  화 수  목 금  토 ");
		System.out.println("--------------------");

		int day = 1;

		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
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

}
