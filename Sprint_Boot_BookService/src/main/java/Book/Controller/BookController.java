package Book.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/book")
public class BookController {
	
	private static final String template = "Book Name, %s!";
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/info")
	@ResponseBody
	public Book bookInfo(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Book("B1212", String.format(template, name),"",1,1);
	}

	@GetMapping(value="/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Book> getBookById(@PathVariable String bookId) {
		return bookService.getBookById(bookId);
	}
		
	
	@GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping(value="/savebooks",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String saveAllBooks(@RequestBody List<Book> books) {
		return bookService.saveAllBooks(books);
	}
	
	@PostMapping(value="/UpdateAvailability/{bookId}/{incremental_count}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Book updateBooksAvailabilty(@PathVariable String bookId,@PathVariable int incremental_count) {
		return bookService.updateBooksAvailabilty(bookId,incremental_count);
	}
}
