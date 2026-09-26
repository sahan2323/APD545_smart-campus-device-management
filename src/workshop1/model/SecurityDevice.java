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
 * Abstract group for campus security devices.
 */
public abstract class SecurityDevice extends Device {

    public static final String CATEGORY = "SecurityDevice";

    protected SecurityDevice(String name, double powerUsage, int serviceInterval,
                             double maintenanceCost, String primaryFunction) {
        super(name, CATEGORY, powerUsage, 0, serviceInterval, maintenanceCost, primaryFunction);
    }
}