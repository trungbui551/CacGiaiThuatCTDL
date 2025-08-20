package BaiTapTong2DaThucDSLK;

public class Cong2BieuThuc {
	static Node c = null; // head
	static Node d = null; // tail

//Bổ sung phần tử mới vào đa thức tổng
	public static void ATTACK(int h, int m) { // add tail
		Node T = new Node();
		T.setCOEF(h);
		T.setEXP(m);
		if (c == null) {
			c = d = T;
		} else {
			d.setNEXT(T);
			d = T;
		}
	}

	// Hàm cộng 2 phần tử
	public static void PADD(Node a, Node b) {
		Node P = a;
		Node Q = b;
		while (P != null && Q != null) {
			// Cùng số mũ
			if (P.getEXP() == Q.getEXP()) {
				int h = P.getCOEF() + Q.getCOEF();
				if (h != 0) {// Khác không thì thêm vào c
					ATTACK(h, P.getEXP());
				}
				P = P.getNEXT();
				Q = Q.getNEXT();
			} else {
				// Khác số mũ:
				if (P.getEXP() > Q.getEXP()) {
					// số mũ ở p lớn hơn q
					ATTACK(P.getCOEF(), P.getEXP());
					P = P.getNEXT();
				} else {
					// Ngược lại:
					ATTACK(Q.getCOEF(), Q.getEXP());
					Q = Q.getNEXT();
				}
			}
		}
		// Một trong 2 biểu thức đã được cộng hết:
		if (Q == null) {
			while (P != null) {
				ATTACK(P.getCOEF(), P.getEXP());
				P = P.getNEXT();
			}
		} else {
			while (Q != null) {
				ATTACK(Q.getCOEF(), Q.getEXP());
				Q = Q.getNEXT();
			}
			d.setNEXT(null);
		}
	}

	public static Node taoDaThuc(int[][] terms) {
		// terms: mảng gồm {hệ số, số mũ}
		Node head = null, tail = null;
		for (int[] term : terms) {
			Node T = new Node();
			T.setCOEF(term[0]);
			T.setEXP(term[1]);
			if (head == null) {
				head = tail = T;
			} else {
				tail.setNEXT(T);
				tail = T;
			}
		}
		return head;
	}

	public static void inDaThuc(Node head) {
		Node p = head;
		while (p != null) {
			System.out.print(p.getCOEF() + "x^" + p.getEXP());
			if (p.getNEXT() != null)
				System.out.print(" + ");
			p = p.getNEXT();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node A = taoDaThuc(new int[][] { { 3, 4 }, { 2, 3 }, { 1, 1 } });

		// Tạo đa thức B = 5x^3 + 2x^1 + 7
		Node B = taoDaThuc(new int[][] { { 5, 3 }, { 2, 1 }, { 7, 0 } });
		System.out.print("Da thuc A: ");
		inDaThuc(A);

		System.out.print("Da thuc B: ");
		inDaThuc(B);
		PADD(A, B);

		// In kết quả
		System.out.print("Tong A + B = ");
		inDaThuc(c);

	}
}
