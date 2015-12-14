package com.martinbrunzell.solarquest.game.objects.planets;

import com.martinbrunzell.solarquest.game.Assets;

public class Venus extends AbstractPlanetObject{


    public Venus(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        super(radius, timeConstant, rotation, center);
        init();
    }

    private void init() {
        reg = Assets.instance.venus.venus;

        //Setting location and size
        position.set(0,0);
        dimension.set(20, 20);
        origin.set(dimension.x/2, dimension.y/2);
        scale.set(1, 1);
    }

}
