package com.martinbrunzell.solarquest.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.martinbrunzell.solarquest.game.objects.planets.Earth;
import com.martinbrunzell.solarquest.game.objects.Space;
import com.martinbrunzell.solarquest.game.objects.planets.Sun;
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
    private Earth earth;

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
        renderWorld(batch);
        //Gdx.app.debug(DEBUG_TAG, "" + Gdx.graphics.getFramesPerSecond());
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

        worldController.space.render(batch);
        worldController.sun.render(batch);
        worldController.earth.render(batch);
        worldController.moon.render(batch);
        worldController.mercury.render(batch);
        worldController.venus.render(batch);
        worldController.mars.render(batch);
        worldController.mars_phobos.render(batch);
        worldController.mars_deimos.render(batch);

        batch.end();
    }



}
