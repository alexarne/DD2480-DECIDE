# SE-24

Assignments for DD2480 Software Engineering Fundamentals (KTH, 2024) 

# User manual

Clone the repository using `git clone`.

## Maven commands

Maven grants several useful commands that can be used to compile, test and package the project. All commands must be executed in the location of the `pom.xml` file, that is in `/decide-app`:

- To compile the project: `mvn compile`

- To test the project: `mvn test`

- To package the project: `mvn package`

The phases are executed sequantially, `mvn test` also compiles the project, and `mvn package` also compiles and tests the project.

Other useful phases can be found in the [Maven Introduction to Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).



## Repository structure

The repository has the following structure:

- decide-app
  
  - src
    
    - main/java/com/decide/app
      
      - Connector.java
      
      - Decide.java
      
      - LaunchInterceptorConditions.java
      
      - Parameters.java
      
      - Point.java
    
    - test/java/com/decide/app
      
      - DecideTest.java
      
      - LaunchInterceptorConditionsTest.java
  
  - A `target` folder will appear here after building the project, containing the executables and jar files.
  
  - pom.xml



## Changing input values

The main class is the `Decide` class, which takes the input values `NUMPOINTS` (int), `POINTS` (array of Point objects), `PARMETERS` (Parameters object with parameter values), `LCM` (2D-array of logical Connector enumerations), and `PUV` (boolean array).

Initialize the `Decide` object with appropriate parameters and call the `DECIDE` method.



## Supported Versions

Other versions can work but are not guaranteed to. The following versions were used during development and are guaranteed to work: 

- Java: OpenJDK 17.0.9 (OpenJDK Runtime Envirnoment)

- Maven: Apache Maven 3.9.1 (Red Hat 3.9.1-3)