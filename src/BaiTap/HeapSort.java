package BaiTap;

import java.util.Arrays;

public class HeapSort {

	// Hàm chuyền cây tạo từ mảng thành đống
	public static void ADJUST(int a[],int r, int n) {
	
		int v = a[r];
		while (r * 2 <= n - 2) {
			int c = r * 2 + 1;
			if (c < n - 1 && a[c] < a[c + 1]) {
				c = c + 1; // Chon nut max
			}
			if (a[c] < v) {
				break;
			}
			a[r] = a[c];
			r = c;
		}
		a[r] = v;
	
	}
	public static void heapSort (int a[]) {
		int n = a.length;
		for (int i=(n-2)/2 ; i>=0; i--) {
			ADJUST(a, i, n);
		}
		for (int i =n-1; i>0; i--) {
			int x = a[0];
			a[0]=a[i];
			a[i]=x;
			ADJUST(a, 0, i);
		}
	}
	public static void main(String[] args) {
		int a[] = {2,4,6,3,1,7,88,34};
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}
