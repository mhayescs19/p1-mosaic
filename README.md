# p1-mosaic
## Project Contributors
| Contributor | GitHub Link | Journal Link |
| ----------- | ----------- | ----------- | 
| Nakul Nandhakumar | [@nakulnandhakumar](https://github.com/nakulnandhakumar) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Sara Beniwal | [@saraben21](https://github.com/saraben21) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)
| Andrew Pegg | [@andrewcomputsci2019](https://github.com/andrewcomputsci2019) | [Pegg, Nandhakumar](https://docs.google.com/document/d/13jZuundZrvb5XTzzLQkuICyFDAwaFdN6_um2oTZFZNU/edit?usp=sharing)
| Michael Hayes | [@mhayescs19](https://github.com/mhayescs19) | [Beniwal, Hayes](https://docs.google.com/document/d/1GPklRpwd5uyFdQljSgF4cZS6Uk6-eDf4EA25CQx3Ngc/edit?usp=sharing)

## 12/18 Weekly Project Contributions and Artifacts Log
### Week 3
| Contributor | Self Grade /20 | Scrum Grade /5 | Artifacts |
| ----------- | --------- |  --------- |  --------- |
| Nakul Nandhakumar | 19/20 | 5/5 | **ARTIFACTS:** <br> - Added [Configuration GUI](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L12) <br> - Created sliders for [Death Chance](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L105), [Birth Chance](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L133), [Initial Pop](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L53) <br> - Created [dropdown menu (JComboBox)](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L65) for end conditions <br> - Added [ChangeListener](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L59) for sliders to update real-time change <br> - Added ["Reset to Default" button](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/ConfigGUI.java#L145) that resets all values on GUI to default values <br> - Met outside of class and linked [pull-requests to issues](https://github.com/mhayescs19/p1-mosaic/projects/1#card-51221842) on Scrum Board <br> **Approx 6.5 hrs coding** <br> <br> **TO-DO:** <br> - Framework for Model Class Structures <br> - See [ScrumBoard TO-DO](https://github.com/mhayescs19/p1-mosaic/projects/1#column-11956723) for other to-do's|
| Andrew Pegg | 18/20 | 5/5 |**ARTIFACTS**<br> - Added [Movement] https://github.com/mhayescs19/p1-mosaic/blob/master/src/Movement/Movement.java#L14 <br> - Added [collision] https://github.com/mhayescs19/p1-mosaic/blob/master/src/Movement/CollisionCheck.java#L11 <br> Both of these classes deal with the basic movement of objects and collsion between them <br> - Added [Wall] https://github.com/mhayescs19/p1-mosaic/blob/master/src/SimulatorObjects/Wall.java#L12 <br> The wall class deals with image calls and width and height setting for the collision class <br> Pull request linked - https://github.com/mhayescs19/p1-mosaic/pull/11 https://github.com/mhayescs19/p1-mosaic/pull/14 <br> <br> **TO-DO** <br> work on the class that will deal with painting of the objects onto to the jframe - https://github.com/mhayescs19/p1-mosaic/projects/1#card-51507416 | 
| Michael Hayes |  19/20 | 5/5 | **Artifacts:** <br> - Added [Person](https://github.com/mhayescs19/p1-mosaic/blob/master/src/SimulatorObjects/Person.java#L23) Class with age, gender, birth rate, and death rate attributes <br> - Added two constructors: one for default creation on start of simulaton, another for birth during simulation <br> - Created method [collisionDetected](https://github.com/mhayescs19/p1-mosaic/blob/f80a525b181ed675b866200f82d8b411ad81c641/src/SimulatorObjects/Person.java#L85) which manages possible new births, including passing genetic of an parental average of birth rate and death rate to the child <br> - Set up simControl.java with class variables; used Person collision method in [updatePopulation](https://github.com/mhayescs19/p1-mosaic/blob/f80a525b181ed675b866200f82d8b411ad81c641/src/Main/SimControl.java#L49) <br> <br> **TO-DO:** <br> - [Data Analysis](https://github.com/mhayescs19/p1-mosaic/projects/1#card-51507611) |
| Sara Beniwal | 19/20 | /5 | **ARTIFACTS:** <br> - Added [MainGUI](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java) <br> - Created [title and labels](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java) <br> - Created [buttons](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java) to pause and end the simulation <br> - Created a [panel](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java) to use the paint class within the JFrame <br> - Created a [paint](https://github.com/mhayescs19/p1-mosaic/blob/master/src/View/MainGUI.java) method to make green ovals for "land" <br> <br> **TO-DO:** <br> - Create circles to represent population <br> - Add bounds to MainGUI  |


## Scrum Board
<a href="https://github.com/mhayescs19/p1-mosaic/projects/1"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/scrum-board-button.png" width="30%" height="auto"><a/> 
  <a href="https://github.com/mhayescs19/p1-mosaic/projects/1#column-11956730"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/12_18-board-column-button.png" width="30%" height="auto"><a/> 
    <a href="https://github.com/mhayescs19/p1-mosaic/projects/1#column-12146723"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/12_11-board-column-button.png" width="30%" height="auto"><a/>

## Population Simulation Project
### OVERVIEW ([PROJECT PLAN LINK](https://docs.google.com/document/d/1xFTt2SqCLsW6-2fDmcQppuPO6XvYHVz6I5cnbozqs2U/edit?usp=sharing))
Increase in population is determined by dot interaction (event based), while decrease is based on time. A simple simulation that models the change of population based on factors such as rate of reproduction, death, and interaction. Algorithms will be used to adjust each person’s chances of dying or reproducing based on their age and interaction with one another. If time allows, an algorithm that introduces a virus in the middle of the simulation will be added in order to model the change of population in the middle of a pandemic environment. At the end of the simulation, a data table will be displayed with data such as average increase in population over the years, notable increases or decreases in population with year number, in number of deaths a year, in offspring produced, etc. A database will be added in the future to store simulation data from multiple simulations.

## Storyboard Video
<a href="https://youtu.be/PfLXFmrjrJM"><img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/Population-Simulation-Screenshot.png" width=35% height=auto><a/>

## Code Model
<img src="https://github.com/mhayescs19/p1-mosaic/blob/master/statics/design_code-model.png" width=75% height=auto>
