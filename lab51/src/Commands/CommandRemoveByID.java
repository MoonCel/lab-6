package Commands;

import Elements.Person;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Класс команды которая удаляет все элементы с указанным id
 */
public class CommandRemoveByID implements Command{
    /**
     * Метод который удаляет все элементы с указанным id
     *
     * @param command - команда которую вводят с консоли
     * @param collection - коллекция
     */
    String message="";
    private TreeSet<Person> collection;
    private String command;
    public CommandRemoveByID(String command, TreeSet<Person> collection) {
        this.collection = collection;
        this.command = command;

    }
    @Override
    public String action(){
        String[] fields;
        Object[] arr;
        boolean work;
        work = false;
        int index;
        String id;
        fields = command.split(" ");
        if (fields.length == 2){
            arr = collection.toArray();
            for (index = 0; index<collection.size(); index++){
                //id = (arr[index].toString()).split(",");
                id = ((Person) arr[index]).getId().toString();
                if (id.equals(fields[1])){
                    collection.remove((arr[index]));
                    message="\nЭлемент успешно удалён\n";
                    work = true;
                } else {
                    message="\nНеверный формат ввода данных\n";

                }
            }
        }
        if (!work) message="\nНе найдено элемента с таким id\n";

        return message;
    }
}
