package co.edu.unbosque.dao;

public class Prueba {
	public static void main(String[] args) {
		ModoTransmisionDAO modoTransmisionDAO = new ModoTransmisionDAO();
		try {
			modoTransmisionDAO.listar().forEach(mt -> System.out.println(mt));
//			modoTransmisionDAO.agregar(new ModoTransmisionDTO("FM"));
//			modoTransmisionDAO.actualizar(2, new ModoTransmisionDTO(2, "AM"));
//			modoTransmisionDAO.eliminar(1);
			modoTransmisionDAO.listar().forEach(mt -> System.out.println(mt));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
