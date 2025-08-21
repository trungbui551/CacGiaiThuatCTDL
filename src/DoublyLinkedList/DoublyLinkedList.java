package DoublyLinkedList;



public class DoublyLinkedList {
	static node l;
	static node r;
	
	public static void insert (int x, node q) {
		node k = new node();
		k.setData(x);
		k.setLeft(null);
		k.setRight(null);
		if(l== null) {
			l=r= k;
		}else {
			if (q== l) {
				k.setRight(l);
				l.setLeft(k);
				l = k;
			}else {
				k.setLeft(q.getLeft());
				k.setRight(q);
				q.setLeft(k);
				k.getLeft().setRight(k);
			}
		}
	}
    public static void printList() {
        node tmp = l;
        while (tmp != null) {
            System.out.print(tmp.getData() + " ");
            tmp = tmp.getRight();
        }
        System.out.println();
    }
	public static void delete (node q) {
		if (l== null) {
			System.out.println("Danh sách rỗng");
		}else {
			if (q.getData()== l.getData()) {
				l= l.getRight();
				l.setLeft(null);
			}else if (q.getData()== r.getData()) {
				r= r.getLeft();
				r.setRight(null);
			}else {
				node tmp = l;
			      while (tmp != null && tmp.getData() != q.getData()) {
			            tmp = tmp.getRight();
			        }
			        if (tmp != null) {
			           tmp.getLeft().setRight(tmp.getRight());
			           tmp.getRight().setLeft(tmp.getLeft());
			        }else {
			        	System.out.println("Không tìm thấy.");
			        }
			}
		}
	}
	public static void main(String[] args) {
        insert(10, null);
        System.out.print("Danh sách sau khi thêm 10: ");
        printList();
        insert(5, l);
        System.out.print("Danh sách sau khi thêm 5 trước head: ");
        printList();
        insert(7, r);
        System.out.print("Danh sách sau khi thêm 7 trước tail: ");
        printList();
        insert(15, r);
        System.out.print("Danh sách sau khi thêm 15 trước tail: ");
        printList();
        delete(l);
        System.out.print("Danh sách sau khi xóa head: ");
        printList();
        node test = new node();
        test.setData(10);
        delete(test);
        System.out.println("Sau khi xóa "+test.getData()+ ":");
        printList();
	}
}
