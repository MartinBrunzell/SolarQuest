package com.martinbrunzell.solarquest.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.util.Constants;

public class Earth extends AbstractWorldObject{
    private TextureRegion earthReg;

    public Earth() {
        init();
    }

    private void init() {
        earthReg = Assets.instance.earth.earth;

        //Setting location and size
        position.set(((Constants.BACKGROUND_DIMENSION * (Constants.BACKGROUND_TILES_AMOUNT) ) / 2) + 100,
                ((Constants.BACKGROUND_DIMENSION * 8 ) / 2) + 100);
        dimension.set(35, 35);
        origin.set(50, 50);
        scale.set(1,1);
    }


    @Override
    public void update(float deltaTime) {
        rotation = 50 * deltaTime;
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        reg = earthReg;

        // Renders the background to the window
        batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);
    }
}


