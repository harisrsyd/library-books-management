package harisrsyd.librarybooksmanagement.service;

import harisrsyd.librarybooksmanagement.entity.Books;
import harisrsyd.librarybooksmanagement.model.BooksResponse;
import harisrsyd.librarybooksmanagement.model.InsertBookRequest;
import harisrsyd.librarybooksmanagement.model.UpdateBookRequest;
import harisrsyd.librarybooksmanagement.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BooksService {
  @Autowired
  private BooksRepository booksRepository;

  @Autowired
  private ValidationService validationService;

  @Transactional
  public BooksResponse create(InsertBookRequest request) {
    validationService.validate(request);

    Books books = new Books();
    books.setTitle(request.getTitle());
    books.setAuthor(request.getAuthor());
    books.setPublishYear(request.getPublishYear());
    books.setPublisher(request.getPublisher());
    books.setIsbn(request.getIsbn());
    books.setLanguage(request.getLanguage());
    books.setPages(request.getPages());
    booksRepository.save(books);

    return toBooksResponse(books);
  }

  private BooksResponse toBooksResponse(Books books) {
    return BooksResponse.builder()
            .id(books.getId())
            .title(books.getTitle())
            .author(books.getAuthor())
            .publishYear(books.getPublishYear())
            .publisher(books.getPublisher())
            .isbn(books.getIsbn())
            .language(books.getLanguage())
            .pages(books.getPages())
            .build();
  }

  @Transactional(readOnly = true)
  public BooksResponse getDetails(Long id) {

    Books books = booksRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found"));
    return toBooksResponse(books);
  }

  @Transactional(readOnly = true)
  public Page<Books> getAll(Pageable pageable) {
    return booksRepository.findAllPage(pageable);
  }

  public BooksResponse update(UpdateBookRequest request) {
    validationService.validate(request);

    Books books = booksRepository.findById(request.getId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found"));

    books.setTitle(request.getTitle());
    books.setAuthor(request.getAuthor());
    books.setPublishYear(request.getPublishYear());
    books.setPublisher(request.getPublisher());
    books.setIsbn(request.getIsbn());
    books.setLanguage(request.getLanguage());
    books.setPages(request.getPages());
    booksRepository.save(books);

    return toBooksResponse(books);
  }

  @Transactional
  public void delete(Long id) {

    Books books = booksRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book Not Found"));
    booksRepository.delete(books);
  }
}
