
package br.com.integration.open.shift.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Thiago Araujo
 *
 */
@Entity
@Table(name = "HOST",uniqueConstraints = { 
		@UniqueConstraint(columnNames = {"NAME"}, name = "UK_AGENT_NAME" )
})
public class Host implements Serializable {

	@Serial
	private static final long serialVersionUID = -7916400007950069494L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", insertable = false)
	private Long id;
	
	@Column(name="NAME", nullable = false, length = 50)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "DATE_CREATED", nullable = false)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "DATE_UPDATED", nullable = true)
	private Date dateUpdated;
	
	

	public Host(String name, Date dateCreated, Date dateUpdated) {
		super();
		this.name = name;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}
	
	public Host() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}