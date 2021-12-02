package Moteurs.sound;

import static junit.framework.TestCase.*;

import Moteurs.physic.Type;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SoundTest {


    @Test
    public void assertEmptySoundsMap(){
        SoundEngine soundEngine = new SoundEngine();
        assertTrue(soundEngine.getSoundsMap().isEmpty());
    }

    @Test
    public void assertSound1Loaded(){
        SoundEngine soundEngine = new SoundEngine();
        soundEngine.loadSound("src/assets/sound/pacman_beginning.wav", "PacmanStart");
        assertTrue(soundEngine.getSoundsMap().containsKey("PacmanStart"));
    }

    @Test
    public void TestSound1Played(){
        SoundEngine soundEngine = new SoundEngine();
        Path currentRelativePath = Paths.get("");
        soundEngine.loadSound(currentRelativePath.toAbsolutePath().toString()+ "/src/assets/sound/pacman_beginning.wav", "PacmanMusique");
        int frames = soundEngine.getSoundsMap().get("PacmanMusique").getFrameLength();
        assertEquals(0, soundEngine.getSoundsMap().get("PacmanMusique").getFramePosition());
        soundEngine.playSound("PacmanMusique");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(frames, soundEngine.getSoundsMap().get("PacmanMusique").getFramePosition());
    }

    // Lancer un son
}
