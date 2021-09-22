package Commands;

import Elements.Person;

import java.util.TreeSet;

/**
 * Класс команды которая удаляет все элементы из коллекции
 */
public class CommandClear implements Command{
    /**
     * Метод который удаляет все элементы из коллекции
     *
     */
    String message="";
    private TreeSet collection;
    public CommandClear(TreeSet<Person> collection) {
        this.collection = collection;
    }
    @Override
    public String action(){
        collection.clear();
        message+="\nКоллекция успешно очищена\n";

        return message;
    }
}
