package com.martinbrunzell.solarquest;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.game.WorldController;
import com.martinbrunzell.solarquest.game.WorldRenderer;
import com.martinbrunzell.solarquest.screens.MenuScreen;

public class SolarQuestMain extends Game {
	
	@Override
	public void create () {
		// Setting libGDX to Debug
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        //Load Assets
        Assets.instance.init(new AssetManager());

        // The Game starts with the menu-screen
        setScreen(new MenuScreen(this));

	}

}
