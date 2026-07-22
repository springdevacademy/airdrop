package com.springdevacademy.airdrop.repository;

import com.springdevacademy.airdrop.model.ResourceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<ResourceItem, Long> {
    List<ResourceItem> findByCategoryIgnoreCase(String category);
}
