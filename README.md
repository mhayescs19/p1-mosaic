# p1-mosaic
## Project Contributors
| Contributor | GitHub Link | 
| ----------- | ----------- |
| Nakul Nandhakumar | [@nakulnandhakumar](https://github.com/nakulnandhakumar) |
| Sara Beniwal | [@saraben21](https://github.com/saraben21) |
| Andrew Pegg | [@andrewcomputsci2019](https://github.com/andrewcomputsci2019) |
| Michael Hayes | [@mhayescs19](https://github.com/mhayescs19) | 

## SUMMARY
### Population Simulation 
Increase in population is determined by dot interaction (event based), while decrease is based on time. A simple simulation that models the change of population based on factors such as rate of reproduction, death, and interaction. Algorithms will be used to adjust each person’s chances of dying or reproducing based on their age and interaction with one another. If time allows, an algorithm that introduces a virus in the middle of the simulation will be added in order to model the change of population in the middle of a pandemic environment. At the end of the simulation, a data table will be displayed with data such as average increase in population over the years, notable increases or decreases in population with year number, in number of deaths a year, in offspring produced, etc. A database will be added in the future to store simulation data from multiple simulations.

1. Initial settings page with variable initialization like initial population, initial chance of death, initial chance of reproduction, etc.
2. As years progress, population changes, the user can "pause" the simulation to view population age group
3. Movement:
   * Bouncing dots
4. Age:
   * Dots slow down as age increases
   * Dots change color throughout age
5. Death:
   * 60+ chance of death increase
   * 90+ chance of natural death increases exponentially
6. Obstacles:
   * Dot hazard - death
     * Chance increases as dot is older
   * Offspring hazards - birth (based on collision)
     * Age requirement - ~18-38
7. Population Density:
   * No management currently
8. Data Analysis:
   * User can select to view statistics from last simulation
     * Histogram of age spread of population
     * Display of averages - deaths, births, increase in population per year
 
## DELIVERY
Project viewing will be inside of Intellij IDEA. Major milestone delivers may deployed via a JAR file

## BIG TICKET ITEMS
1. Initial panel of variable simulation attributes (chance of death, chance of offspring, initial population, simulation speed)
2. Control speed of simulation speed on control panel and while viewing simulation (slow down, pause, speed up)
3. Stopping the simulation would output the data into graphs from that instant (current population, deaths, etc)
4. Obstacles and areas of movement, people objects in circles in which different colors are used over time to show age
5. Database with histogram and data analysis of population change and interaction

## NEXT STEPS
1. Prototype basic version of population simulation
2. Store data locally to .txt file
