package BookStore.BookService.Controllers;
import BookStore.BookService.Entities.Publisher;
import BookStore.BookService.Services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        super();
        this.publisherService = publisherService;
    }

    @GetMapping("/publishers")
    public String listPublishers(Model model) {
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "publishers";
    }

    // Show form to create new publisher
    @GetMapping("/publishers/new")
    public String createPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "create_publisher";
    }

    // Save a new publisher
    @PostMapping("/publishers")
    public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    // Show form to edit an existing publisher
    @GetMapping("/publishers/edit/{id}")
    public String editPublisherForm(@PathVariable Long id, Model model) {
        model.addAttribute("publisher", publisherService.getPublisherById(id));
        return "edit_publisher";
    }

    // Update an existing publisher
    @PostMapping("/publishers/{id}")
    public String updatePublisher(@PathVariable Long id, @ModelAttribute("publisher") Publisher publisher) {
        Publisher existingPublisher = publisherService.getPublisherById(id);
        existingPublisher.setName(publisher.getName());
        publisherService.updatePublisher(existingPublisher);
        return "redirect:/publishers";
    }

    // Delete a publisher
    @GetMapping("/publishers/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
        return "redirect:/publishers";
    }
}

