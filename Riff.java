package notDefaultPkg;
import java.util.Random;

public class Riff {
	private int barLength;
	private String[] riff;
	private String[] keys;

	Random rand = new Random();

	/* 
	 * E = chords[0]
	 * F = chords[1]
	 * F# = chords[2]
	 * G = chords[3]
	 * G# = chords[4]
	 * A = chords[5]
	 * A# = chords[6]
	 * B = chords[7]
	 * C = chords[8]
	 * C# = chords[9]
	 * D = chords[10]
	 * D# = chords[11]
	 */
	String chords[][]  = { {"E4", "F4", "F#4", "G4", "G#4", "A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5"},
			{"F4", "F#4", "G4", "G#4", "A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6"},
			{"F#4", "G4", "G#4", "A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6"},
			{"G4", "G#4", "A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6"},
			{"G#4", "A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6"},
			{"A4", "A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6", "E6"},
			{"A#4", "B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6", "E6", "F6"},
			{"B4", "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6", "E6", "F6", "F#6"},
			{"C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6", "E6", "F6", "F#6", "G6"},
			{"C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6", "E6", "F6", "F#6", "G6", "G#6"},
			{"D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6", "E6", "F6", "F#6", "G6", "G#6", "A6"},
			{"D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5", "C6", "C#6", "D6", "D#6", "E6", "F6", "F#6", "G6", "G#6", "A6", "A#6"}
	};

	int[] powerChord = {0, 2, 4, 7, 12, 0, 2, 4, 7, 12, 0, 2, 4, 7, 12, 0, 2, 4, 7, 12, 3, 5, 9, 10, 11, 3, 5, 9, 10, 11, 3, 5, 9, 10, 11, 1, 6, 8, 19, 16};
	int[] majChord = {0, 2, 4, 7, 12, 0, 2, 4, 7, 12, 0, 2, 4, 7, 12, 0, 2, 4, 7, 12, 5, 9, 11, 16, 19, 5, 9, 11, 16, 19, 5, 9, 11, 16, 19, 1, 3, 6, 8, 10};
	int[] minChord = {0, 2, 3, 7, 12, 0, 2, 3, 7, 12, 0, 2, 3, 7, 12, 0, 2, 3, 7, 12, 5, 8, 10, 15, 19, 5, 8, 10, 15, 19, 5, 8, 10, 15, 19, 1, 4, 6, 9, 11};
	int[] maj7Chord = {0, 4, 7, 11, 12, 0, 4, 7, 11, 12, 0, 4, 7, 11, 12, 0, 4, 7, 11, 12, 2, 5, 9, 16, 19, 2, 5, 9, 16, 19, 2, 5, 9, 16, 19, 1, 3, 6, 8, 10};
	int[] min7Chord = {0, 3, 7, 10, 12, 0, 3, 7, 10, 12, 0, 3, 7, 10, 12, 0, 3, 7, 10, 12, 2, 5, 8, 15, 19, 2, 5, 8, 15, 19, 2, 5, 8, 15, 19, 1, 4, 6, 9, 11};
	int[] reg7Chord = {0, 4, 7, 10, 12, 0, 4, 7, 10, 12, 0, 4, 7, 10, 12, 0, 4, 7, 10, 12, 2, 5, 9, 16, 19, 2, 5, 9, 16, 19, 2, 5, 9, 16, 19, 1, 3, 6, 8, 11};
	int[] reg6Chord = {0, 4, 7, 9, 12, 0, 4, 7, 9, 12, 0, 4, 7, 9, 12, 0, 4, 7, 9, 12, 2, 5, 9, 16, 19, 2, 5, 9, 16, 19, 2, 5, 9, 16, 19, 1, 3, 6, 8, 10};
	int[] min6Chord = {0, 3, 7, 8, 12, 0, 3, 7, 8, 12, 0, 3, 7, 8, 12, 0, 3, 7, 8, 12, 2, 5, 10, 15, 19, 2, 5, 10, 15, 19, 2, 5, 10, 15, 19, 1, 4, 6, 9, 11};
	int[] reg9Chord = {0, 4, 7, 10, 14, 0, 4, 7, 10, 14, 0, 4, 7, 10, 14, 0, 4, 7, 10, 14, 2, 5, 9, 12, 16, 2, 5, 9, 12, 16, 2, 5, 9, 12, 16, 1, 3, 6, 8, 11};
	int[] min9Chord = {0, 3, 7, 10, 14, 0, 3, 7, 10, 14, 0, 3, 7, 10, 14, 0, 3, 7, 10, 14, 2, 5, 8, 12, 15, 2, 5, 8, 12, 15, 2, 5, 8, 12, 15, 1, 4, 6, 9, 11};

