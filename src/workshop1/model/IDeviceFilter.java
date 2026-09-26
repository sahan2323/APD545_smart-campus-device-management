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
 * Functional interface used to filter devices with lambda expressions.
 */
@FunctionalInterface
public interface IDeviceFilter {

    /**
     * @param d the device to test
     * @return true if the device matches the filter condition
     */
    boolean match(Device d);
}