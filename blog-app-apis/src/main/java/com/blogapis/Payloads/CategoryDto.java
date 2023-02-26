package com.blogapis.Payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min=5, message="Min size of category title is 5")
	private String categoryTitle;
	@NotEmpty
	@Size(min=10, message="Min size of category Description is 10")
	private String categoryDescription;

}
