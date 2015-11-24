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
    public AssetMoon moon;
    public AssetMercury mercury;
    public AssetVenus venus;
    public AssetMars mars;
    public AssetMars_Phobos mars_phobos;
    public AssetMars_Deimos mars_deimos;

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
        moon = new AssetMoon(atlas);
        mercury = new AssetMercury(atlas);
        venus = new AssetVenus(atlas);
        mars = new AssetMars(atlas);
        mars_phobos = new AssetMars_Phobos(atlas);
        mars_deimos = new AssetMars_Deimos(atlas);

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

    // Declares the Moon object
    public class AssetMoon {
        public final TextureAtlas.AtlasRegion moon;

        public AssetMoon (TextureAtlas atlas) {
            moon = atlas.findRegion("moon");
        }
    }

    //Declares Mercury!
    public class AssetMercury {
        public final TextureAtlas.AtlasRegion mercury;

        public AssetMercury(TextureAtlas atlas) {
            mercury = atlas.findRegion("mercury");
        }
    }

    //Declares Venus
    public class AssetVenus {
        public final TextureAtlas.AtlasRegion venus;

        public AssetVenus(TextureAtlas atlas) {
            venus = atlas.findRegion("venus");
        }
    }

    //Declares Mars
    public class AssetMars {
        public final TextureAtlas.AtlasRegion mars;

        public AssetMars(TextureAtlas atlas) {
            mars = atlas.findRegion("mars");
        }
    }

    //Declares Mars moon PHOBOS
    public class AssetMars_Phobos {
        public final TextureAtlas.AtlasRegion mars_phobos;

        public AssetMars_Phobos(TextureAtlas atlas) {
            mars_phobos = atlas.findRegion("mars_phobos");
        }
    }

    //Declares Mars moon DEIMOS
    public class AssetMars_Deimos {
        public final TextureAtlas.AtlasRegion mars_deimos;

        public AssetMars_Deimos(TextureAtlas atlas) {
            mars_deimos = atlas.findRegion("mars_deimos");
        }
    }
}





























