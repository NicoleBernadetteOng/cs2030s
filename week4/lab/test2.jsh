/open Cruise.java
/open Loader.java
new Loader(1, new Cruise("A1234", 0, 1, 30))
new Loader(1, new Cruise("A1234", 0, 1, 30)).getIdentifier()
new Loader(1, new Cruise("A1234", 0, 1, 30)).getNextAvailableTime()
new Loader(1, new Cruise("A1234", 0, 1, 30)).canServe(new Cruise("A2345", 30, 1, 30))
new Loader(1, new Cruise("A1234", 0, 1, 30)).serve(new Cruise("A2345", 30, 1, 30))
new Loader(1, new Cruise("A1234", 0, 1, 30)).serve(new Cruise("A2345", 30, 1, 30)).getNextAvailableTime()
new Loader(1, new Cruise("A1234", 0, 1, 30)).canServe(new Cruise("A2345", 10, 1, 30))
new Loader(1, new Cruise("A1234", 0, 1, 30)).serve(new Cruise("A2345", 10, 1, 30))
new Loader(1, new Cruise("A1234", 0, 1, 30)).serve(new Cruise("A2345", 10, 1, 30)).getNextAvailableTime()
new Loader(1, new Cruise("A1234", 0, 1, 30)).serve(new Cruise("A2345", 10, 1, 30)).getIdentifier()
/exit
