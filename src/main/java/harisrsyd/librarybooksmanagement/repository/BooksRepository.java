package harisrsyd.librarybooksmanagement.repository;

import harisrsyd.librarybooksmanagement.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
