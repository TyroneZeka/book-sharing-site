package org.example.booksocialnetwork.api.book;

import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    public static Specification<Book> withOwnerId(Integer ownerId) {
        return (root, query, cb) -> cb.equal(root.get("ownerId"), ownerId);
    }
}
