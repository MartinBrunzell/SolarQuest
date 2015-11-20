package com.martinbrunzell.solarquest.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.util.Constants;

public class Sun extends AbstractWorldObject{
    private TextureRegion sunReg;
    private static Vector2 centerPoint;

    public Sun() {
        init();
    }

    private void init() {
        sunReg = Assets.instance.sun.sun;

        //Setting location and size
        position.set(((Constants.BACKGROUND_DIMENSION * (Constants.BACKGROUND_TILES_AMOUNT) ) / 2) - 50,
                ((Constants.BACKGROUND_DIMENSION * 8 ) / 2) -50);
        dimension.set(100, 100);
        origin.set(50, 50);
        scale.set(1,1);

        centerPoint.set(((Constants.BACKGROUND_DIMENSION * (Constants.BACKGROUND_TILES_AMOUNT) ) / 2) - 50,
                ((Constants.BACKGROUND_DIMENSION * 8 ) / 2) -50);
    }


    @Override
    public void update(float deltaTime) {
        rotation = 50 * deltaTime;
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        reg = sunReg;

        // Renders the background to the window
        batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);
    }

    //######################
    //      GETTERS
    //######################

    public Vector2 getCenterPoint() {
        return centerPoint;
    }

}
