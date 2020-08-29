What I have Done
------------------
created maven project
added dependenices to run springmvc
About classes

urlmapper.java
-------------
this just maps users url to jsps

TransactionFormat.java
---------------
this is just fields we take from csv file


getData.java
-------------
this reads input from csv file

ExecuteProcessing.java
----------------
this is the class responsible for calculating average of country/city



manupulate.java
---------------
first calls getdata class to read data 
then calls executeprocessingclass to process data 

outputputformat.java
--------------------
just contains fields which we wanted to show as output


HOW TO RUN ON YOUR MACHINE
-----------------------------
clone the folder from git
import as existing projects 

run tomcat7:run to start working port 9966 url("http://localhost:9966/spring/getaverage")

otherwise just run manupulator.java to just write in csv file