public Logger<Integer> add(Logger<Integer> a, int b) {
    return a.map(x -> x + b); 
}


public Logger<Integer> sum(int n) {
    // starting value is 0
    Logger<Integer> logger = Logger.make(0);

    // loop to add to the previous value 
    // change the logger 
    // the add method is able to take in a logger and int 
    // so parse in the logger and i

    for (int i = 1; i <= n; i++) {
        logger = add(logger, i);
    }

    return logger;
}


public Logger<Integer> f(int n) {
    Logger<Integer> logger = Logger.make(n);

    while (logger.test(x -> x != 1)) {

        // if the logger value is even
        if (logger.test(x -> x % 2 == 0)) {

            // the logger value will get halved 
            logger = logger.map(x -> x / 2);
        
        } else {

            // if value is odd
            // value * 3 then + 1
            logger = logger.map(x -> 3 * x);
            logger = logger.map(x -> x + 1);
        }
    }

    // if it's 1 will return the logger
    return logger;
}


