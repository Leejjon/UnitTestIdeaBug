package net.leejjon.ideatest;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class FileTest extends GdxTest {

    @Test
    public void testWithoutUsingFile() {
        assertTrue(true);
    }

    /**
     * This test succeeds when using gradlew on the commandline, but fails in IntelliJ OR Android Studio.
     */
    @Test
    public void testLoadingImage() {
        String relativePath = String.format("..%1$sandroid%1$sassets%1$s", File.separator);
        Texture texture = new Texture(relativePath + "badlogic.jpg");
        Image image = new Image(texture);
        assertNotNull(image);
    }
}
