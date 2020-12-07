import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.Map;
import java.util.function.Predicate;
import java.util.ArrayList;

public class LoggerImpl<T> implements Logger<T> {
    private final T value;
    private final ArrayList<String> log;

    // constructors 
    public LoggerImpl(T value) {
        this.value = value;
        this.log = new ArrayList<String>(Arrays.asList("Value initialized. Value = " + value));
    }
    
    // constructor when the Logger value has changed 
    public LoggerImpl(T value, ArrayList<String> log) {
        this.value = value;
        this.log = log; 
    }

    public void printlog() {
        this.log.forEach(x -> System.out.println(x));     
    }
   
    @Override 
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object instanceof LoggerImpl) {
            LoggerImpl<?> loggerObject = (LoggerImpl<?>) object;
            return this.value.equals(loggerObject.value) && this.log.equals(loggerObject.log);
        } else {
            return false;
        }
    }


    public <R> Logger<R> map(Function<? super T, ? extends R> function) {
        // Logger.make(this.t).printlog();
        R newValue = function.apply(this.value);

        ArrayList<String> newLog = new ArrayList<String>(this.log);

        if(this.value.equals(newValue)) {
            newLog.add("Value unchanged. Value = " + newValue);
            return new LoggerImpl<R>(newValue, newLog);

            // if the Logger value has changed
        } else {
            newLog.add("Value changed! New value = " + newValue);
            return new LoggerImpl<R>(newValue, newLog);
        }     
    }


    public <R> Logger<R> flatMap(Function<? super T, ? extends Logger<? extends R>> function) { 
        LoggerImpl<? extends R> newLogger = (LoggerImpl<? extends R>) function.apply(this.value);
        // System.out.println(newLogger.getMessage());

        // break apart the logger then put back together again 
        ArrayList<String> newLog = new ArrayList<String>(this.log);

        for (int i = 1; i < newLogger.log.size(); i++) {
            newLog.add(newLogger.log.get(i));
        }

        return new LoggerImpl<R>(newLogger.value, newLog);
    }

    public boolean test(Predicate<T> pred) {
        return pred.test(this.value);
    }

    @Override
    public String toString() {
        return "Logger[" + this.value + "]";
    }

}

