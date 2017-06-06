package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameState;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = GameState.APP_TITLE + GameState.APP_VERSION;
		config.resizable = GameState.APP_RESIZEABLE;
		config.width = GameState.APP_DESKTOP_WIDTH;
		config.height = GameState.APP_DESKTOP_HEIGHT;
		config.foregroundFPS = GameState.APP_FPS;
		config.backgroundFPS = GameState.APP_FPS;
		config.fullscreen = GameState.APP_FULLSCREEN;
		
		new LwjglApplication(new GameState(), config);
	}
}
