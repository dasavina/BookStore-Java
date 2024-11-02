package BookStore.BookService.Services.Implementations;

import BookStore.BookService.Entities.BookPublisher;
import BookStore.BookService.Entities.BookPublisherId;
import BookStore.BookService.Repositories.BookPublisherRepository;
import BookStore.BookService.Services.BookPublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookPublisherServiceImplementation implements BookPublisherService {

    private final BookPublisherRepository bookPublisherRepository;

    public BookPublisherServiceImplementation(BookPublisherRepository bookPublisherRepository) {
        super();
        this.bookPublisherRepository = bookPublisherRepository;
    }

    @Override
    public List<BookPublisher> getAll() {
        return bookPublisherRepository.findAll();
    }

    @Override
    public BookPublisher getById(BookPublisherId id) {
        return bookPublisherRepository.findById(id).get();
    }


    @Override
    public BookPublisher update(BookPublisher bookPublisher) {
        return bookPublisherRepository.save(bookPublisher);
    }

    @Override
    public void delete(BookPublisherId id) {
        bookPublisherRepository.deleteById(id);
    }

    @Override
    public BookPublisher save(BookPublisher bookPublisher) {
        return bookPublisherRepository.save(bookPublisher);
    }
}
