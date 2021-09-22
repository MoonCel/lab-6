package Manager;

import Elements.Person;

import java.time.LocalDateTime;
import java.io.*;

import java.util.TreeSet;

public class Manager {
    /**
     * Заполнение коллекции при первом запуске
     *
     * @param InPut - входный файл
     * @param collection - коллекция
     */
    public void fill(String InPut, TreeSet<Person> collection) throws FileNotFoundException {
        File file = new File(InPut);
        FileInputStream fis = null;

        fis = new FileInputStream(file);



        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String[] fields;
        String element = null;
        int index;
        while (true) {
            Person person = new Person();
            try {
                element = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (element == null) break;
            fields = element.split(",");

            for (index = 0; index<fields.length; index++){
                if (fields[index].equals("null")){
                    fields[index] = null;
                }
            }

            person.setId(fields[0]);
            person.setName(fields[1]);
            person.setCoordinates(fields[2], fields[3]);
            person.setCreationDate(fields[4]);
            person.setHeight(fields[5]);
            person.setEyeColor(fields[6]);
            person.setHairColor(fields[7]);
            person.setCountry(fields[8]);
            person.setLocation(fields[9],fields[10],fields[11]);
            collection.add(person);
        }
    }
    /**
     * Добавляет новый файл в коллекцию
     *
     * @param element - элемент который вводят с консоли
     * @param collection - коллекция
     */
    public void add (String element, TreeSet<Person> collection, boolean idIsUpdated, int oldId){
        Person person = new Person();
        LocalDateTime today = LocalDateTime.now();
        String[] fields;
        String id;
        int index;
        fields = element.split(",");
        System.out.println(fields.length);
        if (fields.length == 10) {
            for (index = 0; index < fields.length; index++) {
                if (fields[index].equals("null")) {
                    fields[index] = null;
                }
            }
            /*for (int i = 0; i<12; i++) {
                System.out.println(i + ": " + fields[i]);
            }*/
            if (!idIsUpdated) {
                id = String.valueOf(Math.round(Math.random() * 1000000 + 1));
            } else {
                id = String.valueOf(oldId);
            }
            person.setId(id);
            person.setName(fields[0]);
            person.setCoordinates(fields[1], fields[2]);
            person.setCreationDate(today.toString());
            person.setHeight(fields[3]);
            person.setEyeColor(fields[4]);
            person.setHairColor(fields[5]);
            person.setCountry(fields[6]);
            person.setLocation(fields[7],fields[8],fields[9]);

            collection.add(person);
            if (!idIsUpdated) {
                System.out.println("\nЭлемент добавлен в коллекцию\n");
            }
        } else {
            System.out.println("\nНеверный формат элемента\n");
        }
    }
    /**
     * Обновляет поле id у элемента коллекции
     *
     * @param element - исходный элемент коллекции
     * @return - элемент с обновлённым id
     */
    public Person idUpdate (String element){
        Person person = new Person();
        String[] fields;
        String id;
        fields = element.split(",");
        id = String.valueOf(Math.round(Math.random() * 1000000 + 1));
        while(fields[0] == id){
            id = String.valueOf(Math.round(Math.random() * 1000000 + 1));
        }
        fields[0] = id;
        person.setId(fields[0]);
        person.setName(fields[1]);
        person.setCoordinates(fields[2], fields[3]);
        person.setCreationDate(fields[4]);
        person.setHeight(fields[5]);
        person.setEyeColor(fields[6]);
        person.setHairColor(fields[7]);
        person.setCountry(fields[8]);
        person.setLocation(fields[9],fields[10],fields[11]);
        return (person);
    }
    public Person set(String element){
        Person person = new Person();
        String[] fields;
        fields = element.split(",");
        person.setId(fields[0]);
        person.setName(fields[1]);
        person.setCoordinates(fields[2], fields[3]);
        person.setCreationDate(fields[4]);
        person.setHeight(fields[5]);
        person.setEyeColor(fields[6]);
        person.setHairColor(fields[7]);
        person.setCountry(fields[8]);
        person.setLocation(fields[9],fields[10],fields[11]);
        return (person);
    }
}
