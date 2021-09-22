package Commands;

import Elements.Person;
import Manager.Manager;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Класс команды которая обновляет id элемента
 */
public class CommandUpdateID implements Command{
    /**
     * Метод который обновляет id элемента
     *
     * @param command - команда которую вводят с консоли
     * @param collection - коллекция
     */

    private String command;
    private TreeSet<Person> collection;
    public CommandUpdateID(String command, TreeSet<Person> collection) {
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
        String id = null;
        fields = command.split(" ");
        if (fields.length == 2){
            arr = collection.toArray();
            for (index = 0; index<collection.size(); index++){
                id = ((Person) arr[index]).getId().toString();
                if (id.equals(fields[1])){
                    collection.remove((arr[index]));
                    work = true;
                }
            }
        } else {
            System.out.println("\nНеверный формат ввода данных\n"); //TODO
            work = false;
        }
        if (!work) System.out.println("\nНе найдено элемента с таким id\n");

        //------------------------ADDING---------------------------//

        Manager manager = new Manager();
        Scanner in = new Scanner(System.in);
        String element = "";
        String field[] = new String[]{
                //"Id: ",
                "Name: ",
                "X: ",
                "Y: ",
                //"CreationDate: ",
                "Height: ",
                "EyeColor (BLUE, GREEN, RED, ORANGE, BROWN): ",
                "HairColor (BLUE, GREEN, RED, ORANGE, BROWN): ",
                "Country (FRANCE, CHINA, INDIA): ",
                "x: ",
                "y: ",
                "z: "
        } ;
        for (int i = 0; i<10; i++){
            System.out.print(field[i]); //TODO
            element = element + "," + in.nextLine();
        }
        element = element.substring(1);

        manager.add(element, collection, true, Integer.parseInt(id));
        return "Элемент успешно обновлен";
    }
}
