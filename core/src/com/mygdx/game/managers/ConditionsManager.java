package com.mygdx.game.managers;

import java.util.Random;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class ConditionsManager {

		double y = 0;
		
	public double createCrossWind (Body body) {
		
		y  = y + 0.01;
		Random ran = new Random();
		int x = (int) ( 300*Math.sin(y) - ran.nextInt(500) + ran.nextInt(500));
		
		body.applyForceToCenter(new Vector2(x, 0), true);
		body.applyAngularImpulse((float) (0.0005*x), true);
		
		return y;
	}

	public void createDrag (Body body) {
		
		float resistance = (float) (0.03*body.getLinearVelocity().len());
		
		body.setLinearDamping(resistance);
		System.out.println(resistance);
	}
}
