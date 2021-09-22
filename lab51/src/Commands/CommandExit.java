package Commands;

/**
 * Класс команды которая завершает работу программы
 */
public class CommandExit implements Command{
    /**
     * Метод который завершает работу программы
     */
    @Override
    public String action(){
        System.exit(0);

        return null; //TODO
    }

}