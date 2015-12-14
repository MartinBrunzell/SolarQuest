package com.martinbrunzell.solarquest.game.objects.planets;

import com.martinbrunzell.solarquest.game.Assets;
import com.martinbrunzell.solarquest.util.Constants;

public class Sun extends AbstractPlanetObject {

    public Sun(float radius, float timeConstant, float rotation, AbstractPlanetObject center) {
        super(radius, timeConstant, rotation, center);
        init();
    }

    private void init() {
        reg = Assets.instance.sun.sun;

        //Setting location and size
        position.set(((Constants.BACKGROUND_DIMENSION * (Constants.BACKGROUND_TILES_AMOUNT) ) / 2) - 75,
                ((Constants.BACKGROUND_DIMENSION * 8 ) / 2) -75);
        dimension.set(150, 150);
        origin.set(75, 75);
        scale.set(1,1);

        //Choosing the time-constant
    }


    @Override
    public void update(float deltaTime) {
        rotation += 5 * deltaTime;
    }



    //######################
    //      GETTERS
    //######################

}
