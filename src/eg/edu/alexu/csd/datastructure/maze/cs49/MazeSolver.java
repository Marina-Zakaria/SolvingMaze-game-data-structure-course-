package eg.edu.alexu.csd.datastructure.maze.cs49;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import eg.edu.alexu.csd.datastructure.linkedList.cs49.SinglyLinkedList;
import eg.edu.alexu.csd.datastructure.stack.cs49.Stack;
import eg.edu.alexu.csd.datastructure.queue.cs49.LinkedBasedQ;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;

public class MazeSolver implements IMazeSolver {
	private static int numberRows;
	private static int numberColumns;

	@Override
	public int[][] solveBFS(final File maze) {
		String[] grid = this.read(maze);
		if (grid.length != numberRows) {
			throw null;
		}
		for (int i = 0; i < grid.length; i++) {
			if (grid[i].length() != numberColumns) {
				throw null;
			}
		}
		boolean[][] visited = new boolean[numberRows][numberColumns];
		LinkedBasedQ cells = new LinkedBasedQ();
		Point[][] parents = new Point[100][];
		int index = 0;
		SinglyLinkedList result = new SinglyLinkedList();
		Point current = new Point();
		boolean founds = false;
		boolean founde = false;
		for (int i = 0; i < grid.length; i++) {
			if (!founds || !founde) {
				for (int j = 0; j < grid[i].length(); j++) {
					if (grid[i].charAt(j) == 'S') {
						current.setLocation(i, j);
						founds = true;

					} else if (grid[i].charAt(j) == 'E') {
						founde = true;

					}
				}
			}
		}
		if (!founde || !founds) {
			throw null;
		}
		cells.enqueue(current);
		Point start = current;
		visited[current.x][current.y] = true;
		boolean solved = false;
		while (!cells.isEmpty()) {
			current = (Point) cells.dequeue();
			visited[current.x][current.y] = true;
			if (grid[current.x].charAt(current.y) == 'E') {
				solved = true;
				break;
			} else {
				int x = current.x;
				int y = current.y;

				if ((x - 1) >= 0 && grid[x - 1].charAt(y)
						!= '#' && !visited[x - 1][y]) {
					Point next = new Point(x - 1, y);
					cells.enqueue(next);
					parents[index] = new Point[2];
					parents[index][0] = next;
					parents[index++][1] = current;
				}
				if (grid.length > (x + 1) && grid[x + 1].charAt(y) 
						!= '#' && !visited[x + 1][y]) {
					Point next = new Point(x + 1, y);
					cells.enqueue(next);
					parents[index] = new Point[2];
					parents[index][0] = next;
					parents[index++][1] = current;
				}
				if (0 <= (y - 1) && grid[x].charAt(y - 1) != '#' && !visited[x][y - 1]) {
					Point next = new Point(x, y - 1);
					cells.enqueue(next);
					parents[index] = new Point[2];
					parents[index][0] = next;
					parents[index++][1] = current;
				}
				if (grid[x].length() > (y + 1) && grid[x].charAt(y + 1)
						!= '#' && !visited[x][y + 1]) {
					Point next = new Point(x, y + 1);
					cells.enqueue(next);
					parents[index] = new Point[2];
					parents[index][0] = next;
					parents[index++][1] = current;
				}
			}
		}
		if (!solved) {
			return null;
		}
		while (current != start) {
			for (int k = index - 1; k >= 0; k--) {
				if (current == parents[k][0]) {
					result.add(current);
					current = parents[k][1];
					break;
				}
			}
		}
		result.add(start);
		int[][] path = new int[result.size][];
		index = 0;
		for (int i = result.size - 1; i >= 0; i--) {
			path[index] = new int[2];

			path[index][0] = ((Point) (result.get(i))).x;

			path[index++][1] = ((Point) (result.get(i))).y;
		}

		return path;
	}

