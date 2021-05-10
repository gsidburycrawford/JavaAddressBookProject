import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.util.*;

public class AddressBook {
    private HashMap<String, Address> addressBook;
    public static Scanner scanner = new Scanner(System.in);


    public AddressBook() {
        this.addressBook = new HashMap<>();
    }
    public void addAddress() {
        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phone = scanner.nextLine();
        System.out.println("Email Address: ");
        String email = scanner.nextLine();
        Address address = new Address(firstName,lastName,email,phone);
        this.addressBook.put(address.getEmail(), address);
        System.out.println("Added new entry!");
    }

    public  void removeAddress() {
        System.out.println("Enter an entry's email to remove: ");
        String email = scanner.nextLine();
        if (this.addressBook.containsKey(email)) {
            System.out.println("Deleted the following entry: \n");
            this.addressBook.get(email).printAddress();
            this.addressBook.remove(email);
        } else {
            System.out.println("No address found with that record.");
        }
    }

    public void searchAddress() {
        boolean found = false;
        if (!this.addressBook.isEmpty()) {
            System.out.println("1) First Name\n" +
                    "2) Last Name\n" +
                    "3) Phone Number\n" +
                    "4) Email Address");
            System.out.println("Chose a search type: ");
            int searchType = scanner.nextInt();
            System.out.println("Enter your search: ");
            String searchQuery = scanner.nextLine();
            switch (searchType) {
                case 1:
                    for (Address address : this.addressBook.values()) {
                        if (address.getFirstName().equalsIgnoreCase(searchQuery)) {
                            found = true;
                            address.printAddress();
                        }
                    }
                    break;
                case 2:
                    for (Address address : this.addressBook.values()) {
                        if (address.getLastName().equalsIgnoreCase(searchQuery)) {
                            found = true;
                            address.printAddress();
                        }
                    }
                    break;
                case 3:
                    for (Address address : this.addressBook.values()) {
                        if (address.getPhone().equalsIgnoreCase(searchQuery)) {
                            found = true;
                            address.printAddress();
                        }
                    }
                    break;
                case 4:
                    for (Address address : this.addressBook.values()) {
                        if (address.getEmail().equalsIgnoreCase(searchQuery)) {
                            found = true;
                            address.printAddress();
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
                    searchAddress();
                    break;
            }
        } else {
            System.out.println("This Address Book is empty.");
        }
        if (!found) {
            System.out.println("Did not find record with that entry.");
        }

    }

    public  void printAddresses() {
        for (Address address: this.addressBook.values()) {
            address.printAddress();
        }
    }

    public void deleteAddresses() {
        this.addressBook.clear();
        System.out.println("Address book cleared!");
    }


}
