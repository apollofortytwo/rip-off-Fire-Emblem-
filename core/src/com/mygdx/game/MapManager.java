package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * A map manager takes care of all the managers required for the game to operate
 * 
 * 
 * @author 499154010
 *
 */
public class MapManager {
	OrthographicCamera cam;
	CharacterManager cm;
	TileManager tm;
	TileOverlayManager tom;
	ObstacleManager omb;
	Cursor cursor;
	boolean lockOn = false;
	MoveSpread ms;
	Entity entityFocus;

	MapManager(OrthographicCamera cam) {
		
		tm = new TileManager();
		
		WorldPosition.tm = tm;
		
		cm = new CharacterManager();
		
		tom = new TileOverlayManager();
		
		omb = new ObstacleManager();
		
		this.cam = cam;
		cursor = new Cursor(0, 0, tm);

		ms = new MoveSpread();

	}

	public void renderSprites() {

	}

	public void renderOutline(ShapeRenderer sr) {
		
		cm.renderShape(sr);
		cursor.renderShape(sr);
		cursor.renderText();

		tm.renderShape(sr);

		tm.resetColour();
		
		tom.renderShape(sr);
		
		omb.renderShape(sr);

		

	}

	public void update() {
		if (lockOn) {
			Vector2 desired = cursor.wPos;
			desired.sub(cam.position.x, cam.position.y);

		}
		tm.update();
		cm.update();
		cursor.update();
		omb.update();

		if (Gdx.input.isKeyJustPressed(Keys.L)) {
			lockOn = !lockOn;
		}
		if(lockOn){
			Vector2 desire = cursor.wPos;
			desire.sub(cam.position.x, cam.position.y);
			cam.translate(desire);
		}
		cm.tom.resetColour();
		
		
		Character look = cm.map[cursor.x][cursor.y];
		if(look != null && look != entityFocus){
			ArrayList<Vector2> cords = MoveSpread.moves(look.x, look.y, look.move);
			for (Vector2 position : cords) {
				if (position.x >= 0 && position.y >= 0 && position.y < tm.COL && position.x < tm.ROW) {
					cm.tom.map[(int) position.x][(int) position.y].color = Color.ROYAL;
				}
			}
		}

		
		
		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			
			if(entityFocus != null){
				if(tom.map[(int) cursor.x][(int) cursor.y].color == Color.RED){
					if(cm.map[cursor.x][cursor.y] == null){
						entityFocus.move(cursor.x, cursor.y);
						entityFocus = null;
							
					}
					
				}
			}

			tom.resetColour();
			
			for (Character c : cm.list) {
				if (c.x == cursor.x && c.y == cursor.y) {
					
					entityFocus = c;
					
					ArrayList<Vector2> cords = MoveSpread.moves(c.x, c.y, c.move);
					
					for (Vector2 position : cords) {
						if (position.x >= 0 && position.y >= 0 && position.y < tm.COL && position.x < tm.ROW) {
							tom.map[(int) position.x][(int) position.y].color = Color.RED;
						}
					}
					
					tom.map[(int) cursor.x][(int) cursor.y].color = Color.FIREBRICK;
					
				}
			}
			
		}
		
		
		if(Gdx.input.isKeyJustPressed(Keys.A)){
			for(Character c: cm.list){
				ArrayList<Vector2> cords = MoveSpread.moves(c.x, c.y, c.move);
				for (Vector2 position : cords) {

					if (position.x >= 0 && position.y >= 0 && position.y < tm.COL && position.x < tm.ROW) {
						cm.tom.map[(int) position.x][(int) position.y].color = Color.ROYAL;
					}
				}
			}
		}

	}
	
	

	public void addCharacter(int x, int y) {
		for(Entity en: cm.list){
			if(en.x == x && en.y == y){
				return;	
			}
		}
		cm.addCharacter(new Character(x, y));
	}

	public void addObstacle(int x, int y) {
		omb.addObstacle(x,y);
	}

}
