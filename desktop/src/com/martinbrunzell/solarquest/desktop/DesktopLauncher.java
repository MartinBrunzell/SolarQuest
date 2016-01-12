package com.martinbrunzell.solarquest.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.martinbrunzell.solarquest.SolarQuestMain;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;


public class DesktopLauncher {
    private static boolean rebuildAtlas = false; // Rebuild atlas true/false
    private static boolean drawDebugOutline = false; // Put debug borders on regions true/false

	public static void main (String[] arg) {
        //Chooses weather to rebuild atlas(load all images) or not
        if(rebuildAtlas) {
            Settings settings = new Settings();
            settings.maxWidth = 1024 * 2;
            settings.maxHeight = 1024 * 2;
            settings.duplicatePadding = false;
            settings.debug = drawDebugOutline;
            settings.atlasExtension="";
            TexturePacker.process(settings, "assets-raw/images", "images", "solarquest.pack" );
            TexturePacker.process(settings, "assets-raw/images-ui", "images", "solarquest-ui.pack");
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SolarQuestMain(), config);

        config.title = "Solar Quest";
        config.height = 480;
        config.width = 800;


	}
}
