# High Scores Section
## Overview
A high scores section would be accessed from the main menu and would save the top 5 scores of the user and display them.
This will be done using an external text file which saves a user's score if it's a top 5 score.
It can be implemented in the mainApplication class. 
The first thing that will be implemented is the high scores button in the menu 
Clicking high scores will open a page with 5 spots for each high score

## Pseudocode
After user finishes game:

&emsp; get user score

&emsp; read scores file
  
&emsp; if # of scores in file < 5
  
&emsp; &emsp; Insert user score in correct position in file
    
&emsp; else if # of scores in file = 5 and user score > lowest score
  
&emsp; &emsp; insert user score in correct position and remove last score from file

When the user goes to the scores section, ScorePane class will read the scores file and display it to the user

## How I implemented it
MainApplication create a scores file as soon as the game starts unless it already exists.

Once a user plays a game and loses, the score they get will be immediately written to the scores file. This was done in the gamePane class

The scorePane class displays the scores screen when the user clicks on it.

When the user returns to the main menu and clicks the scores button, the scores file will be read into a list and put in descending order. The first five elements will be displayed using GLabels. If there are less than 5 elements, a 0 will be used for each missing element. This was all done in the mainApplication class


<img width="775" alt="Screenshot 2023-01-30 155824" src="https://user-images.githubusercontent.com/89720700/215625278-ddf420fd-4ffd-4fcc-9aff-33ab31a1964c.png">


<img width="772" alt="Screenshot 2023-01-30 155846" src="https://user-images.githubusercontent.com/89720700/215625244-31211c35-10ba-43c7-855b-a4ffbdb2776f.png">
