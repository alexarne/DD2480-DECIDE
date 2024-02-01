# DECIDE: Launch Interceptor Program

DECIDE is a boolean decision-maker for a hypothetical anti-ballistic missile system. The purpose is to analyze input radar signals and evaluate whether certain Launch Interceptor Conditions (LIC) are met. Depending on the input for the program, certain conditions may be disregarded. The final output is a boolean signal (`true` or `false`), which is the decision of whether an interceptor should be launched.

## How to Install and Run

Clone the repository using `git clone`.

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
- Statement of Contributions
- Reviewed: LIC0, LIC1, LIC2, LIC8, distance helper, findCircleRadius helper, LIC6, angle helper, LIC7, LIC10, LIC3, LIC4, LIC5

**Anne Haaker**

- [LIC0 + Tests](https://github.com/alexarne/DECIDE/pull/35)
- [LIC1 + Tests](https://github.com/alexarne/DECIDE/pull/55)
- [LIC2 + Tests](https://github.com/alexarne/DECIDE/pull/54)
- [LIC8 + Tests](https://github.com/alexarne/DECIDE/pull/57)
- [LIC9 + Tests](https://github.com/alexarne/DECIDE/pull/70)
- [Distance Helper + Tests](https://github.com/alexarne/DECIDE/pull/37)
- [CircleRadius Helper + Tests](https://github.com/alexarne/DECIDE/pull/64)
- Reviewed: LIC11, LIC12, CMV, PUM, FUV, DECIDE, triangleArea helper

**Elliot Elmenbeck**

- [LIC6 + Tests](https://github.com/alexarne/DECIDE/pull/93)
- [Angle Helper + Tests](https://github.com/alexarne/DECIDE/pull/78)
- Statement of Contributions
- Reviewed: LIC2, LIC9, countQuads helper

**Hugo Tricot**

- [CI for Maven](https://github.com/alexarne/DECIDE/pull/4)
- [LIC7 + Tests](https://github.com/alexarne/DECIDE/pull/56)
- [LIC10 + Tests](https://github.com/alexarne/DECIDE/pull/71)
- [User Manual](https://github.com/alexarne/DECIDE/pull/96)
- Reviewed: Initial code, LIC13, LIC14, containedInCircle helper, LIC1, LIC9, LIC3, LIC5, LIC3

**Juan Bautista Lavagnini Portela**

- [LIC3 + Tests](https://github.com/alexarne/DECIDE/pull/52)
- [LIC4 + Tests](https://github.com/alexarne/DECIDE/pull/60)
- [LIC5 + Tests](https://github.com/alexarne/DECIDE/pull/61)
- [TriangleArea Helper](https://github.com/alexarne/DECIDE/pull/52)
- [WhichQuad Helper](https://github.com/alexarne/DECIDE/pull/60)
- [countQuads](https://github.com/alexarne/DECIDE/pull/101)
- Reviewed: distance helper, Maven CI

## Way of working - Essence

The group is in the 'in place' state of way-of-working. The group has established principles and key practices regarding tools, communication and how to break down and divide the work. Agreed upon tools are for example the use of the programming language Java, since all the group members have previous experience with it. Another depended upon tool is version control and organization of the work via GitHub. The work is broken down into issues which are divided among the group members by self-assigning issues. The way of self-assigning pieces of work ensures that everyone can work on what they are comfortable with. It also makes the progression of the work clear. Conventions about the use of issues, branches and how to structure commits have been established and has evolved during the process. For example, the group agreed upon using feature-branches and keeping them atomic and connected to a single issue. When a group member deems their current work 'done', they issue a pull request that cannot be merged until at least one other group member has reviewed the work. Review of  others' work provides an opportunity to give feedback and analyze the way in which the work is carried out so that bad practices can be reduced. Additionally, it enforces a more uniform structuring of code and documentation. This means that the whole group uses these practices and tools to perform the work. Communication also occurs via Discord to solve problems or talk about how to move forward, and regular meetings are being held to talk about the work. 

An obstacle to reach the next level is that not all of the practices come natural to all of the group members yet, since we come from different backgrounds making some of the practices new to some. For example, there are some differences in the detail with which others' work is reviewed. The handling of incomplete or incorrect work noticed during reviews of pull requests needs some adjustment to be able to be applied smoothly by the group. Open pull requests with requested changes that have been fixed need to be re-checked, but it sometimes takes time. Better communication could be a possible solution to this, so the group members know if it has been fixed, or when other group members will have time to review changes. In addition, the way of working could be reflected upon more during the process and with the entire group to adapt it.

## P+