package app;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Collections, Integer> {

    // custom query to search to blog post by title or content
    List<Collections> findByUrlContainingOrTokenContaining(String text, String textAgain);

}