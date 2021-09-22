import Commands.Serialization;
import java.io.*;
import java.net.Socket;

public class Client implements Serializable{

    private static Socket clientSocket; // сокет для общения
    private static BufferedReader reader; // ридер читающий с консоли
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    private static final int port = 4004; // порт для подключения
    private static final Serialization serialization = new Serialization(); // сериализптор/десериализатор
    private static final String serializedDate = "C:\\Users\\Евгений\\IdeaProjects\\lab51\\src\\Files\\serializedDate.txt"; // файл для передачи сериализованных сообщений

    /**
     * Это main)
     *
     * @param args - что-то
     */
    public static void main(String[] args){
        try {
            boolean work = true; //TODO
            connection( true);
            while (work){
                String message = write();
                read();
                if (message.equals("exit") | message.equals("close server")){
                    connection(false);
                    work = false;
                }
                read();
            }
        } catch (IOException e) {
            System.err.println("Невозможно установить соединение с сервером");
        }
    }

    /**
     * Модуль отправки запросов на сервер
     *
     * @return - введённая команда
     * @throws IOException - ошибка чтения
     */
    public static String write() throws IOException {
        System.out.print("Введите команду: ");
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        String message = reader.readLine();
        if (message.equals("add")){
            message+= " " + commandPreparation();
        }
        serialization.SerializeObject((Object) message,serializedDate);
        out.write(message + "\n");
        out.flush();
        return message;
    }



