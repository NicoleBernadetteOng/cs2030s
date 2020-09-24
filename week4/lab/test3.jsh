/open Loader.java
/open Cruise.java
/open SmallCruise.java
new SmallCruise("S0001", 0).getArrivalTime()
new SmallCruise("S0001", 0).getServiceCompletionTime()
new SmallCruise("S0001", 0).getNumOfLoadersRequired()
new SmallCruise("S0123", 1220)
new Loader(1, new SmallCruise("S1245", 2330))
new Loader(1, new SmallCruise("S1245", 2330)).canServe(new SmallCruise("S2345", 2359))
new Loader(1, new SmallCruise("S1245", 2330)).serve(new SmallCruise("S2345", 2359))
new Loader(1, new SmallCruise("S2030", 0))
/exit
