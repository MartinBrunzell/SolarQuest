package com.martinbrunzell.solarquest.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.martinbrunzell.solarquest.SolarQuestMain;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.game.WorldController;
import com.martinbrunzell.solarquest.game.WorldRenderer;
import com.martinbrunzell.solarquest.game.objects.Base;
import com.martinbrunzell.solarquest.screens.veiws.BaseScreen;
import com.martinbrunzell.solarquest.util.Constants;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuScreen implements Screen {
    private Game game;
    private Base base;
    private SpriteBatch batch;
    private Sprite sprite;
    private OrthographicCamera cam;
    private Sprite background;
    private Rectangle mission;
    private Rectangle vab;
    private Rectangle lab;



    public MenuScreen (Game game) {
        this.game = game;
    }

    @Override
    public void render(float deltaTime) {
        cam.update();

        batch.setProjectionMatrix(cam.projection);
        batch.begin();

        background.draw(batch);

        batch.end();

        if(Gdx.input.isTouched()){
            System.out.println("X:"+Gdx.input.getX() + " Y:"+Gdx.input.getY());
            game.setScreen(new GameScreen(game));
        }

    }


    @Override public void resize(int width, int height) {}

    @Override public void show() {
        base = new Base();
        batch = new SpriteBatch();
        sprite = new Sprite(Assets.instance.base.background.getTexture());
        cam = new OrthographicCamera();
        background = new Sprite(new Texture("assets-raw/images/baseBackground.png"));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(Gdx.graphics.getWidth() / 2 * -1, Gdx.graphics.getHeight() / 2 * -1);

        cam = new OrthographicCamera();
        cam.setToOrtho(false);

        //mission.set()
    }

    @Override public void hide() {}

    @Override
    public void dispose() {

    }

    @Override public void pause() {}

    @Override
    public void resume() {

    }
}
