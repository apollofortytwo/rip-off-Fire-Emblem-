package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Tile extends Entity {
	public static final int WIDTH = 64;
	public static final int HEIGHT = 64;
	Color color = Color.WHITE;
	int gridX, gridY;

	Tile(int gridX, int gridY, int padding) {
		super(gridX * (Tile.WIDTH + padding), gridY * (Tile.HEIGHT + padding));
		this.gridX = gridX;
		this.gridY = gridY;
	}

	public void update() {

	}

	@Override
	public void renderSprites(SpriteBatch batch) {

	}

	@Override
	public void renderShapes(ShapeRenderer sr) {
		sr.setColor(color);
		sr.rect(x, y, WIDTH, HEIGHT);

	}
}
