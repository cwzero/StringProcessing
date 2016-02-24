import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		File file = null;
		
		if (args.length < 1) {
			file = new File("index.html");
		} else {
			file = new File(args[0].endsWith(".html") ? args[0] : args[0] + ".html");
		}
		
		Scanner input = null;
		
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Pattern pattern = Pattern.compile("<a(?:[\\s]+)(?:[^>]*)(?:[\\s]*)href(?:[\\s]*)=(?:[\\s]*)([\"`’'])([^\"`’']*)\\1", Pattern.CASE_INSENSITIVE);
		String line = null;
		
		while(input.hasNextLine()) {
			line = input.nextLine();
			Matcher matcher = pattern.matcher(line);
			if (matcher.find())
				System.out.println(matcher.group(2));
		}
	}
}
