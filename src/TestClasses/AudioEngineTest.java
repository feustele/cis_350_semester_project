package TestClasses;

import projectSane.audioEngine;
import org.junit.Test;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException; 



public class AudioEngineTest {

    @Test 
    public void playRickRoll() {
        audioEngine.playSong("Never Gonna Give You Up (Medieval Cover).mp3");
    }

    @Test
    public void playInvalidPath() {
        
        audioEngine.playSong("BobTheBuilder.mp3");
    }

    public static void main(String args[]) {
        System.out.println(System.getProperty("user.dir"));
        
        audioEngine.playSong("Never Gonna Give You Up (Medieval Cover).mp3");
    }
}
