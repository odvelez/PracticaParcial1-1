import java.io.*;

public class CRUDArchivos {

    public static void guardarUsuario(Usuario usuario) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.csv", true));
        bw.write(usuario.toCSV());
        bw.newLine();
        bw.close();
    }

    public static void listarUsuarios() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"));
        String linea;

        while ((linea = br.readLine()) != null) {

            Usuario usuario = Usuario.fromCSV(linea);

            if(usuario.getActivo() == 1){
            System.out.println(usuario.getId() + " - " + usuario.getNombre() + " - " + usuario.getEmail() + " - "
                    + usuario.getCiudad());
            }
        }

        br.close();
    }

    public static Usuario buscarUsuarioPorId(long idBuscado) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"));
        String linea;

        while ((linea = br.readLine()) != null) {

            Usuario usuario = Usuario.fromCSV(linea);

            if (usuario.getId() == idBuscado) {
                br.close();
                return usuario;
            }
        }

        br.close();
        return null;
    }

    public static void eliminarUsuario(long idEliminar) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("temp.csv"));

        String linea;

        while ((linea = br.readLine()) != null) {

            Usuario usuario = Usuario.fromCSV(linea);

            if (usuario.getId() != idEliminar) {
                usuario.setActivo(0);
            }

            bw.write(usuario.toCSV());
            bw.newLine();

        }

        br.close();
        bw.close();

        File original = new File("usuarios.csv");
        File temporal = new File("temp.csv");

        original.delete();
        temporal.renameTo(original);
    }

}