# On Demand Delivery Case Study

This is a case study for an application that finds all possible order combination opportunities given the location 
coordinates for each order

## Problem
A company providing on-demand delivery services needs to find opportunities for combining delivery order such that its 
customers can share cost and drivers and riders on their platform can maximise their earnings by doing more deliveries 
at a lower fuel cost. Consider two order A and B. Order A’s pickup location is X and dropoff is Y. Order B’s pickup
is at location X and dropoff at Z. One can get to Z via Y. Say the distance from X to Y is 5 km, Z is 3 km from Y, and the order cost is KSh 30/km. Also, the two order are placed within a short
span of each other. In this example assume order B is placed a minute after order A. These order can be combined in a way that a partner picks up both at X, delivers A at Y then
proceeds to deliver B at Z.

Given the location coordinates for each order (e.g., -1.300176, 36.776714), design and implement an algorithm in Java 
that demonstrates how the company can find such order. Come up with a general solution that can find all possible order
 combination opportunities. Also bear in mind that paths for such order will not always be overlapping as in the case 
 above, but could also be intersecting, or just near each other without touching

## How to run the code
This is a Gradle project. To run open a console on the root project directory and type

`gradle run`