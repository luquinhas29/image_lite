package io.github.dougllasfps.imageliteapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.github.dougllasfps.imageliteapi.entity.Image;
import io.github.dougllasfps.imageliteapi.enums.ImageExtension;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image>{

	default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query){
		if(extension != null) {
			
		}
		
		return findAll();
	}
}
