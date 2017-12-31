package com.oracle.test.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subcategory extends BaseEntity {

	@OneToMany(mappedBy = "category")
	private List<Question> questions;

	private String name;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Category category;

	@Column(length = 2000)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
