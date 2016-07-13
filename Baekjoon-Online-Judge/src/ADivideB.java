/**
 *	A / B
 *	https://www.acmicpc.net/problem/1008
 *	2016-07-13
 */
import java.util.Scanner;
public class ADivideB {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double r = a / b;
		
		System.out.printf("%.10f", r);
	}
}
