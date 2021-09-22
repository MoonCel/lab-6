package Elements;

import java.time.LocalDateTime;

/**
 * Класс элементов коллекции
 */
public class Person {

    private Integer id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates = new Coordinates(); //Поле не может быть null
    private java.time.LocalDateTime creationDate = LocalDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float height; //Значение поля должно быть больше 0  // **
    private Color eyeColor; //Поле не может быть null **
    private Color hairColor; //Поле не может быть null **
    private Country country; //Поле может быть null **
    private Location location = new Location(); //Поле не может быть nulls **

    /**
     *  Устанавливает новое значение переменной id
     *
     *  @param id - значенияпеременной id
     */
    public void setId(String id) {
        try {
            System.out.println(id);
            this.id = Integer.parseInt(id.replaceAll("[^\\p{Print}]", ""));
        } catch (NumberFormatException e) {
            System.err.println("id неверный формат строки!");
            System.exit(0);
        }
        if (this.id <= 0) {
            throw new IllegalStateException("id должно быть больше 0");
        }
    }

    /**
     *  Устанавливает новое значение переменной name
     *
     *  @param name - значений переменной
     */
    public void setName(String name) {
        if (name == null){
            System.err.println("name не может быть null");
            System.exit(0);
        } else if (name.equals("")){
            System.err.println("Name не может быть пустой строкой");
            System.exit(0);
        } else this.name = name;
    }

    /**
     *  Устанавливает новоезначение переменной coordinates
     *
     *  @param x - переменная x
     *  @param y - переменная y
     */

    public void setCoordinates(String x, String y) {
        this.coordinates.setX(x);
        this.coordinates.setY(y);
    }

    /**
     *  Устанавливает новое значение для creationDate
     *
     *  @param creationDate - значении перемнной creationDate
     */

    public void setCreationDate(String creationDate) {
        try {
            if (creationDate == null){
                System.err.println("LocalDateTime не может быть null");
                System.exit(0);
            }else this.creationDate = LocalDateTime.parse(creationDate);
        } catch (NumberFormatException e) {
            System.err.println("creationDate неверный формат строки!");
            System.exit(0);
        }
    }

    /**
     * Устанавливает значение переменной height
     *
     * @param height - значение переменной
     */

    public void setHeight(String height) {
        try {
            if (height == null){
                System.err.println("frontMan.height должно быть больше 0");
                System.exit(0);
            } else this.height = Float.parseFloat(height);
        } catch (NumberFormatException e) {
            System.err.println("frontMan.height неверный формат строки!");
            System.exit(0);
        }
    }

    /**
     *  Устанавливает значение переменной eyeColor
     *     BLUE,
     *     GREEN,
     *     RED,
     *     ORANGE,
     *     BROWN;
     *  @param eyeColor - значение перемнной eyeColor
     */

    public void setEyeColor(String eyeColor) {
        try {
            if (eyeColor == null) {
                System.err.println("eyeColor не может быть null!");
                System.exit(0);
            } else if (eyeColor.equals(Color.GREEN.toString())) {
                this.eyeColor = Color.GREEN;
            } else if (eyeColor.equals(Color.BLUE.toString())) {
                this.eyeColor = Color.BLUE;
            } else if (eyeColor.equals(Color.RED.toString())) {
                this.eyeColor = Color.RED;
            } else if (eyeColor.equals(Color.ORANGE.toString())) {
                this.eyeColor = Color.ORANGE;
            }  else if (eyeColor.equals(Color.BROWN.toString())) {
                    this.eyeColor = Color.BROWN;
                System.err.println("eyeColor неверный формат строки!");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.err.println("eyeColor неверный формат строки!");
            System.exit(0);
        }
    }

    /**
     *  Устанавливает значение переменной hairColor
     *
     *  @param hairColor - значение перемнной hairColor
     */

    public void setHairColor(String hairColor) {
        try {
            if (hairColor == null) {
                System.err.println("eyeColor не может быть null!");
                System.exit(0);
            } else if (hairColor.equals(Color.GREEN.toString())) {
                this.hairColor = Color.GREEN;
            } else if (hairColor.equals(Color.RED.toString())) {
                this.hairColor = Color.RED;
            } else if (hairColor.equals(Color.BLUE.toString())) {
                this.hairColor = Color.BLUE;
            } else if (hairColor.equals(Color.ORANGE.toString())) {
                this.hairColor = Color.ORANGE;
            } else if (hairColor.equals(Color.BROWN.toString())) {
                this.hairColor = Color.BROWN;
            } else {
                System.err.println("eyeColor неверный формат строки!");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.err.println("eyeColor неверный формат строки!");
            System.exit(0);
        }
    }

    /**
     *  Устанавливает значение переменной nationality
     *
     *  @param country - значение перемнной nationality
     */

    public void setCountry(String country) {
        try {
            if (country == null) {
                System.err.println("nationality не может быть null!");
                System.exit(0);
            } else if (country.equals(Country.FRANCE.toString())) {
                this.country = Country.FRANCE;
            } else if (country.equals(Country.CHINA.toString())) {
                this.country = Country.CHINA;
            } else if (country.equals(Country.INDIA.toString())) {
                this.country = Country.INDIA;
            } else {
                System.err.println("nationality неверный формат строки!");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.err.println("nationality неверный формат строки!");
            System.exit(0);
        }
    }

    /**
     *  Устанавливает значение переменной nationality
     *
     * @param x - значение перемнной x
     * @param y - значение перемнной y
     * @param z - значение перемнной z
     */
    public void setLocation(String x,String y,String z){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        try {
            location.setCoordinates(Long.parseLong(x.replaceAll("[^\\p{Print}]", "")),Integer.parseInt(y.replaceAll("[^\\p{Print}]", "")),Integer.parseInt(z.replaceAll("[^\\p{Print}]", "")));

        }
        catch (NullPointerException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public Location getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }
    public Country getCountry() {
        return country;
    }
    public Color getHairColor() {
        return hairColor;
    }
    public Color getEyeColor() {
        return eyeColor;
    }
    public float getHeight() {
        return height;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public Integer getId() {
        return id;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
