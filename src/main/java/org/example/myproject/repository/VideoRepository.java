package org.example.myproject.repository;

import org.example.myproject.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by k on 9/15/15.
 */
public interface VideoRepository extends JpaRepository<Video, Long> {

}
