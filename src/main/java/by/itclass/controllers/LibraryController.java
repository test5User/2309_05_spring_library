package by.itclass.controllers;

import by.itclass.model.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LibraryController {
    private LibraryRepository libraryRepository;

    @Autowired
    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("libraries", libraryRepository.findAll());
        return "index";
    }

    @GetMapping("/view/{id}")
    public String viewById(@PathVariable(name = "id") int id,
                           Model model) {
        model.addAttribute("library", libraryRepository.findById(id).get());
        return "library";
    }
}
