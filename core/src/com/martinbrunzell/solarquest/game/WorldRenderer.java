package com.martinbrunzell.solarquest.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.martinbrunzell.solarquest.util.Constants;
import com.sun.media.jfxmediaimpl.MediaDisposer;

public class WorldRenderer implements MediaDisposer.Disposable{
    private static final String DEBUG_TAG = WorldRenderer.class.getName();
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    public WorldRenderer(WorldController worldController) {
        this.worldController = worldController;
        init();

    }

    private void init() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0); // Sets the starting point for the camera
        camera.update();

    }

    // Draws the changes in the world
    public void render() {
        worldController.cameraHelper.applyTo(camera);
        Gdx.app.debug(DEBUG_TAG, "Y = " + worldController.cameraHelper.getPosition().y + " X = " + worldController.cameraHelper.getPosition().x);
        testRender(batch);

    }

    public void resize(int width, int height){
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / (float) height ) * (float)width;
        camera.update();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }

    //****************
    // TEST RENDER
    //****************

    private void testRender(SpriteBatch batch) {
        Texture background = new Texture("images/pixelSpace.png");
        Texture sun = new Texture("images/sun.png");

        Sprite spr = new Sprite(background);
        Sprite sunSprite = new Sprite(sun);

        spr.setSize(Constants.BACKGROUND_DIMENSION, Constants.BACKGROUND_DIMENSION);
        spr.setPosition(0, 0);

        //sunSprite.se

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        spr.draw(batch);

        batch.end();

    }

    private Pixmap createTestPixmap (int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGB888);
        //Fill square with color;
        pixmap.setColor(0, 1, 0, 0.5f);
        pixmap.fill();

        return pixmap;
    }



}
