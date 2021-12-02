package Moteurs.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SoundEngine {

    public SoundEngine(){}

    private final ConcurrentMap<String, Clip> clipConcurrentHashMap = new ConcurrentHashMap<>();

    public void loadSound(String path, String name){
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            e.printStackTrace();
        }
        clipConcurrentHashMap.put(name, clip);
    }

    /*
    Joue un son
     */
    public void playSound(String name){
        Clip soundToPlay = clipConcurrentHashMap.get(name);
        soundToPlay.start();
    }

    /*
    Stop un son
     */
    public void stopSound(String name){
        Clip soundToStop = clipConcurrentHashMap.get(name);
        soundToStop.stop();
    }

    /*
    Joue un son en continue (notammement pour la musique du jeu)
     */
    public void loopSound(String name){
        Clip soundToLoop = clipConcurrentHashMap.get(name);
        soundToLoop.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public ConcurrentMap<String, Clip> getClipConcurrentHashMap() {
        return clipConcurrentHashMap;
    }
}
