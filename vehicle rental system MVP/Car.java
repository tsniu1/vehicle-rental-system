/**
 * Car.java
 * SUBCLASS of Vehicle — V3.0 (Inheritance) + V4.0 (Polymorphism)
 *
 * Car "is-a" Vehicle. It inherits all Vehicle fields/methods and
 * adds its own attribute (numberOfSeats) plus overrides calculateRentalCost().
 */
public class Car extends Vehicle {

    // ── Car-specific attribute (V1.0 — Classes & Objects) ────────────────────
    private int numberOfSeats;
    private boolean hasAC;

    // ── Constructor — calls super() to reuse Vehicle's constructor (V3.0) ────
    public Car(String vehicleId, String brand, String model,
               int year, double mileage, double baseDailyRate,
               int numberOfSeats, boolean hasAC) {
        super(vehicleId, brand, model, year, mileage, baseDailyRate);
        this.numberOfSeats = numberOfSeats;
        this.hasAC         = hasAC;
    }

    // ── Method OVERRIDING — runtime polymorphism (V4.0) ──────────────────────
    /**
     * Cars: base rate × days.
     * AC adds a flat $5/day surcharge.
     */
    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseDailyRate() * days;
        if (hasAC) cost += 5.0 * days;
        return cost;
    }

    // ── Method OVERLOADING — compile-time polymorphism (V4.0) ────────────────
    /**
     * rent(int days)            — basic rental, no insurance
     * rent(int days, boolean i) — rental WITH optional insurance ($10/day extra)
     *
     * Same method name, different parameter lists = overloading.
     */
    public double rent(int days) {
        return rent(days, false);          // delegates to the full version
    }

    public double rent(int days, boolean withInsurance) {
        if (!isAvailable()) {
            System.out.println("  [!] " + getBrand() + " " + getModel() + " is not available.");
            return 0;
        }
        setAvailable(false);
        double total = calculateRentalCost(days);
        if (withInsurance) total += 10.0 * days;
        System.out.println("  Car rented for " + days + " day(s)."
                + (withInsurance ? " Insurance included." : ""));
        System.out.println("  Total cost: $" + String.format("%.2f", total));
        return total;
    }

    // ── Overriding displayInfo() to add Car-specific details (V3.0 + V4.0) ──
    @Override
    public void displayInfo() {
        super.displayInfo();               // reuse parent logic
        System.out.println("  Type    : Car");
        System.out.println("  Seats   : " + numberOfSeats);
        System.out.println("  AC      : " + (hasAC ? "Yes" : "No"));
        System.out.println("────────────────────────────────");
    }

    // ── Getters / Setters ─────────────────────────────────────────────────────
    public int  getNumberOfSeats() { return numberOfSeats; }
    public boolean hasAC()         { return hasAC; }
}
