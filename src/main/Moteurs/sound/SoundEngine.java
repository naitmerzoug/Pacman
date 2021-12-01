package Moteurs.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SoundEngine {

    public SoundEngine(){}

    private final ConcurrentMap<String, Clip> soundsMap = new ConcurrentHashMap<>();

    public void loadSound(String path, String name){
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    SoundEngine.class.getResourceAsStream(path));
            clip.open(inputStream);
        } catch (Exception e){
            System.err.println(e.getMessage());
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
