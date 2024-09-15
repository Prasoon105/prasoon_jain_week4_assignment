package HandleException;

import java.util.Scanner;

public class ExceptionsHandling {

    public static void NullPointerEx() {
        String str = null;
        System.out.println(str.length()); 
    }

   
    public static void ArithmeticEx() {
        int a = 10;
        int b = 0;
        System.out.println(a / b);  
    }

    public static void ArrayIndexOutOfBoundsEx() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[5]);  
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\nException Handling Demo");
            System.out.println("1. NullPointerException");
            System.out.println("2. ArithmeticException");
            System.out.println("3. ArrayIndexOutOfBoundsException");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        NullPointerEx();
                        break;
                    case 2:
                        ArithmeticEx();
                        break;
                    case 3:
                        ArrayIndexOutOfBoundsEx();
                        break;
                    case 4:
                        continueOperations = false;
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NullPointerException e) {
                System.out.println("Caught NullPointerException: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Caught ArithmeticException: Cannot divide by zero.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught ArrayIndexOutOfBoundsException: Invalid array index.");
            } catch (Exception e) {
                System.out.println("Caught a general exception: " + e.getMessage());
            }

            if (choice != 4) {
                System.out.print("\nDo you want to perform another operation? (y/n): ");
                String response = scanner.next();
                if (!response.equalsIgnoreCase("yes")) {
                    continueOperations = false;
                }
            }
        }

    }
}
