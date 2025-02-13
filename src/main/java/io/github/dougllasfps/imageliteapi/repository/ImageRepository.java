package io.github.dougllasfps.imageliteapi.repository;

import java.util.List;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import io.github.dougllasfps.imageliteapi.entity.Image;
import io.github.dougllasfps.imageliteapi.enums.ImageExtension;
import io.github.dougllasfps.imageliteapi.repository.specs.GenericSpecs;
import io.github.dougllasfps.imageliteapi.repository.specs.ImageSpecs;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image>{

	default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query){
		
		Specification<Image> spec = Specification.where(GenericSpecs.conjunction());
		
		if(extension != null) {
			spec = spec.and(ImageSpecs.extensionEqual(extension));

		}
		
		if(StringUtils.hasText(query)) {
									
			spec = spec.and(Specification.anyOf(ImageSpecs.nameLike(query), ImageSpecs.tagsLike(query)));
		}
		
		return findAll(spec);
	}
}
