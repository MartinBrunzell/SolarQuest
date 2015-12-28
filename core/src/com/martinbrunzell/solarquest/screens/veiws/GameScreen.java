package com.martinbrunzell.solarquest.screens.veiws;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.martinbrunzell.solarquest.game.WorldController;
import com.martinbrunzell.solarquest.game.WorldRenderer;
import com.martinbrunzell.solarquest.screens.AbstractGameScreen;

public class GameScreen extends AbstractGameScreen {
    private static final String TAG = GameScreen.class.getName();

    private WorldController worldController;
    private WorldRenderer worldRenderer;

    private boolean paused;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void render(float deltaTime) {
        //Do not update while paused
        if(!paused) {
            worldController.update(deltaTime);
        }
        // Renders The world
        Gdx.gl.glClearColor(53/255f, 43/255f, 49/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render();
    }

    @Override public void resize(int width, int height) {
        worldRenderer.resize(width, height);
    }

    @Override public void show() {
        worldController = new WorldController(game);
        worldRenderer = new WorldRenderer(worldController);
        Gdx.input.setCatchBackKey(true);
    }

    @Override public void hide() {
        worldRenderer.dispose();
        Gdx.input.setCatchBackKey(false);
    }

    //Only called in Android!
    @Override public void pause() {
        paused = true;
    }

    //Only called in Android!
    @Override public void resume() {
        super.resume();
        paused = false;

    }


}
