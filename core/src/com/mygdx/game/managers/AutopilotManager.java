package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class AutopilotManager {
	
	//Global Vars
	static boolean fire = false;
	
	public static void startAutoLanding (boolean isKeyPressed, Body body, World world){
		
		//Method Vars
		double yforce = Math.cos(-body.getAngle());
		double xforce = Math.sin(-body.getAngle());
		
		
		//Key Press Check
		if (isKeyPressed == true) {
			
			//Calculate target velocity
			double vely = body.getLinearVelocity().y;
			double u = -Math.sqrt(2*((100/body.getMass()) + world.getGravity().y)*(body.getPosition().y));
//			System.out.println("Current vel: " + vely);
//			System.out.println("Target vel: " + u);


			//Negative y velocity check
			if (vely <= 0) {
				System.out.println("Freefall");
				
				//Check for velocity equivalence
				if (Math.round(u-vely) == 0) {
					fire = true;
				}
				
				//Start burn
				if (fire == true) {
					body.applyForceToCenter(new Vector2(0, 100f), true);
					System.out.println("Firing..." + "\n");
				}
				
				//Check for landing
				if (Math.round(body.getLinearVelocity().y) == 0) {
					fire = false;
				}
			}
		}
	}
}


