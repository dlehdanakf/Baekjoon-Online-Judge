/**
 *	분수찾기
 *	https://www.acmicpc.net/problem/1193
 *	2016-07-13
 */
import java.util.Scanner;
public class FindFountain {
	private static Scanner sc;
	
	public static int getDenominatorNumerator(boolean bool, int e){
		/**
		 *	n번째 분모,분자를 구합니다.
		 */
		int max = 1,
			pivot = 1;

		while(true){
			/**
			 *	pivot 부터 e까지 올라간다.
			 */
			if(bool){
				for(int i = 1; i <= max; i++){
					if(pivot == e)
						return i;
					pivot += 1;
				}
			} else {
				for(int i = max; i >= 1; i--){
					if(pivot == e)
						return i;
					pivot += 1;
				}
			}
			
			//	bool 교체
			bool = !bool;
			max += 1;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int nth = sc.nextInt();
		int a = FindFountain.getDenominatorNumerator(false, nth);
		int b = FindFountain.getDenominatorNumerator(true, nth);
		
		System.out.println(a + "/" + b);
	}
}
