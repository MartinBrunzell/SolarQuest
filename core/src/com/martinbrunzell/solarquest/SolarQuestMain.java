package com.martinbrunzell.solarquest;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.martinbrunzell.solarquest.game.WorldController;
import com.martinbrunzell.solarquest.game.WorldRenderer;

public class SolarQuestMain implements ApplicationListener {
	private static final String DEBUG_TAG = SolarQuestMain.class.getName();
    private boolean paused;
	private WorldController worldController;
    private WorldRenderer worldRenderer;
	
	@Override
	public void create () {
		// Setting libGDX to Debug
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        //Initialize controller and renderer
        worldController = new WorldController();
        worldRenderer = new WorldRenderer(worldController);

        // The game world is active on start
        paused = false;

	}

    @Override
    public void resize(int width, int height) {
        worldRenderer.resize(width, height);
    }

    @Override
	public void render () {
        // Stops world from updating when paused
        if (!paused){
            // update from last rendered frame
            worldController.update(Gdx.graphics.getDeltaTime());
        }

        //testColor
        //Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
        Gdx.gl.glClearColor(53/255f, 43/255f, 49/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Renders the world to the screen
        worldRenderer.render();
	}

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        //TODO re-load asstets
        paused = false;
    }

    @Override
    public void dispose() {
        worldRenderer.dispose();
        //TODO delete assets
    }
}
