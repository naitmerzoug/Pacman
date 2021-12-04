package Moteurs.sound;

import static junit.framework.TestCase.*;

import org.junit.Assert;

import org.junit.Test;


/**
 * Tests du moteur sonore
 */
public class SoundTest {

    /**
     * Test de la création de la HashMap de son
     */
    @Test
    public void assertEmptySoundsMap(){
        SoundEngine soundEngine = new SoundEngine();
        assertTrue(soundEngine.getClipConcurrentHashMap().isEmpty());
    }

    /**
     * Test de l'insertion d'un son
     */
    @Test
    public void assertSound1Loaded(){
        SoundEngine soundEngine = new SoundEngine();
        soundEngine.loadSound("/PacmanGame/Sounds/pacman_beginning.wav", "PacmanStart");
        assertTrue(soundEngine.getClipConcurrentHashMap().containsKey("PacmanStart"));
    }

    /**
     * Test pour savoir si un son est joué
     */
    @Test
    public void TestSound1Played(){
        SoundEngine soundEngine = new SoundEngine();
        soundEngine.loadSound("/PacmanGame/Sounds/pacman_beginning.wav", "PacmanMusique");
        int frames = soundEngine.getClipConcurrentHashMap().get("PacmanMusique").getFrameLength();
        assertEquals(0, soundEngine.getClipConcurrentHashMap().get("PacmanMusique").getFramePosition());
        soundEngine.playSound("PacmanMusique");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(frames, soundEngine.getClipConcurrentHashMap().get("PacmanMusique").getFramePosition());
    }

    /**
     * Test pour savoir si un son est stoppé
     */
    @Test
    public void TestSound2Stopped(){
        SoundEngine soundEngine = new SoundEngine();
        soundEngine.loadSound("/PacmanGame/Sounds/pacman_chomp.wav", "PacmanEatCoin");
        int frames = soundEngine.getClipConcurrentHashMap().get("PacmanEatCoin").getFrameLength();
        assertEquals(0, soundEngine.getClipConcurrentHashMap().get("PacmanEatCoin").getFramePosition());
        soundEngine.playSound("PacmanEatCoin");
        soundEngine.stopSound("PacmanEatCoin");
        assertEquals(0, soundEngine.getClipConcurrentHashMap().get("PacmanEatCoin").getMicrosecondPosition());
    }

    /**
     * Test si un son est joué en boucle
     */
    @Test
    public void TestSound3Loop(){
        SoundEngine soundEngine = new SoundEngine();
        soundEngine.loadSound("/PacmanGame/Sounds/pacman_death.wav", "PacmanDeath");
        int frames = soundEngine.getClipConcurrentHashMap().get("PacmanDeath").getFrameLength();
        assertEquals(0, soundEngine.getClipConcurrentHashMap().get("PacmanDeath").getFramePosition());
        soundEngine.loopSound("PacmanDeath");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Assert.assertNotEquals(0, soundEngine.getClipConcurrentHashMap().get("PacmanDeath").getMicrosecondLength());
    }

}
