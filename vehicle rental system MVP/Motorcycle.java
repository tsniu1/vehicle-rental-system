/**
 * Motorcycle.java
 * SUBCLASS of Vehicle — V3.0 (Inheritance) + V4.0 (Polymorphism)
 *
 * Motorcycle "is-a" Vehicle. Cheaper daily rate logic; requires
 * a helmet (optional add-on).
 */
public class Motorcycle extends Vehicle {

    // ── Motorcycle-specific attribute ─────────────────────────────────────────
    private String type;   // e.g., "Sport", "Cruiser", "Off-road"

    // ── Constructor (V3.0 — calls super) ──────────────────────────────────────
    public Motorcycle(String vehicleId, String brand, String model,
                      int year, double mileage, double baseDailyRate,
                      String type) {
        super(vehicleId, brand, model, year, mileage, baseDailyRate);
        this.type = type;
    }

    // ── Method OVERRIDING (V4.0 — runtime polymorphism) ──────────────────────
    /**
     * Motorcycles get a 10 % weekend discount if rented for 2 days or fewer
     * (simulating a short weekend trip deal).
     */
    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseDailyRate() * days;
        if (days <= 2) cost *= 0.90;   // 10% weekend discount
        return cost;
    }

    // ── Method OVERLOADING (V4.0 — compile-time polymorphism) ────────────────
    /**
     * rent(int days)                     — no helmet add-on
     * rent(int days, boolean withHelmet) — adds $3/day for helmet rental
     */
    public double rent(int days) {
        return rent(days, false);
    }

    public double rent(int days, boolean withHelmet) {
        if (!isAvailable()) {
            System.out.println("  [!] " + getBrand() + " " + getModel() + " is not available.");
            return 0;
        }
        setAvailable(false);
        double total = calculateRentalCost(days);
        if (withHelmet) total += 3.0 * days;
        System.out.println("  Motorcycle rented for " + days + " day(s)."
                + (withHelmet ? " Helmet included." : ""));
        System.out.println("  Total cost: $" + String.format("%.2f", total));
        return total;
    }

    // ── Override displayInfo() (V4.0) ─────────────────────────────────────────
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Type    : Motorcycle (" + type + ")");
        System.out.println("────────────────────────────────");
    }

    // ── Getter ────────────────────────────────────────────────────────────────
    public String getType() { return type; }
}
