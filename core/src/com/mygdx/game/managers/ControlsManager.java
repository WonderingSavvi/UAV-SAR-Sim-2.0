package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class ControlsManager {
		
	
	public void getKeyboardControls (Body body) {
		
		double yforce = Math.cos(-body.getAngle());
		double xforce = Math.sin(-body.getAngle());
		
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			body.applyForceToCenter(new Vector2((float) (250*xforce), (float) (250 * yforce)), true);

		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			body.applyForceToCenter(new Vector2((float) (-250*xforce), (float) (-250 * yforce)), true);
			
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			body.applyAngularImpulse(0.8f, true);
			
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			body.applyAngularImpulse(-0.8f, true);

		}
	}
	
	public void getMouseControls (Body body) {
		
		//Can't be bothered at the moment, to be honest.
		
	}
	
	public void dispose() {
		
		//INSERT CODE HERE
		
	}
}