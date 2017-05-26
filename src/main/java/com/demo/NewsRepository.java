/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LocInt
 */
public interface NewsRepository extends CrudRepository<News, Long>  {
    Page<List<News>> findByCreated(Pageable pageable, LocalDate date);
}
