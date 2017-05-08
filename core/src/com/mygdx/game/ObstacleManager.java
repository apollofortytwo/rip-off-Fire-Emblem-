package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ObstacleManager extends Manager<Obstacle> {
	int row, col;

	ObstacleManager() {
		super();
		row = TileManager.ROW;
		col = TileManager.COL;
	}

	public void addObstacle(int x, int y) {
		list.add(new Obstacle(x,y));
	}

	public void renderShape(ShapeRenderer sr) {
		sr.end();
		sr.begin(ShapeRenderer.ShapeType.Filled);
		
		
		for(Obstacle ob: list){
			ob.renderShapes(sr);
		}

		sr.end();
		sr.begin(ShapeRenderer.ShapeType.Line);
	}

	@Override
	public void generateList() {
		
	}

	@Override
	public void initMap() {
		for(Obstacle ob: list){
			map[ob.x][ob.y] = ob;
		}
	}

	@Override
	public void update() {
		super.update();
		
		map = new Obstacle[row][col];
		for(Obstacle ob: list){
			map[ob.x][ob.y] = ob;
		}
	}

}
