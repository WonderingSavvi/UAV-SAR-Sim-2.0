package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.mygdx.game.utils.B2DConstants.PPM;

public final class B2DBodyBuilder {

	private B2DBodyBuilder() {}
	
	public static Body createBoxBody (World world, float x, float y, float width, float height) {
		Body body;
		
		//Body Definition
		BodyDef bDef = new BodyDef();
		bDef.type = BodyDef.BodyType.DynamicBody;
		bDef.fixedRotation = false;
		bDef.position.set(x / PPM, y / PPM);
		bDef.angularDamping = 1.5f;
							
		//Body Creation
		body = world.createBody(bDef);
		
		//Shape Creation
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width / 2 / PPM, height / 2 / PPM);
		
		//Fixture Definition
		FixtureDef fDef = new FixtureDef();
		fDef.shape = shape;
		fDef.density = (float) ((Math.pow(PPM, 2)*1)/1232);
		fDef.friction = 0.8f;
		fDef.restitution = 0.1f;
		
		//Fixture Creation
		body.createFixture(fDef);
		
		//Shape Disposal
		shape.dispose();
		
		return body;
	}
	
	
	public static Body createBallBody (World world, float x, float y, float radius) {
		Body body;
		
		//Body Definition
		BodyDef bDef = new BodyDef();
		bDef.type = BodyDef.BodyType.DynamicBody;
		bDef.position.set(x / PPM, y / PPM);
		bDef.fixedRotation = false;
		bDef.angularDamping = 0.8f;
		body = world.createBody(bDef);

		//Shape Definition
		CircleShape shape = new CircleShape();
		shape.setRadius(radius / PPM);
		
		//Fixture Definition
		FixtureDef fDef = new FixtureDef();
		fDef.shape = shape;
		fDef.density = 1.0f;
		fDef.restitution = 0.5f;
		fDef.friction = 1.0f;
		body.createFixture(fDef);
		shape.dispose();
		
		
		return body;
	}
	
	public static void createWalls(World world, OrthographicCamera camera) {
		Body body;
		
		//Body Definition
		BodyDef bDef = new BodyDef();
		bDef.type = BodyDef.BodyType.StaticBody;
		body = world.createBody(bDef);
		
		//Shape Definition
		ChainShape shape = new ChainShape();
		Vector2[] verts = new Vector2[5];
		verts[0] = new Vector2(1f / PPM, 0);
		verts[1] = new Vector2(150, 0);
		verts[2] = new Vector2(150, (camera.viewportHeight - 1f) / PPM);
		verts[3] = new Vector2(0, (camera.viewportHeight - 1f) / PPM);
		verts[4] = new Vector2(1f / PPM,0);
		shape.createChain(verts);

		//Fixture Definition
		body.createFixture(shape, 1.0f);

	}
	
	
}



