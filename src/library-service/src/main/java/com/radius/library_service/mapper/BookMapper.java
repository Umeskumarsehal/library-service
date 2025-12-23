package com.radius.library_service.mapper;

import com.radius.library_service.base.mapper.GenericEntityVoMapper;
import com.radius.library_service.entity.BookEntity;
import com.radius.library_service.vo.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Component
public class BookMapper extends GenericEntityVoMapper<BookEntity, Book> {
    @Override
    protected List<Consumer<Book>> getEntityToVoMappers(BookEntity entity) {
        return List.of(
                vo -> vo.setId(entity.getId()),
                vo -> vo.setTitle(entity.getTitle()),
                vo -> vo.setAuthor(entity.getAuthor()),
                vo -> vo.setIsbn(entity.getIsbn()),
                vo -> vo.setPublishedDate(entity.getPublishedDate())
        );
    }

    @Override
    protected List<Consumer<BookEntity>> getVoToEntityMappers(Book vo) {
        return List.of(
                entity -> entity.setTitle(vo.getTitle()),
                entity -> entity.setAuthor(vo.getAuthor()),
                entity -> entity.setIsbn(vo.getIsbn()),
                entity -> entity.setPublishedDate(vo.getPublishedDate())
        );
    }

    @Override
    protected List<Consumer<BookEntity>> getVoToEntityPartialMappers(Book partialVo) {
        return List.of(
                entity -> Optional.ofNullable(partialVo.getTitle())
                        .ifPresent(entity::setTitle),
                entity -> Optional.ofNullable(partialVo.getAuthor())
                        .ifPresent(entity::setAuthor),
                entity -> Optional.ofNullable(partialVo.getIsbn())
                        .ifPresent(entity::setIsbn),
                entity -> Optional.ofNullable(partialVo.getPublishedDate())
                        .ifPresent(entity::setPublishedDate)
                // Note: ID is never updated (path variable)
        );
    }

    @Override
    protected Book createVoInstance() {
        return new Book();
    }

    @Override
    protected BookEntity createEntityInstance() {
        return new BookEntity();
    }
}
