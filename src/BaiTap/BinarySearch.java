package BaiTap;

public class BinarySearch {

	public static int binarySearch(int []k, int t, int p , int x) {
		if(t>p) 
			return -1;
		else {
			int g=(t+p)/2;
			if(x ==k[g]) {
				return g;
			}if (x< k[g]) {
				return binarySearch(k, t, g-1, x);
			
			}else {
				 return binarySearch(k, g+1, p, x);
			}
		}
	
	}
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6,7};
		System.out.println(binarySearch(a, 0, 6, 7));
	}
}
