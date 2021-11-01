package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>, QuerydslPredicateExecutor<Genre> {

}
