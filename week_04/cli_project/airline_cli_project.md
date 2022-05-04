# Mini-Project: Building a Command Line Interface

Although a lot of the applications we use day-to-day have user interfaces with buttons to click and lots of graphical information, there are still a huge number of apps in existence which are entirely text-based. Applications such as these are used through a **command line interface**, or **CLI**. With the tools at our disposal now we can build Java apps and interact with them using a CLI


## MVP

Your group is going to develop an app to manage flight bookings. The user will be able to carry out the following actions using a CLI:

- Add a new flight
- Display all available flights
- Add a new passenger
- Book a passenger onto a flight
- Cancel a flight

A passenger needs to have a name, contact information and a unique identifier (id). A flight needs to have a destination, an id and a collection of passengers.

Before you start coding you should spend some time discussing the structure of your code, considering which methods you need to implement and drawing some class diagrams. We also expect to see tests where appropriate for the logic.


## Extensions

- Add search functionality, eg. let the user search for flights going to a particular destination
- Have the application handle the creation of the unique id for flights and passengers
- Throw exceptions where appropriate, eg. when attempting to book a passenger onto a flight which doesn't exist
- Write the details of which passenger has booked which flight to a separate file

## Presentation

At the end of the day each group will give a short presentation of their work and demo their app. Each group will have **7 minutes** to give a demo and talk about any interesting and/or challenging bits of code. Every member of the group needs to contribute, and there will be time for questions after each demo.