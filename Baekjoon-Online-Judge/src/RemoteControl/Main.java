/**
 *	리모콘
 *	https://www.acmicpc.net/problem/1107
 *	2016-07-13
 */
package RemoteControl;

import java.util.Scanner;

public class Main {
	public static boolean inArray(int e, int[] arr){
		/**
		 *	배열안에 해당 원소가 있는지 검사
		 */
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == e){
				return true;
			}			
		}
		
		return false;
	}
	public static int getNearNumber(int go, int[] borken){
		/**
		 *	int go 숫자에서 가장 근접한 숫자를 구한다.
		 */
		String str_go = String.valueOf(go);
		String str_return_up = "";		// 위쪽 가까운 수
		String str_return_down = "";	// 아래쪽 가까운 수
		
		for(int i = 0; i < str_go.length(); i++){
			int num = Character.getNumericValue(str_go.charAt(i));
			
			//	해당 숫자가 망가진 번호인가?
			if(Main.inArray(num, borken)){
				//	망가진 번호라면 위쪽, 아래쪽 가까운 번호를 구한다.
				//	위쪽
				int add_to_up = 0, add_to_down = 0;
				for(int j = num + 1; j <= 9; j++){
					if(!Main.inArray(j, borken)){
						add_to_up = j;
						str_return_up += j;
						break;
					}
				}
				//	아래쪽
				for(int j = num - 1; j >= 0; j--){
					if(!Main.inArray(j, borken)){
						add_to_down = j;
						str_return_down += j;
						break;
					}
				}
				
				//	만약 위쪽, 아래쪽에 숫자가 존재하지 않았다면?
				if(num+1 > 9)
					str_return_up += add_to_down;
				if(num-1 < 0)
					str_return_down += add_to_up;
			} else {
				//	망가진 번호가 아니라면 그대로 사용
				str_return_up += num;
				str_return_down += num;
			}
		}
		
		//	위쪽, 아래쪽 각각의 원 숫자와의 격차를 구하여 격차가 적은것을 고른다.
		int up = Math.abs(go - Integer.valueOf(str_return_up));
		int down = Math.abs(go - Integer.valueOf(str_return_down));
		
		return up < down ? Integer.valueOf(str_return_up) : Integer.valueOf(str_return_down);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//	가고자 하는 채널과 망가진 번호 개수를 입력받는다.
		int go = sc.nextInt();
		int broken_num = sc.nextInt();
		int[] broken = new int[broken_num];
		
		//	망가진 번호를 입력받는다.
		for(int i = 0; i < broken_num; i++){
			broken[i] = sc.nextInt();
		}
		
		//	현재 채널이 100
		if(go == 100){
			System.out.println(0);
			return;
		}
		
		//	만약 가고자 하는 번호가 101 이라면 그냥 +- 키를 누르는게 더 빠를 것이다.
		int g = Math.abs(go - 100);
		
		//	망가진 숫자가 10개일경우 +- 키로만 이동할 수 있다.
		if(broken_num == 10){
			System.out.println(g);
			return;
		}

		//	근접한 숫자를 구한다.
		int near = Main.getNearNumber(go, broken);
		
		//	근접한 숫자의 자리수를 구한다.
		String near_str = String.valueOf(near);
		int near_digit = near_str.length();
		
		//	근접한 숫자와 가고자 하는 채널만큼의 간격을 구한다.
		int gap = Math.abs(go - near);
		
		//	간격 + 자리수가 버튼을 누르는 횟수
		int result = gap + near_digit;
		
		System.out.println(result < go ? result : go);
	}
}
