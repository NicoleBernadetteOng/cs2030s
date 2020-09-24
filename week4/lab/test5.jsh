/open Cruise.java
/open SmallCruise.java
/open BigCruise.java
/open Loader.java
/open level5.jsh
Cruise[] cruises = {
    new SmallCruise("S1111", 1300)}
serveCruises(cruises);
Cruise[] cruises = {
    new BigCruise("B1111", 1300, 80, 3000),
    new SmallCruise("S1111", 1359), 
    new SmallCruise("S1112", 1400), 
    new SmallCruise("S1113", 1429)}
serveCruises(cruises);
Cruise[] cruises = {
    new SmallCruise("S1111", 900), 
    new BigCruise("B1112", 901, 100, 1),
    new BigCruise("B1113", 902, 20, 4500),
    new SmallCruise("S2030", 1031), 
    new BigCruise("B0001", 1100, 30, 1500),
    new SmallCruise("S0001", 1130)}
serveCruises(cruises);
/exit
