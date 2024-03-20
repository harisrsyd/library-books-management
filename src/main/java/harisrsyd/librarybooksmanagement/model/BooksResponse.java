package harisrsyd.librarybooksmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BooksResponse {
  private Long id;

  private String title;

  private Year publishYear;

  private String author;

  private String publisher;

  private String isbn;

  private String language;

  private Long pages;
}
