package com.radius.library_service.repository;

import com.radius.library_service.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity, Long> {
    Optional<List<BookEntity>> findByTitle(String title);
}
