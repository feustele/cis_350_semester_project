package TestClasses;

import projectSane.audioEngine;
import org.junit.Test;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException; 



public class AudioEngineTest {

    @Test 
    public void playRickRoll() {
        audioEngine.playSong("rickroll.wav");
    }

    @Test
    public void playInvalidPath() {
        
        audioEngine.playSong("BobTheBuilder.mp3");
    }

    public static void main(String args[]) {
        System.out.println(System.getProperty("user.dir"));
        
        audioEngine.playSong("rickroll.wav");
    }
}
