package io.github.dougllasfps.imageliteapi.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.dougllasfps.imageliteapi.entity.Image;
import io.github.dougllasfps.imageliteapi.repository.ImageRepository;
import io.github.dougllasfps.imageliteapi.service.ImageService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
	
		private final ImageRepository repository;
		
		@Override
		@Transactional
		public Image save(Image image) {
			return repository.save(image);
		}
		
		@Override
		public Optional<Image> getById(String id){
			return repository.findById(id);
		}
	
}
