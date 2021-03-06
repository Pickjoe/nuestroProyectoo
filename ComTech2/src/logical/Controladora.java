package logical;

import java.util.ArrayList;

public class Controladora {

	private static ArrayList<Admin> administradores;
	private static Person person = null;
	private Tienda tienda;
	private ArrayList<String> modeloStr;
	private ArrayList<String> marcaStr;
	private ArrayList<String> tipoRam;
	private ArrayList<String> conexiones;
	private ArrayList<String> TipoConector;

	public Controladora() {
		super();
		Controladora.administradores = new ArrayList<Admin>();
		Tienda tienda = new Tienda("Villa Olga", "Santiago");
		this.setTienda(tienda);

		Admin LevensonLaguerre = new Admin("Levenson", "Laguerre", "admin", "loteria,calle 3", "admin", "01/01/1997");
		Admin Evelina = new Admin("Evelina", "Villa", "admin", "loteria,calle 3", "eve", "01/01/1997");
		Admin Jhoan = new Admin("Jhoan", "Collado", "admin", "loteria,calle 3", "1234", "01/01/1997");
		administradores.add(Jhoan);
		administradores.add(Evelina);
		administradores.add(LevensonLaguerre);

		this.modeloStr = new ArrayList<String>();
		this.marcaStr = new ArrayList<String>();
		this.conexiones = new ArrayList<String>();
		this.TipoConector = new ArrayList<String>();
		this.tipoRam = new ArrayList<String>();

	}

	public static Person getActualUser() {
		return person;
	}

	public ArrayList<String> getModeloStr() {
		return modeloStr;
	}

	public ArrayList<String> getTipoRam() {
		return tipoRam;
	}

	public ArrayList<String> getConexiones() {
		return conexiones;
	}

	public ArrayList<String> getTipoConector() {
		return TipoConector;
	}

	public ArrayList<String> getMarcaStr() {
		return marcaStr;
	}

	public static void setActualUser(Person person) {
		Controladora.person = person;
	}

	public Person confirmLogin(String usuario, String contrasena) {

		for (Admin adm : administradores) {
			if (adm.getID().equals(usuario) && adm.getContrasena().equals(contrasena)) {
				Controladora.person = adm;
				return adm;
			}
		}
		return null;
	}

	// agregar un admin o varios admin
	public boolean insertarTodosAdmin(ArrayList<Admin> adminis) {
		Controladora.administradores = adminis;
		return true;
	}

	public boolean insertarUnAdmin(Admin admin) {
		Controladora.administradores.add(admin);
		return true;
	}

	// ahi van todos los gettes
	public ArrayList<Admin> getAdministradores() {
		return administradores;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

}
