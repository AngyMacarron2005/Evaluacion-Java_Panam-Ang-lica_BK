package ec.edu.ups.models;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "TBL_CATEGORIA")
public class CategoriaModel {


    @Id
    @Column(name = "cat_id")
    private int id;

    @Column(name = "cat_nombre", unique = true)
    private String nombre;
    private boolean deleted = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    
}