	@Override
	public int[][] solveDFS(final File maze) {
		boolean solved = false;
		String[] grid = this.read(maze);
		if (grid.length != numberRows) {
			throw null;
		}
		for (int i = 0; i < grid.length; i++) {
			if (grid[i].length() != numberColumns) {
				throw null;
			}
		}
		boolean[][] visited = new boolean[numberRows][numberColumns];
		Stack cells = new Stack();
		SinglyLinkedList result = new SinglyLinkedList();
		Point current = new Point();
		boolean founds = false;
		boolean founde = false;
		for (int i = 0; i < grid.length; i++) {
			if (!founds || !founde) {
				for (int j = 0; j < grid[i].length(); j++) {
					if (grid[i].charAt(j) == 'S') {
						current.setLocation(i, j);
						founds = true;

					} else if (grid[i].charAt(j) == 'E') {
						founde = true;

					}
				}
			}
		}
		if (!founde || !founds) {
			throw null;
		}
		cells.push(current);
		visited[current.x][current.y] = true;
		while (!cells.isEmpty()) {
			current = (Point) cells.pop();
			if (result.size > 1) {
				boolean check;
				Point pre = (Point) result.get(result.size - 1);
				check = (pre.x == current.x && Math.abs(pre.y - current.y) == 1)
						|| (pre.y == current.y && Math.abs(pre.x - current.x) == 1);
				do {
					if (!check) {
						result.remove(result.size - 1);
					}
					pre = (Point) result.get(result.size - 1);
					check = (pre.x == current.x && Math.abs(pre.y - current.y) == 1)
							|| (pre.y == current.y && Math.abs(pre.x - current.x) == 1);
				} while (!check);

			}
			result.add(current);
			visited[current.x][current.y] = true;
			if (grid[current.x].charAt(current.y) == 'E') {
				solved = true;
				break;
			} else {
				boolean deadEnd = true;
				int x = current.x;
				int y = current.y;
				if (0 <= (y - 1) && grid[x].charAt(y - 1) != '#' && !visited[x][y - 1]) {
					Point next = new Point(x, y - 1);
					cells.push(next);
					deadEnd = false;
				}
				if (grid[x].length() > (y + 1) && grid[x].charAt(y + 1) != '#' && !visited[x][y + 1]) {
					Point next = new Point(x, y + 1);
					cells.push(next);
					deadEnd = false;
				}

				if ((x - 1) >= 0 && grid[x - 1].charAt(y) != '#' && !visited[x - 1][y]) {
					Point next = new Point(x - 1, y);
					cells.push(next);
					deadEnd = false;
				}
				if (grid.length > (x + 1) && grid[x + 1].charAt(y) != '#' && !visited[x + 1][y]) {
					Point next = new Point(x + 1, y);
					cells.push(next);
					deadEnd = false;
				}

				if (deadEnd) {
					result.remove(result.size - 1);
				}
			}
		}
		if (!solved) {
			return null;
		}
		int[][] path = new int[result.size][];
		for (int i = 0; i < result.size; i++) {
			path[i] = new int[2];

			path[i][0] = ((Point) (result.get(i))).x;

			path[i][1] = ((Point) (result.get(i))).y;
		}

		return path;
	}

	/**
	 * read from file.
	 * @param maze
	 *            file containing the maze required to be solved
	 * @return array of Strings
	 */
	public static String[] read(final File maze) {
		BufferedReader br;
		FileReader fr;

		try {
			fr = new FileReader(maze);
			br = new BufferedReader(fr);
			String line = br.readLine();
			String[] descriotion = new String[2];

			descriotion = line.split(" ");
			numberRows = Integer.parseInt(String.valueOf(descriotion[0]));
			numberColumns = Integer.parseInt(String.valueOf(descriotion[1]));
			String[] grid = new String[numberRows];

			line = br.readLine();
			int i = 0;
			while (line != null) {
				grid[i++] = line;
				line = br.readLine();

			}
			return grid;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
