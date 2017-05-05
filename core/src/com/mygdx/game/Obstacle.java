package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Obstacle extends Entity {
	public Obstacle(int x, int y) {
		super(x, y);
		color = Color.GRAY;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void renderSprites(SpriteBatch batch) {

	}

	@Override
	public void renderShapes(ShapeRenderer sr) {
		sr.setColor(color);
		sr.rect(wPos.x + (Tile.WIDTH) / 4, wPos.y + (Tile.HEIGHT) / 4, (Tile.WIDTH) / 2, (Tile.WIDTH) / 2);
	}

}
