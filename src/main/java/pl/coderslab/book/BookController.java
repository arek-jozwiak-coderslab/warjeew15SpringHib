package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;


    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @ResponseBody
    @GetMapping("/test-rating")
    public String testRating(@RequestParam int rating) {
        bookDao.findAllByRating(rating)
                .forEach(b -> System.out.println(b.getTitle()));
        return "test-rating";
    }

    @ResponseBody
    @GetMapping("/test-author")
    public String testAuthor(@RequestParam long authorId) {
        bookDao.findBooksWithAuthor(authorDao.findById(authorId))
                .forEach(b -> System.out.println(b.getTitle()));
        return "test-rating";
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
