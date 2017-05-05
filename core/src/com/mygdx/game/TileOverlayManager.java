package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TileOverlayManager {

	public TileOverlay[][] map;
	int row, col;
	TileManager tm;
	
	TileOverlayManager(TileManager tm){
		this.tm = tm;
		row = tm.width;
		col = tm.height;
		map = new TileOverlay[row][col];
	}
	
	public void initMap() {
		for (int x = 0; x < tm.width; x++) {
			for (int y = 0; y < tm.height; y++) {
				map[x][y] = new TileOverlay(x * (Tile.WIDTH + tm.padding), y * (Tile.HEIGHT + tm.padding));
			}
		}
	}
	
	
	public void renderBlanket(ShapeRenderer sr){
	
		Gdx.gl.glEnable(Gdx.gl.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		sr.end();
		sr.begin(ShapeRenderer.ShapeType.Filled);
		
		for(TileOverlay[] x: map){
			for(TileOverlay y: x){
				y.render(sr);
			}
		}
		sr.end();
		sr.begin(ShapeRenderer.ShapeType.Line);
		
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
	
	public void resetColour() {
		for(TileOverlay[] x: map){
			for(TileOverlay y: x){
				y.color = Color.CLEAR;
			}
		}
		
	}
}
