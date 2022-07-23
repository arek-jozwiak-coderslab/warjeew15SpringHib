package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        Book build = Book.builder().
                title("Thinking in java")
                .rating(4)
                .description("About Java")
                .build();
        bookDao.save(build);

        Book byId = bookDao.findById(build.getId());

        System.out.println(byId.getTitle());

        byId.setTitle("Java 2 podstawy");
        bookDao.update(byId);

        bookDao.delete(byId);

        return "book";
    }


    @ResponseBody
    @GetMapping("/update/{id}/{rating}")
    public String update(@PathVariable Long id, @PathVariable int rating) {
        Book byId = bookDao.findById(id);
        System.out.println(byId.getTitle());
        System.out.println(byId.getId());
        byId.setTitle("new title");
        byId.setRating(rating);
        bookDao.update(byId);
        return "book";
    }


    @ResponseBody
    @GetMapping("/save-publisher-book")
    public String savePublisherAndBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);
        Book book = new Book();
        book.setTitle("Some title");
        book.setPublisher(publisher);
        bookDao.save(book);
        return "";
    }

}
