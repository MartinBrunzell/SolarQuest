package com.martinbrunzell.solarquest.screens.veiws;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.game.objects.Mission;
import com.martinbrunzell.solarquest.screens.AbstractGameScreen;

public class BaseScreen extends AbstractGameScreen {
    private SpriteBatch batch;

    public BaseScreen(Game game) {
        super(game);

    }

    @Override
    public void render(float deltaTime) {

    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void show() {
        batch = new SpriteBatch();
    }

    @Override
    public void hide() {
        batch.dispose();
    }

    @Override
    public void pause() {}
}
