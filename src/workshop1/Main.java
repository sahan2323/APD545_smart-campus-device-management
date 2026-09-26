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

package workshop1;

import workshop1.controller.DeviceController;
import workshop1.model.Device;
import workshop1.model.SmartCamera;
import workshop1.model.SmartDoorLock;
import workshop1.model.SmartProjector;
import workshop1.model.SmartSpeaker;
import workshop1.model.SmartThermostat;
import workshop1.view.DeviceView;

/**
 * Entry point for the Smart Campus Device Management System.
 */
public class Main {

    public static void main(String[] args) {
        Device[] devices = {
                new SmartProjector(),
                new SmartCamera(),
                new SmartDoorLock(),
                new SmartThermostat(),
                new SmartSpeaker()
        };

        DeviceView view = new DeviceView();
        DeviceController controller = new DeviceController(devices, view);
        controller.run();
    }
}