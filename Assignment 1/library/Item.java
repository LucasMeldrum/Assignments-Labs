package library;

public class Item {
    protected String id;
    protected String name;
    protected String author;
    protected int yearOfPublication;
    private boolean leased;
    private String clientId;

    //Default constructor
    public Item() {
     leased = false;
    }
    //Parameterized constructor
    public Item(String id, String name, String author, int yearOfPublication) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
    //Copy constructor
    public Item(Item item) {
    
        this.id = item.id;
        this.name = item.name;
        this.author = item.author;
        this.yearOfPublication = item.yearOfPublication;
    }
  //Accessors 
    public String getId() {
    	return this.id;
    }
    public String getName() {
    	return this.name;
    }
    public String getAuthor() {
    	return this.author;
    }
    public int getYearOfPublication() {
    	return this.yearOfPublication;
    }
    public boolean isLeased() {
        return leased;
    }
    public String getClientId() {
        return clientId;
    }

    //Mutators
    public void setId(String id) {
    	this.id = id;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public void setAuthor(String author) {
    	this.author = author;
    }
    public void setYearOfPublication(int yearOfPublication) {
    	this.yearOfPublication = yearOfPublication;
    }
    public void setLeased(boolean leased) {
    	this.leased = leased;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    //toString() method
    @Override
    public String toString() {
        return "ID: " + id + "\n Name: " + name + "\n Author: " + author + "\n Year of Publication: " + yearOfPublication;
    }

    //equals() method
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        else {
        Item item = (Item) obj;
        return this.name.equals(item.name) && this.author.equals(item.author) && this.yearOfPublication == item.yearOfPublication;
    }
        }
    
}