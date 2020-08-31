package Book.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	private final MessageProcess msgProcess;

	@Autowired
	public BookService(MessageProcess msgProcess) {
		this.msgProcess = msgProcess;
	}

	@Autowired
	private BookRepository bookrepository;

	public Optional<Book> getBookById(String bookId) {
		return bookrepository.findById(bookId);
	}

	public List<Book> getAllBooks() {
		return bookrepository.findAll();
	}

	public String saveAllBooks(List<Book> books) {
		bookrepository.saveAll(books);
		return "All Books Saved Successfully";
	}

	public Book updateBooksAvailabilty(String bookId,int incremental_count) {

		Book book = bookrepository.findById(bookId).get();
				
		if(incremental_count<0) {
			
			int available_copies = book.getAvailable_copies() - 1;
			if (available_copies <= book.getTotal_copies())
				book.setAvailable_copies(available_copies);
			bookrepository.save(book);
			return book;
			
		}else {
			
			int available_copies = book.getAvailable_copies() + 1;
			if (available_copies <= book.getTotal_copies())
				book.setAvailable_copies(available_copies);
			bookrepository.save(book);
			if(available_copies==1) {
				System.out.println("*****Sending book message::1*****");
				String message =String.format("$$ -> Update the book --> Auther -->%s -->%s", book.getAuthor(),book.getId());
				this.msgProcess.sendMessage(message);
			}
			return book;
			
		}

	}	

}
