package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.GameState;
import com.mygdx.game.managers.ConditionsManager;
import com.mygdx.game.managers.ControlsManager;
import com.mygdx.game.utils.B2DBodyBuilder;

import static com.mygdx.game.utils.B2DConstants.PPM;

public class GameScreen extends AbstractScreen{

	OrthographicCamera camera;
	
	//Box2d Variables
	World world;
	Box2DDebugRenderer b2dr;
	Body box, box1, box2, box3;
	
	//Body Managers
	ControlsManager cm;
	ConditionsManager condm;
	
	
	//Game Screen Constructor
	public GameScreen(GameState app) {
		super(app);
		
		//Setting up the camera
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, GameState.V_WIDTH , GameState.V_HEIGHT);
		
		//Setting up the Debug Renderer
		b2dr = new Box2DDebugRenderer();
		
	}

	@Override
	public void show() {
		//Setting up the world
		world = new World(new Vector2(0f, -9.8f), false);
		
		cm = new ControlsManager();
		condm = new ConditionsManager();
		
		
		//Setting the Physics bodies
		box = B2DBodyBuilder.createBoxBody(world, camera.viewportWidth / 2, camera.viewportHeight / 2, 100f, 100f);
		box1 = B2DBodyBuilder.createBoxBody(world, 200f, 100, 100f, 300f);
		box2 = B2DBodyBuilder.createBoxBody(world, 400f, 100, 100f, 300f);
		box3 = B2DBodyBuilder.createBoxBody(world, 300f, 300f, 300f, 100f);
		
		
		B2DBodyBuilder.createWalls(world, camera);
				
		//Setting projection Matrix
		app.batch.setProjectionMatrix(camera.combined);
		app.shapeBatch.setProjectionMatrix(camera.combined);
		
		//Desk Check
		System.out.println("Width: " + camera.viewportWidth);
		System.out.println("Height: " + camera.viewportHeight);
	}
	
	@Override
	public void update(float delta) {
		world.step(1/60f, 6, 2);
		stage.act(delta);
	}
	
	@Override
	public void render(float delta){
		super.render(delta);
		b2dr.render(world, camera.combined.cpy().scl(PPM));
		stage.draw();
		cm.getKeyboardControls(box);
//		condm.createCrossWind(box);
		condm.createDrag(box);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		world.dispose();
		cm.dispose();
	}
	


}
