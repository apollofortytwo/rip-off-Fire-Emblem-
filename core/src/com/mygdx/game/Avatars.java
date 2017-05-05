package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Avatars extends Entity {
	public int move = 5;

	public Avatars(int x, int y) {
		super(x, y);

		width = 50;
		height = 20;
		color = Color.WHITE;

	}

	@Override
	public void renderSprites(SpriteBatch batch) {

	}



	@Override
	public void update() {
		super.update();
	}
}
