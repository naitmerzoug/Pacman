package Moteurs.sound;

import static junit.framework.TestCase.*;

import Moteurs.physic.Type;
import org.junit.BeforeClass;
import org.junit.Test;

public class SoundTest {


    @Test
    public void assertEmptySoundsMap(){
        SoundEngine soundEngine = new SoundEngine();
        assertTrue(soundEngine.getSoundsMap().isEmpty());
    }

    @Test
    public void assertSound1Loaded(){
        SoundEngine soundEngine = new SoundEngine();
        soundEngine.loadSound("pacman_beginning.wav", "PacmanStart");
        assertTrue(soundEngine.getSoundsMap().containsKey("PacmanStart"));
    }

    @Test
    public void TestSound1Played(){
        SoundEngine soundEngine = new SoundEngine();
        soundEngine.loadSound("pacman_beginning.wav", "PacmanStart");
        assertEquals(0, soundEngine.getSoundsMap().get("PacmanStart").getFramePosition());
        soundEngine.playSound("PacmanStart");
        assertEquals(soundEngine.getSoundsMap().get("PacmanStart").getFrameLength(), soundEngine.getSoundsMap().get("PacmanStart").getFramePosition());
    }
}
