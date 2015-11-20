package com.martinbrunzell.solarquest.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.util.Constants;

public class Space extends AbstractWorldObject{
    private TextureRegion spaceReg;
    private float radius;

    public Space() {
        init();
    }


    private void init() {
        spaceReg = Assets.instance.space.space;

        //Setting location and size
        position.set(0,0);
        dimension.set(Constants.BACKGROUND_DIMENSION, Constants.BACKGROUND_DIMENSION);
        origin.set(50, 50);
        scale.set(1,1);

        radius = 100.0f;

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        reg = spaceReg;

        // Renders the background to the window
        for(int i = 0; i < Constants.BACKGROUND_TILES_AMOUNT; i++) {
            for(int j = 0; j < Constants.BACKGROUND_TILES_AMOUNT + 2; j++){
                batch.draw(reg.getTexture(), position.x + j * Constants.BACKGROUND_DIMENSION,
                        position.y + i * Constants.BACKGROUND_DIMENSION, origin.x, origin.y,
                        dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                        reg.getRegionWidth(), reg.getRegionHeight(), false, false);

            }
        }
    }

    //######################
    //      GETTERS
    //######################

    public float getRadius() {
        return radius;
    }

}
