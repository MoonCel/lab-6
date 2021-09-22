import Commands.*;
import Elements.Person;
import Manager.Manager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    private static final TreeSet<Person> collection = new TreeSet<Person>(new PersonComparator()); // коллекция
    private static final int port = 4004; // порт для подключения
    private static final Serialization serialization = new Serialization(); // сериализптор/десериализатор
    private static final LocalDateTime today = LocalDateTime.now(); //
    private static String file = null; // файл с коллекцией
    private static final String serializedDate = "C:\\Users\\Евгений\\IdeaProjects\\lab51\\src\\Files\\serializedDate.txt"; // файл для передачи сериализованных сообщений

    public static void main(String[] args) {
        Manager manager = new Manager();
        while (true){
            try {
                System.out.print("Путь к файлу: ");
                Scanner scanner = new Scanner(System.in);
                file = scanner.nextLine();
                manager.fill(file, collection);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }
        }
        System.out.println("\nhelp : вывести справку по доступным командам\n");

        try {
            System.out.println("Сервер запущен!");
            while (true) {
                connection(true);
                while (true) {
                    String message = read();
                    System.out.println("Сервер принял команду: " + message);
                    if (message != null) {
                        write(message, "get");
                        if (message.equals("exit")) {
                            connection(false);
                            break;
                        }
                        write(message, "send");
                    }
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("save? (y/n): ");
                    String nigger = scanner.nextLine();
                    if (nigger.equals("y")) {
                        CommandSave commandSave = new CommandSave(file, collection);
                        commandSave.action();
                        System.out.println("collection saved");
                    } else if (nigger.equals("n")) {
                        System.out.println("collection not saved");
                        continue;
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }
    }
    /**
     * Модуль выполнения команд
     *
     * @param message - сообщение принятое от клиент
     * @param serializedDate - файл, где храниться сериализованная команда
     */
    public static void execution(String message, String serializedDate){
        String command;
        String[] field;
        field = message.split(" ");
        command = field[0];
        CommandExecution commandExecution = new CommandExecution(collection, message, command, file, today);
        serialization.SerializeObject(commandExecution.action(), serializedDate);
    }

    /**
     * Модуль приёма подключений
     *
     * @param connect - режим работы (отключиться/подключиться)
     * @throws IOException - ошибка подключения
     */
    public static void connection(boolean connect) throws IOException {
        if (connect) {
            server = new ServerSocket(port);
            System.out.println("Ожидание подключения...");
            clientSocket = server.accept();
            System.out.println("Соединение с клиентом установлено");
        }
        if (!connect) {
            System.out.println("Соединение с клиентом разорвано");
            clientSocket.close();
            server.close();

        }
    }

    /**
     * Модуль чтения запроса
     *
     * @return - возвращает десериализованную команду
     * @throws IOException - ошибка чтения запроса
     */
    private static String read() throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        String message = in.readLine();
        message = serialization.DeserializeObject(serializedDate);
        return message;
    }

    /**
     * Модуль отправки ответов клиенту
     *
     * @param message - сообщение от клиента
     * @param command - комманда
     * @throws IOException - ошибка чтения запроса
     * @throws InterruptedException - ошибка ожидания
     */
    private static void write(String message, String command) throws IOException, InterruptedException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        if (command.equals("get")){
            String messageToClient = "\nСервер принял команду: " + message + "\n";
            serialization.SerializeObject(messageToClient, serializedDate);
            out.write("\n");
            out.flush();
        } else if (command.equals("send")){
            TimeUnit.SECONDS.sleep(1);
            execution(message, serializedDate);
            out.write("\n");
            out.flush();
        }
    }
}