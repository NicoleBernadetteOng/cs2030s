Logger.make(5)
Logger.make(5) instanceof Logger 
try { Logger.make(Logger.make(7)); } catch (Exception e) { System.out.println(e); }
Logger.make(5).make(7)
try { Logger.make(null); } catch (Exception e) { System.out.println(e); }
/exit
