package BaiTap;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

	public static void selectionSort(int []a, int n) {
		for (int i = 0; i< n-1 ; i++) {
			int m  = i;// gán min ban đầu trùng vị trí i
			for (int j = i+1; j< n; j++) {
				if(a[j]<a[m]) { // có một giá trị nhỏ hơn giá trị min
					m=j; // gán vị trí của giá trị min
				}
			}
			if (i<m) {
				// Hoán đổi giá trị i và m
				int temp = a[i];
				a[i]=a[m];
				a[m]=temp;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Nhập số phần tử của mảng");
		n = sc.nextInt();
		int a[]=new int [n];
		for(int i = 0; i< n ; i++) {
			System.out.println("Nhap phan tu:");
			a[i]= sc.nextInt();
		}
		System.out.println(Arrays.toString(a));
		selectionSort(a, n);
		System.out.println("Sau khi sắp xếp:");
		System.out.println(Arrays.toString(a));
		
	}
}
