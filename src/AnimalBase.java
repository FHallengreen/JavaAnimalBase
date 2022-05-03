import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AnimalBase {

    private ArrayList<Animal> animals;
    FileHandler handler = new FileHandler();

    public AnimalBase() {
        animals = new ArrayList<>();
    }

    public void start() throws FileNotFoundException {
        loadDatabase();
        UserInterface ui = new UserInterface(this);
        ui.start();
    }

    public static void main(String[] args) throws FileNotFoundException {
        AnimalBase app = new AnimalBase();
        app.start();
    }

    public Iterable<Animal> getAllAnimals() {
        return animals;
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void sortBy(String sortBy, SortDirection sortDirection) {
        // TODO: Implement sorting!
        System.out.println("TODO: Sort the list of animals by: " + sortBy);
    }

    public void createNewAnimal(String name, String description, String type, int age, double weight) {
        Animal animal = new Animal(name, description, type, age, weight);
        animals.add(animal);
    }

    public boolean deleteAnimal(String name) {
        // find animal with this name
        Animal animal = findAnimalByName(name);
        if (animal == null) {
            return false;
        } else {
            animals.remove(animal);
            return true;
        }
    }

    private Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }


    public void loadDatabase() {
        try {
        handler.loadAnimalsToFile(animals);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    public void saveDatabase() throws FileNotFoundException {

        handler.saveAnimalsToFile(animals);

    }
}
