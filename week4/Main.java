import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // create a Scanner object
        Scanner scanner = new Scanner(System.in); 
        // scanner.useDelimiter("\n");

        System.out.println("Enter a, b, n, and t: ");
        // integer input 
        int a = scanner.nextInt();
        int aOut = a - 1;

        // double input 
        double b = scanner.nextDouble();
        double bOut = b - 1.0;
        
        System.out.println(aOut);
        System.out.println(bOut);
        
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.nextLine();
            System.out.println(lines[i]);
        }  

        int t = scanner.nextInt();  
        for (int j = 0; j < t; j++) {
           System.out.println(scanner.next());
        }

        scanner.close();
      
    }

}
