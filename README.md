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


# DECIDE: Launch Interceptor Program

DECIDE is a boolean decision-maker for a hypothetical anti-ballistic missile system. The purpose is to analyze input radar signals and evaluate whether certain Launch Interceptor Conditions (LIC) are met. Depending on the input for the program, certain conditions may be disregarded. The final output is a boolean signal (`true` or `false`), which is the decision of whether an interceptor should be launched.

## Statement of Contributions

**Alex Gunnarsson**

- [Initial code structure](https://github.com/alexarne/DECIDE/pull/28)
- [LIC11 + Tests](https://github.com/alexarne/DECIDE/pull/69)
- [LIC12 + Tests](https://github.com/alexarne/DECIDE/pull/68)
- [LIC13 + Tests](https://github.com/alexarne/DECIDE/pull/83)
- [LIC14 + Tests](https://github.com/alexarne/DECIDE/pull/81)
- [CMV + Tests](https://github.com/alexarne/DECIDE/pull/48)
- [PUM + Tests](https://github.com/alexarne/DECIDE/pull/65)
- [FUV + Tests](https://github.com/alexarne/DECIDE/pull/66)
- [Final Launch Decision + Tests](https://github.com/alexarne/DECIDE/pull/49)
- [ContainedInCircle Helper + Tests](https://github.com/alexarne/DECIDE/pull/79)
- [Refactor TriangleArea Helper + Tests](https://github.com/alexarne/DECIDE/pull/67)
- []()

**Anne Haaker**

- [LIC0 + Tests](https://github.com/alexarne/DECIDE/pull/35)
- [LIC1 + Tests](https://github.com/alexarne/DECIDE/pull/55)
- [LIC2 + Tests](https://github.com/alexarne/DECIDE/pull/54)
- [LIC8 + Tests](https://github.com/alexarne/DECIDE/pull/57)
- [LIC9 + Tests](https://github.com/alexarne/DECIDE/pull/70)
- [Distance Helper + Tests](https://github.com/alexarne/DECIDE/pull/37)
- [CircleRadius Helper + Tests](https://github.com/alexarne/DECIDE/pull/64)
- []()

**Elliot Elmenbeck**

- [LIC6 + Tests](https://github.com/alexarne/DECIDE/pull/93)
- [Angle Helper + Tests](https://github.com/alexarne/DECIDE/pull/78)

**Hugo Tricot**

- [CI for Maven](https://github.com/alexarne/DECIDE/pull/4)
- [LIC7 + Tests](https://github.com/alexarne/DECIDE/pull/56)
- [LIC10 + Tests](https://github.com/alexarne/DECIDE/pull/71)
- []()

**Juan Bautista Lavagnini Portela**

- [LIC3 + Tests](https://github.com/alexarne/DECIDE/pull/52)
- [LIC4 + Tests](https://github.com/alexarne/DECIDE/pull/60)
- [LIC5 + Tests](https://github.com/alexarne/DECIDE/pull/61)
- [TriangleArea Helper](https://github.com/alexarne/DECIDE/pull/52)
- [WhichQuad Helper](https://github.com/alexarne/DECIDE/pull/60)

## Essence

## P+