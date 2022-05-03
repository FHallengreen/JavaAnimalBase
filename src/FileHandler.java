import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileHandler {

    public void loadAnimalsToFile(ArrayList<Animal> animals) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("animals.csv"));
        while  (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            Scanner input = new Scanner(line).useDelimiter(";").useLocale(Locale.ENGLISH);
            String name = input.next();
            String description = input.next();
            String type = input.next();
            int age = input.nextInt();
            double weight = input.nextDouble();
            Animal animal = new Animal(name,description,type,age,weight);
            animals.add(animal);
        }
    }

    public void saveAnimalsToFile(ArrayList<Animal> animals) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("animals.csv"));
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            out.print(animal.getName());
            out.print(";");
            out.print(animal.getDesc());
            out.print(";");
            out.print(animal.getType());
            out.print(";");
            out.print(animal.getAge());
            out.print(";");
            out.print(animal.getWeight());
            out.print("\n");
        }
    }
}
