package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.physics.box2d.Body;

public class SpriteBuilder {

	public static void createSprite (SpriteBatch batch, int width, int height) {
		Sprite sprite;

		sprite = new Sprite();
	}
	
	public static void renderSprite (Body body, int width, int height) {
		
		ShapeRenderer shape;
		
		shape = new ShapeRenderer();
		shape.set(ShapeType.Filled);
		shape.rect(body.getPosition().x, body.getPosition().y, width, height);
	}
	
}
