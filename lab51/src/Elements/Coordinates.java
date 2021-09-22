package Elements;

/**
 * Класс координат Person (?)
 */
public class Coordinates {
    private Long x; //Значение поля должно быть больше -270, Поле не может быть null
    private Double y; //Поле не может быть null

    public Long getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    /**
     * Метод, устанавливающий значение переменной x
     *
     * @param x
     */
    public void setX(String x){
        try {
            if (x== null) {
                System.err.println("Coordinates.x не может быть null");
                System.exit(0);
            } else if (Long.parseLong(x) < -270) {
                System.err.println("Coordinates.x не можеты быть < -270");
                System.exit(0);
            } else this.x = Long.parseLong(x);
        } catch (NumberFormatException e) {
            System.err.println("Coordinates.x не верный формат строки!");
            System.exit(0);
        }
    }
    /**
     * Метод, устанавливающий значение переменной y
     *
     * @param y
     */
    public void setY(String y){
        try {
            if (y== null) {
                System.err.println("Coordinates.x не может быть null");
                System.exit(0);
            } else this.y = Double.parseDouble(y);
        } catch (NumberFormatException e) {
            System.err.println("Coordinates.x не верный формат строки!");
            System.exit(0);
        }
    }

    @Override
    public String toString(){
        String result;
        result = x + ","+ y;
        return (result);
    }
}
