package harisrsyd.librarybooksmanagement.controller;

import harisrsyd.librarybooksmanagement.entity.Books;
import harisrsyd.librarybooksmanagement.model.*;
import harisrsyd.librarybooksmanagement.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

  @Autowired
  private BooksService booksService;

  @PostMapping(
          path = "/api/books",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public WebResponse<BooksResponse> insert (@RequestBody InsertBookRequest request){
    BooksResponse booksResponse = booksService.create(request);
    return WebResponse.<BooksResponse>builder().data(booksResponse).build();
  }

  @GetMapping(
          path = "/api/books/{id}",
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public WebResponse<BooksResponse> getDetail (@PathVariable("id") Long id) {
    BooksResponse booksResponse = booksService.getDetails(id);
    return WebResponse.<BooksResponse>builder().data(booksResponse).build();
  }

  @GetMapping(
          path = "/api/books",
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public WebResponse<List<BooksResponse>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                         @RequestParam(value = "size", defaultValue = "5") int size)
  {
    Pageable pageable = PageRequest.of(page, size);
    Page<BooksResponse> booksResponses = booksService.getAll(pageable);
    return WebResponse.<List<BooksResponse>>builder().data(booksResponses.getContent())
            .paging(PagingResponse.builder()
                    .currentPage(booksResponses.getNumber())
                    .totalPage(booksResponses.getTotalPages())
                    .size(booksResponses.getSize())
                    .build())
            .build();
  }

  @PutMapping(
          path = "/api/books/{id}",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public WebResponse<BooksResponse> update(@RequestBody UpdateBookRequest request,
                                           @PathVariable("id") Long id){
    request.setId(id);
    BooksResponse booksResponse = booksService.update(request);
    return WebResponse.<BooksResponse>builder().data(booksResponse).build();
  }

  @DeleteMapping(
          path = "/api/books/{id}",
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public WebResponse<String> delete (@PathVariable("id") Long id) {
    booksService.delete(id);
    return WebResponse.<String>builder().data("OK").build();
  }
}
