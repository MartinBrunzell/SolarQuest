package com.martinbrunzell.solarquest.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CameraHelper {
    private static final String DEBUG_TAG = CameraHelper.class.getName();

    private final float MAX_ZOOM_IN = 0.25f;
    private final float MAX_ZOOM_OUT = 500.0f;

    private Vector2 position;
    private float zoom;

    public CameraHelper() {
        position = new Vector2();
        position.set(((Constants.BACKGROUND_DIMENSION * (Constants.BACKGROUND_TILES_AMOUNT) ) / 2) - 50,
                ((Constants.BACKGROUND_DIMENSION * 8 ) / 2) -50);
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
        float border = (Constants.BACKGROUND_DIMENSION * 7);

        if (position.x > -border && position.x < border)
            position.x += -(x / (95.5f)) * zoom;

        if (position.y > -border && position.y < border)
            position.y += (y / (95.5f )) * zoom;

        if(position.y > (border - 249))
            position.y = (border - 249) - 0.0001f;
        else if(position.y < 1250)
            position.y = (1250) + 0.0001f;

        if(position.x > (border - 360))
            position.x = (border - 360) - 0.0001f;
        else if(position.x < 3360)
            position.x = (3360) + 0.0001f;
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
