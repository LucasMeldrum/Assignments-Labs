package driver;

import java.util.Scanner;
import library.Item;
import library.Book;
import library.Media;
import library.Journal;
import client.Client;


public class Driver {

	
	static Item[] items = new Item[10000]; 
    static int itemCount = 0; 
  
    static Client[] clients = new Client[10000];
    static int clientCount = 0; 
    
    private static boolean[] leasedStatus = new boolean[100];

   
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to FunReadings Library Management System!");
        System.out.println("Do you want to run a predefined scenario or access the menu?");
        System.out.println("1. Predefined Scenario");
        System.out.println("2. Menu");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
		
        if (choice == 1) {
        	 System.out.println("Running predefined scenario...");

             // Create objects for each type of item
             Book book1 = new Book("B1", "Book1", "Author1", 2020, 200);
             Book book2 = new Book("B2", "Book2", "Author2", 2018, 250);
             Book book3 = new Book("B3", "Book3", "Author3", 2019, 180);

             Journal journal1 = new Journal("J1", "Journal1", "JournalAuthor1", 2021, 1);
             Journal journal2 = new Journal("J2", "Journal2", "JournalAuthor2", 2020, 2);
             Journal journal3 = new Journal("J3", "Journal3", "JournalAuthor3", 2019, 3);

             Media media1 = new Media("M1", "Media1", "MediaAuthor1", 2022, "Audio");
             Media media2 = new Media("M2", "Media2", "MediaAuthor2", 2021, "Video");
             Media media3 = new Media("M3", "Media3", "MediaAuthor3", 2020, "Interactive");

             // Create objects for users
             Client client1 = new Client("C1", "User1", "1", "Gmail");
             Client client2 = new Client("C2", "User2", "2", "Concordia");
             Client client3 = new Client("C3", "User3", "3", "Yahoo");
             
             System.out.println("Books:");
             System.out.println(book1);
             System.out.println(book2);
             System.out.println(book3);

             System.out.println("Journals:");
             System.out.println(journal1);
             System.out.println(journal2);
             System.out.println(journal3);

             System.out.println("Media:");
             System.out.println(media1);
             System.out.println(media2);
             System.out.println(media3);

             System.out.println("Users:");
             System.out.println(client1);
             System.out.println(client2);
             System.out.println(client3);
             
             System.out.println("Testing object equality...");
             System.out.println("Equality of two objects from different classes: " + book1.equals(client1));
             System.out.println("Equality of two objects from the same class with different values: " + book1.equals(book2));
             System.out.println("Equality of two objects of the same class with similar values: " + book1.equals(new Book("B1", "Book1", "Author1", 2020, 200)));
             
             Book[] books = new Book[]{book1, book2, book3};
             Journal[] journals = new Journal[]{journal1, journal2, journal3};
             Media[] medias = new Media[]{media1, media2, media3};
             Item[] items = new Item[]{book1, book2, book3, journal1, journal2, journal3, media1, media2, media3};
             
             
             Book biggestBook = getBiggestBook(books);
             if (biggestBook != null) {
                 System.out.println("Biggest Book:");
                 System.out.println(biggestBook);
             } else {
                 System.out.println("No books found.");
             }

             // Call the copyBooks() method on the array of Media
             // Does not work since only copies books???
             Book[] copiedMedias = copyBooks(books);
             System.out.println("Copied Media:");
             for (Book media : copiedMedias) {
                 System.out.println(media);
             }


        	
        } 
        
