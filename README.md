# SECRET SANTA
Welcome to Secret Santa game, the game is under active development. this is an simple run as it is application taking input as files

## Prerequisites
Java 11+
Maven 3.6+

## SETUP
1. clone the repo
2. replace **data/players_list.csv**
3. if there is no previous game leave "data/previous_game.csv" empty
4. mvn clean install

### players_list.csv
> Employee_Name,Employee_EmailID

### previous_game.csv
> Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID

### application.properties
>file.player_list.path="path to players"  
>file.previous_game.path="path to previous game, leave it empty if it doesn't exist"  
>file.new_game.path="path to store the generated game"  
retry_count.min="minimum time to retry before program fails"

## RUNNING
1. cd Secret-Santa-Generator
2. mvn exec:java -Dexec.mainClass="com.game.app.App"
3. the default output path is src/resources/new_pairs.csv