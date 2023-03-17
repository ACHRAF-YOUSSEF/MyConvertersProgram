public class ConverterClass {
    private final String fromTo;
    private final double ratio;

    ConverterClass(String fromTo, double ratio) {
        this.fromTo = fromTo;
        this.ratio = ratio;
    }

    public String getFromTo() {
        return fromTo;
    }

    public double convertFromTo(double what) {
        return what * ratio;
    }

    @Override
    public String toString() {
        return fromTo;
    }
}
