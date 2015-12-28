package com.martinbrunzell.solarquest.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.martinbrunzell.solarquest.game.objects.Space;
import com.martinbrunzell.solarquest.game.objects.planets.Earth;
import com.martinbrunzell.solarquest.game.objects.planets.Sun;
import com.martinbrunzell.solarquest.util.Constants;
import com.sun.media.jfxmediaimpl.MediaDisposer;

public class WorldRenderer implements MediaDisposer.Disposable{
    private static final String DEBUG_TAG = WorldRenderer.class.getName();
    private OrthographicCamera camera;
    private OrthographicCamera cameraHUD;
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

        cameraHUD = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        cameraHUD.setToOrtho(true); // flip y-axis
        cameraHUD.position.set(0, 0, 0);
        cameraHUD.update();

        worldController.cameraHelper.setCamera(camera);

    }

    // Draws the changes in the world
    public void render() {
        batch.begin(); // Starts the writing

        renderWorld(batch);
        renderHUD(batch);

        batch.end();
    }



    public void resize(int width, int height){
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / (float) height ) * (float)width;
        camera.update();

        cameraHUD.viewportHeight = Constants.VIEWPORT_HUD_HEIGHT;
        cameraHUD.viewportWidth = (Constants.VIEWPORT_HUD_HEIGHT
                / (float)height) * (float)width;
        cameraHUD.position.set(cameraHUD.viewportWidth / 2,
                cameraHUD.viewportHeight / 2, 0);
        cameraHUD.update();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }

    // Renders the game world
    private void renderWorld(SpriteBatch batch) {
        worldController.cameraHelper.applyTo(camera);

        batch.setProjectionMatrix(camera.combined);

        worldController.space.render(batch);
        worldController.sun.render(batch);

        worldController.moon.render(batch);
        worldController.earth.render(batch);

        worldController.mercury.render(batch);
        worldController.venus.render(batch);

        worldController.mars_phobos.render(batch);
        worldController.mars_deimos.render(batch);
        worldController.mars.render(batch);

    }

    private void renderHUD(SpriteBatch batch) {
        batch.setProjectionMatrix(cameraHUD.combined);
        renderCurrency(batch);
    }

    private void renderCurrency(SpriteBatch batch) {
        float x = 2;
        float y = 30;
        batch.draw(Assets.instance.icons.moneyIcon, x, y, 1, -1, 16 * 3, 25 * 3, 0.6f, -0.2f, 0);
        Assets.instance.fonts.fontSmall.draw(batch, "" + 300, 28, 12);

        batch.draw(Assets.instance.icons.scienceIcon, 5 * 22 + 20, y, 5, 5, 16 * 3, 25 * 3, 0.35f, - 0.35f, 0);
        Assets.instance.fonts.fontSmall.draw(batch, "" + 2, 150, 12);
    }



}
