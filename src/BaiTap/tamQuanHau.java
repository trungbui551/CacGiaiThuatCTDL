package BaiTap;
import java.util.HashMap;
import java.util.Map;

public class tamQuanHau {

	public static void Giai(int j, int a[], int b[], Map<Integer,Integer>c, int x[]) {
	
	
		
	
		for (int i = 1; i<= 8 ; i++) {
			
			if (a[i]==0&&b[i+j]==0&&c.get(i-j)==0) {
				x[j]=i;
				a[i]=b[i+j]=1;
				c.put(i-j, 1);
			if (j<8) {
				Giai(j+1, a, b, c,x);
			}else {
				for(int k = 1; k<= 8 ; k++) {
					System.out.print(x[k]+" ");
					
				}
				System.out.println();
				//thu hoi hau de tiep tuc chay vong lap moi
			
			}
			a[i]=b[i+j]=0;
			c.put(i-j, 0);
			}
		}
	}
	public static void main(String[] args) {
		 int a []=new int [9];
		 int b[] = new int [17];
		Map<Integer, Integer> c=new HashMap<>()	;
		int x[]= new int [9];
		for (int z = -7; z<= 7; z++) {
			c.put(z, 0);
		}
		Giai(1, a, b, c,x);
	}
}
