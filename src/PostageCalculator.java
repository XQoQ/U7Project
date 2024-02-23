public class PostageCalculator {
    public static double calculatePostage(int zipCode1, int zipCode2, double weight, double length, double width, double height) {
        // basic cost
        double cost = 3.75;

        // additional cost for every tenth of a pound
        cost += 0.05 * (weight * 10);

        // additional cost based on zip code
        if ((zipCode1 + "").length() == 3 && (zipCode2 + "").length() == 3) {

        }
        cost += Math.abs((double) ((zipCode1 / 100) - (zipCode2 / 100)) / 100);

        // additional cost for exceeding size of 36 inches
        if (length + width + height > 36) {
            cost += 0.1 * (length + width + height - 36);
        }

        // additional cost for weight exceeding 40 pound
        if (weight > 40) {
            cost += 0.1 * ((weight - 40) * 10);
        }

        return cost;
    }

    public static double calculatePostage(Address address1, Address address2, double weight, double length, double width, double height) {
        // basic cost
        double cost = 3.75;

        // additional cost for every tenth of a pound
        cost += 0.05 * (weight * 10);

        // additional cost based on zip code
        cost += Math.abs((double) ((address1.getZipCode() / 100) - (address2.getZipCode() / 100)) / 100);

        // additional cost for exceeding size of 36 inches
        if (length + width + height > 36) {
            cost += 0.1 * (length + width + height - 36);
        }

        // additional cost for weight exceeding 40 pound
        if (weight > 40) {
            cost += 0.1 * ((weight - 40) * 10);
        }

        return cost;
    }

    public static double calculatePostage(Package p) {
        // basic cost
        double cost = 3.75;

        // additional cost for every tenth of a pound
        cost += 0.05 * (p.getWeight() * 10);

        // additional cost based on zip code
        cost += Math.abs((double) ((p.getDestination().getZipCode() / 100) - (p.getOrigin().getZipCode() / 100)) / 100);

        // additional cost for exceeding size of 36 inches
        if (p.getLength() + p.getWeight() + p.getHeight() > 36) {
            cost += 0.1 * (p.getLength() + p.getWeight() + p.getHeight() - 36);
        }

        // additional cost for weight exceeding 40 pound
        if (p.getWeight() > 40) {
            cost += 0.1 * ((p.getWeight() - 40) * 10);
        }

        return cost;
    }
}
