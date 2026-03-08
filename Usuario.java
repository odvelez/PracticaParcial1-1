public class Usuario {

    private long id;
    private String nombre;
    private String email;
    private String ciudad;
    private int activo;

    public ConstructosUsuario(long id, String nombre, String email, String ciudad){
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciudad = ciudad;
    this.activo = activo;
}

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String toCSV() {
        return id + "," + nombre + "," + email + "," + ciudad + "," + activo;
    }

    public static Usuario fromCSV(String linea) {
        String[] datos = linea.split(",");
        long id = Long.parseLong(datos[0]);
        String nombre = datos[1];
        String email = datos[2];
        String ciudad = datos[3];
        int activo = Integer.parseInt(datos[4]);

        return new Usuario(id, nombre, email, ciudad, activo);
    }
}