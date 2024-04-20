package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modos_transmision")
public class ModoTransmisionDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "modo")
	private String modo;
	
	public ModoTransmisionDTO() {
		
	}

	public ModoTransmisionDTO(int id, String modo) {
		this.id = id;
		this.modo = modo;
	}

	public ModoTransmisionDTO(String modo) {
		this.modo = modo;
	}

	@Override
	public String toString() {
		return "ModoTransmisionDTO [id=" + id + ", modo=" + modo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

}
