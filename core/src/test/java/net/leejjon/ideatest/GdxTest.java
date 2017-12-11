package net.leejjon.ideatest;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.File;

import static org.mockito.Mockito.mock;

/**
 * Credits to this method for setting up tests:
 * http://manabreak.eu/java/2016/10/21/unittesting-libgdx.html
 */
public class GdxTest {
    private static Application application;
    protected static Preferences preferences;
    protected static Array<String> logMessages = new Array<>();

    @BeforeClass
    public static void init() {
        // Note that we don't need to implement any of the listener's methods
        application = new HeadlessApplication(new ApplicationListener() {
            @Override public void create() {

            }
            @Override public void resize(int width, int height) {}
            @Override public void render() {}
            @Override public void pause() {}
            @Override public void resume() {}
            @Override public void dispose() {}
        }) {
            @Override
            public Preferences getPreferences(String name) {
                return preferences;
            }

            @Override
            public void log(String tag, String message) {
                logMessages.add(message);
            }

            @Override
            public void log(String tag, String message, Throwable exception) {
                logMessages.add(message);
            }
        };

        // Use Mockito to mock the OpenGL methods since we are running headlessly
        Gdx.gl20 = mock(GL20.class);
        Gdx.gl = Gdx.gl20;
    }

    @Before
    public void setup() {
        preferences = mock(Preferences.class);
    }


    @After
    public void reset() {
        logMessages.clear();
    }

    @AfterClass
    public static void cleanUp() {
        // Exit the application first
        application.exit();
        application = null;
    }
}
