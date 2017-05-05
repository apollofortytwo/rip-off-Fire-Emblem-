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
	EntityManager em;
	TileManager tm;
	TileOverlayManager tom;
	ObstacleManager omb;
	Cursor cursor;
	boolean lockOn = false;
	MoveSpread ms;
	Entity entityFocus;

	MapManager(OrthographicCamera cam) {
		
		tm = new TileManager(200, 200);
		tm.initMap();
		
		
		em = new EntityManager(tm);
		
		tom = new TileOverlayManager(tm);
		tom.initMap();
		
		omb = new ObstacleManager(tm);
		
		this.cam = cam;
		cursor = new Cursor(0, 0, tm);

		ms = new MoveSpread();

	}

	public void renderSprites() {

	}

	public void renderOutline(ShapeRenderer sr) {
		
		em.renderOutline(sr);
		cursor.renderOutline(sr);
		cursor.renderText();

		tm.renderOutline(sr);

		tm.resetColour();
		
		tom.renderBlanket(sr);
		
		omb.renderShape(sr);

		

	}

	public void update() {
		if (lockOn) {
			Vector2 desired = cursor.wPos;
			desired.sub(cam.position.x, cam.position.y);

		}
		tm.update();
		em.update();
		cursor.update();

		if (Gdx.input.isKeyJustPressed(Keys.L)) {
			lockOn = !lockOn;
		}
		if(lockOn){
			Vector2 desire = cursor.wPos;
			desire.sub(cam.position.x, cam.position.y);
			cam.translate(desire);
		}
		em.tom.resetColour();
		
		
		Entity look = em.getEntity(cursor.x, cursor.y);
		if(look != null && look != entityFocus){
			ArrayList<Vector2> cords = MoveSpread.moves(look.x, look.y, look.move);
			for (Vector2 position : cords) {
				System.out.println(position);
				if (position.x >= 0 && position.y >= 0 && position.y < tm.height && position.x < tm.width) {
					em.tom.map[(int) position.x][(int) position.y].color = Color.ROYAL;
				}
			}
		}

		
		
		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			
			if(entityFocus != null){
				System.out.println("focused");
				if(tom.map[(int) cursor.x][(int) cursor.y].color == Color.RED){
					if(em.getEntity(cursor.x, cursor.y) == null){
						entityFocus.move(cursor.x, cursor.y);
						entityFocus = null;
							
					}
					
				}
			}

			tom.resetColour();
			
			for (Entity entity : em.enList) {
				if (entity.x == cursor.x && entity.y == cursor.y) {
					
					entityFocus = entity;
					
					ArrayList<Vector2> cords = MoveSpread.moves(entity.x, entity.y, entity.move);
					
					for (Vector2 position : cords) {
						if (position.x >= 0 && position.y >= 0 && position.y < tm.height && position.x < tm.width) {
							tom.map[(int) position.x][(int) position.y].color = Color.RED;
						}
					}
					
					tom.map[(int) cursor.x][(int) cursor.y].color = Color.FIREBRICK;
					
				}
			}
			
		}
		
		
		if(Gdx.input.isKeyJustPressed(Keys.A)){
			for(Entity en: em.enList){
				ArrayList<Vector2> cords = MoveSpread.moves(en.x, en.y, en.move);
				for (Vector2 position : cords) {
					System.out.println(position);
					if (position.x >= 0 && position.y >= 0 && position.y < tm.height && position.x < tm.width) {
						em.tom.map[(int) position.x][(int) position.y].color = Color.ROYAL;
					}
				}
			}
		}

	}
	
	

	public void addEntity(int x, int y) {
		for(Entity en: em.enList){
			if(en.x == x && en.y == y){
				return;	
			}
		}
		em.addEntity(new Entity(x, y));
	}

	public void addObstacle(int x, int y) {
		omb.addObstacle(x,y);
	}

}
