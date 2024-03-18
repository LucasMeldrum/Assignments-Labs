package library;

public class Media extends Item{
	private String type;

	public Media() {
		
	}
	public Media(String id, String name, String author, int yearOfPublication, String type) {
        super(id, name, author, yearOfPublication);
        this.type = type;
	}
	public Media(Media media) {
		super(media);
        this.type = media.type;
    }
	
	//Accessors 
    public String getType() {
    	return this.type;
    }
    
    //Mutators
    public void setType(String type) {
    	this.type = type;
    }
    
    //toString() method
    @Override
    public String toString() {
        return "ID: " + id + "\n Name: " + name + "\n Author: " + author + "\n Year of Publication: " + yearOfPublication + "\n Type: " + type;
    }

    //equals() method
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        else {
        Media media = (Media) obj;
        return this.name.equals(media.name) && this.author.equals(media.author) && this.yearOfPublication == media.yearOfPublication && this.type == media.type;
    }
        }
    
}