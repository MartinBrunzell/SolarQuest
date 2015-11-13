package com.martinbrunzell.solarquest.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;

public class Sun extends AbstractWorldObject{
    private TextureRegion sunReg;

    public Sun() {
        init();
    }

    private void init() {
        sunReg = Assets.instance.sun.sun;

        //Setting location and size
        position.set(0, 0);
        dimension.set(75, 75);
        origin.set(50, 50);
        scale.set(1,1);
    }


    @Override
    public void update(float deltaTime) {
        rotation = 5 * deltaTime;
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
}