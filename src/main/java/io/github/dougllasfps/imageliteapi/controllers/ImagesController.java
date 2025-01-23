package io.github.dougllasfps.imageliteapi.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.convert.Delimiter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.github.dougllasfps.imageliteapi.entity.Image;
import io.github.dougllasfps.imageliteapi.enums.ImageExtension;
import io.github.dougllasfps.imageliteapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor
public class ImagesController {

	private final ImageService service;
	
	@PostMapping
	public ResponseEntity save(
			@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("tags") List<String> tags
			) throws IOException {
		
		log.info("Imagem recebida: name: {}, size: {}", file.getOriginalFilename(), file.getSize());
		//log.info("Content Type: {}", file.getContentType());
		//log.info("Media Type: {}", MediaType.valueOf(file.getContentType()));
		
		Image image = Image.builder()
				.name(name)
				.tags(String.join(",", tags))
				.size(file.getSize())
				.extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
				.file(file.getBytes())
				.build();
		
		service.save(image);
		
		return ResponseEntity.ok().build();
	}
}
