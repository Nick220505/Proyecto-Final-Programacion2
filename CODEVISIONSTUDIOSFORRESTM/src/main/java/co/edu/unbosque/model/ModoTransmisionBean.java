package co.edu.unbosque.model;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.ModoTransmisionDAO;

@ManagedBean
public class ModoTransmisionBean {

	private ModoTransmisionDAO gestorModoTransmision;
	private String modo;

	public ModoTransmisionBean() {
		gestorModoTransmision = new ModoTransmisionDAO();
	}

	public ModoTransmisionBean(String modo) {
		this.modo = modo;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}
}
