package Commands;
import Elements.Person;

import java.util.TreeSet;

/**
 * Класс команды которая выводит все элементы коллекции
 */
public class CommandShow implements Command {
    /**
     * Метод который выводит все элементы коллекции
     *
     * @param collection - коллекция
     */
    String message="";
    private TreeSet<Person> collection;
    public CommandShow(TreeSet<Person> collection) {
        this.collection = collection;
    }
    @Override

    public String action(){
        Person[] arr;
        arr = collection.toArray(new Person[0]);
        for (int i =0; i < collection.size(); i++){
            if (i == 0) {
                show(arr[i]);
            } else if (i == collection.size()-1) {
                show(arr[i]);
            } else show(arr[i]);
        }
        return message;
    }
    private void show(Person person){
        message+="id: "+ person.getId() + "\n";
        message+="Name: "+ person.getName() + "\n";
        message+="Coordinates: "+ person.getCoordinates().getX() + "\n";
        message+="Coordinates: "+ person.getCoordinates().getY() + "\n";
        message+="Country: "+ person.getCountry() + "\n";
        message+="CreationDate: "+ person.getCreationDate() + "\n";
        message+="EyeColor: "+ person.getEyeColor().toString() + "\n";
        message+="HairColor: "+ person.getHairColor().toString() + "\n";
        message+="Height: "+ person.getHeight() + "\n";
        message+="\tLocation X: "+ person.getLocation().getXloc() + "\n";
        message+="\tLocation Y: "+ person.getLocation().getYloc() + "\n";
        message+="\tLocation Z: "+ person.getLocation().getZloc() + "\n";

        message+=person.getLocation();

    }
}
