package library;

public class Journal extends Item{
	private int volumeNumber;

	public Journal() {
		
	}
	public Journal(String id, String name, String author, int yearOfPublication, int volumeNumber) {
        super(id, name, author, yearOfPublication);
        this.volumeNumber = volumeNumber;
	}
	public Journal(Journal journal) {
		super(journal);
        this.volumeNumber = journal.volumeNumber;
    }
	
	//Accessors 
    public int getVolumeNumber() {
    	return this.volumeNumber;
    }
    
    //Mutators
    public void setVolumeNumber(int volumeNumber) {
    	this.volumeNumber = volumeNumber;
    }
    
    //toString() method
    @Override
    public String toString() {
        return "ID: " + id + "\n Name: " + name + "\n Author: " + author + "\n Year of Publication: " + yearOfPublication + "\n Volume Number: " + volumeNumber;
    }

    //equals() method
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        else {
        Journal journal = (Journal) obj;
        return this.name.equals(journal.name) && this.author.equals(journal.author) && this.yearOfPublication == journal.yearOfPublication && this.volumeNumber == journal.volumeNumber;
    }
        }
    
}