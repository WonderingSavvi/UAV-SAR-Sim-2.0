package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.managers.ConditionsManager;
import com.mygdx.game.managers.ControlsManager;
import com.mygdx.game.managers.GameScreenManager;
import com.mygdx.game.utils.SpriteBuilder;

public class GameState extends Game {
	
	//Application Variables
	public static String APP_TITLE = "Test Game ";
	public static double APP_VERSION = 0.1;
	public static int APP_DESKTOP_WIDTH = 1920;
	public static int APP_DESKTOP_HEIGHT = 1080;
	public static int APP_FPS = 60;
	public static boolean APP_RESIZEABLE = false;
	public static boolean APP_FULLSCREEN = true;
	
	//Game Variables
	public static int V_WIDTH = 1920;
	public static int V_HEIGHT = 1080;
	
	//Managers
	public GameScreenManager gsm;
	public AssetManager assets;
	public ControlsManager cm;
	
	//Batches
	public SpriteBatch batch;
	public ShapeRenderer shapeBatch;
	
	//Sprites
	public Sprite player;
	
	
	@Override
	public void create() {
		
		batch = new SpriteBatch();
		shapeBatch = new ShapeRenderer();
		player = new Sprite();
				
		// Setup managers
		assets = new AssetManager();
		gsm = new GameScreenManager(this);

		
	}

	@Override
	public void render () {
		
		super.render();
		
		
//		batch.begin();
//		player.draw(batch);
//		batch.end();
		
		//Escape to exit game
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();	
		}
	}
	
	@Override
	public void dispose () {
		
		super.dispose();
		batch.dispose();
		shapeBatch.dispose();
		assets.dispose();
		gsm.dispose();
	}
}
