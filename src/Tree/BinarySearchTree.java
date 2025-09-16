package Tree;

import java.util.Scanner;

public class BinarySearchTree {
	public static void BTS(Root T, int x) {
		Root Q = new Root();
		Root P = T;

		while (P != null) {

			if (x == P.getData()) {
				System.out.println("Đã tìm thấy!");
				return;
			}

			Q = P;
			
			if (x < P.getData()) {
				P = P.getLeft();
			} else {
				P = P.getRight();
			}
		}
		P = new Root();
		P.setData(x);
		P.setLeft(null);
		P.setRight(null);
		if (T == null) {// Cây rỗng
			T = P;// Nút mới chính là gốc
		} else {
		
			if (x < Q.getData()) {
				Q.setLeft(P);
			} else {
				Q.setRight(P);
			}
			System.out.println("Không tìm thấy, đã bổ sung "+ P.getData());
		}
	}

	public static Root BST_Delete(Root T, int x) {
		Root P = T;
		Root Q = null;
		while (P != null) {
			if (x == P.getData()) {
				break;
			}
			Q = P;
			if (x < P.getData()) {
				P = P.getLeft();
			} else {
				P = P.getRight();
			}

		}
		if (P == null) {
			return T;
		}
		// P có cả hai cây con
		if (P.getLeft() != null && P.getRight() != null) {
			Root Node = P;
			Q = P;
			P = P.getLeft();
			while (P.getRight() != null) {
				Q = P;
				P = P.getRight();
			}
			Node.setData(P.getData());

		}
		Root Child;
		if (P.getLeft() != null) {
			Child = P.getLeft();
		} else {
			Child = P.getRight();
		}
		if (P == T) {
			T = Child;
		} else {
			if (Q.getLeft() == P) {
				Q.setLeft(Child);
			} else {
				Q.setRight(Child);
			}
		}
		return T;
	}

	// Duyệt cây:
	public static void TT_truoc(Root root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			TT_truoc(root.getLeft());
			TT_truoc(root.getRight());
		}
	}
	// Hàm chuyển mảng qua cây:

	public static Root add(Root root, int x) {
		Root newNode = new Root(x);
		if (root == null) {
			root = newNode;
			return root;

		} else {
			Root temp = root;
			while (true) {
				if (x > temp.getData()) {
					if (temp.getRight() == null) {
						
						temp.setRight(newNode);
				
						break;
					} else {
						temp = temp.getRight();
					}
				} else {
					if (temp.getLeft() == null) {
						temp.setLeft(newNode);
						
						break;
					} else {
						temp = temp.getLeft();
					}
				}

			}
			return root;
		}
	}
	// Thêm phần tử vào Cây nhị phân

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = { 1,2,3,4,5,6,7,8};
		Root T = new Root();
		for(int i = 0  ;i < 8 ; i++) {
			T = add(T, a[i]);
		}
		
		System.out.println("Nhập phần tử cần tìm kiếm: ");
		int x = sc.nextInt();
		BTS(T, x);
		System.out.println("Nhập phần tử cần xóa");
		int y = sc.nextInt();
		Root Q = BST_Delete(T, y);
		TT_truoc(Q);
	}
}
