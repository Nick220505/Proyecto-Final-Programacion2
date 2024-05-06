package co.edu.unbosque.forrestmfront.model;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name = "errorBean")
@RequestScoped
public class ErrorBean {
	public void redirigirAPaginaInicio(ComponentSystemEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		if (externalContext.getSessionMap().get("mensajeError") == null) {
			try {
				externalContext.redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
