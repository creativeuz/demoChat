package com.payway.demochat.repository;

import com.payway.demochat.model.CSupport;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CSupportRepository extends JpaRepository<CSupport, Long> {
    Optional<CSupport> findByCsId(Long id);
}
