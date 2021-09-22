package Commands;

import Elements.Person;

import java.time.LocalDateTime;
import java.util.TreeSet;

/**
 * Класс команды которая выводит всю информацию о коллекции
 */
public class CommandInfo implements Command{
    /**
     * Метод который выводит всю информацию о коллекции
     *
     * @param collection - коллекция
     * @param time - время создания коллекции
     */
    String message="";
    private TreeSet<Person> collection;
    private LocalDateTime time;
    public CommandInfo(TreeSet<Person> collection, LocalDateTime time) {
        this.collection = collection;
        this.time = time;
    }
    @Override
    public String action(){
        message+="\nТип коллекции: java.util.TreeSet";
        message+="Дата создания: " + time;
        message+="Структура элемента: {id, name, coordinates.x, coordinates.y, creationDate, " +
                "Height, eyeColor, hairColor, country, location(x), location(y), " +
                "location(z)}";
        message+="Колличество элементов: " + collection.size() + "\n";
        return message;
    }
}