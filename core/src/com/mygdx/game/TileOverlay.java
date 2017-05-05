package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TileOverlay extends Entity {

	TileOverlay(int x, int y) {
		super(x, y);
		color = Color.CLEAR;
		update();
	}

	public void render(ShapeRenderer sr) {
		if (color != Color.CLEAR) {
			sr.setColor(new Color(color.r, color.g, color.b, 0.5f));
			sr.rect(wPos.x, wPos.y, bounds.width, bounds.height);
		}

	}

	@Override
	public void update() {
		wPos = new WorldPosition(x,y);
	}

	@Override
	public void renderSprites(SpriteBatch batch) {
		
	}

	@Override
	public void renderShapes(ShapeRenderer sr) {
		
	}

}
