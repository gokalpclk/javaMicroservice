package com.outplay.libraryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author Gokalp on 7.03.2023
 * @project javaMicroservice
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Library {

    @Id
    @Column(name = "library_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ElementCollection
    private List<String> userBook;

}
