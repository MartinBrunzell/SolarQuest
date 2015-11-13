package com.martinbrunzell.solarquest.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.martinbrunzell.solarquest.game.objects.Space;
import com.martinbrunzell.solarquest.game.objects.Sun;
import com.martinbrunzell.solarquest.util.Constants;
import com.sun.media.jfxmediaimpl.MediaDisposer;

public class WorldRenderer implements MediaDisposer.Disposable{
    private static final String DEBUG_TAG = WorldRenderer.class.getName();
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    //Game objects
    private Space space;
    private Sun sun;

    public WorldRenderer(WorldController worldController) {
        this.worldController = worldController;
        init();

    }

    private void init() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0); // Sets the starting point for the camera
        camera.update();

        //Initiates the game objects
        space = new Space();
        sun = new Sun();
    }

    // Draws the changes in the world
    public void render() {
        renderWorld(batch);
        Gdx.app.debug(DEBUG_TAG, "" + Gdx.graphics.getFramesPerSecond());

    }

    public void resize(int width, int height){
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / (float) height ) * (float)width;
        camera.update();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }

    // Renders the game world
    private void renderWorld(SpriteBatch batch) {
        worldController.cameraHelper.applyTo(camera);
        batch.setProjectionMatrix(camera.combined);

        batch.begin(); // Starts the writing

        space.render(batch);
        sun.render(batch);

        batch.end();
    }
    //****************
    // TEST RENDER
    //****************
/*
    private void testRender(SpriteBatch batch) {
        Texture background = new Texture("images/testSpace.png");
        Texture sun = new Texture("images/sun.png");

        Sprite spr = new Sprite(background);
        Sprite sunSprite = new Sprite(sun);

        spr.setSize(Constants.BACKGROUND_DIMENSION, Constants.BACKGROUND_DIMENSION);
        spr.setPosition(Constants.BACKGROUND_DIMENSION / -2.0f, Constants.BACKGROUND_DIMENSION / -2.0f);

        sunSprite.setPosition(-5, -5);
        sunSprite.setSize(10, 10);


        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        spr.draw(batch);
        sunSprite.draw(batch);

        batch.end();

    }
*/




}
