1. Create MySQL database with name AME. Make sure it has access to root user with blank password.
You can use following query to create database

mysql>> CREATE DATABSE AME;

2. Configure the database connection
Make sure that your Database connection string is "jdbc:mysql://localhost:3306/AME"

3. Initial Setup

Place the ".txt" file containing the conference name in following folder
for ex. if the file name is conference.txt the path of the file should look like
C:\Users\Public\Documents\Dataset\conference.txt   (Copy the Dataset folder to C:\Users\Public\Documents\)

Place all the Input Documents ".txt" files containing input data in following folder
for ex. if the file name is  doc.txt the path of the file should look like
C:\Users\Public\Documents\Input\doc.txt  (Copy the Input folder to C:\Users\Public\Documents\)

Place the stopwordslist.txt file in the following Documents folder. The path of this file should look like
C:\Users\Public\Documents\stopwordslist.txt

4. Copy the whole project in eclipse
Add the external library to your project mysql-connector-java-6.0-bin.jar

5. Run main.java file

For the Parser code refer README.txt present in Parser folder