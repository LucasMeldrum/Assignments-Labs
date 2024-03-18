
public class Book {

	private String title; 
	private String author;
	private Long ISBN;
	private Double price;
	private static int numberOfCreatedBooks = 0;


public Book(String title, String author, Long ISBN, Double price) {
	this.title = title;
	this.author = author;
	this.ISBN = ISBN;
	this.price = price;
	
	numberOfCreatedBooks++;
}
public Book() {
	this.title = "";
	this.author ="";
	this.ISBN = 0L ;
	this.price = 0.0;
	
}

//setters
public void setTitle(String title) {
	this.title = title;
}
public void setAuthor(String author) {
	this.author = author;
}
public void setISBN(Long ISBN) {
	this.ISBN = ISBN;
}
public void setPrice(Double price) {
	this.price = price;
}

//getters
public static int findNumberOfBooks() {
	return numberOfCreatedBooks;
}

public String getTitle() {
	return this.title;
}
public String getAuthor() {
	return this.author;
}
public Long getISBN() {
	return this.ISBN;
}
public Double getPrice() {
	return this.price;
}

//equals method
public boolean equals(Book otherBook) {
	return this.ISBN == otherBook.ISBN && this.price == otherBook.price;
}
public String toString() {
	return "Title: " + this.title + "\nAuthor: " + this.author + "\nISBN: " + this.ISBN + "\nPrice: " + this.price;
}
 }