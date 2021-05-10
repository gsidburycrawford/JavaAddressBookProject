import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static AddressBook myAddressBook = new AddressBook();

    public static void mainMenu() {
        System.out.println("1) Add an entry\n" +
                "2) Remove an entry\n" +
                "3) Search for a specific entry\n" +
                "4) Print Address Book\n" +
                "5) Delete Book\n" +
                "6) Quit\n" +
                "Please choose what you'd like to do with the database: ");
        int userCommand = scanner.nextInt();
        switch (userCommand) {
            case 1:
                myAddressBook.addAddress();
                break;
            case 2:
                myAddressBook.removeAddress();
                break;
            case 3:
                myAddressBook.searchAddress();
                break;
            case 4:
                myAddressBook.printAddresses();
                break;
            case 5:
                myAddressBook.deleteAddresses();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
        mainMenu();
    }
    public static void main(String[] args) {
        mainMenu();
    }
}
