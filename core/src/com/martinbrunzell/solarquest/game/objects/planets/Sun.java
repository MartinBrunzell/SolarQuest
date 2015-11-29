package com.martinbrunzell.solarquest.game.objects.planets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.game.objects.AbstractWorldObject;
import com.martinbrunzell.solarquest.util.Constants;

public class Sun extends AbstractPlanetObject {
    private TextureRegion sunReg;

    public Sun(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        super(radius, timeConstant, rotation, center);
        init();
    }

    private void init() {
        sunReg = Assets.instance.sun.sun;

        //Setting location and size
        position.set(((Constants.BACKGROUND_DIMENSION * (Constants.BACKGROUND_TILES_AMOUNT) ) / 2) - 50,
                ((Constants.BACKGROUND_DIMENSION * 8 ) / 2) -50);
        dimension.set(150, 150);
        origin.set(75, 75);
        scale.set(1,1);

        //Choosing the time-constant
    }


    @Override
    public void update(float deltaTime) {
        rotation += 5 * deltaTime;
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;
        reg = sunReg;

        // Renders the background to the window
        batch.draw(reg.getTexture(), position.x - dimension.x/2, position.y - dimension.y/2, origin.x, origin.y,
                dimension.x, dimension.y, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(),
                reg.getRegionWidth(), reg.getRegionHeight(), false, false);
    }

    //######################
    //      GETTERS
    //######################

}
