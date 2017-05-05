package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class EntityManager {

	ArrayList<Entity> enList = new ArrayList<Entity>();
	TileOverlayManager tom;
	
	public EntityManager(TileManager tm) {
		tom = new TileOverlayManager(tm);
		tom.initMap();
	}
	
	public Entity getEntity(int x, int y){
		for(Entity entity: enList){
			if(entity.x == x && entity.y == y){
				return entity;
			}
		}
		return null;
	}

	public void update() {
		for (Entity entity : enList) {
			entity.update();
		}
	}
	
	public Entity[][] getMap(){
		Entity[][] map = new Entity[tom.row][tom.col];
		for(Entity en: enList){
			map[en.x][en.y] = en;
		}
		return map;
	}

	public void renderSprite() {

	}

	public void renderOutline(ShapeRenderer sr) {
		for (Entity entity : enList) {
			entity.renderShapes(sr);
		}
		
		tom.renderBlanket(sr);
	}

	public void addEntity(Entity entity) {
		enList.add(entity);
	}

}
