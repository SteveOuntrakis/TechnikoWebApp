# TechnikoWebApp

- TechnikoWebApp is a property management application designed for property owners and administrators. It allows users to manage properties, repairs, and provides role-based access for admins and property owners.

## Project Description

- [`Click for Project Description`](https://github.com/SteveOuntrakis/TechnikoWebApp/blob/main/TechnikoFinalProject.pdf)

## Project Structure

The project contains the following basic structure :
- Resource classes: This is where the Api requests exist. These classes communicate with the Service classes.
- Service classes : They help the communication between the resources and the repository.
- Repository classes : This is where the communication between the database and the services happen. They handle all the code we need to retrieve or store data to the database.
- Model classes : Here we have the classes we need in order to create our database. These classes orchestrate the whole project.

Extra structure :
- Test classes : there is one test class as an example.
- Exception classes : there are some exception classes we use in order to show an error.
- Security classes: This contains the
    -  CorsManagement ( a class that is needed in order to make the communication between our backend and our frontEnd ) and the
    -  AuthenticationFilter, a class that creates the basic Auth ( the basic Auth was removed afterwards as we never implementented in our frontEnd.
 
## Features
In The project there are some nice to have features which they are implemented:
- If you to Post an existing object giving it's id in the url, the program will update it.
- The data are soft-deleted and not permantly deleted. There is not business strategy of how to "undelete" them so maybe this will be a feature.
- There is a basic Auth implemented in the project but they were commented out for the future ( Front-End doesnt want Basic Auth for the moment ).
- There is a Login Page in the Project. If the Front-End wants to add a front-Page in the future it can easily be added.
- There are Test and Exceptions classes. More can be added as a feature.

## How to Deploy

- Clone the Project .
- In the Persistence file (resources -> META-INF -> Persistence.xml ) change this line : `<property name="hibernate.hbm2ddl.auto" value="validate"/>` to this `<property name="hibernate.hbm2ddl.auto" value="create"/>`.
- Run the project and when the database is created change back the line in the Persistence.xml to its original value.

## How to Use

- First we need to create some values in our database. In order to do that we need to run the Post command in every collection.
  - The Admin is independent so we may run it whenever we like.
  - First we need to create a PropertyOwner. ( We need on owner in order to have Property ).
  - Secondly we create Properties. ( we need to have properties in order to make repairs ).
  - Finally we may create some PropertyRepairs.
 - After that we may use all of our API's without any issue.
 
## API:

- All the Api calls are contained in the TechnikoWebApp.postman_collection.json. You may import this file to your Postman and have every request you need in your Project.
