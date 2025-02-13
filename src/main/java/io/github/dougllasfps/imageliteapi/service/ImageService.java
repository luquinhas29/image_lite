package io.github.dougllasfps.imageliteapi.service;

import java.util.List;
import java.util.Optional;

import io.github.dougllasfps.imageliteapi.entity.Image;
import io.github.dougllasfps.imageliteapi.enums.ImageExtension;

public interface ImageService {
	Image save(Image image);
	
	Optional<Image> getById(String id);
	
	List<Image> search(ImageExtension extension, String query);
	
}
