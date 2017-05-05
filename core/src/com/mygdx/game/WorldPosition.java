package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class WorldPosition extends Vector2{
	/**
	 * The cursor has two different kinds of positions the position that the
	 * cursor exist on a grid the position that the cursor exist in the world
	 * 
	 * @param x
	 *            horizontal grid position
	 * @param y
	 *            vertical grid position
	 * @return the position that the cursor exist in the world
	 */
	
	WorldPosition(int x, int y) {
		Tile tile = TileManager.map[x][y];
		this.x = tile.x;
		this.y = tile.y;
		
	}
}
