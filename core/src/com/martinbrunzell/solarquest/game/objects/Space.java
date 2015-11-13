package com.martinbrunzell.solarquest.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.util.Constants;

public class Space extends AbstractWorldObject{
    private TextureRegion spaceReg;

    public Space() {
        init();
    }


    private void init() {
        spaceReg = Assets.instance.space.space;

        //Setting location and size
        position.set(Constants.BACKGROUND_DIMENSION / -2.0f, Constants.BACKGROUND_DIMENSION / -2.0f);
        dimension.set(Constants.BACKGROUND_DIMENSION, Constants.BACKGROUND_DIMENSION);
        origin.set(50, 50);
        scale.set(1,1);

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        reg = spaceReg;

        // Renders the background to the window
        batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);


    }


}
