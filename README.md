README FILE FOR COMPILING WITH MAVEN.


NOTE: 
Please make sure you are running the most recent versions of MAVEN and JDK.

Starting up with Maven

If you want to use Maven and you're running gitBash, you will likely need to use the export command. 
Export the address of your maven folder to be stored as a global variable.

 
Use export PATH=$PATH:"..."
inside the quotations put the path of you bin folder in the directory storing maven's files,

for example I use the command.
..
export PATH=$PATH:"C:\Program Files\apache-maven-3.3.9\bin"

I want to compile the program. What do I do.

Make sure every file you need is in the java and resources folder.
Go to the top of the repo directory, team05, and execute the command
mvn package
This will create an executable jar file that you'll be able to run using the command.

java -jar target/ca.uwo.csd.cs2212.team05-1.0-SNAPSHOT-jar-with-dependencies

What comes after target depends on what .jar file was created after using "mvn package"
Either way though, the file you are running will be in the target folder.
