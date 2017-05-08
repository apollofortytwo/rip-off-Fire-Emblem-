package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CharacterManager extends Manager<Character>{
	TileOverlayManager tom;
	
	public CharacterManager() {
		super();
		tom = new TileOverlayManager();
	}
	
	public void update() {
		for (Entity entity : list) {
			entity.update();
		}
	}
	
	public Character[][] getMap(){
		Character[][] map = new Character[TileManager.ROW][TileManager.COL];
		for(Character en: list){
			map[en.x][en.y] = en;
		}
		return map;
	}


	public void addCharacter(Character character) {
		list.add(character);
	}

	public void renderShape(ShapeRenderer sr) {
		for (Entity entity : list) {
			entity.renderShapes(sr);
		}
		
		tom.renderShape(sr);
	}

	@Override
	public void generateList() {
		
	}

	@Override
	public void initMap() {
		map = getMap();
	}

}
