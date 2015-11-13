package com.martinbrunzell.solarquest.util;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class CameraHelper {
    private static final String DEBUG_TAG = CameraHelper.class.getName();

    private final float MAX_ZOOM_IN = 0.25f;
    private final float MAX_ZOOM_OUT = 72.5f;

    private Vector2 position;
    private float zoom;

    public CameraHelper() {
        position = new Vector2();
        zoom = 10.5f;
    }

    public void update (float deltaTime) {

    }

    public void applyTo(OrthographicCamera camera) {
        camera.position.x = position.x;
        camera.position.y = position.y;
        camera.zoom = zoom;
        camera.frustum.boundsInFrustum(new BoundingBox(new Vector3(-145, -145, 0), new Vector3(145, 145, 1)));
        camera.update();
    }

    public void dragCamera(float x, float y) {
        float border = (Constants.BACKGROUND_DIMENSION / 2.5f) - Constants.BACKGROUND_DIMENSION * 0.1f;

        if (position.x > -border && position.x < border)
            position.x += -(x / (75.5f)) * zoom;

        if (position.y > -border && position.y < border)
            position.y += (y / (75.5f )) * zoom;

        if(position.y > border)
            position.y = border - 0.0001f;
        else if(position.y < -border)
            position.y = -border + 0.0001f;

        if(position.x > border  * 0.75)
            position.x = (border  * 0.75f) - 0.0001f;
        else if(position.x < -border * 0.75)
            position.x = -(border  * 0.75f) + 0.0001f;
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
