@Entity
@Table(name = "TBL_PRODUCTO")
public class ProductoModel {

    @Id
    @Column(name = "pro_id")
    private int id;

    @Column(name = "pro_nombre", nullable = false)
    private String nombreProductos;

    @Column(name = "pro_precio")
    private double precio;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private CategoriaModel categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
}
