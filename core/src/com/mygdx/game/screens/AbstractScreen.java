package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameState;

public abstract class AbstractScreen implements Screen{

	protected final GameState app;
	
	Stage stage;
	
//	Constructor
	public AbstractScreen(final GameState app){
		this.app = app;
		this.stage = new Stage();
	}
	
//	Setting delta time for physics engine
	public abstract void update(float delta);
	
	
//	Render Method Super
	@Override
	public void render(float delta){
		update(delta);
		
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
//	Resize Method Super
	@Override
	public void resize(int width, int height){
		stage.getViewport().update(width, height, true);
		
	}
	
	@Override
	public void dispose(){
		this.stage.dispose();
		
	}
}
