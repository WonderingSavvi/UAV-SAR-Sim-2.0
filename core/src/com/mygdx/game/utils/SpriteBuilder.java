package com.mygdx.game.utils;

import static com.mygdx.game.utils.B2DConstants.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.GameState;
import com.mygdx.game.screens.AbstractScreen;

public class SpriteBuilder extends AbstractScreen{

	public SpriteBuilder(GameState app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	public static void createObject (World world, Sprite sprite, SpriteBatch batch, Texture texture, String img, int x, int y, int width, int height){
		Body body;
		
		body = B2DBodyBuilder.createBoxBody(world, x, y, width, height);
		
		texture = SpriteBuilder.createSpriteTexture(img);
		sprite = SpriteBuilder.createSprite(world, body, batch, texture, x, y, width, height);
		
	}
	
	public static Texture createSpriteTexture (String img) {
		Texture texture;
		texture = new Texture(Gdx.files.internal(img));
		
		return texture;
	}
	
	
	public static Sprite createSprite (World world, Body body, SpriteBatch batch, Texture texture, int x, int y, int width, int height) {
		Sprite sprite;
				
		sprite = new Sprite(texture);
		sprite.setBounds(0, 0, width, height);
		sprite.setOriginCenter();
		
		return sprite;

	}
	
	public static Sprite fixSprite (Body body, SpriteBatch batch, Sprite sprite, Vector2 pos) {
		
		//Set Sprite Position
		sprite.setPosition((pos.x*PPM)-sprite.getWidth()/2, (pos.y*PPM)-sprite.getHeight()/2);
		
		sprite.setRotation((float) (body.getAngle()*180/Math.PI));
		
		return sprite;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	
}
