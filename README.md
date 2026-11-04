# JavaToMSSQL

A Java console application that connects to a local SQL Server database over JDBC and inserts or deletes rows in a `student_details` table (name, marks). It asks for the database username and password at startup. Written while learning JDBC.

## Tech stack

- Java
- JDBC
- Microsoft SQL Server (mssql-jdbc 9.4.0, included in `ExternalJARs`)
- Eclipse project files

## How to run

1. Create a database named `students` on `localhost:1433` with a `student_details` table that has `name` and `marks` columns.
2. Import the project into Eclipse (the `.project` and `.classpath` files are included) and make sure `ExternalJARs/mssql-jdbc-9.4.0.jre16.jar` is on the build path.
3. Run the main class and follow the prompts.
