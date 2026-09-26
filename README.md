# Smart Campus Device Management System

A Java console application that manages smart devices on a campus, such as projectors, speakers, cameras, door locks and thermostats. It tracks device uptime, finds which devices need maintenance most urgently, sorts devices by power usage, and filters them by category.

Built for **APD545 – Application Program Development** at Seneca Polytechnic (Workshop 1, Fall 2026).

## Features

- **Track device uptime:** enter the current uptime for each device, with input validation
- **Most urgent device:** finds the device closest to (or past) its service interval
- **Sort by power usage:** lists devices from highest to lowest wattage
- **Filter by category:** uses a lambda expression to show Classroom, Security or Facility devices
- **Sort by maintenance urgency:** shows remaining hours for every device (negative means overdue)

## Concepts Used

- Inheritance and abstract classes
- Interfaces, including a custom functional interface (`IDeviceFilter`)
- Lambda expressions
- The `Comparable` interface for custom sorting
- Arrays of objects
- The MVC (Model–View–Controller) design pattern

## Project Structure

```
src/workshop1/
├── Main.java                  # Entry point, connects model, view and controller
├── model/
│   ├── IDeviceInfo.java
│   ├── IDeviceMaintenance.java
│   ├── IDeviceFilter.java     # Functional interface for lambdas
│   ├── Device.java            # Abstract base class, implements Comparable
│   ├── ClassroomDevice.java   # Abstract category classes
│   ├── SecurityDevice.java
│   ├── FacilityDevice.java
│   ├── SmartProjector.java    # Concrete devices
│   ├── SmartSpeaker.java
│   ├── SmartCamera.java
│   ├── SmartDoorLock.java
│   └── SmartThermostat.java
├── view/
│   └── DeviceView.java        # Console output only
└── controller/
    └── DeviceController.java  # Input, sorting, filtering, urgency logic
```

## Maintenance Urgency Rules

```
remaining = serviceInterval - currentUptime
```

1. Devices with the fewest remaining hours come first.
2. If two devices are tied, the one with higher uptime comes first.

## How to Run

**IntelliJ IDEA:** open the project, go to `src/workshop1/Main.java`, and click the green ▶ next to `main`.

**Terminal:**

```bash
javac -d out $(find src -name "*.java")
java -cp out workshop1.Main
```

Requires Java 17 or newer.

## Sample Run

```
--: Requirement 2 : Determine Maintenance Urgency --
The device requiring the most urgent maintenance is: SmartDoorLock
SmartDoorLock's primary function: Door access control
SmartDoorLock's power usage: 15.0 watts
SmartDoorLock's service interval: Every 8,000 hours
SmartDoorLock's maintenance cost: $120.0

--: Requirement 5 : Sort by Maintenance Urgency --
SmartDoorLock (8,000h interval / 8,000h uptime → 0h remaining)
SmartCamera (4,000h interval / 3,500h uptime → 500h remaining)
SmartThermostat (3,000h interval / 2,200h uptime → 800h remaining)
SmartProjector (2,000h interval / 1,200h uptime → 800h remaining)
SmartSpeaker (2,000h interval / 900h uptime → 1,100h remaining)
```

## Academic Integrity

This project was submitted as graded coursework. If you're a student taking APD545 or a similar course, please use it only as a general reference for how the concepts fit together, and don't copy or submit any part of it as your own. Doing so goes against Seneca's Academic Integrity Policy.

## Author

**Sahan Vimukthi Hewa Gallage**
[GitHub](https://github.com/sahan2323) · [LinkedIn](https://www.linkedin.com/in/sahan-vimukthi-hewa-gallage-bb3a24239)
