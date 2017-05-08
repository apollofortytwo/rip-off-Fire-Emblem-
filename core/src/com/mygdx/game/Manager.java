package com.mygdx.game;

import java.util.ArrayList;

public abstract class Manager<T extends Entity> {
	public ArrayList<T> list = new ArrayList<T>();
	public T[][] map;
	
	public Manager(){
	
		generateList();
		initMap();
	}
	
	public abstract void generateList();
	public abstract void initMap();
	public void update(){
		for(T t: list){
			t.update();
		}
	}
	
	
}
