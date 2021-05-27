import java.awt.*;

public interface Resolver {
    public boolean hasCommonPart(Rectangle r1, Rectangle r2);
    public double calculateCommonPart(Rectangle r1, Rectangle r2);
}
