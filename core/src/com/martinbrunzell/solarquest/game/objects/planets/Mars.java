package com.martinbrunzell.solarquest.game.objects.planets;

import com.martinbrunzell.solarquest.game.Assets;

public class Mars extends AbstractPlanetObject {


    public Mars(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        super(radius, timeConstant, rotation, center);
        init();
    }

    private void init() {
        reg = Assets.instance.mars.mars;

        //Setting location and size
        position.set(0,0);
        dimension.set(19, 19);
        origin.set(dimension.x/2, dimension.y/2);
        scale.set(1, 1);
    }


}
