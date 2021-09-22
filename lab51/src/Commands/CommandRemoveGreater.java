package Commands;

import Elements.Person;

import java.time.LocalDateTime;
import java.util.TreeSet;

/**
 * Класс команды который удаляет из коллекции все элементы, большие, чем заданный
 */
public class CommandRemoveGreater implements Command{
    /**
     * Метод который удаляет из коллекции все элементы, большие, чем заданный
     *
     * @param command - команда которую вводят с консоли
     * @param collection - коллекция
     */
    String message="";
    private String command;
    private TreeSet<Person> collection;
    public CommandRemoveGreater(String command, TreeSet<Person> collection) {
        this.command = command;
        this.collection = collection;
    }
    @Override

    public String action(){
        String[] field;
        Object[] arr;
        String element;
        boolean work;
        work = false;
        int index;
        field = command.split(" ");
        if (field.length == 1){
            message="\nЭлемент отсутствует\n";
        } else if (field.length >= 2){
            element = field[1];
            if (field.length > 2){
                for (index = 2; index<field.length; index++) {
                    element = element + " " + field[index];
                }
            }
            arr = collection.toArray();
            for (index = 0; index<collection.size(); index++) {

                if (element.hashCode() < arr[index].hashCode()) {
                    collection.remove(arr[index]);
                    work = true;
                }
            }
            if (!work) {
                message="\nЭлементов меньше указанного не существует\n";

            } else message="\nНаибольшие элементы удалены\n";

        } else message="\nНеверный формат ввода данных\n";

        return message;
    }
}
