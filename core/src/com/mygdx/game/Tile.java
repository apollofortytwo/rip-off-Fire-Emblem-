package com.mygdx.game;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Tile extends Entity {
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	Color color = Color.WHITE;
	
	
	Tile(int x, int y) {
		super(x,y);
	}

	public void update() {
		
	}

	@Override
	public void renderSprites(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderShapes(ShapeRenderer sr) {
		sr.setColor(color);
		sr.rect(x, y, bounds.width, bounds.height);
		
	}
}
