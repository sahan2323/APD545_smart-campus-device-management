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

package workshop1.controller;

import java.util.Arrays;
import java.util.Scanner;

import workshop1.model.ClassroomDevice;
import workshop1.model.Device;
import workshop1.model.FacilityDevice;
import workshop1.model.IDeviceFilter;
import workshop1.model.SecurityDevice;
import workshop1.view.DeviceView;

/**
 * Connects the model and view. Handles user input, sorting,
 * filtering, and maintenance urgency evaluation.
 */
public class DeviceController {

    private static final String[] VALID_CATEGORIES = {
            ClassroomDevice.CATEGORY, SecurityDevice.CATEGORY, FacilityDevice.CATEGORY
    };

    private final Device[] devices;
    private final DeviceView view;
    private final Scanner scanner;

    public DeviceController(Device[] devices, DeviceView view) {
        this.devices = devices;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    /** Runs all requirements in order. */
    public void run() {
        trackDeviceUptime();
        determineMaintenanceUrgency();
        sortByPowerUsage();
        filterByCategory();
        sortByMaintenanceUrgency();
        scanner.close();
    }

    // ---------- Requirement 1: Track Device Uptime ----------

    private void trackDeviceUptime() {
        view.showSectionHeader(1, "Track Device Uptime");
        for (Device device : devices) {
            device.setCurrentUptime(readValidUptime(device.getName()));
        }
    }

    /** Keeps asking until the user enters a whole number 0 or greater. */
    private int readValidUptime(String deviceName) {
        while (true) {
            view.showUptimePrompt(deviceName);
            String input = scanner.nextLine().trim();
            try {
                int uptime = Integer.parseInt(input);
                if (uptime >= 0) {
                    return uptime;
                }
                view.showError("Uptime cannot be negative. Please try again.");
            } catch (NumberFormatException e) {
                view.showError("Invalid input. Please enter a whole number of hours.");
            }
        }
    }

    // ---------- Requirement 2: Determine Maintenance Urgency ----------

    private void determineMaintenanceUrgency() {
        view.showSectionHeader(2, "Determine Maintenance Urgency");
        view.showMostUrgentDevice(getDevicesSortedByUrgency()[0]);
    }

    // ---------- Requirement 3: Sort by Power Usage ----------

    private void sortByPowerUsage() {
        view.showSectionHeader(3, "Sort by Power Usage");
        Device[] sorted = Arrays.copyOf(devices, devices.length);
        Arrays.sort(sorted, (a, b) -> Double.compare(b.getPowerUsage(), a.getPowerUsage()));
        view.showDevicesByPower(sorted);
    }

    // ---------- Requirement 4: Filter by Category (Lambda) ----------

    private void filterByCategory() {
        view.showSectionHeader(4, "Filter by Category (Lambda)");
        String category = readValidCategory();
        IDeviceFilter categoryFilter = d -> d.getCategory().equals(category);
        view.showDevicesInCategory(category, filterDevices(categoryFilter));
    }

    /** Keeps asking until the user enters one of the three categories. */
    private String readValidCategory() {
        while (true) {
            view.showCategoryPrompt();
            String input = scanner.nextLine().trim();
            for (String valid : VALID_CATEGORIES) {
                if (valid.equalsIgnoreCase(input)) {
                    return valid;
                }
            }
            view.showError("Invalid category. Please try again.");
        }
    }

    /**
     * Returns a new array containing only the devices that pass the filter.
     * @param filter the condition to apply (usually a lambda)
     */
    private Device[] filterDevices(IDeviceFilter filter) {
        int count = 0;
        for (Device device : devices) {
            if (filter.match(device)) {
                count++;
            }
        }
        Device[] result = new Device[count];
        int index = 0;
        for (Device device : devices) {
            if (filter.match(device)) {
                result[index++] = device;
            }
        }
        return result;
    }

    // ---------- Requirement 5: Sort by Maintenance Urgency ----------

    private void sortByMaintenanceUrgency() {
        view.showSectionHeader(5, "Sort by Maintenance Urgency");
        view.showDevicesByUrgency(getDevicesSortedByUrgency());
    }

    /** Returns a copy of the devices sorted using Device.compareTo(). */
    private Device[] getDevicesSortedByUrgency() {
        Device[] sorted = Arrays.copyOf(devices, devices.length);
        Arrays.sort(sorted);
        return sorted;
    }
}