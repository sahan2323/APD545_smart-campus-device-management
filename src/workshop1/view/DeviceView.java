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

package workshop1.view;

import workshop1.model.Device;

/**
 * Handles all console output. Contains no business logic.
 */
public class DeviceView {

    /** Prints a requirement section header. */
    public void showSectionHeader(int number, String title) {
        System.out.println();
        System.out.println("--: Requirement " + number + " : " + title + " --");
    }

    /** Prompts the user for a device's uptime. */
    public void showUptimePrompt(String deviceName) {
        System.out.print("Enter the current uptime for " + deviceName + " (hours): ");
    }

    /** Prompts the user for a device category. */
    public void showCategoryPrompt() {
        System.out.print("Enter a device category (ClassroomDevice, SecurityDevice, FacilityDevice): ");
    }

    /** Prints an error message. */
    public void showError(String message) {
        System.out.println(message);
    }

    /** Prints details of the most urgent device (Requirement 2). */
    public void showMostUrgentDevice(Device device) {
        String name = device.getName();
        System.out.println("The device requiring the most urgent maintenance is: " + name);
        System.out.println(name + "'s primary function: " + device.getPrimaryFunction());
        System.out.println(name + "'s power usage: " + device.getPowerUsage() + " watts");
        System.out.printf("%s's service interval: Every %,d hours%n", name, device.getServiceInterval());
        System.out.println(name + "'s maintenance cost: $" + device.getMaintenanceCost());
    }

    /** Prints devices sorted by power usage (Requirement 3). */
    public void showDevicesByPower(Device[] devices) {
        System.out.println("Devices in Descending Order of Power Usage:");
        for (Device device : devices) {
            System.out.println(device.getName() + " - " + device.getPowerUsage() + " watts");
        }
    }

    /** Prints devices in the selected category (Requirement 4). */
    public void showDevicesInCategory(String category, Device[] devices) {
        System.out.println("Devices in " + category + " Category:");
        if (devices.length == 0) {
            System.out.println("No devices found.");
            return;
        }
        for (Device device : devices) {
            System.out.println(device.getName()
                    + " - Primary Function: " + device.getPrimaryFunction()
                    + " - Power Usage: " + device.getPowerUsage() + " watts");
        }
    }

    /** Prints devices sorted by maintenance urgency (Requirement 5). */
    public void showDevicesByUrgency(Device[] devices) {
        System.out.println("Devices sorted by maintenance urgency (closest to service interval first):");
        for (Device device : devices) {
            System.out.printf("%s (%,dh interval / %,dh uptime → %,dh remaining)%n",
                    device.getName(),
                    device.getServiceInterval(),
                    device.getCurrentUptime(),
                    device.getRemainingHours());
        }
    }
}