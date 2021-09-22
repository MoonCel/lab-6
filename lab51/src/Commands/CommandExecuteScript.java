package Commands;

import Elements.Person;

import java.io.*;
import java.time.LocalDateTime;
import java.util.TreeSet;

/**
 * Класс команды которая считывает команды из файла и выполняет их
 */
public class CommandExecuteScript implements Command {
    /**
     * Метод который считывает команды из файла и выполняет их
     *
     * @param collection - коллекция
     * @param line       - строка котрую вводят с консоли
     * @param command    - комманда котрую вводят с консоли
     * @param file       - файл в котором храниться коллекция
     * @param time       - текущее время
     */
    public boolean executeStatus = false;
    String message="";
    private String command;
    private TreeSet collection;
    private String line;
    private String file;
    private LocalDateTime time;
    public CommandExecuteScript(TreeSet<Person> collection, String line, String command, String file, LocalDateTime time) {
        this.command = command;
        this.collection = collection;
        this.line = line;
        this.file = file;
        this.time = time;
    }
    @Override
    public String action() {
        //execute_script commands.txt
        //String temp = System.getenv().get("PersonPATH");
        String[] fields;
        fields = line.split(" ");
        int index;
        String InPut;

        if (fields.length >= 2) {
            InPut = /*temp +*/ fields[1];
            if (fields.length >= 3) {
                for (index = 2; index < fields.length; index++) {
                    InPut = InPut + " " + fields[index];
                }
            }
            File way = new File(InPut);
            FileInputStream fis = null;

            try {
                fis = new FileInputStream(way);
            } catch (FileNotFoundException e) {
                message="Файл не найден";
            }

            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String newLine = null;
            while (true)
            {
                if(!executeStatus)
                {
                    try {
                        newLine = br.readLine();
                        //System.out.println(newLine);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {

                }
                if (newLine == null) break;
                String[] newCommand;
                newCommand = newLine.split(" ");
                //System.out.println(newCommand[0]);
                CommandExecution commandExecution = new CommandExecution(collection, newCommand[0],newLine, file, time);
                commandExecution.action();
            }

        } else message="\nНеверный формат ввода данных\n";

        return message;
    }
}