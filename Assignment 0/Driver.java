import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String password = "249";
        Book[] inventory;
        boolean Pass = true;
        int attempts;
        int totalAttempts = 0;
        int totalAmountOfBooks = 0;

        System.out.println("Welcome to the bookstore!\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the max number of books your bookstore can contain: ");
        int maxBooks = scanner.nextInt();
        inventory = new Book[maxBooks];

        int choice;

        do {
        	
        	Pass = true;
            System.out.print("\nWhat do you want to do?\n"
                    + "1. Enter new books (password required)\n"
                    + "2. Change information of a book (password required)\n"
                    + "3. Display all books by a specific author\n"
                    + "4. Display all books under a certain a price.\n"
                    + "5. Quit\n"
                    + "Please enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1: 

                    for (attempts = 0; attempts < 3 && Pass; attempts++) {

                        System.out.print("\nEnter your password:");
                        String passwordCheck = scanner.next();

                        if (!(password.equals(passwordCheck))) {
                            System.out.println("Incorrect password, try again.");
                            if (attempts == 2) {
                                totalAttempts++;
                                if (totalAttempts == 4) {
                                    System.out.println("Program detected suspicious activities and will terminate immediately!");
                                    System.exit(0);
                                } else {
                                    System.out.println("\nYou have failed too many times, back to the menu!");

                                }
                            }
                        } else {
                            Pass = false;
                            int max = 1;
                            while (max != 0) {
                                System.out.print("How many books do you want to enter: ");
                                int bookAmount = scanner.nextInt();
                                totalAmountOfBooks = totalAmountOfBooks + bookAmount;

                                if (totalAmountOfBooks > maxBooks) {
                                    System.out.print("There are only " + maxBooks + " spot(s) for books left. Please enter a different number\n");
                                    totalAmountOfBooks = 0;
                                } else {
                                    max = 0;
                                    for (int i = 0; i < bookAmount; i++) {
                                        System.out.println("\nEnter details for Book " + (i + 1) + " (with no spaces)");

                                        System.out.print("Title: ");
                                        String title = scanner.next();

                                        System.out.print("Author: ");
                                        String author = scanner.next();

                                        System.out.print("ISBN: ");
                                        long ISBN = scanner.nextLong();

                                        System.out.print("Price: ");
                                        double price = scanner.nextDouble();

                                        // Create a new Book object and add it to the inventory
                                        Book book = new Book(title, author, ISBN, price);
                                        System.out.println("Book " + (i + 1) + " added to inventory:\n" + book.toString());
                                        
                                        int index = 0;
                                        while (index < inventory.length && inventory[index] != null) {
                                            index++;
                                        }

                                        // Check if there is space in the inventory
                                        if (index < inventory.length) {
                                            inventory[index] = book;
                                        }

                                    }
                                }
                            }
                        }
                    }
                
                break;

                case 2:
                    for (attempts = 0; attempts < 3 && Pass; attempts++) {
                        System.out.print("\nEnter your password: ");
                        String passwordCheck = scanner.next();
                        
                        if (!(password.equals(passwordCheck))) {
                            System.out.println("Incorrect password, try again.");
                            if (attempts == 2) {
                                System.out.println("\nYou have failed too many times, back to the menu!");
                            }
                        } else {
                            Pass = false;
                            System.out.print("Enter the book number to update: ");
                            int bookNumber = scanner.nextInt();
                            
                            int retry = 0;
							do {
                         
                            	
                            
                            if (bookNumber >= 0 && bookNumber < inventory.length && inventory[bookNumber] != null) {
                                Book bookToUpdate = inventory[bookNumber - 1];
                                System.out.println("Book #" + bookNumber);
                                System.out.println("Author: " + bookToUpdate.getAuthor());
                                System.out.println("Title: " + bookToUpdate.getTitle());
                                System.out.println("ISBN: " + bookToUpdate.getISBN());
                                System.out.println("Price: $" + bookToUpdate.getPrice());

                                int choice2;
                                do {
                                    System.out.println("\nChoose an attribute to update:");
                                    System.out.println("1. Author");
                                    System.out.println("2. Title");
                                    System.out.println("3. ISBN");
                                    System.out.println("4. Price");
                                    System.out.println("5. Quit");

                                    System.out.print("Enter your choice: ");
                                    choice2 = scanner.nextInt();

                                    switch (choice2) {
                                        case 1:
                                            System.out.print("Enter the new author: ");
                                            String newAuthor = scanner.next();
                                            bookToUpdate.setAuthor(newAuthor);
                                            break;
                                        case 2:
                                            System.out.print("Enter the new title: ");
                                            String newTitle = scanner.next();
                                            bookToUpdate.setTitle(newTitle);
                                            break;
                                        case 3:
                                            System.out.print("Enter the new ISBN: ");
                                            long newISBN = scanner.nextLong();
                                            bookToUpdate.setISBN(newISBN);
                                            break;
                                        case 4:
                                            System.out.print("Enter the new price: ");
                                            double newPrice = scanner.nextDouble();
                                            bookToUpdate.setPrice(newPrice);
                                            break;
                                        case 5:
                                            System.out.println("Quitting update operation.");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                                    }

                                    // Display the updated information of the book
                                    System.out.println("Updated Book #" + bookNumber);
                                    System.out.println("Author: " + bookToUpdate.getAuthor());
                                    System.out.println("Title: " + bookToUpdate.getTitle());
                                    System.out.println("ISBN: " + bookToUpdate.getISBN());
                                    System.out.println("Price: $" + bookToUpdate.getPrice());

                                } while (choice2 != 5);
                            } else {
                                System.out.println("No Book object at the specified index location.");
                                System.out.print("Do you want to enter another book? (enter a different index or 0 for no): ");
                                retry = scanner.nextInt();
                                if (retry == 0) {
                                    break; // Exit the update operation and go back to the main menu
                                }
                            }
                            } while (retry !=0);
                        }
                    }
                    break;

                case 3: 
                	System.out.print("Enter the author's name to display books by that author:\n ");
                    String requestedAuthor = scanner.next();

                    // Display information of all books by the requested author
                    Pass = false;
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] != null && inventory[i].getAuthor().equalsIgnoreCase(requestedAuthor)) {
                            // Display information of the book
                            System.out.println("Book #" + (1+i));
                            System.out.println("Author: " + inventory[i].getAuthor());
                            System.out.println("Title: " + inventory[i].getTitle());
                            System.out.println("ISBN: " + inventory[i].getISBN());
                            System.out.println("Price: $" + inventory[i].getPrice());
                            System.out.println();
                            Pass = true;
                        }
                    }

                    // Inform the user if no books were found by the specified author
                    if (!Pass) {
                        System.out.println("No books found by the author: " + requestedAuthor);
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter the maximum price to display books under that price:\n ");
                    double maxPrice = scanner.nextDouble();

                    // Display information of books with a price smaller than the entered value
                   Pass = false;
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] != null && inventory[i].getPrice() < maxPrice) {
                            // Display information of the book
                            System.out.println("Book #" + (1+i));
                            System.out.println("Author: " + inventory[i].getAuthor());
                            System.out.println("Title: " + inventory[i].getTitle());
                            System.out.println("ISBN: " + inventory[i].getISBN());
                            System.out.println("Price: $" + inventory[i].getPrice());
                            System.out.println();
                            Pass = true;
                        }
                    }

                    // Inform the user if no books were found under the specified price
                    if (!Pass) {
                        System.out.println("No books found under the specified price: $" + maxPrice);
                    }
                    break;
                    
                case 5: 
                	System.out.println("Goodbye!");
                	break;

                default:
                	System.out.println("Sorry that is not a valid option try again.");
                }
            

                
               

        
   

            } while (choice != 5);
    
         
        scanner.close();
    }
}
