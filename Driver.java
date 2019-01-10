package notDefaultPkg;
import java.util.Random;
import java.util.*;
import org.jfugue.player.Player;

public class Driver {
	public static void main (String[] args) {
		
		String[] keys = {"Emaj7", "Emaj7", "D#power", "D#power", "C#min7", "C#min7", "Bmaj", "Bmaj"};
		System.out.println("Chords: power, maj, min, maj7, min7, reg7, reg6, min6, reg9, min9");
		int barLength = 8;
		
		Riff riffTest = new Riff(keys, barLength);
		String generatedMeasure = riffTest.outputRiff();
		
		System.out.println(generatedMeasure);
		
		Player player = new Player();
		player.play(generatedMeasure);
	}
}
