package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.GameState;
import com.mygdx.game.managers.ConditionsManager;
import com.mygdx.game.managers.ControlsManager;
import com.mygdx.game.utils.B2DBodyBuilder;
import com.mygdx.game.utils.SpriteBuilder;

import static com.mygdx.game.utils.B2DConstants.PPM;

import java.io.Console;

public class GameScreen extends AbstractScreen{

	OrthographicCamera camera;
	
	//Box2d Variables
	World world;
	Box2DDebugRenderer b2dr;
	Body uavbody, wallbody;
	
	//Body Managers
	ControlsManager cm;
	ConditionsManager condm;
	
	//Textures for Render
	SpriteBatch batch;
	Texture uavtexture, walltexture, bgtexture;
	Sprite uavsprite, wallsprite;

	
	
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
				
		
		B2DBodyBuilder.createWalls(world, camera);
		
		
		//Setting projection Matrix
		app.batch.setProjectionMatrix(camera.combined);
		app.shapeBatch.setProjectionMatrix(camera.combined);
		
		//SpriteBatch Setup
		batch = new SpriteBatch();
		
		//UAV
		uavbody = B2DBodyBuilder.createBoxBody(world, camera.viewportWidth / 2, camera.viewportHeight / 2, 100f, 64f);
		uavtexture = SpriteBuilder.createSpriteTexture("UAV.png");
		uavsprite = SpriteBuilder.createSprite(world, uavbody, batch, uavtexture, 500, 500, 100, 64);
		
		//Wall
		wallbody = B2DBodyBuilder.createBoxBody(world, 400f, 100, 100f, 500f);
		walltexture = SpriteBuilder.createSpriteTexture("concrete.jpg");
		wallsprite = SpriteBuilder.createSprite(world, wallbody, batch, walltexture, 500, 500, 100, 500);

		//Background
		Pixmap px = new Pixmap(Gdx.files.internal("lab wall.jpg"));
		bgtexture = new Texture(px);
		bgtexture.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		
		
		
		//Desk Check
		System.out.println("Width: " + camera.viewportWidth);
		System.out.println("Height: " + camera.viewportHeight);
		
	}
	
	@Override
	public void update(float delta) {
		world.step(1/60f, 6, 2);
		stage.act(delta);
		this.camera.update();
	}
	
	@Override
	public void render(float delta){
		
		//Camera Tracking
		camera.position.set(uavbody.getPosition().x*PPM, uavbody.getPosition().y*PPM, 0);
				
		super.render(delta);
		b2dr.render(world, camera.combined.cpy().scl(PPM));
		stage.draw();
		cm.getKeyboardControls(uavbody, world);
//		condm.createCrossWind(box);
		condm.createDrag(uavbody);
		
		//Clear the screen
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Texture Fixtures
		uavsprite = SpriteBuilder.fixSprite(uavbody, batch, uavsprite, uavbody.getPosition(), camera);
		wallsprite = SpriteBuilder.fixSprite(wallbody, batch, wallsprite, wallbody.getPosition(), camera);
		
		
		
		//Batch rendering
		batch.begin();
		wallsprite.draw(batch);
		uavsprite.draw(batch);
		batch.end();
		

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
