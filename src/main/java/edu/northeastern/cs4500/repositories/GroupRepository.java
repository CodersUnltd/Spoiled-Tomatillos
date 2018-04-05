package edu.northeastern.cs4500.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs4500.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
}
