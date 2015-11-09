package com.martinbrunzell.solarquest.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.martinbrunzell.solarquest.SolarQuestMain;


public class DesktopLauncher {
	public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SolarQuestMain(), config);

        config.title = "Solar Quest";
        config.height = 480;
        config.width = 800;


	}
}
