package harisrsyd.librarybooksmanagement.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsertBookRequest {
  @NotBlank
  private String title;

  @NotNull
  private Year publishYear;

  @NotBlank
  private String author;

  @NotBlank
  private String publisher;

  private String isbn;

  private String language;

  private Long pages;
}
