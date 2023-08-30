package com.ojulari.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojulari.inventory.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
