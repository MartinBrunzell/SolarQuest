package com.martinbrunzell.solarquest.game.objects.planets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.game.objects.AbstractWorldObject;

import java.util.LinkedList;


public class AbstractPlanetObject extends AbstractWorldObject{
    private float radius;
    private float timeConstant;
    private AbstractPlanetObject center;
    private double angle;
    protected TextureRegion reg;
    private TextureRegion flare;
    private LinkedList<Vector2> flarePos;
    private int index;

    public AbstractPlanetObject(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        this.radius = radius;
        this.timeConstant = timeConstant;
        super.rotation = rotation;
        this.center = center;
        angle = System.currentTimeMillis();
        bounds = new Rectangle(position.x, position.y, dimension.x, dimension.y);
        flare = Assets.instance.levelDecoration.flare;
        flarePos = new LinkedList<Vector2>();
        index = 0;

    }

    @Override
    public void update(float deltaTime) {
        angle += deltaTime / timeConstant;
        Vector2 cP = center.getPosition();
        rotation += 5 * deltaTime;

        float x = (float) Math.cos(angle) * radius + cP.x ;
        float y = (float) Math.sin(angle) * radius + cP.y ;

        position.set(x, y);
        bounds.set(position.x - dimension.x, position.y - dimension.x, 2 * dimension.x, 2 * dimension.y);

        if(flarePos.size() < 39){
            flarePos.addFirst(new Vector2(x, y));

        } else{
            flarePos.removeLast();
        }

        index++;
    }

    private void renderFlare(SpriteBatch batch) {
        for (int i = 0; i < flarePos.size(); i++) {
            batch.draw(flare.getTexture(), flarePos.get(i).x, flarePos.get(i).y, 1, 1,
                    2f, 2f, 1, 1, 1, flare.getRegionX(), flare.getRegionY(),
                    flare.getRegionWidth(), flare.getRegionHeight(), false, false);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Renders the flare after the planets
        renderFlare(batch);

        // Renders the background to the window
        batch.draw(reg.getTexture(), position.x - dimension.x / 2, position.y - dimension.y / 2, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);


    }

    public Vector2 getPosition() {
        Vector2 pos = new Vector2(position);
        return pos.set(pos.x, pos.y );
    }

}
