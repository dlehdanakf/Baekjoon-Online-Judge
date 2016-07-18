/**
 *	약수
 *	https://www.acmicpc.net/problem/1037
 *	2017-07-17
 */

package Divisor;

import java.util.Scanner;

class Multiple {
	/**
	 *	배열안의 수와 주어진 수의 모든 곱을 계산하여 저장한다.
	 */
	public int[] result;
	public Multiple(int p, int[] arr){
		/**
		 *	int p : 배열에서 몇번째 수를 기준으로 전부 곱해볼건지 결정
		 *	int[] arr : 약수 배열
		 */
		
		this.result = new int[arr.length - 1];
		for(int i = 0, j = 0; i < arr.length; i++, j++){
			if(i == p){
				j--;
				continue;
			}
			
			this.result[j] = arr[i] * arr[p];
		}
	}
	public boolean inArray(int search){
		/**
		 *	int[] result 안에 search 숫자가 존재하는지 검
		 */
		for(int i = 0; i < this.result.length; i++){
			if(this.result[i] == search){
				//	존재함
				return true;
			}
		}
		
		return false;
	}
}

public class Main {
	public static void getDuplicateValue(Multiple[] arr){
		/**
		 *	배열들 사이에서 중복되는 값들을 분석한다.
		 *	배열의 0번을 기준으로!
		 */
		
		searchloop:
		for(int i = 0; i < arr[0].result.length; i++){
			//	search에 비교할 숫자를 할당
			int search = arr[0].result[i];
			
			//	search 숫자가 나머지 다른 배열들에도 존재하는지 검사
			for(int j = 1; j < arr.length; j++){
				if(!arr[j].inArray(search)){
					//	존재하지 않는다면
					continue searchloop;
				}
			}
			
			System.out.println(search);
			return;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dv = new int[n];
		Multiple[] m = new Multiple[n];
		
		//	약수를 입력받는다.
		for(int i = 0; i < n; i++){
			dv[i] = sc.nextInt();
		}
		
		if(n == 1){
			//	약수가 한개면 걍 그 숫자.
			System.out.println(dv[0]);
			return;
		}
		
		//	해당 약수들을 모두 곱해본다.
		for(int i = 0; i < n; i++){
			m[i] = new Multiple(i, dv);
		}
		
		Main.getDuplicateValue(m);
	}
}
