package functions;

/*
 * см. functions.TriangleDemo
 */

public class Triangle {

    private int legA;
    private int legB;
    private double volume;

    public Triangle(int legA, int legB) {
        setLegA(legA);
        setLegB(legB);
        setVolume();
    }

    private void setLegA(int legA) {
        this.legA = legA;
    }

    private void setLegB(int legB) {
        this.legB = legB;
    }

    private void setVolume() {
        volume = (double) (legA * legB) / 2;
    }

    public double getVolume() {
        return volume;
    }

    public int compareVolume(Triangle secondTriangle) {
        int bigger = 1;
        int equal = 0;
        int smaller = -1;
        double firstVolume = this.getVolume();
        double secondVolume = secondTriangle.getVolume();

        if (firstVolume == secondVolume)
            return equal;
        else
            return firstVolume < secondVolume ? smaller : bigger;
    }

    public void printCompareVolume(Triangle secondTriangle) {
        switch (compareVolume(secondTriangle)) {
            case 1 -> System.out.println("First triangle is bigger");
            case 0 -> System.out.println("Triangles are equal");
            case -1 -> System.out.println("First triangle is smaller");
            default -> throw new RuntimeException("The comparison was unsuccessful");
        }
    }
}