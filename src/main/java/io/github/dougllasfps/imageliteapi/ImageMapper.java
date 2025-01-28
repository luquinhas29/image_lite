package io.github.dougllasfps.imageliteapi;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import io.github.dougllasfps.imageliteapi.entity.Image;
import io.github.dougllasfps.imageliteapi.enums.ImageExtension;

@Component
public class ImageMapper {
	
	public Image mapToImage(MultipartFile file, String name, List<String> tags ) throws IOException {
		
		return Image.builder()
				.name(name)
				.tags(String.join(",", tags))
				.size(file.getSize())
				.extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
				.file(file.getBytes())
				.build();
	}

}
