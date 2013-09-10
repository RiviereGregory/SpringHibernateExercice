package fr.treeptik.springhibernateexercice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// la valeur que l'on a pour le Dtype
@DiscriminatorValue(value = "DP")
public class DesignProject extends Project {

	private static final long serialVersionUID = 1L;

}
