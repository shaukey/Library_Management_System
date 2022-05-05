package com.project.library_mangement_system.model;

import com.project.library_mangement_system.repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedBookService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    public IssuedBookService(IssuedBookRepository issuedBookRepository) {
        this.issuedBookRepository=issuedBookRepository;
    }

    public List<IssuedBook> getAll() {
        return issuedBookRepository.findAll();
    }

    public IssuedBook get(Long id) {
        return issuedBookRepository.findById(id).get();
    }

    public Long getCountByBook(Book book) {
        return issuedBookRepository.countByBookAndReturned(book, Constants.BOOK_NOT_RETURNED);
    }

    public IssuedBook save(IssuedBook issuedBook) {
        return issuedBookRepository.save(issuedBook);
    }

    public IssuedBook addNew(IssuedBook issuedBook) {
        issuedBook.setReturned( Constants.BOOK_NOT_RETURNED );
        return issuedBookRepository.save(issuedBook);
    }
}
