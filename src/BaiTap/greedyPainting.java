package BaiTap;

public class greedyPainting {

	public static void toMauDoThi(int g[][], int n) {
		int color[] = new int[n];
		for (int u = 0; u < n; u++) {
			boolean checkNeighborU[] = new boolean[n];
			for (int v = 0; v < n; v++) {
				if (g[u][v] == 1 && color[v] != 0) {
					checkNeighborU[color[v]] = true;
				}
			}
			int minColor = 1;
			while (checkNeighborU[minColor] == true) {
				minColor++;
			}
			color[u] = minColor;

		}
		for (int i = 0; i < n; i++) {
			System.out.println("vertex " + i + " is covered by: " + color[i]);
		}
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 0, 0 }, { 0, 1, 0, 1, 1, 0 }, { 1, 1, 1, 0, 1, 1 },
				{ 0, 0, 1, 1, 0, 1 }, { 0, 0, 0, 1, 1, 0 } };
		toMauDoThi(graph, 6);
	}
}
