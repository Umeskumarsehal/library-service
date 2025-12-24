package com.radius.library_service.service;

import com.radius.library_service.entity.BookEntity;
import com.radius.library_service.exception.BookNotFoundException;
import com.radius.library_service.mapper.BookMapper;
import com.radius.library_service.repository.BookEntityRepository;
import com.radius.library_service.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookEntityRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookMapper.mapToVoList(bookRepository.findAll());
    }

    public Book getBookById(Long id) {
        Optional<BookEntity> book = bookRepository.findById(id);
        if(book.isPresent()){
            return bookMapper.mapToVo(book.get());
        }
        throw new BookNotFoundException("Book Not found with Id: "+id);
    }

    public List<Book> getBookByTitle(String title) {
        Optional<List<BookEntity>> books = bookRepository.findByTitle(title);
        if(books.isPresent()){
            return bookMapper.mapToVoList(books.get());
        }
        throw new BookNotFoundException("Book Not found with Title: "+title);
    }

    public Book createBook(Book bookVo) {
        BookEntity entity = bookMapper.mapToEntity(bookVo);
        BookEntity saved = bookRepository.save(entity);
        return bookMapper.mapToVo(saved);
    }

    public Book updateBook(Long id, Book bookDetails) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book Not found with Id: "+id));
        bookMapper.updateEntity(book, bookDetails);
        BookEntity saved = bookRepository.save(book);
        return bookMapper.mapToVo(saved);
    }

    public void deleteBook(Long id) {
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException("Book Not found with Id: "+id);
        }
        bookRepository.deleteById(id);
    }
}
