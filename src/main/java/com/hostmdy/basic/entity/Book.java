package com.hostmdy.basic.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private String title;
	@NonNull
	private String genre;
	@NonNull
	private Double price;
	
	@ManyToMany
	@JoinTable(name = "book_author",joinColumns = @JoinColumn(name="book_id"),
			inverseJoinColumns = @JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<>();

}
