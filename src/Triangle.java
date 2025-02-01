/*
 * см. TriangleDemo
 */

public class Triangle {

    private final int a;
    private final int b;
    private double volume;

    public Triangle(int a, int b) {
        this.a = a;
        this.b = b;
        setVolume();
    }

    private void setVolume() {
        volume = (double) (a * b) / 2;
    }

    public double getVolume() {
        return volume;
    }

    public static void compare(Triangle tr1, Triangle tr2) {
        if (tr1.getVolume() == tr2.getVolume())
            System.out.println("Triangles are equal");
        else
            System.out.println("First triangle is " + (tr1.getVolume() < tr2.getVolume() ? "smaller" : "bigger"));
    }
}
