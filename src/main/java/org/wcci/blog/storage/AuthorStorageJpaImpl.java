package org.wcci.blog.storage;

import org.wcci.blog.models.Author;
import org.wcci.blog.storage.repositories.AuthorRepository;

public class AuthorStorageJpaImpl implements AuthorStorage {
    private AuthorRepository authorRepository;

    public AuthorStorageJpaImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public void store(Author authorToStore){
        authorRepository.save(authorToStore);
    }
}
