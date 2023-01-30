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
