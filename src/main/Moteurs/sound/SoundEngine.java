package Moteurs.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SoundEngine {

    public SoundEngine(){}

    private final ConcurrentMap<String, Clip> soundsMap = new ConcurrentHashMap<>();

    public void loadSound(String path, String name){
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
        soundsMap.put(name, clip);
    }

    public void playSound(String name){
        Clip soundToPlay = soundsMap.get(name);
        soundToPlay.start();
    }

    public void stopSound(String name){
        Clip soundToStop = soundsMap.get(name);
        soundToStop.stop();
    }

    public void stopAllSound(){
        for (String sound: soundsMap.keySet()){
            stopSound(sound);
        }
    }

    public ConcurrentMap<String, Clip> getSoundsMap() {
        return soundsMap;
    }
}
