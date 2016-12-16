package com.rocketOzzy.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@NamedQueries({
	@NamedQuery(name="clientDB.deleteClientsByNumber", query="delete from ClientDB obj where obj.cliNumber in(:cliNumbers) ")
})
@Entity
@Table(name="CLIENT")
public class ClientDB implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="CLI_NUMBER")
	@SequenceGenerator(name="CLIENTE_SEQ", sequenceName="CLIENTE_SEQ", allocationSize=1)
	@GeneratedValue(generator="CLIENTE_SEQ")
	private BigDecimal cliNumber;
	
	@Column(name="CLI_NAME")
	private String cliName;
	
	@Column(name="CLI_DATEBIRTH")
	@JsonSerialize(using = com.rocketOzzy.util.JSONSerializer.class)
	@JsonDeserialize(using = com.rocketOzzy.util.JSONDeserialize.class)
	private Date cliDatebirth;
	
	@Column(name="CLI_LASTNAME")
	private String cliLastname;
	
	@Column(name="CLI_REGISTER")
	private String cliRegister;
	
	
	public BigDecimal getCliNumber() {
		return cliNumber;
	}

	public void setCliNumber(BigDecimal cliNumber) {
		this.cliNumber = cliNumber;
	}

	public String getCliName() {
		return cliName;
	}

	public void setCliName(String cliName) {
		this.cliName = cliName;
	}

	public Date getCliDatebirth() {
		return cliDatebirth;
	}

	public void setCliDatebirth(Date cliDatebirth) {
		this.cliDatebirth = cliDatebirth;
	}

	public String getCliLastname() {
		return cliLastname;
	}

	public void setCliLastname(String cliLastname) {
		this.cliLastname = cliLastname;
	}

	public String getCliRegister() {
		return cliRegister;
	}

	public void setCliRegister(String cliRegister) {
		this.cliRegister = cliRegister;
	}

	


	public void setSampleData(String id){
		this.setCliName("JOHN_"+id);
		this.setCliDatebirth(new Date());
		this.setCliLastname("BLACK_"+1);
		this.setCliRegister("333.222.111-"+id);
	}
	
}
