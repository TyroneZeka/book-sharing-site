package org.example.booksocialnetwork.api.history;

import org.example.booksocialnetwork.api.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionalHistory,Integer> {
    @Query("""
    SELECT history 
    FROM BookTransactionalHistory history
    WHERE history.user.id = :userId
    """)
    Page<BookTransactionalHistory> findAllBorrowedBooks(Pageable pageable, Integer userId);

    @Query("""
    SELECT history 
    FROM BookTransactionalHistory history
    WHERE history.book.owner.id = :userId
        """)
    Page<BookTransactionalHistory> findAllReturnedBooks(Pageable pageable, Integer userId    );

    @Query("""
        SELECT 
        (COUNT(*) > 0) AS isBorrowed
        FROM BookTransactionalHistory history
        WHERE history.book.owner.id = :userId
        AND history.book.id = :bookId
        AND history.returnApproved = false
        """)
    boolean isAlreadyBorrowed(Integer bookId, Integer userId);

    @Query("""
    SELECT transaction
    FROM BookTransactionalHistory transaction
    WHERE transaction.user.id = :userId
    AND transaction.book.id = :bookId
    AND transaction.returned = false
    AND transaction.returnApproved = false
        """)
    Optional<BookTransactionalHistory> findByBookIdAndUserId(Integer bookId, Integer userId);

    @Query("""
    SELECT transaction
    FROM BookTransactionalHistory transaction
    WHERE transaction.book.owner.id = :ownerId
    AND transaction.book.id = :bookId
    AND transaction.returned = true
    AND transaction.returnApproved = false
        """)
    Optional<BookTransactionalHistory> findByBookIdAndOwnerId(Integer bookId, Integer ownerId);
}
