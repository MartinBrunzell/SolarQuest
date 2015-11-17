package com.martinbrunzell.solarquest.util;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CameraHelper {
    private static final String DEBUG_TAG = CameraHelper.class.getName();

    private final float MAX_ZOOM_IN = 0.25f;
    private final float MAX_ZOOM_OUT = 2572.5f;

    private Vector2 position;
    private float zoom;

    public CameraHelper() {
        position = new Vector2();
        position.set((Constants.BACKGROUND_DIMENSION * Constants.BACKGROUND_TILES_AMOUNT) / 2,
                (Constants.BACKGROUND_DIMENSION * Constants.BACKGROUND_TILES_AMOUNT) / 2);
        zoom = 100.5f;
    }

    public void update (float deltaTime) {

    }

    public void applyTo(OrthographicCamera camera) {
        camera.position.x = position.x;
        camera.position.y = position.y;
        camera.zoom = zoom;

        camera.update();
    }

    public void dragCamera(float x, float y) {
        float border = (Constants.BACKGROUND_DIMENSION * Constants.BACKGROUND_TILES_AMOUNT) / 1.05f;

        if (position.x > -border && position.x < border)
            position.x += -(x / (75.5f)) * zoom;

        if (position.y > -border && position.y < border)
            position.y += (y / (75.5f )) * zoom;

        if(position.y > border)
            position.y -= 0.005f;
        else if(position.y < 0)
            position.y += 1.5f;

        if(position.x > border - Constants.BACKGROUND_DIMENSION )
            position.x -= 1.5f;
        else if(position.x < Constants.BACKGROUND_DIMENSION)
            position.x += 1.5f;
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

}
