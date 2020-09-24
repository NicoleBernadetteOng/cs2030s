public void serveCruises(Cruise[] cruises) {

    Loader[] loads = new Loader[40];

    for (int i = 0; i < cruises.length; i++) {
        int counter = cruises[i].getNumOfLoadersRequired();
        int k = 0;

        while (counter > 0 && k < loads.length) {
            if (loads[k] == null) {
                loads[k] = new Loader(k+1, cruises[i]);
                System.out.println(loads[k].toString());
                counter--;
            } else if (loads[k].canServe(cruises[i])) {
                loads[k] = loads[k].serve(cruises[i]);
                System.out.println(loads[k].toString());
                counter--;
            }
            k++;
        }
    }

}

