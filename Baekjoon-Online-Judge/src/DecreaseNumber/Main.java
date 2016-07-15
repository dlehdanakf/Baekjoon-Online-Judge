/**
 *	감소하는 수 구하기
 *	https://www.acmicpc.net/problem/1038
 *	2016-07-15
 */
package DecreaseNumber;

import java.util.Scanner;

public class Main {
	public static int number = 0;
	public static int index = 0;
	public static boolean getNumOfDigit(int digit, int max, String total){
		/**
		 *	최고자리수가 max보다 작은 digit자리수를 구한다.
		 */
		for(int i = 0; i < max; i++){
			if(digit == 1){
				Main.index++;
				if(Main.index == Main.number){
					System.out.println(total + i);
					return true;
				}
			}
			
			if(Main.getNumOfDigit(digit - 1, i, total + i)){
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main.number = sc.nextInt();
		
		if(number <= 9){
			/**
			 *	0 ~ 9 까지는 그 숫자 자체가 감소하는 수 이므로 바로 출력.
			 */
			System.out.println(number);
			return;
		}
		if(number > 1022){
			/**
			 *	987654321 보다 큰 감소하는 수는 없는데 987654321이 1022번째 감소하는 수 이다.
			 *	따라서 1023 부터는 존재하지 않는다.
			 */
			System.out.println("-1");
			return;
		}
		
		/**
		 *	0 ~ 9 까지는 그 자체로 감소하는 수 이므로 바로 출력하고 그 만큼 뺀다.
		 */
		number -= 9;
		
		int digit = 1;
		search:
		while(true){
			for(int i = 0; i < 10; i++){
				if(Main.getNumOfDigit(digit, i, String.valueOf(i))){
					break search;
				}
			}
			digit++;
		}
	}
}