import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ResolverImpl implements Resolver {


    /**
     * czy prostokąty mają wspólną część
     * @param r1
     * @param r2
     * @return
     */
    @Override
    public boolean hasCommonPart(Rectangle r1, Rectangle r2) {

        return r1.intersects(
                r2.getX(),
                r2.getY(),
                r2.getWidth(),
                r2.getHeight()
        );
    }

    /**
     * Obliczanie wspólnej części prostokątów
     * @param r1
     * @param r2
     * @return pole, jeśli brak przecięcia -> 0
     */
    @Override
    public double calculateCommonPart(Rectangle r1, Rectangle r2) {
        if (!hasCommonPart(r1, r2))
            return 0;


        List<Double> xCoordinates = Arrays.asList(r1.getMinX(),
                r1.getMaxX(),
                r2.getMinX(),
                r2.getMaxX());

        List<Double> yCoordinates = Arrays.asList(r1.getMinY(),
                r1.getMaxY(),
                r2.getMinY(),
                r2.getMaxY());

        xCoordinates.
                sort(Double::compare);
        yCoordinates.
                sort(Double::compare);

        return calculateArea(
                xCoordinates.get(1),
                xCoordinates.get(2),
                yCoordinates.get(2),
                yCoordinates.get(1)
        );

    }

    /**
     * Obliczenie powierzchni prostokąta
     *
     * @param xl
     * @param xr
     * @param yu
     * @param yd
     * @return pole
     */
    private double calculateArea(double xl,
                                 double xr,
                                 double yu,
                                 double yd) {
        double width = xr - xl;
        double height = yu - yd;

        return width * height;
    }
}
