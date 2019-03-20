package programs;

import java.util.Scanner;

public class Months {
	public static void main(String[] args) {

		System.out.println("Enter a number from 1 to 12");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();

		in.close();
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		if (a >= 1 && a <= 12) {
			System.out.println(months[a - 1]);
		} else {
			System.out.println("enter a valid number");
		}
	}
}
