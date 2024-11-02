package BookStore.BookService.Services.Implementations;

import BookStore.BookService.Entities.Publisher;
import BookStore.BookService.Repositories.PublisherRepository;
import BookStore.BookService.Services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImplementation implements PublisherService {

private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImplementation(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).get();
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}

