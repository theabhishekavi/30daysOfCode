import java.util.Scanner;

public class Medel {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			int max = -1, min = 110, c1 = -1, c2 = -1;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] > max) {
					max = arr[i];
					c1 = i;

				}
				if (arr[i] < min) {
					min = arr[i];
					c2 = i;
				}
			}
			if (c1 < c2)
				System.out.println(max + " " + min);
			else
				System.out.println(min + " " + max);
			t--;
		}
	}
}
