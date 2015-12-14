package com.martinbrunzell.solarquest.game.objects.planets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.martinbrunzell.solarquest.game.Assets;

public class Earth extends AbstractPlanetObject {
    private TextureRegion earthReg;


    public Earth(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        super(radius, timeConstant, rotation, center);
        init();
    }

    private void init() {
        reg = Assets.instance.earth.earth;

        //Setting location and size
        position.set(0,0);
        dimension.set(25, 25);
        origin.set(dimension.x/2, dimension.y/2);
        scale.set(1, 1);
    }


}


