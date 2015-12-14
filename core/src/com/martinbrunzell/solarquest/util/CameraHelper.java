package com.martinbrunzell.solarquest.util;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.martinbrunzell.solarquest.game.objects.planets.AbstractPlanetObject;

public class CameraHelper {
    private static final String DEBUG_TAG = CameraHelper.class.getName();

    private final float MAX_ZOOM_IN = 0.25f;
    private final float MAX_ZOOM_OUT = 500.0f;

    private Vector2 position;
    private float zoom;
    private AbstractPlanetObject target;
    private OrthographicCamera camera;

    public CameraHelper() {
        position = new Vector2();
        position.set(((Constants.BACKGROUND_DIMENSION * (Constants.BACKGROUND_TILES_AMOUNT) ) / 2) - 50,
                ((Constants.BACKGROUND_DIMENSION * 8 ) / 2) -50);
        zoom = 130f;
        target = null;
    }

    public void update (float deltaTime) {

    }

    public void applyTo(OrthographicCamera camera) {
        float camX = camera.position.x;
        float camY = camera.position.y;

        if(target == null) {
            float minCameraX = camera.zoom * (camera.viewportWidth / 2);
            float maxCameraX = Constants.BACKGROUND_DIMENSION * Constants.BACKGROUND_TILES_AMOUNT - minCameraX;
            float minCameraY = camera.zoom * (camera.viewportHeight / 2);
            float maxCameraY = Constants.BACKGROUND_DIMENSION * Constants.BACKGROUND_TILES_AMOUNT - minCameraY;
            camera.position.set(Math.min(maxCameraX, Math.max(position.x - 150, minCameraX)),
                    Math.min(maxCameraY, Math.max(position.y - 150, minCameraY)),
                    0);

        } else {
            camera.position.x = target.position.x;
            camera.position.y = target.position.y;
        }
        camera.zoom = zoom;
        camera.update();

    }

    public Vector2 getWorldCoordinates(float x, float y) {
        Vector3 coords = new Vector3(x, y, 0);
        Vector3 newCoord = camera.unproject(coords);

        return new Vector2(newCoord.x, newCoord.y);
    }

    public void dragCamera(float x, float y) {
            position.x += -(x / (95.5f)) * zoom;
            position.y += (y / (95.5f )) * zoom;
        /*
        float border = (Constants.BACKGROUND_DIMENSION * 7);


        if(position.y > (border - 249))
            position.y = (border - 249) - 0.0001f;
        else if(position.y < 1250)
            position.y = (1250) + 0.0001f;

        if(position.x > (border - 360))
            position.x = (border - 360) - 0.0001f;
        else if(position.x < 3360)
            position.x = (3360) + 0.0001f;
        */
    }

    //********************
    // Setters and getters
    //********************

    public void setPosition( float x , float y) {
        this.position.set(x, y);
    }
    public Vector2 getPosition() {
        return position;
    }
    public void setZoom(float zoom) {
        this.zoom = MathUtils.clamp(zoom, MAX_ZOOM_IN, MAX_ZOOM_OUT); // limits the value zoom can take on
    }
    public void addZoom (float amount) {
        setZoom(zoom + amount);
    }
    public float getZoom() {
        return zoom;
    }
    public void setTarget(AbstractPlanetObject target) {
        this.target = target;
    }
    public AbstractPlanetObject getTarget() {return target;}
    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

}
