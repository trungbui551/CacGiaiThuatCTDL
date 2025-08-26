package BaiTap;


import java.util.Arrays;

public class QuickSort {

	public static void qSort(int[] a, int iL, int iR) {
		// chon khoa
		int mid = (iL + iR) / 2;
		int key = a[mid];
		if (iL >= iR) {
			return;
		}
		// phan bo lai mang
		int k = partition(a, iL, iR, key);
		// chia doi mang=>lap lai
		qSort(a, iL, k - 1);
		qSort(a, k, iR);
	}

	private static int partition(int[] a, int iL, int iR, int key) {
		while (iL <= iR) {
			while (a[iL] < key) {
				iL++;
			}
			while (a[iR] > key) {
				iR--;
			}
			if (iL <= iR) {
				int temp = a[iL];
				a[iL] = a[iR];
				a[iR] = temp;
				iL++;
				iR--;
			}
		}
		return iL;
	}

	public static void main(String[] args) {
		int[] a = { 9, 4, 3, 5,12};
		qSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

	}
}
