package by.itclass.controllers;

import by.itclass.model.entities.Library;
import by.itclass.model.repositories.LibraryRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") int id) {
        libraryRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addLibrary(@RequestParam(name = "name") String name,
                             @RequestParam(name = "address") String address) {
//        var library = new Library();
//        library.setName(name);
//        library.setAddress(address);
//        libraryRepository.save(library);
        libraryRepository.save(new Library(name, address));
        return "redirect:/";
    }

    @GetMapping("/upd/{id}")
    public ModelAndView updateById(@PathVariable(name = "id") int id) {
        var library = libraryRepository.findById(id).get();
        return new ModelAndView("upd-lib", "library", library);
    }

    @PostMapping("/save")
    public String saveLibrary(@ModelAttribute(name = "library") Library library) {
        libraryRepository.save(library);
        return "redirect:/";
    }

    @PostMapping("/saveOld")
    public String saveLibraryOld(@RequestParam(name = "id") int id,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "address") String address) {
        libraryRepository.save(new Library(id, name, address));
        return "redirect:/";
    }

}
