/**
 *	리모콘
 *	https://www.acmicpc.net/problem/1107
 *	2016-07-13
 */
import java.util.Scanner;
public class RemoteControl {
	private static Scanner sc;
	
	public static boolean inArray(int search, int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == search) return true;
		}
		
		return false;
	}
	
	public static int getNearNumber(int input, int[] avaliable){
		/**
		 *	input 넘버와 avaliable 배열에서 가장 근접한 숫자를 찾는다.
		 */
		int up_num = input, 
			up_idx = 0, 
			down_num = input, 
			down_idx = 0;

		//	input 넘버보다 위
		for(int i = input; i < 10; i++){
			if(RemoteControl.inArray(i, avaliable)){
				//	i 가 사용할 수 있는 숫자라면
				up_num = i;
				break;
			}
			up_idx++;
		}
		
		//	input 넘버보다 아래
		for(int i = input; i >= 0; i--){
			if(RemoteControl.inArray(i, avaliable)){
				down_num = i;
				break;
			}
			down_idx++;
		}
		
		return up_idx <= down_idx ? up_num : down_num;
	}
	
	public static String getMinimal(int go, int[] avalible){
		//	자릿수 계산을 위해 int형을 string형으로 변
		String str = String.valueOf(go);
		String return_str = "";
		
		//	각 자릿수마다 broken되지 않은 숫자들을 채움
		for(int i = 0; i < str.length(); i++){
			int j =  Character.getNumericValue(str.charAt(i));
			return_str += RemoteControl.getNearNumber(j, avalible);
		}
		
		return return_str;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		//	0. 가고자 하는 채널과 망가진 번호 개수를 입력받는다.
		int go = sc.nextInt();
		int broken_num = sc.nextInt();
		int[] broken = new int[broken_num];
		int[] avaliable = new int[10 - broken_num];
		
		//	1. 망가진 번호를 입력받는다.
		for(int i = 0; i < broken_num; i++){
			broken[i] = sc.nextInt();
		}
		
		//	1.1. 가고자 하는 채널이 100이면 이미 100번을 시청중이므로 0 반환.
		if(go == 100){
			System.out.println("0");
			return;
		}
		
		//	2. 안망가진 번호를 계산한다.
		for(int i = 0; i < (10 - broken_num); i++){
			if(!RemoteControl.inArray(i, broken)){
				avaliable[i] = i;
			}
		}
		
		//	3. 가고자 하는 채널에 가장 근접한 숫자를 구한다.
		String near= RemoteControl.getMinimal(go, avaliable);
		
		//	4. 근접한 숫자와 가고자 하는 채널과의 격차를 구한다.
		int gap = Math.abs(Integer.parseInt(near) - go);
		
		//	5. 근접한 숫자의 자릿수와 가고자하는 채널과의 격차를 더한다. 더한 결과물이 버튼을 누른 횟수.
		int result = near.length() + gap;
		
		System.out.println(result);
	}
}
