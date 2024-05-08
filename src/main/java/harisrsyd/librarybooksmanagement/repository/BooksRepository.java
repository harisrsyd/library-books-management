package harisrsyd.librarybooksmanagement.repository;

import harisrsyd.librarybooksmanagement.entity.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<Books, Long> {

//  @Query(value = "select * from books", nativeQuery = true)
//  Page<Books> findAllPage(Pageable pageable);
}
