package BaiTap;

public class ThapHaNoiSolution {
	
	public static void thapHaNoi(int n, String A, String B, String C) {
		if (n==1 ) {
			System.err.println(A+"->"+C);
		}
		else {
			thapHaNoi(n-1, A, C, B);
			System.out.println(A+"->"+C);
			thapHaNoi(n-1, B, A, C);
		}
	}
public static void main(String[] args) {
	thapHaNoi(4, "A", "B", "C");
}
}
