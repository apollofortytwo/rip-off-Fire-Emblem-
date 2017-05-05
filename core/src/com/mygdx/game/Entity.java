package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Entity {

	public int x, y;
	public int width, height;
	public Rectangle bounds;
	public Vector2 wPos;
	public Color color;
	public int move = 8;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, Tile.WIDTH, Tile.HEIGHT);
		color = Color.WHITE;
		update();
	}

	public void update() {
		wPos = new WorldPosition(x, y);
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void renderSprites(SpriteBatch batch) {

	}

	public void renderShapes(ShapeRenderer sr) {
		sr.setColor(color);
		sr.rect(wPos.x + (Tile.WIDTH) / 4, wPos.y + (Tile.HEIGHT) / 4, (Tile.WIDTH) / 2, (Tile.WIDTH) / 2);
	}
}
