package com.Todo.Repository;

import com.Todo.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepo extends JpaRepository<Author, Integer> {

    public Optional<Author> findByEmail(String Email);

}
