package by.itclass.controllers;

import by.itclass.model.entities.Book;
import by.itclass.model.entities.BookInLibrary;
import by.itclass.model.repositories.BookRepository;
import by.itclass.model.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private LibraryRepository libraryRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping("/addBook/{id}")
    public ModelAndView addBook(@PathVariable(name = "id") int id) {
        return new ModelAndView("addBook", "book", new BookInLibrary(id));
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute(name = "book") BookInLibrary bookInLibrary) {
        var library = libraryRepository.findById(bookInLibrary.getLibrary_id()).get();
        var book = new Book(bookInLibrary.getTitle(), bookInLibrary.getAuthor(),
                bookInLibrary.getPages(), library);
        bookRepository.save(book);
        return "redirect:/view/" + bookInLibrary.getLibrary_id();
    }

    @GetMapping("/updBook/{id}")
    public ModelAndView updBook(@PathVariable(name = "id") int bookId) {
        var book = bookRepository.findById(bookId).get();
        return new ModelAndView("updBook", "book",
                new BookInLibrary(bookId, book.getTitle(), book.getAuthor(), book.getPages(),
                        book.getLibrary().getId()));
    }

    @PostMapping("/saveUpdated")
    public String saveUpdated(@ModelAttribute(name = "book") BookInLibrary bInL) {
        var book = new Book(bInL.getId(), bInL.getTitle(), bInL.getAuthor(),
                bInL.getPages(), libraryRepository.findById(bInL.getLibrary_id()).get());
        bookRepository.save(book);
        return "redirect:/view/" + bInL.getLibrary_id();
    }
}
