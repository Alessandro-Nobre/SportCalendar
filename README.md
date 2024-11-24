## Overview
The Sports Event Calendar is a simple web application designed to store and display sports events. 
Users can view upcoming sports events, get details such as the date, time, participating teams, and venue. 
This application is built using a relational database and a simple backend that interacts with a frontend to display event data in a user-friendly format.

## Features
- View all events or search by ID.
- Add new events to the calendar with a friendly interface.
- Delete events by ID

## Project Structure
The project is organized into the following components:
- Database Design and Implementation: A relational database with tables designed to store event details.
- Backend: A backend API built using Java and Boot Spring as framework that connects to the database and serves the event data.
- Frontend: An HTML-based user interface that displays events and their details, forms for adding new events and option to delete events by ID.

## Database Modelling
In this project, a relational database was designed to store sports event data. The database schema includes the following tables:

- Match: Stores details about each Match (e.g., matchId, date, time, teams, result, stage).
- Team: Stores information about each Team (e.g., teamId, name, officialName, abbreviation).
- Result: Stores information about each Result scores for each Match (e.g., resultId, goals, winner, message).
- Stage: Stores information about each Stage (e.g., staged, name, ordering).
- Player: Stores information about each Player (e.g., playerId, name, birthday, JerseyNumber).
- Goal: Stores information about each Goal (e.g., goalId, time).
- Card: Stores information about each Card (e.g., cardId, cardType, reason, time).

## ERD:
![Project_BE](https://github.com/user-attachments/assets/a3454b2c-496a-47af-9ee2-51d22caef964)

## Executing from IDE
Open the source code from your favorite IDE and run the “SportCalendarApplication”.

## How to use
- To access the console SQL: http://localhost:8080/h2-console
- To access frontend: http://localhost:8080/index.html

The Index should look like this:

![Index](https://github.com/user-attachments/assets/9c0153c3-add7-4b64-90b3-070150e36959)

From here you have 3 main options, to visualize events, to create events and to delete events.

### Events Info
If you want to visualize events and click on “Events Info”, the next page should appear like this:

![Events Info](https://github.com/user-attachments/assets/1842cb16-cbf2-4155-907d-e20127f44e98)

From here can choose between what kind of information you want to receive, or you can still change to create new events or delete them.

After choosing what kind of information, you want to receive, you can choose between getting all the data stored on the database about that, or you can choose to see information by ID

![Events Info Matches](https://github.com/user-attachments/assets/423e1489-ec18-4bc2-91ed-181dc918cc14)

After you have decided to see data stored by ID you should see this interface where you will need to provide the ID you want information about. Just enter the ID you want, and press enter.

![Events Info ById](https://github.com/user-attachments/assets/42c428e5-682c-4a46-b935-86ed3ae9c41e)


### Create Events
Otherwise if you want to create a new event, you can click on ”Create Events”, from there, you can chose what kind of event you want to create.

![Create Events](https://github.com/user-attachments/assets/934cbed7-3fdb-43a1-a657-33aad94f5a6d)

Then if you will need to fulfill, the form with the information about the event you want to create.

![Create Match](https://github.com/user-attachments/assets/a0529903-5b16-4f02-bbb1-d21b340062c9)

Also, you need to insert the data you have following the exigences of the form.

### Delete Events
Also, there is an option to delete events, if you want to delete some event you just need to know what kind of event it is and its ID.

![Delete Events](https://github.com/user-attachments/assets/904b7135-4db0-4762-b8b1-d1a765a93b23)

After choosing the event you want to delete the interface should look like this:

![Delete ById](https://github.com/user-attachments/assets/258a0b62-57ad-4e38-8768-5ca59f91343f)

After entering the ID you want to delete and confirm it, it should show you a confirmation box, if it was successful, or if there was some error with the delete process. 
It can happen in case you are trying to delete some ID that does not exist on your Database.