    /**
     * Модуль принятия сообщений от сервера
     *
     * @throws IOException - ошибка принятия сообщений
     */
    public static void read() throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        String serverWord = in.readLine();
        serverWord = serialization.DeserializeObject(serializedDate);
        System.out.println(serverWord);
    }

    /**
     * Модуль соединения с сервером
     *
     * @param connect - режим работы (отключиться/подключиться)
     * @throws IOException - ошибка подключения
     */
    public static void connection(boolean connect) throws IOException {
        if (connect) {
            clientSocket = new Socket("localhost", port);
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Соединение с сервером установлено");
        }
        if (!connect) {
            System.out.println("Клиент был закрыт...");
            clientSocket.close();
            in.close();
            out.close();
        }
    }

    public static String commandPreparation() throws IOException {
        String result = "";
        System.out.println("ppppppppppppp");
        //String command = reader.readLine();
        //String command1 = command.trim();
        System.out.print("Введите значение поля name: ");
        StringBuilder name = new StringBuilder(reader.readLine());
            while (name.toString().isEmpty()) {
                System.out.println("У вас пустая строка!");
                System.out.print("Введите значение поля name: ");
                name.replace(0, name.length(), reader.readLine());
            }
            System.out.print("Введите значение поля coordinates_x: ");
            StringBuilder coordinates_x = new StringBuilder("");
            boolean xcheck = true;
            while (xcheck) {
                coordinates_x.replace(0, coordinates_x.length(), reader.readLine());
                try {
                    Long com3 = Long.parseLong(coordinates_x.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Введите значение поля coordinates_x в диапозоне от [-2147483648;2147483647]");
                }
                xcheck = false;
            }
            System.out.print("Введите значение поля coordinates_y: ");
            StringBuilder coordinates_y = new StringBuilder("");
            boolean ycheck = true;
            while (ycheck) {
                coordinates_y.replace(0, coordinates_y.length(), reader.readLine());
                if (coordinates_y.toString().isEmpty()) {
                    ycheck = false;
                } else {
                    try {
                        if (Double.parseDouble(coordinates_y.toString()) >= -270) {
                            ycheck = false;
                        } else {
                            System.out.println("Число должно быть больше -270 \nВведите значение поля y");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Введите значение поля y");
                    }
                }
            }
            System.out.print("Введите значение поля Height: ");
            boolean totalHeightCheck = true;
            StringBuilder totalHeight = new StringBuilder("");
            while (totalHeightCheck) {
                totalHeight.replace(0, totalHeight.length(), reader.readLine());
                if (totalHeight.toString().isEmpty()) {
                    System.out.println("Значение поля Height не может быть null");
                    ;
                } else {
                    try {
                        if (Long.parseLong(totalHeight.toString()) < Long.MAX_VALUE && Long.parseLong(totalHeight.toString()) > 0) {
                            totalHeightCheck = false;
                        } else
                            System.out.println("Значение поля Height должно быть больше 0");
                    } catch (NumberFormatException e) {
                        System.out.println("Введите значение поля Height ");
                    }
                }
            }
            System.out.print("Введите значение поля EyeColor (BLUE, GREEN, RED, ORANGE, BROWN): ");
            StringBuilder EyeColor = new StringBuilder();
            boolean EyeColorCheck = true;
            while (EyeColorCheck) {
                EyeColor.replace(0, EyeColor.length(), reader.readLine());
                switch (EyeColor.toString()) {
                    case ("BLUE"):
                        EyeColor.replace(0, EyeColor.length(), "BLUE");
                        EyeColorCheck = false;
                        break;
                    case ("GREEN"):
                        EyeColor.replace(0, EyeColor.length(), "GREEN");
                        EyeColorCheck = false;
                        break;
                    case ("RED"):
                        EyeColor.replace(0, EyeColor.length(), "RED");
                        EyeColorCheck = false;
                        break;
                    case ("ORANGE"):
                        EyeColor.replace(0, EyeColor.length(), "ORANGE");
                        EyeColorCheck = false;
                        break;
                    case ("BROWN"):
                        EyeColor.replace(0, EyeColor.length(), "BROWN");
                        EyeColorCheck = false;
                        break;
                    case (""):
                        EyeColor.replace(0, EyeColor.length(), "");
                        EyeColorCheck = false;
                        break;
                    default:
                        System.out.println("Значение поля EyeColor должно соответствовать одному из списка (BLUE, GREEN, RED, ORANGE, BROWN)");
                }
            }
            System.out.print("Введите значение поля EyeColor (BLUE, GREEN, RED, ORANGE, BROWN): ");
            StringBuilder HairColor = new StringBuilder();
            boolean HairColorCheck = true;
            while (HairColorCheck) {
                HairColor.replace(0, HairColor.length(), reader.readLine());
                switch (HairColor.toString()) {
                    case ("BLUE"):
                        HairColor.replace(0, HairColor.length(), "BLUE");
                        HairColorCheck = false;
                        break;
                    case ("GREEN"):
                        HairColor.replace(0, HairColor.length(), "GREEN");
                        HairColorCheck = false;
                        break;
                    case ("RED"):
                        HairColor.replace(0, HairColor.length(), "RED");
                        HairColorCheck = false;
                        break;
                    case ("ORANGE"):
                        HairColor.replace(0, HairColor.length(), "ORANGE");
                        HairColorCheck = false;
                        break;
                    case ("BROWN"):
                        HairColor.replace(0, HairColor.length(), "BROWN");
                        HairColorCheck = false;
                        break;
                    case (""):
                        HairColor.replace(0, HairColor.length(), "");
                        HairColorCheck = false;
                        break;
                    default:
                        System.out.println("Значение поля HairColor должно соответствовать одному из списка (BLUE, GREEN, RED, ORANGE, BROWN)");
                }
            }
            System.out.print("Введите значение поля Country (FRANCE, CHINA, INDIA): ");
            StringBuilder Country = new StringBuilder();
            boolean CountryCheck = true;
            while (CountryCheck) {
                Country.replace(0, Country.length(), reader.readLine());
                switch (Country.toString()) {
                    case ("FRANCE"):
                        Country.replace(0, Country.length(), "FRANCE");
                        CountryCheck = false;
                        break;
                    case ("CHINA"):
                        Country.replace(0, Country.length(), "CHINA");
                        CountryCheck = false;
                        break;
                    case ("INDIA"):
                        Country.replace(0, Country.length(), "INDIA");
                        CountryCheck = false;
                        break;
                    case (""):
                        Country.replace(0, Country.length(), "");
                        CountryCheck = false;
                        break;
                    default:
                        System.out.println("Значение поля Country должно соответствовать одному из списка (FRANCE, CHINA, INDIA)");
                }
            }
            System.out.print("Введите значение поля x: ");
            StringBuilder xcoord = new StringBuilder();
            boolean xcoordCheck = true;
            while (xcoordCheck) {
                xcoord.replace(0, xcoord.length(), reader.readLine());
                try {
                    if (Integer.parseInt(xcoord.toString()) > 0) {
                        xcoordCheck = false;
                    } else
                        System.out.println("Значение поля x должно быть больше 0");
                } catch (NumberFormatException e) {
                    System.out.println("Введите значение поля x в диапазоне");
                }
            }
            System.out.print("Введите значение поля y: ");
            StringBuilder ycoord = new StringBuilder();
            boolean ycoordCheck = true;
            while (ycoordCheck) {
                ycoord.replace(0, ycoord.length(), reader.readLine());
                try {
                    if (Integer.parseInt(ycoord.toString()) > 0) {
                        ycoordCheck = false;
                    } else
                        System.out.println("Значение поля y должно быть больше 0");
                } catch (NumberFormatException e) {
                    System.out.println("Введите значение поля y в диапазоне");
                }
            }
            System.out.print("Введите значение поля z: ");
            StringBuilder zcoord = new StringBuilder();
            boolean zcoordCheck = true;
            while (zcoordCheck) {
                zcoord.replace(0, zcoord.length(), reader.readLine());
                try {
                    if (Integer.parseInt(zcoord.toString()) > 0) {
                        zcoordCheck = false;
                    } else
                        System.out.println("Значение поля z должно быть больше 0");
                } catch (NumberFormatException e) {
                    System.out.println("Введите значение поля z в диапазоне");
                }
            }
            result = name.toString() + "," + coordinates_x.toString() + "," + coordinates_y.toString() + "," + totalHeight.toString() + "," + EyeColor.toString() + "," +
                    HairColor.toString() + "," + Country.toString() + "," + xcoord.toString() + "," + ycoord.toString() + "," + zcoord.toString();
            System.out.println(result);
        return result;
    }
}