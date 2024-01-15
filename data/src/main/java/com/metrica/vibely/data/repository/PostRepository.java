package com.metrica.vibely.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metrica.vibely.data.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, java.util.UUID>{

    /**
     * @params username, content
     * @return Post
     * @throws NoSuchElementException
     */
//	Optional<Post> findByContentandUser(String username, String content);

    /**
     * @params following
     * @return TreeSet Posts
     * @throws NoSuchElementException
     */
//	Set<Post> getFollowingPost(Set<User> following);

}

