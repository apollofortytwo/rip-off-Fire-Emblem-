package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ObstacleManager {
	Obstacle[][] obstacleMap;
	
	int row, col;

	ObstacleManager() {
		row = TileManager.ROW;
		col = TileManager.COL;
		obstacleMap = new Obstacle[row][col];
	}

	public void addObstacle(int x, int y) {
		obstacleMap[x][y] = new Obstacle(x,y);
	}

	public void renderShape(ShapeRenderer sr) {
		sr.end();
		sr.begin(ShapeRenderer.ShapeType.Filled);

		for (Obstacle[] x : obstacleMap) {
			for (Obstacle y : x) {
				if (y != null) {
					y.renderShapes(sr);
				}
			}
		}

		sr.end();
		sr.begin(ShapeRenderer.ShapeType.Line);
	}

}
