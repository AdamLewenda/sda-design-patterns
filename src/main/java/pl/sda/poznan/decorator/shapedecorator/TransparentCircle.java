package pl.sda.poznan.decorator.shapedecorator;

//drugi dekorator - dodaje przejrzystosc
public class TransparentCircle implements Shape {

    private double transparency;
    private Shape shapeToDecorate;

    public TransparentCircle(Shape shapeToDecorate, double transparency) {
        if (transparency < 0.0 || transparency > 100.0) {
            throw new IllegalArgumentException("Transparency must have value form 0 to 100");
        }
        this.transparency = transparency;
        this.shapeToDecorate = shapeToDecorate;
    }

    @Override
    public String info() {
        return shapeToDecorate.info() + " has " + transparency;
    }
}
