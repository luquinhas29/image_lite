package io.github.dougllasfps.imageliteapi.repository.specs;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecs {
	
	private GenericSpecs() {
	}
	
	public static <T> Specification<T> conjunction(){
			return (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();
	}

}
