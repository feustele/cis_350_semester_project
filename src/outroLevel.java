import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class outroLevel extends Room {
	//prevents a monster from being spawned in this room.
		@Override
		public void roomEngine() {
			outroLevel out = new outroLevel();
			out.enemySpawnChance = 0;
			Scanner scnr = new Scanner(System.in);
			try {
				BufferedReader outro = new BufferedReader(new FileReader("outro.txt"));
				String line;
				while ((line = outro.readLine()) != null && scnr.next().equals("/n")) {
					System.out.print(line);
				}
				//reads out room enter text
				outro.close();
				System.out.println("Do retrieve the Mysterious Amulet?");
				String word1 = scnr.next();
				if (word1.equalsIgnoreCase("NO") || word1.equalsIgnoreCase("N")) {
					//if the player chooses not to take the amulet, the game ends.
					try {
						BufferedReader badBuffer = new BufferedReader(new FileReader("badOutro.txt"));
						while ((line = badBuffer.readLine()) != null && scnr.next().equals("/n")) {
							System.out.print(line);
						}
						badBuffer.close();
						IOException end = new IOException();
						throw end;
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (word1.equalsIgnoreCase("YES") || word1.equalsIgnoreCase("Y")) {
					{
						try {
							BufferedReader goodBuffer = new BufferedReader(new FileReader("goodOutro.txt"));
							while ((line = goodBuffer.readLine()) != null && scnr.next().equals("/n")) {
								System.out.print(line);
							}
							goodBuffer.close();
							IOException end = new IOException();
							throw end;
						}
						// reads out ending text.
						catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
}