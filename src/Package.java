public class Package {
    private Address origin;
    private Address destination;
    private double weight;
    private double length;
    private double width;
    private double height;

    public Package(Address origin, Address destination, double weight, double length, double width, double height) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
