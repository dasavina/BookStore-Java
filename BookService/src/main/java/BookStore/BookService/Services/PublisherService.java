package BookStore.BookService.Services;

import BookStore.BookService.Entities.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> getAllPublishers();
    Publisher getPublisherById(Long id);
    Publisher savePublisher(Publisher publisher);
    Publisher updatePublisher(Publisher publisher);
    void deletePublisherById(Long id);

}
