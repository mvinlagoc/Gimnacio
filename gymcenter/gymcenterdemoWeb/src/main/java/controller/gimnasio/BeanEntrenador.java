package controller.gimnasio;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.core.entities.Cliente;
import model.core.entities.Detfichaantropometrica;
import model.core.entities.Fichaantropometrica;
import model.gimnasio.managers.ManagerGimnasio;

@Named
@SessionScoped
public class BeanEntrenador implements Serializable {

	@EJB
	private ManagerGimnasio mGimnasio;
	private Fichaantropometrica nuevaFicha;
	private Detfichaantropometrica nuevoDetFicha;
	private List<Cliente> listaCliente;
	
	private int IDCliente;
	
	
	public BeanEntrenador() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@PostConstruct
	public void inicializar() {
		nuevaFicha = new Fichaantropometrica();
		nuevoDetFicha = new Detfichaantropometrica();
		listaCliente = mGimnasio.findAllClientes();
	}
	
	public void insertarFicha() throws Exception {
		nuevaFicha.setCliente(mGimnasio.findClienteByID(IDCliente));
		mGimnasio.createFicha(nuevaFicha);
		nuevaFicha = new Fichaantropometrica();
	}

	public Fichaantropometrica getNuevaFicha() {
		return nuevaFicha;
	}

	public void setNuevaFicha(Fichaantropometrica nuevaFicha) {
		this.nuevaFicha = nuevaFicha;
	}

	public Detfichaantropometrica getNuevoDetFicha() {
		return nuevoDetFicha;
	}

	public void setNuevoDetFicha(Detfichaantropometrica nuevoDetFicha) {
		this.nuevoDetFicha = nuevoDetFicha;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}

	
	

}
