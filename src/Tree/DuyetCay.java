package Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DuyetCay {
	// Duyệt đệ quy:
	public static void TT_truoc(Root root) {
		if (root != null) {
			System.out.println(root.getData() + " ");
			TT_truoc(root.getLeft());
			TT_truoc(root.getRight());
		}
	}

	// Hàm chuyển mảng qua cây:
	public static Root chuyenMangQuaTree(int a[]) {
		if (a.length == 0) {
			return null;
		}
		Root root = new Root(a[0]);
		Queue<Root> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (i < a.length) {
			Root curent = queue.poll();
			if (i < a.length) {
				curent.setLeft(new Root(a[i++]));
				queue.add(curent.getLeft());
			}
			if (i < a.length) {
				curent.setRight(new Root(a[i++]));
				queue.add(curent.getRight());
			}
		}
		return root;
		// Duyệt không đệ quy:
	}

	public static void TT_truoc2(Root root) {
		Stack<Root> stack = new Stack<Root>();
		if (root == null) {
			System.out.println("Cây rỗng");
		} else {

			stack.push(root);
		}
		while (!stack.isEmpty()) {
			root = stack.pop();
			while (root != null) {
				System.out.println(root.getData());
				if (root.getRight() != null) {
					stack.push(root.getRight());
				}
				root = root.getLeft();
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		// TT_truoc(chuyenMangQuaTree(a));
		TT_truoc2(chuyenMangQuaTree(a));
	}
}
