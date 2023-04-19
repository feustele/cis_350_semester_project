package projectSane;
import java.io.File;
import java.io.IOException;

//import javax.media.*;
import java.net.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class audioEngine {
	
	public static void playSong(String songName) {
		try {

			String path = "Music/" + songName;
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(path));
			Clip track = AudioSystem.getClip();
			track.open(stream);
			//track.loop(0);
			track.start();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}

}

