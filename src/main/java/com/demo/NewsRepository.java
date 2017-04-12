/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LocInt
 */
public interface NewsRepository extends CrudRepository<News, Long>  {
    
}
