package library;

public class Book extends Item{
	private int numberOfPages;

	public Book() {
		
	}
	public Book(String id, String name, String author, int yearOfPublication, int numberOfPages) {
        super(id, name, author, yearOfPublication);
        this.numberOfPages = numberOfPages;
	}
	public Book(Book book) {
		super(book);
        this.numberOfPages = book.numberOfPages;
    }
	
	//Accessors 
    public int getNumberOfPages() {
    	return this.numberOfPages;
    }
    
    //Mutators
    public void setNumberOfPages(int numberOfPages) {
    	this.numberOfPages = numberOfPages;
    }
    
    //toString() method
    @Override
    public String toString() {
        return "ID: " + id + "\n Name: " + name + "\n Author: " + author + "\n Year of Publication: " + yearOfPublication + "\n Number of pages: " + numberOfPages;
    }

    //equals() method
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        else {
        Book book = (Book) obj;
        return this.name.equals(book.name) && this.author.equals(book.author) && this.yearOfPublication == book.yearOfPublication && this.numberOfPages == book.numberOfPages;
    }
        }
    
}