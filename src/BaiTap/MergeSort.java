package BaiTap;

import java.util.Arrays;

public class MergeSort {

	public static int[] merge(int[] a, int L, int R) {
		if (L == R) {
			int[] newArr = { a[L] };
			return newArr;
		}
		int Mid = (L + R) / 2;
		int[] mang1 = merge(a, L, Mid);
		int[] mangcon2 = merge(a, Mid + 1, R);

		// Da hoan thanh buoc chia
		// =>thuc hien tron (hay dua 2 mang da sap xep vao mot mang)
		int k = 0;
		int i = 0;
		int n = mang1.length;
		int m = mangcon2.length;
		int j = 0;
		int[] gop = new int[m + n];
		while (k < (n + m)) {
			if (i <= (n - 1) && j <= (m - 1)) {
				if (mang1[i] < mangcon2[j]) {
					gop[k++] = mang1[i++];
				} else {
					gop[k++] = mangcon2[j++];
				}
			} else {// mot trong 2 mang rong
				if (i < n) {
					gop[k++] = mang1[i++];
				} else {
					gop[k++] = mangcon2[j++];
				}
			}
		}

		return gop;
	}

	public static int[] nergeSort(int[] a) {
		return merge(a, 0, a.length - 1);
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 8, 12, 3, 4 };
		int[] kq = nergeSort(a);
		System.out.println(Arrays.toString(kq));
	}

}
