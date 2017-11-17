package eg.edu.alexu.csd.datastructure.maze.cs49;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		MazeSolver m =new MazeSolver();
		File maze =new File("maze.txt");
		m.solveBFS(maze);

	}

}
