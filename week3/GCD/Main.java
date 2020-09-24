class Main {
    static int gcd(int a, int b) {
        // GCD calculations
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
