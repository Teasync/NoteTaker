package ca.cerul3an.notetaker.controller;

import ca.cerul3an.notetaker.exception.ResourceNotFoundException;
import ca.cerul3an.notetaker.model.Note;
import ca.cerul3an.notetaker.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class NotetakerController implements ErrorController{

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    ErrorAttributes errorAttributes;

    private static final String PATH = "/error";

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "notfound";
    }

    @RequestMapping(value = PATH)
    public String errorPage(HttpServletRequest request, HttpServletResponse response,
                                  Model model) {
        model.addAttribute("responseCode", response.getStatus());
        return "error";
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/list")
    public String noteList(Model model) {
        List<Note> allNotes = noteRepository.findAll();
        model.addAttribute("listOfNotes", allNotes);
        return "list";
    }

    @GetMapping("/find")
    public String find(Model model) {
        return "find";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("note", new Note());
        return "create";
    }

    @PostMapping("/create")
    public String createNote(@Valid @ModelAttribute Note note) {
        noteRepository.save(note);
        return "createDone";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
