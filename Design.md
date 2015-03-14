# Introduction #

This page details the design of the application.


# Details #

## Process Flow ##
The process flow is shown below;

<img src='https://lh3.googleusercontent.com/-P0haHmQOkL4/TwhvOF8GVmI/AAAAAAAAAwM/8x4uGgjE9yw/s640/ProcessFlow.jpg' alt='Process flow through the Football Manager Roles application' title='Process Flow' />

It is;

  1. Gather the input - i.e. the file with the player
  1. Load the Data Access Object and the required data
  1. Determine whether it is a Football Player or Staff (TBD) parser that is required
  1. Parse out the player / staff member
  1. Calculate the suitability for the various roles
  1. Report the roles

## Class Diagram ##

The class diagram is shown in the projects source directory below.  It shows the interfaces, enums and classes plus the relationships between them.

<img src='https://lh4.googleusercontent.com/-wMqfPc7PSYE/TwhvPL7HUxI/AAAAAAAAAwU/e1HdtBy_HyE/s800/Class.jpg' alt='Class diagram of the football manager roles application showing the relationship between the classes' title='Class Diagram' />

There are several groups of classes;

  * data access (i.e. to databases)
  * roles
  * people
  * parsers
  * attributes
  * input

## Database ##

The database contains a number of key tables which are shown in the Entity-Relationship Diagram below.

<img src='https://lh5.googleusercontent.com/-NUoPtNZmCo0/TwhvPJJYYjI/AAAAAAAAAwY/SFzcR_iCtPM/s912/EntityRelationshipDiagram.jpg' alt='Entity-Relationship Diagram for Football Manager roles showing the relationships between the key tables' title='Entity-Relationship Diagram' />

The main tables are;

  * CategoriesGK
  * TypeGK
  * AttributesGK
  * CategoriesOutfield
  * TypesOutfield
  * AttributesOutfield
  * PitchArea
  * Role
  * Side
  * Duty
  * Positions\_To\_Roles