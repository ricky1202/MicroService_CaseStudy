package Book.Controller;

public class Book {

	public Book() {
		super();
		this.id = 0;
		this.book_Name = "";
		this.author = "";
		this.available_copies = 0;
		this.total_copies = 0;
		// TODO Auto-generated constructor stub
	}

	public Book(long id, String book_Name, String author, Number available_copies, Number total_copies) {
		super();
		this.id = id;
		this.book_Name = book_Name;
		this.author = author;
		this.available_copies = available_copies;
		this.total_copies = total_copies;
	}

	private final long id;
	private final String book_Name;
	private final String author;
	private final Number available_copies;
	private final Number total_copies;

	public long getId() {
		return id;
	}
	
	public String getBook_Name() {
		return book_Name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Number getAvailable_copies() {
		return available_copies;
	}
	
	public Number getTotal_copies() {
		return total_copies;
	}
	
	public long bookId() {
		return id;
	}

	public String getBookName() {
		return book_Name;
	}
}
