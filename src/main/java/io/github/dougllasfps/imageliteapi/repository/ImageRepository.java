package io.github.dougllasfps.imageliteapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.dougllasfps.imageliteapi.entity.Image;

public interface ImageRepository extends JpaRepository<Image, String>{

}
