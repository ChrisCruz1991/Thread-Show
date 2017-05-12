import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * StarWarsThread class
 * This class sets all the images plus the .wav sound
 * to run the ThreadShow
 * Music: Imperial March (Star Wars)
 * @author Christopher Cruz
 *
 */
public class StarWarsThread{

	public static void main(String[] args) {

		//deathStar image
		Figures deathStar = new Figures("resources2/deathstar.png");
		deathStar.setMultiplier(0);

		//Droid image
		Figures droid = new Figures("resources2/droid.png");
		droid.setMultiplier(400);
		droid.setTimeDivisor(10);

		//republic image
		Figures republic = new Figures("resources2/republic.png");
		republic.setMultiplier(300);
		republic.setTimeDivisor(10);

		//xwing image
		Figures xWing = new Figures("resources2/xwing.png");
		xWing.setMultiplier(240);
		xWing.setTimeDivisor(10);

		//milleniumFalcon image
		Figures millFalcon = new Figures("resources2/milleniumFalcon.png");
		millFalcon.setMultiplier(320);
		millFalcon.setTimeDivisor(10);

		//tieFighter image
		Figures tieFighter = new Figures("resources2/tieFighter.png");
		tieFighter.setMultiplier(380);
		tieFighter.setTimeDivisor(10);

		//Audio clip 
		//Vader theme
		try {
			File audioFile = new File("resources2/imperial_march.wav");
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			Clip clip;

			stream = AudioSystem.getAudioInputStream(audioFile);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		}
		catch (Exception e) {
		}

	}
}

