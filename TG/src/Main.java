import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<String> listaStringova = null;
		try (Stream<String> stream = Files.lines(
		new File("@../dat/tvrdiDiskovi.txt").toPath())) {
		listaStringova = stream.collect(Collectors.toList());
		} catch (IOException e) {
		 e.printStackTrace();
		 
		}
		
		for (String string : listaStringova) {
		System.out.println(string);
	}
		}

}
