package com.martinbrunzell.solarquest.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.martinbrunzell.solarquest.game.objects.AbstractWorldObject;
import com.martinbrunzell.solarquest.game.objects.planets.*;
import com.martinbrunzell.solarquest.game.objects.Space;
import com.martinbrunzell.solarquest.util.CameraHelper;

public class WorldController extends InputAdapter{
    private static final String DEBUG_TAG = WorldController.class.getName();
    public CameraHelper cameraHelper;

    // Objects
    protected Space space;

    //Planets
    protected Sun sun;
    protected Earth earth;
    protected Moon moon;
    protected Mercury mercury;
    protected Venus venus;
    protected Mars mars;
    protected Mars_Phobos mars_phobos;
    protected Mars_Deimos mars_deimos;

    private float test = 0;



    public WorldController () {
        init();
    }

    private void init() {
        Gdx.input.setInputProcessor(this);
        cameraHelper = new CameraHelper();

        // Initiates objects
        space = new Space();
        sun = new Sun(0, 1, 1, null);
        earth = new Earth(250, 4.1f, 100, sun);
        moon = new Moon(30, 1f, 100, earth);
        mercury = new Mercury(100, 3.8f, 100, sun);
        venus = new Venus(175, 4f, 100, sun);
        mars = new Mars(350, 13f, 120, sun);
        mars_phobos = new Mars_Phobos(20, 0.5f, 200, mars);
        mars_deimos = new Mars_Deimos(25, 2, 150, mars);

    }

    public void update(float deltaTime){
        handleDebugInput(deltaTime);
        cameraHelper.update(deltaTime);
        updatePlanets(deltaTime);
    }

    // Implements movement of camera
    @Override
    public boolean touchDragged (int x, int y, int pointer) {
        cameraHelper.dragCamera(Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
        return true;
    }

    //**************
    //DEGUB CONTROLLS
    //**************

    private void handleDebugInput (float deltaTime) {
        if (Gdx.app.getType() != Application.ApplicationType.Desktop) return;

        // Camera Controls (move)
        float camMoveSpeed = 5 * deltaTime;
        float camMoveSpeedAccelerationFactor = 5;
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) camMoveSpeed *= camMoveSpeedAccelerationFactor;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) moveCamera(-camMoveSpeed, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moveCamera(camMoveSpeed, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) moveCamera(0, camMoveSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) moveCamera(0, -camMoveSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)) cameraHelper.setPosition(0, 0);

        // Camera Controls (zoom)
        float camZoomSpeed = 1 * deltaTime;
        float camZoomSpeedAccelerationFactor = 500;
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) camZoomSpeed *= camZoomSpeedAccelerationFactor;
        if (Gdx.input.isKeyPressed(Input.Keys.COMMA)) cameraHelper.addZoom(camZoomSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.PERIOD)) cameraHelper.addZoom(-camZoomSpeed);
        if (Gdx.input.isKeyPressed(Input.Keys.SLASH)) cameraHelper.setZoom(1);
    }

    private void moveCamera (float x, float y) {
        x += cameraHelper.getPosition().x;
        y += cameraHelper.getPosition().y;
        cameraHelper.setPosition(x, y);
    }

    private void updatePlanets(float deltaTime) {
        sun.update(deltaTime);
        earth.update(deltaTime);
        moon.update(deltaTime);
        mercury.update(deltaTime);
        venus.update(deltaTime);
        mars.update(deltaTime);
        mars_phobos.update(deltaTime);
        mars_deimos.update(deltaTime);
    }


}
