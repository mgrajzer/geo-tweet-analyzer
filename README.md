# Geo Tweet Analyzer

A simple Java application that reads and parses a CSV file containing tweets. It is the final assignment for the course Practice: Software Development at the University of Salzburg in the Summer Semester 2025. 

## Structure
Project consists of four classes, i.e. `User`, `Message`, `Point` and `Main`, as well as the CSV file [twitter.csv](http://www.berndresch.com/work/twitter.csv).

### 1. `User`
This class is the representation of a user that posts messages/tweets. 

- **Attributes:**
	-`userId` (String)
- **Methods:**
	- `getUserId()` - getter for returning the `userId` 
	-`getMessages` (ArrayList<Message>m):ArrayList<Message> - this method returns the list of messages, which belongs to specific user 

### 2. `Message`
This class is the representation of a message/tweet. 

- **Attributes:**
	- `messageId` (String)
	- `text` (String)
	- `location` (Point)
	- `emotion` (String)
	- `user` (User)
- **Methods:**
	- `getEmotion()` - getter for returning the `emotion`.
	- `getLocation()` - getter for returning the `location`.
	- `getUser()` - getter for returning the `user`.
	- `getText()` - getter for returning the `text`.
	
### 3. `Point`
This class is the representation of point, so the exact location from where tweet/message was written.

- **Attributes**
	- `latitude` (double)
	- `longitude` (double)
- **Methods**
	- `getLatitude()` - getter for returning the `latitude`.
	- `getLongitude()` - getter for returning the `longitude`.
	- `distanceTo` (Point input) - this method returns the Euclidean distance between input and point
	- `search` (double radius, ArrayList<Message> m): ArrayList<Message> - this method returns the list of messages, which are within a certain radius from one location
	
### 4. `Main`
This is the main class containing the main method, and is responsible for the following actions:
- creating a new ArrayList<> containing all of the messages/tweets.
- parsing the CSV file, taking care of special signs that they will not affect reading the file.
- printing all of the messages using following style: `messageId` | `text` | `userId` | `lat` | `lon` | `emotion`.
- catching and explaining the errors or exceptions. 
- creating new `User` instance in order to test the `getMessages` method.
- creating new `Point` instance in order to test the `search` method. 

>[!NOTE]
>Code was partially written with help of AI. The prompts however were focused on explainig my mistakes, and guiding me to the solution rather than giving the straight forward answer. 

An honorable mention to [Boloco 50 Congress Street - Burrito Restaurant](https://boloco.com/), which served as the reference point for measuring distance and seems like a cool place to visit. :)