package com.martinbrunzell.solarquest.game.objects.planets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.martinbrunzell.solarquest.game.objects.AbstractWorldObject;
import com.martinbrunzell.solarquest.util.Constants;

import java.util.Map;
import java.util.Random;


public class AbstractPlanetObject extends AbstractWorldObject{
    private float radius;
    private float timeConstant;
    private AbstractPlanetObject center;
    private double angle;

    public AbstractPlanetObject(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        this.radius = radius;
        this.timeConstant = timeConstant;
        super.rotation = rotation;
        this.center = center;
        angle = System.currentTimeMillis();
    }

    @Override
    public void update(float deltaTime) {
        angle += deltaTime / timeConstant;
        Vector2 cP = center.getPosition();
        rotation += 5 * deltaTime;

        float x = (float) Math.cos(angle) * radius + cP.x ;
        float y = (float) Math.sin(angle) * radius + cP.y ;

        position.set(x, y);
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    public Vector2 getPosition() {
        Vector2 pos = new Vector2(position);
        return pos.set(pos.x, pos.y );
    }

}
