# SE-24

Assignments for DD2480 Software Engineering Fundamentals (KTH, 2024) 



# User manual

## Downloading instructions

The online repository to get access to the code can be downloaded from GitHub using the the Git tool by the following commands:

- `git clone https://github.com/alexarne/DECIDE.git` to clone via HTTPS

- `git clone git@github.com:alexarne/DECIDE.git` to clone via a password-protected SSH key

The `main` branch contains the latest features and patches.



## Supported setup

Other setups can work but are not guaranteed to. the following is guaranteed to work:

- OS: Fedora Linux 39

- kernel: Linux version 6.6.13-200.fc39.x86_64

- Java: opendk 17.0.9 (OpenJDK Runtime Envirnoment)

- Maven: Apache Maven 3.9.1 (Red Hat 3.9.1-3)



Java can be downloaded by executing `sudo dnf install java-latest-openjdk.x86_64` in a command line interface.

Maven can be downloaded by executing `sudo dnf install maven` in a command line interface.



## Changing input values

To modify the input values, go to `decide-app/src/main/java/com/decide/app/Parameters.java` and change the values in the `Parameters` default constructor.



## Maven commands

Maven grants several useful commands that can be used to compile, test and package the project. All commands must be executed in the location of the `pom.xml` file, that is in `/decide-app`:

- To compile the project: `mvn compile`

- To test the project: `mvn test`

- To package the project: `mvn package`

The phases are executed sequantially, `mvn test` also compiles the project, and `mvn package` also compiles and tests the project.

Other useful phases can be found in the [Maven Introduction to Build Lifecycle]([Maven – Introduction to the Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).



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

- README.md

- .gitignore
