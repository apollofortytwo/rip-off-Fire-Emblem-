package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class MoveSpread {
	public static ArrayList<Vector2> moves(int x, int y, int moves) {
		ArrayList<Vector2> cords = new ArrayList<Vector2>();
		tree(cords, x, y, moves);
		return cords;
	}

	private static void tree(ArrayList<Vector2> cords, int x, int y, int moves) {
		cords.add(new Vector2(x, y));

		if (moves > 0) {
			tree(cords, x - 1, y, moves - 1);
			tree(cords, x + 1, y, moves - 1);
			tree(cords, x, y + 1, moves - 1);
			tree(cords, x, y - 1, moves - 1);
		}
	}
	
	public static ArrayList<Vector2> movesWithObstacle(ObstacleManager omb, int x, int y, int moves) {
		ArrayList<Vector2> cords = new ArrayList<Vector2>();
		tree(cords, x, y, moves);
		return cords;
	}
	

}
