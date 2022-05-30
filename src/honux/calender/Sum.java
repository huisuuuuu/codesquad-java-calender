package honux.calender;

import java.util.Scanner;

public class Sum {
	
	public static void main(String[] args) {
		
		//입력: 키보드로 두 수를 입력받는다.
		Scanner sc = new Scanner(System.in); //자바에서 키보드 입력은 System.in 이므로 Scanner 객체에 전달인자로 System.in을 넣는 것
		System.out.println("두 수를 입력하세요.");
		System.out.print("첫번째 수 입력: ");
		int su1 = sc.nextInt();
		System.out.print("두번째 수 입력: ");
		int su2 = sc.nextInt();
		
		//출력: 화면에 두 수의 합을 출력한다.
		System.out.println("입력하신 두 수의 합은 "+(su1+su2)+"입니다.");
		System.out.printf("%d와 %d의 합은 %d입니다.",su1, su2, (su1+su2));
		sc.close();
	}
}
