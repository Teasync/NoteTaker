package ca.cerul3an.notetaker.controller;

import ca.cerul3an.notetaker.exception.ResourceNotFoundException;
import ca.cerul3an.notetaker.model.Note;
import ca.cerul3an.notetaker.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NotetakerController {
    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("active", "active");
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
        return "create";
    }

}
