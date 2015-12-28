package com.martinbrunzell.solarquest.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.martinbrunzell.solarquest.screens.veiws.BaseScreen;

public class MenuScreen extends AbstractGameScreen{

    public MenuScreen (Game game) {
        super(game);
    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(Gdx.input.isTouched())
            game.setScreen(new BaseScreen(game));
    }

    @Override public void resize(int width, int height) {}

    @Override public void show() {}

    @Override public void hide() {}

    @Override public void pause() {}
}
