package com.martinbrunzell.solarquest.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.sun.media.jfxmediaimpl.MediaDisposer;

public class Assets implements MediaDisposer.Disposable, AssetErrorListener{
    private static final String DEBUG_TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    private AssetManager assetManager;

    // Singleton class: Only one instance
    private Assets() {}

    public void init(AssetManager assetManeger) {
        this.assetManager = assetManeger;
        //TODO FINNISH CLASS
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {

    }

    @Override
    public void dispose() {

    }
}
