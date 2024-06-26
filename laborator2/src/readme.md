# Advanced Programming 2023 - Lab 2 
___________________________
Java solutions for the lab exercises. Solved assignments are marked [x] .

Author: Frij Alexandra-Stefania, 2B2
_____________________________

## Specifications: Object and Classes

An instance of the "Best Route Problem" consists of locations and roads. Locations may be cities, airports, gas stations, etc.
Two locations may be connected by a road, or not. Roads may be highways, express, country, etc.

Each location has a name, type and x, y coordinates (assume that the locations are placed in a cartesian coordinate system).
Each road has a type, length and a speed limit. The length of a road should not be less than the euclidean distance between the location coordinates.
We consider the problem of determining the "best" route from one location to another.
_______________________________

## Compulsory (1p)

- [x] Create an object-oriented model of the problem. You should have (at least) the following classes: Location, Road.
  The location and road types will be implemented as enums.
- [x] Each class should have appropriate constructors, getters and setters.
  Use the IDE features for code generation, such as generating getters and setters.
- [x] The toString method form the Object class must be properly overridden for all the classes.
  Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
- [x] Create and print on the screen various objects of the two classes.
_________________________________

## Compulsory observations:
- [ ] After resolving the homework exercises, the enum initially created for the Location class has been replaced with 3 classes, one for each type of location (city, airport or gas station).
__________________________________

## Homework (2p)

- [x] Create a class that describes an instance of the problem.
- [x] Override the Object.equals method for the Location and Road classes. The problem should not allow adding the same location or road twice.
- [x] Instead of using an enum, create dedicated classes either for locations: cities, air ports, gas stations etc. or roads: highway, express, country, etc. Each concrete location class may have additional specific properties (population, number of terminals, gas price, etc.)
- [x] Implement a method that determines if a problem's instance is valid.
- [x] Implement an algorithm for determining if it is possible to go from one location to another using the given roads.
- [x] Write doc comments in your source code and generate the class documentation using javadoc.
___________________________________

# Homework observations:
- [ ] The enum for the Location class has been replaced with 3 classes for each possible type of location
- [ ] For the City class, it has been added a field for population (int).
- [ ] For the Airport class, it has been added a field for the terminals number (int).
- [ ] For the GasStation class, it has been added a field for the gas price (double).
_____________________________________

# Bonus (2p)

- [ ] Create a class to describe the solution.
- [ ] Implement an algorithm to find the best route from a location to another, either as the shortest route, or the fastest route.
- [ ] Generate large random instances of the problem and analyze the performance of your algorithm (running times, memory consumption).