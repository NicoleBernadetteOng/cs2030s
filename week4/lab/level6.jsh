public void serveCruises(Cruise[] cruises) {

    Loader[] loads = new Loader[40];

    for (Cruise cruise : cruises) {
        int counter = cruise.getNumOfLoadersRequired();
        int k = 0; 

        while (counter > 0 && k < loads.length) {
            if (loads[k] == null) {
                if ((k + 1) % 3 == 0) {
                    loads[k] = new RecycledLoader(k+1, cruise);
                } else {
                    loads[k] = new Loader(k+1, cruise);
                }
                System.out.println(loads[k].toString());
                counter--;

            } else if (loads[k].canServe(cruise)) {
                loads[k] = loads[k].serve(cruise);
                System.out.println(loads[k].toString());
                counter--;
            }
            k++;
        }
    }

}