	/**
	 * Constructor method that takes in a String array that 
	 * specifies the keys relative to each bar. The barLength
	 * var simply serves to count the bars.
	 * 
	 * barLength must be 2, 4, 8, 12, or 16 bars.
	 */
	public Riff(String[] keys, int barLength) {
		this.barLength = barLength;
		this.keys = keys;
		riff = new String[barLength];
		
		//if (barLength )
	}
	
	public String outputRiff() {
		String strRiff = "";
		
		// Creates the rhythms that will have their notes filled in.
		for (int n = 0; n < barLength; n++) {
			riff[n] = rhythm();
		}
		
		// Goes bar by bar and replaces each 'Z' with an appropriate note.
		for (int i = 0; i < barLength; i++) {
			// In each bar's rhythm string, generates an appropriate note.
			for (int x = 0; x < riff[i].length(); x++) {
				riff[i] = riff[i].replaceFirst("Z", generateNote(keys[i]));
			}
		}
		
		for (int p = 0; p < barLength; p++) {
			strRiff += riff[p] + " | ";
		}
		return strRiff;
	}
	
	public String rhythm() {
		String rhythmString = "";

		int n = rand.nextInt(24);
		
		switch (n) {
		case 0:
			rhythmString += "Zq Zq Zq Zq ";
			break;
		case 1:
			rhythmString += "Zh Zh ";
			break;
		case 2:
			rhythmString += "Zw ";
			break;
		case 3:
			rhythmString += "Zi Zi Zi Zi Zi Zi Zi Zi ";
			break;
		case 4:
			rhythmString += "Zi* Zi* Zi* Zi* Zi* Zi* Zi* Zi* Zi* Zi* Zi* Zi* ";
			break;
		case 5:
			rhythmString += "Zq* Zq* Zq* Zq* Zq* Zq* ";
			break;
		case 6:
			rhythmString += "Zi Zi Zq Zi Zi Zq ";
			break;
		case 7:
			rhythmString += "Zq Zq Zi Zi Zi Zi ";
			break;
		case 8:
			rhythmString += "Zi Zi Zi Zi Zq Zq ";
			break;
		case 9:
			rhythmString += "Zq ri Zi- Z-q Zi ri ";
			break;
		case 10:
			rhythmString += "Zi Zi Zi ri Zi Zi ri Zi ";
			break;
		case 11:
			rhythmString += "rq Zq rq Zq";
			break;
		case 12:
			rhythmString += "ri Zi ri Zi ri Zi ri Zi ";
			break;
		case 13:
			rhythmString += "Zi* Zi* Zi* Zq Zi* Zi* Zi* Zq ";
			break;
		case 14:
			rhythmString += "Zi* Zi* Zi* Zi* Zi* Zi* Zq Zq ";
			break;
		case 15:
			rhythmString += "Zq Zi* Zi* Zi* Zq Zi* Zi* Zi* ";
			break;
		case 16:
			rhythmString += "Zq Zi Zi Zq Zi Zi ";
			break;
		case 17:
			rhythmString += "rq Zq Zq Zq";
			break;
		case 18:
			rhythmString += "Zs Zs Zs Zs Zs Zs Zs Zs Zq Zq ";
			break;
		case 19:
			rhythmString += "Zq ri Zi Zi Zi Zi Zi ";
			break;
		case 20:
			rhythmString += "Zq* Zq* Zq* Zh ";
			break;
		case 21:
			rhythmString += "Zi Zs rs Zs rs Zs Zi Zi Zi Zi ";
			break;
		case 22:
			rhythmString += "rq rq Zi Zi Zq ";
			break;
		case 23:
			rhythmString += "Zi Zi Zi ri Zi ri Zi ri ";
			break;
		}
		return rhythmString;
	}

