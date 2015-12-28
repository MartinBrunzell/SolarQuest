package com.martinbrunzell.solarquest.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;

public class Mission extends AbstractWorldObject{
    private TextureRegion reg;

    public  Mission() {
        init();
    }

    private void init() {
        reg = Assets.instance.base.mission;
        dimension.set(55, 59);
        position.set(55, 55);
        bounds.set(position.x, position.y, dimension.x, dimension.y);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);
    }
}
