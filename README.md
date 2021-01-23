# p1-mosaic
## Project Contributors
| Contributor | GitHub Link | Journal Link |
| ----------- | ----------- | ----------- | 
| Nakul Nandhakumar | [@nakulnandhakumar](https://github.com/nakulnandhakumar) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Sara Beniwal | [@saraben21](https://github.com/saraben21) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)
| Andrew Pegg | [@andrewcomputsci2019](https://github.com/andrewcomputsci2019) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Michael Hayes | [@mhayescs19](https://github.com/mhayescs19) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)

## Population Simulation Project
### OVERVIEW ([PROJECT PLAN LINK](https://docs.google.com/document/d/1xFTt2SqCLsW6-2fDmcQppuPO6XvYHVz6I5cnbozqs2U/edit?usp=sharing))
Increase in population is determined by dot interaction (event based), while decrease is based on time. A simple simulation that models the change of population based on factors such as rate of reproduction, death, and interaction. Algorithms will be used to adjust each person’s chances of dying or reproducing based on their age and interaction with one another. If time allows, an algorithm that introduces a virus in the middle of the simulation will be added in order to model the change of population in the middle of a pandemic environment. At the end of the simulation, a data table will be displayed with data such as average increase in population over the years, notable increases or decreases in population with year number, in number of deaths a year, in offspring produced, etc. A database will be added in the future to store simulation data from multiple simulations.
### AP UNITS IN PROJECT
[LINK](https://docs.google.com/document/d/1n9hqvHHT1ru5K8gSgDt7DpwIyEZGhx0f8VcoV56nmS0/edit)

## ScrumBoard
<a href="https://github.com/mhayescs19/p1-mosaic/projects/1"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/scrum-board-button.png" width="30%" height="auto"><a/> 
  <a href="https://github.com/mhayescs19/p1-mosaic/projects/1#column-12588132"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/1_22-board-column-button.png" width="30%" height="auto"><a/>
  <a href="https://github.com/mhayescs19/p1-mosaic/projects/1#column-12570582"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/1_15-board-column-button.png" width="30%" height="auto"><a/> 
  <a href="https://github.com/mhayescs19/p1-mosaic/projects/1#column-12377226"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/1_8-board-column-button.png" width="30%" height="auto"><a/> 
  <a href="https://github.com/mhayescs19/p1-mosaic/projects/1#column-11956730"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/12_18-board-column-button.png" width="30%" height="auto"><a/> 
    <a href="https://github.com/mhayescs19/p1-mosaic/projects/1#column-12146723"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/12_11-board-column-button.png" width="30%" height="auto"><a/>

## Runtime Guidance For Entire Project
1. Clone the project repository.
2. Open the src directory, open the Main package, and open the Main.java file.
3. Run from Main.java (inside of the "Main" package) OR set up configuration to Main.
<img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/runtime-in-main.png" height="auto" width="52%"> <img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/runtime-configuration.png" width="40%" height="auto">

## 1/21  Weekly Project Contributions and Artifacts Log
### Week 6
### 1. [Debug and Activate Births & Dynamically Size ArrayList After Iteration](https://github.com/mhayescs19/p1-mosaic/issues/41)
Before this fix, a new birth would throw errors, crashing the program. As well, a new death would throw a single error, but the program could continue. <br> Created by **Michael Hayes** <br> **Contents:** <br> - Indentified bug: ArrayLists cannot be resized (elements added or removed) during an iteration check. <br> **Fixes:** <br> 1) respective [temporary ArrayLists](https://github.com/mhayescs19/p1-mosaic/blob/830e95e1d122221838fc2ee639c0b886536d9479/src/Main/SimControl.java#L27) for births and deaths created <br> 2) [Births](https://github.com/mhayescs19/p1-mosaic/blob/830e95e1d122221838fc2ee639c0b886536d9479/src/Main/SimControl.java#L107) and [deaths](https://github.com/mhayescs19/p1-mosaic/blob/830e95e1d122221838fc2ee639c0b886536d9479/src/Main/SimControl.java#L159) detected during check of panel added to respective temp lists <br> 3) New method [recountPopulation](https://github.com/mhayescs19/p1-mosaic/blob/830e95e1d122221838fc2ee639c0b886536d9479/src/Main/SimControl.java#L225) created to activate respective additions and deletions to master population ArrayList **AFTER** all iteration checks of the repaint call to avoid mutating the master population ArrayList mid iteration

### 2. [Debug Collision Check, Fix Screen Resolution, and Adjust Dot "People" Size](https://github.com/mhayescs19/p1-mosaic/issues/40) 
Before this fix, the balls (dots) would pass straight through each other and not collide and bounce off of each other. <br> Created by **Nakul Nandhakumar** and **Andrew Pegg** <br> **Contents:** <br> - Identified Bug: In a "for loop" that iterates through each person in an arraylist, a function call "collisionCheck" would be called for each person and check if they were colliding with any other people. Then 2 functions would be called to reverse the x and y velocities for **each** person which caused them to be called again when the other person that was colliding with the original was evauluated, canceling out the change. <br> **Fixes:** <br> 1) The [functions to reverse x and y velocities](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Main/SimControl.java#L101-L102) were called only for the person being evauluated <br> 2) Reduced the [size of the balls](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Movement/Movement.java#L32-L33) to 2/5 the original size to prevent velocity reversals from being called multiple times due to balls still being in contact with each other after the next tick <br> 3) Adjusted [screen resolution](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Panel/Painter.java#L37) to make it so that the panel is within the bounds of the user's screen while still being big enough to have the simulations run (the balls move) smoothly

## 1/15 Weekly Project Contributions and Artifacts Log

## Featured ScrumBoard Tickets (20/20)
1. [Integrating ConfigGUI with SimControl Using ConfigControl](https://github.com/mhayescs19/p1-mosaic/issues/33) <br> For the team, this was a big step towards getting the project to actually run and visually experience all of our past hard work. Got the MainGUI where simulation happens to pop up after ConfigGUI "start" button is pressed. Every member of the group participated in this ticket.

2. [ConfigGUI](https://github.com/mhayescs19/p1-mosaic/issues/7) <br> ConfigGUI is where the user enters intial specifications for simulation, length of simulation, and starts the simulation. Sliders, dropdown menus, Textfields, and buttons from JFrame are all utilized in this class. Initiliazes all the variables like inital population and passes them to SimControl. Created by Nakul Nandhakumar.

3. [Paint](https://github.com/mhayescs19/p1-mosaic/issues/17) <br> This class manages a timer which counts by the millisecond and repeatedly calls a paint method very frequently to draw the people (circles) onto the panel so that the balls appear to move to the screen. Also paints the walls and background that the balls will move on. Created by Andrew Pegg.

4. [SimControl & Person](https://github.com/mhayescs19/p1-mosaic/issues/29) <br> The Person class creates the "people" of the population simulation and all of their details such as age, health status, birth chance, death chance, etc. SimControl manages the execution of the simulation and calls all the methods in order to run the simulation. It manages the status of each person. Created by Michael Hayes.

5. [MainGUI](https://github.com/mhayescs19/p1-mosaic/issues/8) <br> This class creates one of the panels that is needed for the balls to appear on. It utilizes a paint method from the class Paint to display the ovals which is the island. It has a pause button as well which will be implemented in the project later. Created by Sara Beniwal. 

### Week 5
| Contributor | Artifacts |
| ----------- | ----------- |
| Nakul Nandhakumar | **ARTIFACTS:** <br> - Added [endSimulation](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Main/SimControl.java#L160) method in SimControl <br> - Passed variables from ConfigGUI to SimControl in [constructor](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Main/SimControl.java#L160) <br> - Added [updateYear](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Main/SimControl.java#L160) method in SimControl <br> - Worked with Scrum Team to integrate ConfigGUI and SimControl using class [ConfigControl](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Main/SimControl.java#L160) <br> <br> **RUNTIME GUIDANCE:** <br> I created a temporary main method in SimControl used for testing to see if my methods in SimControl are executed and confirmed via print statements. The method is at the bottom of SimControl, run that main method if you want to see if my Simcontrol methods are functioning. <br> <br> <br> **SCRUMBOARD TICKET LINKS:** <br> - [ConfigControl](https://github.com/mhayescs19/p1-mosaic/issues/33) <br> - [SimControl Methods](https://github.com/mhayescs19/p1-mosaic/issues/25) <br> (For the actual code added an commits made, see the linked pull requests) |
| Andrew Pegg | **ARTIFACTS:** <br> - Added[ Packager](https://github.com/mhayescs19/p1-mosaic/blob/DataBranch/src/Packager/Packager.java) class used for packing data WIP <br>  - Added updates to [panel](https://github.com/mhayescs19/p1-mosaic/blob/DataBranch/src/Panel/Painter.java)<br><br> **RUNTIME GUIDANCE:** <br> uses nakuls entry point to run code <br> **SCRUMBOARD TICKET LINKS** <br> [Packager](https://github.com/mhayescs19/p1-mosaic/issues/27) <br> |
| Michael Hayes |  **ARTIFACTS:** <br> - updated [ageManager](https://github.com/mhayescs19/p1-mosaic/blob/bb2ce8189c0ff0c7ade45aa5de2b3eba2cbdae6b/src/SimulatorObjects/Person.java#L140) after GUI connection to function correctly: 1) death rates are randomized better 2) does not add age to person if the person is dead <br> - added runtime debug printing ([Ex1](https://github.com/mhayescs19/p1-mosaic/blob/bb2ce8189c0ff0c7ade45aa5de2b3eba2cbdae6b/src/Main/SimControl.java#L72), [Ex2](https://github.com/mhayescs19/p1-mosaic/blob/bb2ce8189c0ff0c7ade45aa5de2b3eba2cbdae6b/src/SimulatorObjects/Person.java#L150)) to give a deeper representation of the simulation not visible on screen <br> **RUNTIME GUIDANCE:** <br> N/a; changes are visible in terminal and visually <br> **SCRUMBOARD TICKET LINKS** <br> - [Connect SimControl to the Main GUI; Get Dots Moving on the Screen](https://github.com/mhayescs19/p1-mosaic/projects/1#card-52451243)|
| Sara Beniwal | **ARTIFACTS:** <br> - Added [DataGUI](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/DataGUI.java) class to display the statistics/results of the simulation <br> - Within DataGUI, added JLabels for each statistic that will be displayed: [Start Year](https://github.com/mhayescs19/p1-mosaic/blob/6f3e9362c7331c3a7abeb2bf813f6649dc0631f0/src/View/DataGUI.java#L25), [End Year](https://github.com/mhayescs19/p1-mosaic/blob/6f3e9362c7331c3a7abeb2bf813f6649dc0631f0/src/View/DataGUI.java#L30), [Initial Population](https://github.com/mhayescs19/p1-mosaic/blob/6f3e9362c7331c3a7abeb2bf813f6649dc0631f0/src/View/DataGUI.java#L35), [Final Population](https://github.com/mhayescs19/p1-mosaic/blob/6f3e9362c7331c3a7abeb2bf813f6649dc0631f0/src/View/DataGUI.java#L40), [Births](https://github.com/mhayescs19/p1-mosaic/blob/6f3e9362c7331c3a7abeb2bf813f6649dc0631f0/src/View/DataGUI.java#L45), [Deaths](https://github.com/mhayescs19/p1-mosaic/blob/6f3e9362c7331c3a7abeb2bf813f6649dc0631f0/src/View/DataGUI.java#L50) <br> - Researched to add histogram to DataGUI (planning on finishing next week} <br> <br>  **RUNTIME GUIDANCE:** <br> - Please run DataGUI separately for now (either in terminal or within the DataGUI class) <br> <br> **SCRUMBOARD TICKET LINKS** <br> - [Complete GUI and Class Setup of Graph and Histogram Functionality](https://github.com/mhayescs19/p1-mosaic/issues/28) - Please note, still in progress|

## 1/08 Weekly Project Contributions and Artifacts Log
### Week 4
| Contributor | Artifacts |
| ----------- | --------- |
| Nakul Nandhakumar | **ARTIFACTS:** <br> - Added [SimData](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Data/SimData.java#L7) <br> - Imported and defined Simulation Data values using [constructor](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Data/SimData.java#L24) <br> - Method to create file for temporarily displaying data called [createNewDataFile](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Data/SimData.java#L79) <br> - Method to write data on created file called [writeOnDataFile](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Data/SimData.java#L93) <br> - Added [genderPercentageSlider](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Data/SimData.java#L93) to ConfigGUI to set up inital genders <br> <br> **RUNTIME GUIDANCE:** <br> - SimData: Go to the Data folder and open the SimData class file. See the temporary main method at the bottom of the class file and hit run (the green play button) next to the main method to run the code for SimData. <br> - ConfigGUI: Go to the Main folder and open the Main class file. Hit the run button (the green play button) next to the main method to run the code to see the GUI. <br> <br> **SCRUMBOARD TICKET LINKS:** <br> - [SimData](https://github.com/mhayescs19/p1-mosaic/issues/18) <br> - [ConfigGUI](https://github.com/mhayescs19/p1-mosaic/issues/7) <br> (See the linked pull request on the Scurmboard Link for code)|
| Andrew Pegg | **ARTIFACTS** <br> - Added [Painter](https://github.com/mhayescs19/p1-mosaic/blob/DataBranch/src/Panel/Painter.java)<br> - Main class that deals with updating ui stuff on the screen <br> -Added [Panel](https://github.com/mhayescs19/p1-mosaic/blob/DataBranch/src/Panel/Panel.java) <br> - class that maps out certian functions for painter <br> - Added [Collison loop](https://github.com/mhayescs19/p1-mosaic/blob/DataBranch/src/Main/SimControl.java#L113) <br> - method that loops through the population to see if they collied or not if so changes veloctity <br> **Runtime Guidance** <br> Not applicatble applicable <br> **SCRUMBOAD TICKET LINKS:** <br> PainterIssue(https://github.com/mhayescs19/p1-mosaic/projects/1) <br>  |
| Michael Hayes | **ARTIFACTS:** <br> - [setup](https://github.com/mhayescs19/p1-mosaic/blob/5017d7a5d9b306f095c5fa8e948db5fbc47f87af/src/SimulatorObjects/Person.java#L81) basic attributes (gender, birthrate death rate) <br> - aligned [collision method](https://github.com/mhayescs19/p1-mosaic/blob/5017d7a5d9b306f095c5fa8e948db5fbc47f87af/src/SimulatorObjects/Person.java#L99) to involve age in deciding birth <br> - created [ageManager](https://github.com/mhayescs19/p1-mosaic/blob/5017d7a5d9b306f095c5fa8e948db5fbc47f87af/src/SimulatorObjects/Person.java#L129) which handles updating age each time paint is called (tied to event of timer, not event of collision) <br> <br> **SCRUMBOARD TICKET LINKS** <br> - [Person Class Method & simControl Setup](https://github.com/mhayescs19/p1-mosaic/projects/1#card-51528468) <br> - [Assigning Basic Person Attributes](https://github.com/mhayescs19/p1-mosaic/projects/1#card-51221835) |
| Sara Beniwal | **ARTIFACTS:** <br> - Added minor changes to [MainGUI](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java): small edits to comments, renaming of JLabels (all done to improve code and make it easier to understand) <br> - Began the research process for [DataGUI](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/DataGUI.java) over weekend; worked on how to collect data and display as JLabels on DataGUI <br> <br>  **SCRUMBOARD TICKET LINKS** <br> - N/A |

## 12/18 Weekly Project Contributions and Artifacts Log
### Week 3
| Contributor | Self Grade /20 | Scrum Grade /5 | Artifacts |
| ----------- | --------- |  --------- |  --------- |
| Nakul Nandhakumar | 19/20 | 5/5 | **ARTIFACTS:** <br> - Added [Configuration GUI](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L12) <br> - Created sliders for [Death Chance](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L105), [Birth Chance](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L133), [Initial Pop](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L53) <br> - Created [dropdown menu (JComboBox)](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L65) for end conditions <br> - Added [ChangeListener](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L59) for sliders to update real-time change <br> - Added ["Reset to Default" button](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L145) that resets all values on GUI to default values <br> - Met outside of class and linked [pull-requests to issues](https://github.com/mhayescs19/p1-mosaic/projects/1#card-51221842) on Scrum Board <br> **Approx 6.5 hrs coding** <br> <br> **TO-DO:** <br> - Framework for Model Class Structures <br> - See [ScrumBoard TO-DO](https://github.com/mhayescs19/p1-mosaic/projects/1#column-11956723) for other to-do's <br> <br> **RUNTIME GUIDANCE:** <br> - ConfigGUI: ConfigGUI: Go to the Main folder and open the Main class file. Hit the run button (the green play button) next to the main method to run the code to see the GUI. <br> <br> **SCRUMBOARD TICKET LINKS:** <br> - [ConfigGUI](https://github.com/mhayescs19/p1-mosaic/issues/7) <br> (See the linked pull request on the Scurmboard Link for code)|
| Andrew Pegg | 18/20 | 5/5 |**ARTIFACTS:**<br> - Added [Movement](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Movement/Movement.java#L14) <br> - Added [collision](https://github.com/mhayescs19/p1-mosaic/blob/master/src/Movement/CollisionCheck.java#L11) <br> Both of these classes deal with the basic movement of objects and collsion between them <br> - Added [Wall](https://github.com/mhayescs19/p1-mosaic/blob/master/src/SimulatorObjects/Wall.java#L12) <br> The wall class deals with image calls and width and height setting for the collision class <br> <br> **SCRUMBOARD LINKS**: <br> - [Wall](https://github.com/mhayescs19/p1-mosaic/pull/14) <br> - [Movement](https://github.com/mhayescs19/p1-mosaic/pull/11) <br> (See the linked pull request on the Scrumboard Link for code) <br> <br> **TO-DO:** <br> Work on the [Painter Class](https://github.com/mhayescs19/p1-mosaic/projects/1#card-51507416) | 
| Michael Hayes |  19/20 | 5/5 | **Artifacts:** <br> - Added [Person](https://github.com/mhayescs19/p1-mosaic/blob/master/src/SimulatorObjects/Person.java#L23) Class with age, gender, birth rate, and death rate attributes <br> - Added two constructors: one for default creation on start of simulaton, another for birth during simulation <br> - Created method [collisionDetected](https://github.com/mhayescs19/p1-mosaic/blob/f80a525b181ed675b866200f82d8b411ad81c641/src/SimulatorObjects/Person.java#L85) which manages possible new births, including passing genetic of an parental average of birth rate and death rate to the child <br> - Set up simControl.java with class variables; used Person collision method in [updatePopulation](https://github.com/mhayescs19/p1-mosaic/blob/f80a525b181ed675b866200f82d8b411ad81c641/src/Main/SimControl.java#L49) <br> <br> **TO-DO:** <br> - [Data Analysis](https://github.com/mhayescs19/p1-mosaic/projects/1#card-51507611) |
| Sara Beniwal | 19/20 | 5/5 | **ARTIFACTS:** <br> - Added [MainGUI](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java) <br> - Created [title and labels](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java#L14) <br> - Created [buttons](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java#L29) to pause and end the simulation <br> - Created a [panel](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java#L77) to use the paint class within the JFrame <br> - Created a [paint](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java#L92) method to make green ovals for "land" <br> Spent about **5 and a half** hours to finish the MainGUI since it was first time completely coding out the GUI. Also, took time to resolve errors involving colors not showing up as well as how to incorporate the paint method into the JFrame. <br> <br> **TO-DO:** <br> - Create circles to represent population <br> - Add bounds to MainGUI  |

## Storyboard Video
<a href="https://youtu.be/PfLXFmrjrJM"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/Population-Simulation-Screenshot.png" width=35% height=auto><a/>

## Code Model
<img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/design_code-model.png" width=75% height=auto>
