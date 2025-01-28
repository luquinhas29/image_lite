package io.github.dougllasfps.imageliteapi.service;

import java.util.Optional;

import io.github.dougllasfps.imageliteapi.entity.Image;

public interface ImageService {
	Image save(Image image);
	
	Optional<Image> getById(String id);
}
