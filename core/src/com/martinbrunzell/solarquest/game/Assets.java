package com.martinbrunzell.solarquest.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.martinbrunzell.solarquest.util.Constants;
import com.sun.media.jfxmediaimpl.MediaDisposer;


public class Assets implements MediaDisposer.Disposable, AssetErrorListener{
    private static final String DEBUG_TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    private AssetManager assetManager;

    public AssetSpace space;
    public AssetSun sun;
    public AssetEarth earth;

    // Singleton class: Only one instance
    private Assets() {
        init(new AssetManager());
    }

    public void init(AssetManager assetManeger) {
        this.assetManager = assetManeger;
        //set asset manager error handler
        assetManeger.setErrorListener(this);

        //load texture atlas
        assetManeger.load(Constants.TEXTURE_ATLAS_OBJECT, TextureAtlas.class);
        //starts the loading and waits until done
        assetManeger.finishLoading();

        TextureAtlas atlas = assetManeger.get(Constants.TEXTURE_ATLAS_OBJECT);

        // enables texture filtering for pixel smoothing
      /*  for (Texture t : atlas.getTextures())
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        */

        // creates game reasource objects
        space = new AssetSpace(atlas);
        sun = new AssetSun(atlas);
        earth = new AssetEarth(atlas);

    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(DEBUG_TAG, "Coudlnt load asset [" + asset.fileName + "]", (Exception)throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    //############################################################################
    //                            ASSET CLASSES
    //############################################################################

    // Declares the space background object
    public class AssetSpace {
        public final TextureAtlas.AtlasRegion space;

        public AssetSpace(TextureAtlas atlas) {
            space = atlas.findRegion("space3");
        }
    }

    // Declares the Sun object
    public class AssetSun {
        public final TextureAtlas.AtlasRegion sun;

        public AssetSun (TextureAtlas atlas) {
            sun = atlas.findRegion("sun");
        }
    }

    // Declares the Earth object
    public class AssetEarth {
        public final TextureAtlas.AtlasRegion earth;

        public AssetEarth (TextureAtlas atlas) {
            earth = atlas.findRegion("Earth");
        }
    }

}





























