package Commands;

/**
 * Класс от которого наследуются все команды
 */
interface Command  {
    /**
     * Метод который запускает выполнение команды
     */
    public String action();

}
