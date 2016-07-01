package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS_SPRING")
public class Book {


	
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;
    
    @Column
    String writer;
    
    @Column
    java.util.Date  editionDate;
    
    @Enumerated(EnumType.STRING)
    private Rating rating;
    
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Lend.class)
  	@JoinColumn(name = "LEND_ID", nullable = false)
    private Lend lend;

    
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lend getLend() {
		return lend;
	}

	public void setLend(Lend lend) {
		this.lend = lend;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public java.util.Date getEditionDate() {
		return editionDate;
	}

	public void setEditionDate(java.util.Date editionDate) {
		this.editionDate = editionDate;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
    
    
}
