package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Character extends Entity {
	public int move = 5;

	public Character(int x, int y) {
		super(x, y);
		update();
	}

	@Override
	public void renderSprites(SpriteBatch batch) {

	}

	@Override
	public void update() {
		wPos = new WorldPosition(x,y);
	}

	@Override
	public void renderShapes(ShapeRenderer sr) {
		sr.setColor(color);
		sr.rect(wPos.x + (Tile.WIDTH) / 4, wPos.y + (Tile.HEIGHT) / 4, (Tile.WIDTH) / 2, (Tile.WIDTH) / 2);
	}
}
