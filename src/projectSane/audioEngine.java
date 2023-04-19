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

/**
 * The audioEngine plays a track when called
 * used when the game calls for a certain song in a certain room
 */


public class audioEngine {
	static Clip track;
	// used for stopping tracks within levels
	
	public static void playSong(String songName) {
		// takes in the string of the name of the song in question
		try {

			String path = "Music/" + songName;
			// formats to the path where the song is
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(path));
			// creates a stream from that file
			Clip track = AudioSystem.getClip();
			// clip from the stream
			track.open(stream);
			// opens the clip
			track.loop(2);
			// runs the clip twice as each clip is around 30 seconds
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

