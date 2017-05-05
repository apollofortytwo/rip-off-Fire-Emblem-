package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TileOverlay extends Tile {

	TileOverlay(int x, int y) {
		super(x, y);
		color = Color.CLEAR;
	}

	public void render(ShapeRenderer sr) {
		if (color != Color.CLEAR) {
			sr.setColor(new Color(color.r, color.g, color.b, 0.5f));
			sr.rect(x, y, bounds.width, bounds.height);
		}

	}

}
