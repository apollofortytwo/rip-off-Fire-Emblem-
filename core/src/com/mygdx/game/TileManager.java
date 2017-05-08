package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * contains the all the tiles and organizes them into the grid this class is the
 * medium allowing us to manipulate all the tiles in the game
 * 
 * @author 499154010
 *
 */
public class TileManager extends Manager<Tile> {
	public static final int ROW = 500;
	public static final int COL = 500;
	int padding = 2;

	/**
	 * 
	 * @param width
	 *            the length of the tiles across
	 * @param height
	 *            the length of tiles vertically
	 * @param cam
	 *            the camera allowing us
	 */
	TileManager() {
		super();
	}

	public void generateList() {
		for (int x = 0; x < ROW; x++) {
			for (int y = 0; y < COL; y++) {
				list.add(new Tile(x, y, padding));
			}
		}
	}

	/**
	 * given the width and height the map is created
	 */
	public void initMap() {
		map = new Tile[ROW][COL];
		for (Tile tile : this.list) {
			map[tile.gridX][tile.gridY] = tile;
		}
	}

	/**
	 * the basic framework for all the tiles calls the render method for all the
	 * tiles
	 * 
	 * @param sr
	 *            ShapeRenderer
	 */
	public void renderShape(ShapeRenderer sr) {
		for (int x = 0; x < ROW; x++) {
			for (int y = 0; y < COL; y++) {
				map[x][y].renderShapes(sr);
			}
		}
	}

	public void resetColour() {
		for (Tile[] x : map) {
			for (Tile y : x) {
				y.color = Color.LIGHT_GRAY;
			}
		}
	}

	public void update() {

	}

}
