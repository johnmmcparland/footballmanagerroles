# Introduction #

This page discusses some of the implmentation of the project, focussing on technologies and the choices.


# Details #

There were a few technology decisions made

  * Deployment
  * Database
  * Implementation language
  * Frameworks
  * User Interface

## Deployment ##
Due to being a data-processing application, it was felt that this project suited being a web application with a database back-end.

For this reason, a web deployment was chosen.

## Database ##
Cost was the main consideration here so MySQL was chosen as it is free.

Historically, this project actually started out using a simple OpenOffice Base (HSQL) database.  It was just queries to determine various things, such as optimal training schedules for players.  Much of the data was migrated from this database to MySQL.

## Implementation language ##
As a web application was chosen and the developer's main strength was Java it was chosen.

Another possibility, has the application been a desktop application was C# .NET.

## Frameworks ##
To ease the integration with database and web technologies, Spring was chosen.

## User Interface ##
The user interface is plain HTML.  This is generated by the servlet.