package Moteurs.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Moteur sonore
 */
public class SoundEngine {


    private final ConcurrentMap<String, Clip> clipConcurrentHashMap = new ConcurrentHashMap<>();

    /**
     * Charge un son
     * @param path Chermin vers le son audio
     * @param name Nom du son
     */
    public void loadSound(String path, String name){
        Clip clip = null;
        File file = new File(path);

        try {
            clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(String.valueOf(file)));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            e.printStackTrace();
        }
        clipConcurrentHashMap.put(name, clip);
    }

    /**
     * Joue un son
     * @param name Nom du son
     */
    public void playSound(String name){
        Clip soundToPlay = clipConcurrentHashMap.get(name);
        soundToPlay.start();
    }

    /**
     * Arrête un son
     * @param name Nom du son
     */
    public void stopSound(String name){
        Clip soundToStop = clipConcurrentHashMap.get(name);
        soundToStop.stop();
    }

    /**
     * Joue un son en continue
     * @param name Nom du son
     */
    public void loopSound(String name){
        Clip soundToLoop = clipConcurrentHashMap.get(name);
        soundToLoop.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // Getter

    public ConcurrentMap<String, Clip> getClipConcurrentHashMap() {
        return clipConcurrentHashMap;
    }
}
