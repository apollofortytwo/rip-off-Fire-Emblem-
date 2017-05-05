package com.mygdx.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.math.Vector2;

public class MoveSpread {
	public static ArrayList<Vector2> moves(int x, int y, int moves) {
		ArrayList<Vector2> cords = new ArrayList<Vector2>();
		tree(cords, x, y, moves);
		return removeDups(cords);
	}

	private static void tree(ArrayList<Vector2> cords, int x, int y, int moves) {
			cords.add(new Vector2(x,y));
		

		if (moves > 0) {
			tree(cords, x - 1, y, moves - 1);
			tree(cords, x + 1, y, moves - 1);
			tree(cords, x, y + 1, moves - 1);
			tree(cords, x, y - 1, moves - 1);
		}
	}
	
	
	public static ArrayList<Vector2> removeDups(ArrayList<Vector2> list){
		Set<Vector2> hs = new HashSet<Vector2>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		return list;
		
	}
	
	public static ArrayList<Vector2> movesWithObstacle(ObstacleManager omb, int x, int y, int moves) {
		ArrayList<Vector2> cords = new ArrayList<Vector2>();
		tree(cords, x, y, moves);
		return cords;
	}
	

}
