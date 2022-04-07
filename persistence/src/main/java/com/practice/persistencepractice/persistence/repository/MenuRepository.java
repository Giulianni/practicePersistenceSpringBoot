package com.practice.persistencepractice.persistence.repository;

import com.practice.persistencepractice.persistence.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

//    @Query("SELECT menu FROM Menu where menu.roles_id in ?1")
//    Optional<List<Menu>>findByRoleIds(List<Integer> ids);
//select kurs from Kategori kat join kat.kursList kurs where kat.kategoriId = ?
    @Query ("SELECT m FROM Menu m join m.roles r where r.id in :ids")
    Optional<List<Menu>>findByRoleIds(List<Integer> ids);
}
