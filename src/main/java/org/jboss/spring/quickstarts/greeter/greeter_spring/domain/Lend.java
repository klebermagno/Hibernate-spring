package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LEND_SPRING")
public class Lend {

	@Id
    @GeneratedValue
    private Long id;

    @Column
    java.util.Date  lendDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    
    
    @OneToMany(fetch = FetchType.LAZY,targetEntity=Book.class)
    private Set<Book> Books = new HashSet<Book>(0);

    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public java.util.Date getLendDate() {
		return lendDate;
	}


	public void setLendDate(java.util.Date lendDate) {
		this.lendDate = lendDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Book> getBooks() {
		return Books;
	}


	public void setBooks(Set<Book> books) {
		Books = books;
	}



    
}
