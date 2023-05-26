package ru.kpfu.itis.emelyanov.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.emelyanov.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
