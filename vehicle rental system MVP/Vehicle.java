/**
 * Vehicle.java
 * BASE / SUPERCLASS — V1.0 (Classes & Objects) + V2.0 (Encapsulation) + V3.0 (Inheritance)
 *
 * This abstract class is the foundation of the entire hierarchy.
 * All shared vehicle attributes live here, protected by private fields
 * and accessed through getters/setters (encapsulation).
 */
public abstract class Vehicle {

    // ── Encapsulation: private fields (V2.0) ─────────────────────────────────
    private String vehicleId;
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private boolean available;
    private double baseDailyRate;

    // ── Constructor (V1.0 — Classes & Objects) ────────────────────────────────
    public Vehicle(String vehicleId, String brand, String model,
                   int year, double mileage, double baseDailyRate) {
        this.vehicleId    = vehicleId;
        this.brand        = brand;
        this.model        = model;
        this.year         = year;
        this.mileage      = mileage;
        this.baseDailyRate = baseDailyRate;
        this.available    = true;          // all vehicles start as available
    }

    // ── Abstract method — forces every subclass to override it (V4.0) ─────────
    /**
     * calculateRentalCost() is declared abstract here so Car, Motorcycle,
     * and Truck MUST provide their own pricing logic → runtime polymorphism.
     */
    public abstract double calculateRentalCost(int days);

    // ── Concrete shared method — inherited by all subclasses (V3.0) ──────────
    /**
     * Prints a summary of the vehicle. Subclasses call super.displayInfo()
     * then add their own details, demonstrating inheritance reuse.
     */
    public void displayInfo() {
        System.out.println("────────────────────────────────");
        System.out.println("  ID      : " + vehicleId);
        System.out.println("  Vehicle : " + year + " " + brand + " " + model);
        System.out.println("  Mileage : " + mileage + " km");
        System.out.println("  Status  : " + (available ? "Available" : "Rented"));
        System.out.println("  Base Rate: $" + baseDailyRate + "/day");
    }

    // ── Getters (V2.0 — Encapsulation) ───────────────────────────────────────
    public String getVehicleId()    { return vehicleId; }
    public String getBrand()        { return brand; }
    public String getModel()        { return model; }
    public int    getYear()         { return year; }
    public double getMileage()      { return mileage; }
    public boolean isAvailable()    { return available; }
    public double getBaseDailyRate(){ return baseDailyRate; }

    // ── Setters with basic validation (V2.0 — Encapsulation) ─────────────────
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setMileage(double mileage) {
        if (mileage < 0) {
            System.out.println("  [Error] Mileage cannot be negative.");
            return;
        }
        this.mileage = mileage;
    }

    public void setBaseDailyRate(double rate) {
        if (rate <= 0) {
            System.out.println("  [Error] Rate must be positive.");
            return;
        }
        this.baseDailyRate = rate;
    }
}
