package BaiTap;

import java.util.Arrays;

public class InsertSort {

	public static void Solution(int a[]) {
		for(int i = 1; i< a.length; i++) {
			int x= a[i];
			int j = i-1;
			// Lùi j cho đến khi gặp giá trị nhỏ hơn hoặc bằng x
			while (a[j]>x&& j>=0) {
				a[j+1]= a[j];
				j--;
			if(j==-1) {
				break;
			}
			}
			//Chèn
			a[j+1]= x;
		}
	}
	public static void main(String[] args) {
		int a[]= {2,5,3,4,8,6};
		Solution(a);
		System.out.println(Arrays.toString(a));
	}

}
