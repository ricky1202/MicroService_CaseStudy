package Book.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
	
	private static final String template = "Book Name, %s!";

	public BookController()
	{}
	
	@GetMapping("/info")
	@ResponseBody
	public Book bookInfo(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Book(1, String.format(template, name),"",1,1);
	}

}
