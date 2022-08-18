# SpringBoot-RestApi-DiningReview

 Project from course "Create REST APIs with Spring and Java" from CodeAcademy 
 -  RESTful web API with data persistence using Spring and Spring Data JPA
 -  Connection to MySql database using Hibernate
 -  A simple system to Review restaurants, rating them and adding description of the experience.
 
 # Functionalities
 
 User entity-related scenarios:
- As an unregistered user, create user profile using a display name that’s unique only to a user.
- As a registered user, update user profile. Cannot modify my unique display name.
- As an application experience, fetch the user profile belonging to a given display name.
- As part of the backend process that validates a user-submitted dining review verify that the user exists, based on the user display name associated with the dining review.
 
 Dining review entity-related scenarios:
- As a registered user, submit a dining review.
- As part of the backend process that updates a restaurant’s set of scores, fetch the set of all approved dining reviews belonging to this restaurant.

 Restaurant entity-related scenarios:
- As an application experience, submit a new restaurant entry. Should a restaurant with the same name already exist, will see a failure.
- As an application experience, fetch the details of a restaurant, given its unique Id.
- As an application experience, fetch restaurants that have at least one user-submitted score. 
