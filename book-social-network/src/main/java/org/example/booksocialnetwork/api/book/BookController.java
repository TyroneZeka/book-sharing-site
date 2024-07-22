package org.example.booksocialnetwork.api.book;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.booksocialnetwork.api.common.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
@Tag(name="Book")
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<Integer> saveBook(
            @Valid @RequestBody BookRequest bookRequest,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.save(bookRequest,connectedUser));
    }

    @GetMapping("{book-id}")
    public ResponseEntity<BookResponse> findBookById(@PathVariable("book-id") Integer bookId) {
        return ResponseEntity.ok(service.findById(bookId));
    }

    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> findAllBooks(
            @RequestParam(name = "page", defaultValue = "0",required = false) int page,
            @RequestParam(name = "size", defaultValue = "10",required = false) int size,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.findAllBooks(page,size,connectedUser));
    }

    @GetMapping("/owner")
    public ResponseEntity<PageResponse<BookResponse>> findBooksByOwner(
            @RequestParam(name = "page", defaultValue = "0",required = false) int page,
            @RequestParam(name = "size", defaultValue = "10",required = false) int size,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.findAllBooksByOwner(page,size,connectedUser));
    }

    @GetMapping("/borrowed")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllBorrowedBooks(
            @RequestParam(name = "page", defaultValue = "0",required = false) int page,
            @RequestParam(name = "size", defaultValue = "10",required = false) int size,
            Authentication connectedUser
    )
    {
        return ResponseEntity.ok(service.findAllBorrowedBooks(page,size,connectedUser));
    }

    @GetMapping("/returned")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllReturnedBooks(
            @RequestParam(name = "page", defaultValue = "0",required = false) int page,
            @RequestParam(name = "size", defaultValue = "10",required = false) int size,
            Authentication connectedUser
    )
    {
        return ResponseEntity.ok(service.findAllReturnedBooks(page,size,connectedUser));
    }

    @PatchMapping("/shareable/{book-id}")
    public ResponseEntity<Integer> updateShareableStatus(
            @PathVariable("book-id") Integer bookId,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.updateShareableStatus(bookId,connectedUser));
    }

    @PatchMapping("/archive/{book-id}")
    public ResponseEntity<Integer> updateArchiveStatus(
            @PathVariable("book-id") Integer bookId,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.updateArchiveStatus(bookId,connectedUser));
    }

    @PostMapping("/borrow/{book-id}")
    public ResponseEntity<Integer> borrowBook(
            @PathVariable("book-id") Integer bookId,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.borrowBook(bookId,connectedUser));
    }

    @PostMapping("/borrow/return/{book-id}")
    public ResponseEntity<Integer> returnBook(
            @PathVariable("book-id") Integer bookId,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.returnBook(bookId,connectedUser));
    }
    @PostMapping("/borrow/return/approve/{book-id}")
    public ResponseEntity<Integer> approceReturnedBook(
            @PathVariable("book-id") Integer bookId,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.approveReturnedBook(bookId,connectedUser));
    }

    @PostMapping(value = "/cover/{book-id}", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadBookCover(
            @PathVariable("book-id") Integer bookId,
            @Parameter
            @RequestPart("file")MultipartFile file,
            Authentication connectedUser
            ){
        service.uploadBookCover(file,connectedUser,bookId);
        return ResponseEntity.accepted().build();
    }


}
