package Tree;

public class Root {

	private int data;
	private Root left;
	private Root right;

	public Root(int data, Root left, Root right) {

		this.data = data;
		this.left = left;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Root getLeft() {
		return left;
	}

	public void setLeft(Root left) {
		this.left = left;
	}

	public Root(int data) {

		this.data = data;
	}

	public Root getRight() {
		return right;
	}

	public void setRight(Root right) {
		this.right = right;
	}

}