	/**
	 * This method takes a note and it's corresponding chord to generate
	 * a note within that chord.
	 * 
	 */
	public String generateNote(String key) {
		String note = "";
		String chord = "";

		// First, the string will separate between the note and its corresponding chord.

		// A boolean to recognize black key notes.
		if (key.contains("#") || key.contains("b")) {
			note = key.substring(0, 2);
			chord = key.substring(2);

			// Converts flat accidentals to their sharp equivalent.
			if (key.contains("b")) 
				note = getEquivalent(note);	
		}
		else {
			note = key.substring(0, 1);
			chord = key.substring(1);
		}

		// Then, randomly selects an index from the chord arrays. 
		int arrayPtr;
		// pre-selected random index, to select a chord index.
		int randIndex = getNextArrayPos();
		switch (chord) {
		case "power": arrayPtr = powerChord[randIndex];
		break;
		case "maj": arrayPtr = majChord[randIndex];
		break;
		case "min": arrayPtr = minChord[randIndex];
		break;
		case "maj7": arrayPtr = maj7Chord[randIndex];
		break;
		case "min7": arrayPtr = min7Chord[randIndex];
		break;
		case "reg7": arrayPtr = reg7Chord[randIndex];
		break;
		case "reg6": arrayPtr = reg6Chord[randIndex];
		break;
		case "min6": arrayPtr = min6Chord[randIndex];
		break;
		case "reg9": arrayPtr = reg9Chord[randIndex];
		break;
		case "min9": arrayPtr = min9Chord[randIndex];
		break;
		default: { arrayPtr = powerChord[randIndex];
		System.out.println("ERROR: chord not recognized");
		break;
		}
		}

		String generatedNote ="";
		// Finally, selects a note from the two-dimensional note array.
		switch (note) {
		case "E": generatedNote = chords[0][arrayPtr];
		break;
		case "F": generatedNote = chords[1][arrayPtr];
		break;
		case "F#": generatedNote = chords[2][arrayPtr];
		break;
		case "G": generatedNote = chords[3][arrayPtr];
		break;
		case "G#": generatedNote = chords[4][arrayPtr];
		break;
		case "A": generatedNote = chords[5][arrayPtr];
		break;
		case "A#": generatedNote = chords[6][arrayPtr];
		break;
		case "B": generatedNote = chords[7][arrayPtr];
		break;
		case "C": generatedNote = chords[8][arrayPtr];
		break;
		case "C#": generatedNote = chords[9][arrayPtr];
		break;
		case "D": generatedNote = chords[10][arrayPtr];
		break;
		case "D#": generatedNote = chords[11][arrayPtr];
		break;
		}

		return generatedNote;
	}

	public int getNextArrayPos() {
		return rand.nextInt(40);
	}

	/**
	 * Converts an accidental with a flat into it's sharp equivalent. 
	 * For example, Bb would change to A#.
	 * @param flatAccid
	 * @return sharpEquivalent 
	 */
	public String getEquivalent(String flatAccid) {
		String sharpEquivalent = "";
		switch (flatAccid) {
		case "Bb": sharpEquivalent = "A#";
		break;
		case "Db": sharpEquivalent = "C#";
		break;
		case "Eb": sharpEquivalent = "D#";
		break;
		case "Gb": sharpEquivalent = "F#";
		break;
		case "Ab": sharpEquivalent = "G#";
		break;
		default: sharpEquivalent = "invalid note";
		break;
		}

		return sharpEquivalent;
	}
}