package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * contains the all the tiles and organizes them into the grid
 * this class is the medium allowing us to manipulate all the tiles in the game
 * @author 499154010
 *
 */
public class TileManager {


	public static Tile[][] map;
	int width, height;
	int padding = 2;
	
	/**
	 * 
	 * @param width the length of the tiles across
	 * @param height the length of tiles vertically
	 * @param cam the camera allowing us 
	 */
	TileManager(int width, int height) {
		map = new Tile[width][height];
		this.width = width;
		this.height = height;
	}

	/**
	 * given the width and height the map is created 
	 */
	public void initMap() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				map[x][y] = new Tile(x * (Tile.WIDTH + padding), y * (Tile.HEIGHT + padding));
			}
		}
	}
	
	/**
	 * the basic framework for all the tiles
	 * calls the render method for all the tiles
	 * @param sr ShapeRenderer
	 */
	public void renderOutline(ShapeRenderer sr){
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				map[x][y].renderOutline(sr);
			}
		}
	}

	/**
	 * 
	 */
	public void update() {
		
		
		
//		if (Gdx.input.isTouched()) {
//			float mouseX = Gdx.input.getX();
//			float mouseY = Gdx.input.getY();
//			Vector3 cords = new Vector3(mouseX,mouseY,0);
//			cam.unproject(cords);
//			System.out.println(cords);
//			
//			for (int x = 0; x < width; x++) {
//				for (int y = 0; y < height; y++) {
//					if(map[x][y].bounds.contains(cords.x,cords.y)){
//						map[x][y].color = Color.BLUE;
//					}
//				}
//			}	
//			
//		}
	
	}

	public void resetColour() {
		for(Tile[] x: map){
			for(Tile y: x){
				y.color = Color.LIGHT_GRAY;
			}
		}
		
	}
	
}
