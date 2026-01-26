package ec.edu.ups.services;

public class Error{

    private int codigo;
    private String name;
    private String detalles;

    public Error(int code, String message, String details) {
        this.codigo = code;
        this.name = message;
        this.detalles = details;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public String getDetalles() {
        return detalles;
    }

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
}

