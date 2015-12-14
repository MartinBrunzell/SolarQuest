package com.martinbrunzell.solarquest.game.objects.planets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.martinbrunzell.solarquest.game.Assets;


public class Moon extends AbstractPlanetObject {

    public Moon(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        super(radius, timeConstant, rotation, center);
        init();
    }

    private void init() {
        reg = Assets.instance.moon.moon;

        //Setting location and size
        position.set(1,1);
        dimension.set(6.5f, 6.5f);
        origin.set(dimension.x / 2, dimension.y / 2);
        scale.set(1, 1);
    }

    @Override
    public void render(SpriteBatch batch) {

        // Renders the background to the window
        batch.draw(reg.getTexture(), position.x - dimension.x / 2, position.y - dimension.y / 2, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);

    }


}
