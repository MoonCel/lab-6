package Commands;
import Elements.Person;

import java.util.TreeSet;

/**
 * Класс команды который выводит элементы, значение поля name которых содержит заданную подстроку
 */
public class CommandFilterContains implements Command {
    /**
     * Метод который выводит элементы, значение поля name которых содержит заданную подстроку
     *
     */
    String message="";
    private String line;
    private TreeSet<Person> collection;
    public CommandFilterContains(String line, TreeSet<Person> collection) {
        this.line = line;
        this.collection = collection;
    }
    @Override
    public String action(){
        Person[] arr;
        arr = collection.toArray(new Person[0]);
        for (int i =0; i < collection.size(); i++){
            if (i == 0) {
                show(arr[i], line);
            } else if (i == collection.size()-1) {
                show(arr[i], line);
            } else show(arr[i], line);
        }
         return message;
    }
    private void show(Person person,String line){
        if (person.getName().contains(line)) {

            message+="id: " + person.getId() +"\n";
            message+="Name: " + person.getName();
            message+="Coordinates: " + person.getCoordinates().getX() +"\n";
            message+="Coordinates: " + person.getCoordinates().getY() +"\n";
            message+="Country: " + person.getCountry() +"\n";
            message+="CreationDate: " + person.getCreationDate() +"\n";
            message+="EyeColor: " + person.getEyeColor().toString() +"\n";
            message+="HairColor: " + person.getHairColor().toString() +"\n";
            message+="Height: " + person.getHeight() +"\n";
            message+="\tLocation X: " + person.getLocation().getXloc() +"\n";
            message+="\tLocation Y: " + person.getLocation().getYloc() +"\n";
            message+="\tLocation Z: " + person.getLocation().getZloc() +"\n";

            message+=person.getLocation();
        }
    }
}
