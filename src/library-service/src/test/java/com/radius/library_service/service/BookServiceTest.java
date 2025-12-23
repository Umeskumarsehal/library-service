package com.radius.library_service.service;

import com.radius.library_service.entity.BookEntity;
import com.radius.library_service.exception.BookNotFoundException;
import com.radius.library_service.mapper.BookMapper;
import com.radius.library_service.repository.BookEntityRepository;
import com.radius.library_service.vo.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookEntityRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookService bookService;

    @Test
    void getAllBooks_shouldReturnListOfBooks() {
        BookEntity entity = new BookEntity();
        entity.setId(1L);

        Book book = new Book();
        book.setId(1L);

        when(bookRepository.findAll()).thenReturn(List.of(entity));
        when(bookMapper.mapToVoList(List.of(entity))).thenReturn(List.of(book));

        List<Book> result = bookService.getAllBooks();

        assertEquals(1, result.size());
        verify(bookRepository).findAll();
    }

    @Test
    void getBookById_shouldReturnBook_whenExists() {
        BookEntity entity = new BookEntity();
        entity.setId(1L);

        Book book = new Book();
        book.setId(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(bookMapper.mapToVo(entity)).thenReturn(book);

        Book result = bookService.getBookById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void getBookById_shouldThrowException_whenNotExists() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class,
                () -> bookService.getBookById(1L));
    }

    @Test
    void createBook_shouldSaveAndReturnBook() {
        Book book = new Book();
        BookEntity entity = new BookEntity();

        when(bookMapper.mapToEntity(book)).thenReturn(entity);
        when(bookRepository.save(entity)).thenReturn(entity);
        when(bookMapper.mapToVo(entity)).thenReturn(book);

        Book result = bookService.createBook(book);

        assertNotNull(result);
        verify(bookRepository).save(entity);
    }
}
