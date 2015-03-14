# Introduction #

This page details how to install the Football Manager Roles software.

# Details #

## Step 1: Create the database ##
  1. Use the download FootballManagerRoles.sql to create the database
  1. Ensure it has collation utf8\_general\_ci
  1. Name the database footballmanagerroles
  1. Configure a user called fmrolesuser.
  1. Ensure fmrolesuser has SELECT privilages only on the footballmanagerroles database
  1. Create a strong password for fmrolesuser (change it from the default)

## Step 2: Configure JNDI ##
  1. Add to tomcat\conf\context.xml the following
```
<Resource name="jdbc/footballmanagerroles" auth="Container" 		type="javax.sql.DataSource" maxActive="100" maxIdle="30" maxWait="10000" username="fmrolesuser" password="1gNorance" driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/footballmanagerroles" />
```
  1. CHANGE THE PASSWORD to be the same as the one in the database

## Step 3: Upload the WAR ##
  1. Place the FootballManagerRoles.war file in tomcat\webapps
  1. Restart Tomcat