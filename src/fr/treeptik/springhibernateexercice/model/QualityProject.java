package fr.treeptik.springhibernateexercice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "QP")
public class QualityProject extends Project {

	private static final long serialVersionUID = 1L;

}
