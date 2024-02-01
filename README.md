# DECIDE: Launch Interceptor Program

DECIDE is a boolean decision-maker for a hypothetical anti-ballistic missile system. The purpose is to analyze input radar signals and evaluate whether certain Launch Interceptor Conditions (LIC) are met. Depending on the input for the program, certain conditions may be disregarded. The final output is a boolean signal (`true` or `false`), which is the decision of whether an interceptor should be launched.

## How to Install and Run

Clone the repository using `git clone` and install Maven.

The project is tested using Maven configured with JUnit 4 (at least version 4.13.1), but the program itself can be extracted and executed with vanilla Java.

### Maven commands

Maven grants several useful commands that can be used to compile, test and package the project. All commands must be executed in the location of the `pom.xml` file, that is in `/decide-app`:

- To compile the project: `mvn compile`

- To test the project: `mvn test`

- To package the project: `mvn package`

The phases are executed sequantially, `mvn test` also compiles the project, and `mvn package` also compiles and tests the project.

Other useful phases can be found in the [Maven Introduction to Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

### Changing input values

The main class is the `Decide` class, which takes the input values `NUMPOINTS` (int), `POINTS` (array of Point objects), `PARMETERS` (Parameters object with parameter values), `LCM` (2D-array of logical Connector enumerations), and `PUV` (boolean array).

Initialize the `Decide` object with appropriate parameters and call the `DECIDE` method.

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

## Supported Versions

Other versions can work but are not guaranteed to. The following versions were used during development and are guaranteed to work:

- Java: OpenJDK 17.0.9 (OpenJDK Runtime Envirnoment)

- Maven: Apache Maven 3.9.1 (Red Hat 3.9.1-3)

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
- Reviewed: LIC0, LIC1, LIC2, LIC3, LIC4, LIC5, LIC6, LIC7, LIC8, LIC10, distance helper, findCircleRadius helper, angle helper

**Anne Haaker**

- [LIC0 + Tests](https://github.com/alexarne/DECIDE/pull/35)
- [LIC1 + Tests](https://github.com/alexarne/DECIDE/pull/55)
- [LIC2 + Tests](https://github.com/alexarne/DECIDE/pull/54)
- [LIC8 + Tests](https://github.com/alexarne/DECIDE/pull/57)
- [LIC9 + Tests](https://github.com/alexarne/DECIDE/pull/70)
- [Distance Helper + Tests](https://github.com/alexarne/DECIDE/pull/37)
- [CircleRadius Helper + Tests](https://github.com/alexarne/DECIDE/pull/64)
- Essence paragraph
- Reviewed: LIC11, LIC12, CMV, PUM, FUV, triangleArea helper

**Elliot Elmenbeck**

- [LIC6 + Tests](https://github.com/alexarne/DECIDE/pull/93)
- [Angle Helper + Tests](https://github.com/alexarne/DECIDE/pull/78)
- Reviewed: LIC2, LIC9, countQuads helper

**Hugo Tricot**

- [CI for Maven](https://github.com/alexarne/DECIDE/pull/4)
- [LIC7 + Tests](https://github.com/alexarne/DECIDE/pull/56)
- [LIC10 + Tests](https://github.com/alexarne/DECIDE/pull/71)
- [User Manual](https://github.com/alexarne/DECIDE/pull/96)
- Reviewed: LIC1, LIC3, LIC5, LIC9, LIC13, LIC14, containedInCircle helper

**Juan Bautista Lavagnini Portela**

- [LIC3 + Tests](https://github.com/alexarne/DECIDE/pull/52)
- [LIC4 + Tests](https://github.com/alexarne/DECIDE/pull/60)
- [LIC5 + Tests](https://github.com/alexarne/DECIDE/pull/61)
- [TriangleArea Helper](https://github.com/alexarne/DECIDE/pull/52)
- [WhichQuad Helper](https://github.com/alexarne/DECIDE/pull/60)
- [countQuads](https://github.com/alexarne/DECIDE/pull/101)
- Reviewed: distance helper

## Way of working - Essence

The group is in the 'in place' state of way-of-working. The group has established principles and key practices regarding tools, communication and how to break down and divide the work. Agreed upon tools are for example Java and Git, whereas practices include self-assignment of issues, that are also reviewed through PRs. The main obstacle to get to the 'working well' state is for all members to gain more experience with the tools in order to apply the practices naturally, without thinking about them.

## P+

We believe that three aspects have been significant throughout the development of this project, that perhaps collectively meet the requirement for _remarkable_ quality:

1. **Code Structure -** The group decided on an initial code structure early on, where the purpose was to support independent development and lay the foundation for a smooth development experience. This included defining how the points and various parameters would be represented, as well as the interface for the different LICs and intermediary steps in calculating the DECIDE function. This was successful in that the group members did not have to be concerned with what everyone else was doing. Specifically, the division of the DECIDE function allowed for thorough unit testing of each intermediary step.
2. **Continuous Integration -** Despite not being required for this assignment, the group set up continuous integration which automated the testing with Maven. This resulted in an easier experience for group members to review other members' PRs, since they could focus on the code whilst being assured that it passed all tests.
3. **Test Driven Development -** The group agreed to require each new feature and function to include at least one positive test, one edge-case test, and one invalid input test (if applicable). These tests were also heavily criticized during PR reviews, in order to guarantee a properly functioning implementation. Furthermore, the repository was configured such that no one could push changes directly to the main branch, and every PR required at least one approval before merging. This meant that at least one other group member had to have been convinced that the implementation is correct, which helped in giving everyone else an overview of what other group members were doing.
