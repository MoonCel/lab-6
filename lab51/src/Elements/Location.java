package Elements;

public class Location {
    private long x;
    private int y;
    private int z;

    public void setCoordinates(long x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;

    }
    /**
     *
     * @return x - возвращает значение x
     */

    public long getXloc() {
        return x;
    }

    /**
     *
     * @return y - возвращает значение x
     */

    public int getYloc() {
        return y;
    }

    /**
     *
     * @return z - возвращает значение x
     */

    public int getZloc() {
        return z;
    }

    /**
     *  Возвращает информации о положении объекта
     *  @return information
     */

    public String getShow() {
        return " Location: ("+getXloc()+ ", " +getYloc()+ ", " +getZloc()+")";
    }
}
