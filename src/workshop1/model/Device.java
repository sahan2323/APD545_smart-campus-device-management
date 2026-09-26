/***********************************************
 Workshop # 1
 Course: APD545NBB - Fall 2026
 Last Name: Hewa Gallage
 First Name: Sahan Vimukthi
 ID: 178061230
 This assignment represents my own work in accordance
 with Seneca Academic Policy.
 Date: September 25, 2026

 References:
 - Ali, M. Segment 1 - Inheritance and Abstract Classes. APD545, Seneca Polytechnic.
 - Ali, M. Segment 2 - Interfaces and Implementations. APD545, Seneca Polytechnic.
 - Ali, M. Segment 4 - MVC Pattern. APD545, Seneca Polytechnic.
 - Workshop 1 - Smart Campus Device Management System. APD545, Seneca Polytechnic.
 ***********************************************/

package workshop1.model;

/**
 * Abstract base class for all smart campus devices.
 * Stores shared device data and defines maintenance urgency ordering.
 */
public abstract class Device implements IDeviceInfo, IDeviceMaintenance, IDeviceFilter, Comparable<Device> {

    protected String name;
    protected String category;
    protected double powerUsage;
    protected int currentUptime;
    protected int serviceInterval;
    protected double maintenanceCost;
    protected String primaryFunction;

    /**
     * Creates a device with all of its details.
     */
    public Device(String name, String category, double powerUsage, int currentUptime,
                  int serviceInterval, double maintenanceCost, String primaryFunction) {
        this.name = name;
        this.category = category;
        this.powerUsage = powerUsage;
        setCurrentUptime(currentUptime);
        this.serviceInterval = serviceInterval;
        this.maintenanceCost = maintenanceCost;
        this.primaryFunction = primaryFunction;
    }

    /** @return the device name */
    public String getName() {
        return name;
    }

    /** @return the device category (e.g. SecurityDevice) */
    public String getCategory() {
        return category;
    }

    /** @return current uptime in hours */
    public int getCurrentUptime() {
        return currentUptime;
    }

    /**
     * Sets the current uptime after validating it.
     * @param currentUptime uptime in hours, must be 0 or greater
     * @throws IllegalArgumentException if uptime is negative
     */
    public final void setCurrentUptime(int currentUptime) {
        if (currentUptime < 0) {
            throw new IllegalArgumentException("Uptime cannot be negative.");
        }
        this.currentUptime = currentUptime;
    }

    /**
     * Calculates hours left before service is due.
     * @return remaining hours (negative means overdue)
     */
    public int getRemainingHours() {
        return serviceInterval - currentUptime;
    }

    @Override
    public String getPrimaryFunction() {
        return primaryFunction;
    }

    @Override
    public double getPowerUsage() {
        return powerUsage;
    }

    @Override
    public int getServiceInterval() {
        return serviceInterval;
    }

    @Override
    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    /**
     * Checks whether another device belongs to the same category as this one.
     * @param d the device to compare against
     * @return true if both devices share a category
     */
    @Override
    public boolean match(Device d) {
        return d != null && category.equals(d.getCategory());
    }

    /**
     * Orders devices by maintenance urgency.
     * Rule 1: fewer remaining hours is more urgent.
     * Rule 2: if tied, higher uptime is more urgent.
     */
    @Override
    public int compareTo(Device d) {
        int result = Integer.compare(this.getRemainingHours(), d.getRemainingHours());
        if (result == 0) {
            result = Integer.compare(d.getCurrentUptime(), this.getCurrentUptime());
        }
        return result;
    }
}