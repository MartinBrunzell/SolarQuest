package com.martinbrunzell.solarquest.game.objects.planets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;

public class Mars extends AbstractPlanetObject {
    private TextureRegion marsReg;


    public Mars(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        super(radius, timeConstant, rotation, center);
        init();
    }

    private void init() {
        marsReg = Assets.instance.mars.mars;

        //Setting location and size
        position.set(0,0);
        dimension.set(19, 19);
        origin.set(dimension.x/2, dimension.y/2);
        scale.set(1, 1);
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        reg = marsReg;

        // Renders the background to the window
        batch.draw(reg.getTexture(), position.x - dimension.x/2, position.y - dimension.y/2, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);
    }
}
