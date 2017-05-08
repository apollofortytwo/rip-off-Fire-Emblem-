package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TileOverlayManager {

	public TileOverlay[][] map;
	int row, col;
	
	TileOverlayManager(){
		row = TileManager.ROW;
		col = TileManager.COL;
		map = new TileOverlay[row][col];
		initMap();
	}
	
	public void initMap() {
		map = new TileOverlay[row][col];
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				map[x][y] = new TileOverlay(x,y);
			}
		}
	}
	
	public void resetColour() {
		for(TileOverlay[] x: map){
			for(TileOverlay y: x){
				y.color = Color.CLEAR;
			}
		}
		
	}

	public void renderShape(ShapeRenderer sr) {
		
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
	
	public void update(){
		for(TileOverlay[] x: map){
			for(TileOverlay y: x){
				y.update();
			}
		}
	}
}
