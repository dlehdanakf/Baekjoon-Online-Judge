/**
 *	박사과정
 *	https://www.acmicpc.net/problem/5026
 *	2016-07-16
 */
package PhDCourse;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void calculate(String str){
		String query = "^([0-9]+)\\+([0-9]+)()$";
		Pattern p = Pattern.compile(query);
		
		Matcher m = p.matcher(str);
		if(m.matches()){
			int a = Integer.valueOf(m.group(1));
			int b = Integer.valueOf(m.group(2));
			
			System.out.println(a + b);
		} else {
			System.out.println("error");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] questions = new String[num];
		String pnp = new String("P=NP");
		
		sc.nextLine();
		
		for(int i = 0; i < num; i++){
			questions[i] = sc.nextLine();
		}
		
		for(int i = 0; i < num; i++){
			if(questions[i].equals(pnp)){
				System.out.println("skipped");
			} else {
				Main.calculate(questions[i]);
			}
		}
	}
}