        else if (choice == 2) {
        	while (true) {
                System.out.println("---- Library Management System Menu ----");
                System.out.println("1. Manage items");
                System.out.println("2. Manage clients");
                System.out.println("3. Lease or return an item from a client");
                System.out.println("4. Show all items leased by a client");
                System.out.println("5. Show all leased items (by all clients)");
                System.out.println("6. Display the biggest book");
                System.out.println("7. Make a copy of the books array");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                int option = scanner.nextInt();
                scanner.nextLine(); 

                switch (option) {
                    case 1:
                    	while (true) {
                            System.out.println("---- Manage Items Menu ----");
                            System.out.println("1. Add an item");
                            System.out.println("2. Delete an item");
                            System.out.println("3. Change information of an item");
                            System.out.println("4. List all items in a specific category");
                            System.out.println("5. Print all items (from all categories)");
                            System.out.println("0. Go back to main menu");
                            System.out.print("Enter your choice: ");

                            int itemOption = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (itemOption) {
                                case 1:
                                	System.out.println("Choose the type of item to add:");
                                    System.out.println("1. Book");
                                    System.out.println("2. Journal");
                                    System.out.println("3. Media");

                                    int itemType = scanner.nextInt();
                                    scanner.nextLine(); 

                                    switch (itemType) {
                                        case 1:
                
                                            System.out.println("Enter book details:");
                                            System.out.print("ID: ");
                                            String bookId = scanner.nextLine();
                                            System.out.print("Name: ");
                                            String bookName = scanner.nextLine();
                                            System.out.print("Author: ");
                                            String bookAuthor = scanner.nextLine();
                                            System.out.print("Year of Publication: ");
                                            int bookYear = scanner.nextInt();
                                            System.out.print("Number of Pages: ");
                                            int numberOfPages = scanner.nextInt();
                                            
                                            scanner.nextLine(); 
                                            
                                         
                                            Book book = new Book(bookId, bookName, bookAuthor, bookYear, numberOfPages); 
                                            items[itemCount++] = book;
                                           
                                            
                                            System.out.println("Book added successfully.");
                                            break;
                                            
                                        case 2:
                                        	 System.out.println("Enter journal details:");
                                             System.out.print("ID: ");
                                             String journalId = scanner.nextLine();
                                             System.out.print("Name: ");
                                             String journalName = scanner.nextLine();
                                             System.out.print("Author: ");
                                             String journalAuthor = scanner.nextLine();
                                             System.out.print("Year of Publication: ");
                                             int journalYear = scanner.nextInt();
                                             System.out.print("Volume number: ");
                                             int volumeNumber = scanner.nextInt();
                                             
                                             scanner.nextLine(); 
                                             
                                          
                                             Journal journal = new Journal(journalId, journalName, journalAuthor, journalYear, volumeNumber); 
                                             items[itemCount++] = journal;
                                             
                                            break;
                                        case 3:
                                        	 System.out.println("Enter media details:");
                                             System.out.print("ID: ");
                                             String mediaID = scanner.nextLine();
                                             System.out.print("Name: ");
                                             String mediaName = scanner.nextLine();
                                             System.out.print("Author: ");
                                             String mediaAuthor = scanner.nextLine();
                                             System.out.print("Year of Publication: ");
                                             int mediaYear = scanner.nextInt();
                                             System.out.print("Type: ");
                                             String mediaType = scanner.nextLine();
                                             
                                             scanner.nextLine(); 
                                             
                                          
                                             Media media = new Media(mediaID, mediaName, mediaAuthor, mediaYear, mediaType); 
                                             items[itemCount++] = media;
                                             
                                            break;
                                        default:
                                            System.out.println("Invalid item type. Please enter a valid option.");
                                    }
                                    break;
                                case 2:
                                	System.out.println("Enter the ID of the item you want to delete:");
                                    String idToDelete = scanner.nextLine();

                                    boolean itemDeleted = false;
                                    for (int i = 0; i < itemCount; i++) {
                                        if (items[i] != null && items[i].getId().equals(idToDelete)) {
                                            // Found the item with the matching ID, remove it from the array
                                            // Shift elements to the left to fill the gap
                                            for (int j = i; j < itemCount - 1; j++) {
                                                items[j] = items[j + 1];
                                            }
                                            items[itemCount - 1] = null; // Remove the last reference
                                            itemCount--; // Decrement the item count
                                            System.out.println("Item with ID " + idToDelete + " deleted successfully.");
                                            itemDeleted = true;
                                            break; // Exit the loop after deleting the item
                                        }
                                    }
                                    if (!itemDeleted) {
                                        System.out.println("Item with ID " + idToDelete + " not found.");
                                    }
                    
                                    break;
                                case 3:
                                	System.out.println("Enter the ID of the item you want to change:");
                                    String idToChange = scanner.nextLine();

                                    for (int i = 0; i < itemCount; i++) {
                                        if (items[i] != null && items[i].getId().equals(idToChange)) {
                                            
                                            
                                            if (items[i] instanceof Book) {
                                                
                                                Book book = (Book) items[i];
                                                System.out.print("Enter new name for the book: ");
                                                book.setName(scanner.nextLine());
                                                System.out.print("Enter new author for the book: ");
                                                book.setAuthor(scanner.nextLine());
                                                System.out.print("Enter new year of publication for the book: ");
                                                book.setYearOfPublication(Integer.parseInt(scanner.nextLine()));
                                                System.out.print("Enter new number of pages for the book: ");
                                                book.setNumberOfPages(Integer.parseInt(scanner.nextLine()));
                                                System.out.println("Book information updated successfully.");
                                                
                                            } else if (items[i] instanceof Journal) {
                                                
                                                Journal journal = (Journal) items[i];
                                                System.out.print("Enter new name for the journal: ");
                                                journal.setName(scanner.nextLine());
                                                System.out.print("Enter new author for the journal: ");
                                                journal.setAuthor(scanner.nextLine());
                                                System.out.print("Enter new year of publication for the journal: ");
                                                journal.setYearOfPublication(Integer.parseInt(scanner.nextLine()));
                                                System.out.print("Enter new volume number for the journal: ");
                                                journal.setVolumeNumber(Integer.parseInt(scanner.nextLine()));
                                                System.out.println("Journal information updated successfully.");
                                                
                                            } else if (items[i] instanceof Media) {
                                                
                                                Media media = (Media) items[i];
                                                System.out.print("Enter new name for the media: ");
                                                media.setName(scanner.nextLine());
                                                System.out.print("Enter new author for the media: ");
                                                media.setAuthor(scanner.nextLine());
                                                System.out.print("Enter new year of publication for the media: ");
                                                media.setYearOfPublication(Integer.parseInt(scanner.nextLine()));
                                                System.out.print("Enter new type for the media: ");
                                                media.setType(scanner.nextLine());
                                                System.out.println("Media information updated successfully.");
                                            } else {
                                                
                                                System.out.println("Unknown item type.");
                                            }
                                            
                                        }
                                    }
                                    
                                    break;
                                    
                                case 4:
                                	
                                	System.out.println("Choose the category:");
                                    System.out.println("1. Books");
                                    System.out.println("2. Journals");
                                    System.out.println("3. Media");

                                    int categoryChoice = scanner.nextInt();
                                    scanner.nextLine(); 

                                    switch (categoryChoice) {
                                        case 1:
                                            System.out.println("Books:\n");
                                            
                                            for (int i = 0; i < itemCount; i++) {
                                                Item item = items[i];
                                            	
                                                if (item instanceof Book) {
                                                    System.out.println(item);
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Journals:\n");
                                            for (int i = 0; i < itemCount; i++) {
                                                Item item = items[i];
                                            	
                                                if (item instanceof Journal) {
                                                    System.out.println(item);
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Media:");
                                            for (int i = 0; i < itemCount; i++) {
                                                Item item = items[i];
                                            	
                                                if (item instanceof Media) {
                                                    System.out.println(item);
                                                }
                                            }
                                            break;
                                            
                                        default:
                                            System.out.println("Invalid category choice.");
                                    }
                                    
                                    break;

                                   
                                case 5:
                                	 System.out.println("All Items:");
                                	    for (Item item : items) {
                                	        if (item instanceof Book) {
                                	            System.out.println("\nBook:");
                                	            System.out.println(item);
                                	        } else if (item instanceof Journal) {
                                	            System.out.println("\nJournal:");
                                	            System.out.println(item);
                                	        } else if (item instanceof Media) {
                                	            System.out.println("\nMedia:");
                                	            System.out.println(item);
                                	        }
                                	        
                                	    }
                                    break;
                                case 0:
                                    // Go back to main menu
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                            }
                            
                            if (itemOption == 0) {
                                break; // Break the inner loop and go back to main menu
                            }
                        }
                        
                        break;
                        
                    case 2:
                 
                        while (true) {
                            System.out.println("---- Client Management Menu ----");
                            System.out.println("1. Add a client");
                            System.out.println("2. Edit a client");
                            System.out.println("3. Delete a client");
                            System.out.println("0. Go back to main menu");
                            System.out.print("Enter your choice: ");

                            int pick = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (pick) {
                                case 1:
                              
                                	System.out.print("Enter client ID: ");
                                    String id = scanner.nextLine();
                                    System.out.print("Enter client name: ");
                                    String name = scanner.nextLine();
                                    System.out.print("Enter client phone number: ");
                                    String phoneNumber = scanner.nextLine();
                                    System.out.print("Enter client email address: ");
                                    String emailAddress = scanner.nextLine();
                                    
                                    Client newClient = new Client(id, name, phoneNumber, emailAddress);
                                    clients[clientCount++] = newClient;
                                    
                                    break;
                                case 2:
                                	 // Prompt the user to enter the ID of the client to edit
                                    System.out.print("Enter client ID to edit: ");
                                    String idToEdit = scanner.nextLine();

                                    // Flag to check if the client was found and edited
                                    boolean found = false;

                                    // Iterate through the array of clients
                                    for (int i = 0; i < clientCount; i++) {
                                        if (clients[i].getId().equals(idToEdit)) {
                                            // Client found prompt the user to enter new details
                                            System.out.println("Client found. Enter new details:");

                                            // Prompt the user to enter new details for the client
                                            System.out.print("Enter new client name: ");
                                            String newName = scanner.nextLine();
                                            System.out.print("Enter new client phone number: ");
                                            String newPhoneNumber = scanner.nextLine();
                                            System.out.print("Enter new client email address: ");
                                            String newEmailAddress = scanner.nextLine();

                                            // Update the client's information with the new details
                                            clients[i].setName(newName);
                                            clients[i].setPhoneNumber(newPhoneNumber);
                                            clients[i].setEmailAddress(newEmailAddress);

                                            found = true;
                                            System.out.println("Client with ID " + idToEdit + " edited successfully.");
                                            break; // Exit the loop after editing the client
                                        }
                                    }

                                    
                                    if (!found) {
                                        System.out.println("Client with ID " + idToEdit + " not found.");
                                    }
                                   
                                    break;
                                case 3:
                                	
                                	 System.out.print("Enter client ID to delete: ");
                                     String idToDelete = scanner.nextLine();

                                     // Flag to check if the client was found and deleted
                                     boolean check = false;

                                     // Iterate through the array of clients
                                     for (int i = 0; i < clientCount; i++) {
                                         if (clients[i].getId().equals(idToDelete)) {
                                             // Client found, remove it from the array
                                             for (int j = i; j < clientCount - 1; j++) {
                                                 clients[j] = clients[j + 1];
                                             }
                                             clients[clientCount - 1] = null;
                                             clientCount--;
                                             check = true;
                                             System.out.println("Client with ID " + idToDelete + " deleted successfully.");
                                             break; // Exit the loop after deleting the client
                                         }
                                     }

                                     // If client was not found, display a message
                                     if (!check) {
                                         System.out.println("Client with ID " + idToDelete + " not found.");
                                     }
                                    
                                    break;
                                case 0:
                                    // Return to the main menu
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                            }
                            
                            if (pick == 0) {
                                break; // Break the inner loop and go back to main menu
                            }
                        }
                        break;
                        
                        
                    case 3:
                        
                        System.out.println("---- Item Leasing System ----");
                        System.out.println("1. Lease an item to a client");
                        System.out.println("2. Return an item");
                        System.out.println("0. Exit");

                        // Read user choice
                        System.out.print("Enter your choice: ");
                        int pick = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (pick) {
                            case 1:
                            	 System.out.println("Leasing an item to a client by ID:");

                                 // Prompt the user to enter the ID of the item to lease
                                 System.out.print("Enter item ID to lease: ");
                                 String itemId = scanner.nextLine();

                                 // Flag to check if the item was found
                                 boolean itemFound = false;

                                 // Iterate through the array of items
                                 for (int i = 0; i < itemCount; i++) {
                                     if (items[i].getId().equals(itemId)) {
                                         // Item found, prompt the user to enter the ID of the client
                                         System.out.print("Enter client ID to lease the item: ");
                                         String clientId = scanner.nextLine();

                                         // Iterate through the array of clients
                                         for (int j = 0; j < clientCount; j++) {
                                             if (clients[j].getId().equals(clientId)) {
                                                 // Client found, mark the item as leased by the client
                                            	 leasedStatus[i] = true;
                                            	 items[i].setLeased(true);
                                            	 items[i].setClientId(clientId);
                                                 itemFound = true;
                                                 
                                                 System.out.println("Item leased to client with ID " + clientId + " successfully.");
                                                 break; // Exit the loop after leasing the item
                                             }
                                         }

                                         if (!itemFound) {
                                             System.out.println("Client with ID " + clientId + " not found.");
                                         }
                                         
                                         itemFound = true;
                                         break; // Exit the loop after finding the item
                                     }
                                 }

                                 // If item was not found, display a message
                                 if (!itemFound) {
                                     System.out.println("Item with ID " + itemId + " not found.");
                                 }
                             
                                break;
                            case 2:
                            	// Prompt the user to enter the ID of the item to return
                                System.out.print("Enter the ID of the item to return: ");
                                String itemid = scanner.nextLine();

                                // Search for the item in the items array
                                int itemIndex = -1;
                                for (int i = 0; i < items.length; i++) {
                                    if (items[i] != null && items[i].getId().equals(itemid)) {
                                        itemIndex = i;
                                        break;
                                    }
                                }

                                // Check if the item is available and currently leased
                                if (itemIndex != -1 && leasedStatus[itemIndex]) {
                                    // Return the item
                                    leasedStatus[itemIndex] = false;
                                    items[itemIndex].setLeased(false);// Mark the item as not leased
                                    System.out.println("Item with ID " + itemid + " returned successfully.");
                                } else {
                                    // Display error message if the item is not available or not leased
                                    System.out.println("Item with ID " + itemid + " not found or is not currently leased.");
                                }
                                break;
                            case 0:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }

                       
      
                        
                        break;
                    case 4:
                    	System.out.print("Enter client ID to view leased items: ");
                    	String clientId = scanner.nextLine();

                    	// Flag to check if any leased items were found for the client
                    	boolean found = false;

                    	// Iterate through the array of items to find leased items by the client
                    	System.out.println("Items leased by client with ID " + clientId + ":");
                    	for (int i = 0; i < itemCount; i++) {
                    	    if (items[i].isLeased() && items[i].getClientId().equals(clientId)) {
                    	        System.out.println(items[i]);
                    	        found = true;
                    	    }
                    	}

                    	// If no leased items were found for the client, display a message
                    	if (!found) {
                    	    System.out.println("No items leased by client with ID " + clientId);
                    	}
                    	
                        break;
                    case 5:
                   
                    	for (int i = 0; i < items.length; i++) {
                    	    // Check if the item is not null, leased, and leased by the specified client
                    	    if (items[i] != null && leasedStatus[i]) {
                    	        System.out.println(items[i]);
                    	    }
                    	}
                        break;
                    case 6:
                    	System.out.println("Selected: Display the biggest book");
                        Book biggestBook = getBiggestBook(items);
                        if (biggestBook != null) {
                            System.out.println("The biggest book is:");
                            System.out.println(biggestBook);
                        } else {
                            System.out.println("No books found.");
                        }

                        
                        break;
                    case 7:
                    	  Book[] copiedBooks = copyBooks(items);
                    	  System.out.println("Copied Books:");
                          for (Book book : copiedBooks) {
                              System.out.println(book);
                          }
                       
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } 
        
        else {
            System.out.println("Invalid choice. Exiting...");
        }
        scanner.close();
    }
	
	 static Book getBiggestBook(Item[] items) {
	      
	        Book biggestBook = null;
	        int maxPages = Integer.MIN_VALUE;
	        for (Item item : items) {
	            if (item instanceof Book) {
	                Book book = (Book) item; 
	                	if (book.getNumberOfPages() > maxPages) {
	                		maxPages = book.getNumberOfPages();
	                		biggestBook = book;
	                	}
	                }
	            }
	            
	        
	            
	        return biggestBook;
	        }
	 
	 public static Book[] copyBooks(Item[] items) {
	        // Count the number of books in the items array
	        int bookCount = 0;
	        for (Item item : items) {
	            if (item instanceof Book) {
	                bookCount++;
	            }
	        }

	        // Create a new array to store copied books
	        Book[] copiedBooks = new Book[bookCount];
	        
	        //Iterate through items array to copy books
	        int copiedIndex = 0;
	        for (Item item : items) {
	            if (item instanceof Book) {
	                Book originalBook = (Book) item;
	                Book copiedBook = new Book(originalBook.getId(), originalBook.getName(), originalBook.getAuthor(), originalBook.getYearOfPublication(), originalBook.getNumberOfPages());
	                copiedBooks[copiedIndex] = copiedBook;
	                copiedIndex++;
	            }
	        }
	        return copiedBooks;
	    }
}
