package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	public int x, y;
	public int width, height;
	public Rectangle bounds;
	public Vector2 wPos;
	public Color color;
	
	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, Tile.WIDTH, Tile.HEIGHT);
		color = Color.WHITE;
	}

	public abstract void update();

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void renderSprites(SpriteBatch batch);

	public abstract void renderShapes(ShapeRenderer sr);
}
