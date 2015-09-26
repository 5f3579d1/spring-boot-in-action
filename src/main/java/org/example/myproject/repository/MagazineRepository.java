package org.example.myproject.repository;

import org.example.myproject.domain.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by k on 9/15/15.
 */
public interface MagazineRepository extends JpaRepository<Magazine, Long> {

}
