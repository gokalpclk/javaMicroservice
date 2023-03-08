package com.outplay.libraryservice.repository;

import com.outplay.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gokalp on 7.03.2023
 * @project javaMicroservice
 */
public interface LibraryRepository extends JpaRepository<Library, String> {
}
