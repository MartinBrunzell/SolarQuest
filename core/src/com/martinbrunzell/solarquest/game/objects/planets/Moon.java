package com.martinbrunzell.solarquest.game.objects.planets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;


public class Moon extends AbstractPlanetObject {
    private TextureRegion moonReg;

    public Moon(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        super(radius, timeConstant, rotation, center);
        init();
    }

    private void init() {
        moonReg = Assets.instance.moon.moon;

        //Setting location and size
        position.set(1,1);
        dimension.set(7.5f, 7.5f);
        origin.set(dimension.x/2, dimension.y/2);
        scale.set(1, 1);
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        reg = moonReg;

        // Renders the background to the window
        batch.draw(reg.getTexture(), position.x - dimension.x / 2, position.y - dimension.y / 2, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);
    }

}
