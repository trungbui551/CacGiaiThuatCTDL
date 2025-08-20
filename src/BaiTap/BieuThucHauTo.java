package BaiTap;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BieuThucHauTo {
	// xác định mứa độ ưu tiên của các toán tử
	public static int getDoUuTien(char toanTu) {
		switch (toanTu) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	// Chuyen Trung to thanh hau to:
	public static String getBieuThucHauTo(String bieuThuc) {
		// Xoa khoang trắng:
		bieuThuc = bieuThuc.replace(" ", "");
		String result = "";
		Stack<Character> stack = new Stack<Character>();
		boolean checkPreDigit = false;// Đánh dấu trước đó có phải số hay không
		for (int i = 0; i < bieuThuc.length(); i++) {
			char c = bieuThuc.charAt(i);

			// Nếu là số thì thêm vào kết quả
			if (Character.isDigit(c)) {
				if (checkPreDigit)
					result += c;
				else {
					result += c + " ";
				}
				checkPreDigit = true;
			} else {
				if (c == '(') {

					stack.push(c);

				} else if (c == ')') {
					// Gặp dấu đóng ngoặc -> đưa các phần tử trong stack ra
					// Cho đén khi gặp dấu đóng ngoăc
					while (!stack.isEmpty() && stack.peek() != '(') {
						result += stack.pop() + " ";

					}
					stack.pop();

				} else {

					// Nếu là toán tử
					while (!stack.isEmpty() && (getDoUuTien(c) <= getDoUuTien(stack.peek()))) {

						// độ ưu tiên của c thấp hơn đỉnh của stack-> pop các giá trị ở đỉnh stack
						result += stack.pop() + " ";
						if (stack.peek() == '(') {
							break;
						}
					}
					// Đưa c vào stack
					stack.push(c);

				}
				checkPreDigit = false;
			}

		} // Đưa tất cả các phần tử còn lại vào kết quả
		while (!stack.isEmpty()) {
			result += stack.pop() + " ";

		}
		return result;
	}

	// Hàm tính giá trị biểu thức hậu tố
	public static double tinhGiaTriBieuThuc(String ex) {
		Stack<Double> stack = new Stack<Double>();
		ex = ex.trim();
		String[] tokens = ex.split(" ");

		double r = 0;
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			// Neu la so day vao stack

			if (token.matches("\\d+")) {

				double value = Double.parseDouble(token);
				stack.push(value);

			} else {

				// token la toan tu, lay 2 so tu stack de tinh
				double b = stack.pop();
				double a = stack.pop();
				switch (token.charAt(0)) {
				case '+':
					r = a + b;
					break;
				case '-':
					r = a - b;
					break;
				case '*':
					r = a * b;
					break;
				case '/':
					r = a / b;
					break;
				case '^':
					r = Math.pow(a, b);
					break;
				}
				// Push ket qua vao stack
				stack.push(r);
			}
		}
		// Tra ve ket qua
		return stack.pop();
	}

	public static void main(String[] args) {
		String bieuThuc = "5  *  ( 7  -  3 )";
		String bieuThucHauTo = getBieuThucHauTo(bieuThuc);
		System.out.println(bieuThucHauTo);
		double kq = tinhGiaTriBieuThuc(bieuThucHauTo);
		System.out.println("Kết quả biểu thức: " + kq);
	}
}
