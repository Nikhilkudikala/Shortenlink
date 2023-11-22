/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
public class LinkShortener {
    private static Map<String, String> shortToLongMap = new HashMap<>();
    private static Map<String, String> longToShortMap = new HashMap<>();

    public static String shortenURL(String longURL) {
        String shortURL = Base64.getUrlEncoder().encodeToString(longURL.getBytes()).substring(0, 8);
        shortToLongMap.put(shortURL, longURL);
        longToShortMap.put(longURL, shortURL);
        return shortURL;
    }

    public static String expandURL(String shortURL) {
        return shortToLongMap.get(shortURL);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Shorten a URL");
            System.out.println("2. Expand a URL");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.println("Enter a long URL:");
                    String longURL = scanner.nextLine();
                    String shortURL = shortenURL(longURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;

                case 2:
                    System.out.println("Enter a short URL:");
                    String inputShortURL = scanner.nextLine();
                    String expandedURL = expandURL(inputShortURL);
                    if (expandedURL != null) {
                        System.out.println("Expanded URL: " + expandedURL);
                    } else {
                        System.out.println("Invalid short URL.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}