package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CharacterManager {

	ArrayList<Character> list = new ArrayList<Character>();
	TileOverlayManager tom;
	
	public CharacterManager(TileManager tm) {
		tom = new TileOverlayManager(tm);
		tom.initMap();
	}
	
	public Character getCharacter(int x, int y){
		for(Character character: list){
			if(character.x == x && character.y == y){
				return character;
			}
		}
		return null;
	}

	public void update() {
		for (Entity entity : list) {
			entity.update();
		}
	}
	
	public Entity[][] getMap(){
		Entity[][] map = new Entity[tom.row][tom.col];
		for(Entity en: list){
			map[en.x][en.y] = en;
		}
		return map;
	}

	public void renderSprite() {

	}

	public void renderOutline(ShapeRenderer sr) {

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

}
