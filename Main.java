import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            try {

                if (opcion == 1) {

                    System.out.print("Ingrese ID: ");
                    long id = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese email: ");
                    String email = sc.nextLine();

                    System.out.print("Ingrese ciudad: ");
                    String ciudad = sc.nextLine();

                    Usuario usuario = new Usuario(id, nombre, email, ciudad);

                    CRUDArchivos.guardarUsuario(usuario);

                    System.out.println("Usuario registrado correctamente.");

                } else if (opcion == 2) {

                    CRUDArchivos.listarUsuarios();

                } else if (opcion == 3) {

                    System.out.print("Ingrese el ID a buscar: ");
                    long id = sc.nextLong();
                    sc.nextLine();

                    Usuario usuario = CRUDArchivos.buscarUsuarioPorId(id);

                    if (usuario != null) {
                        System.out.println(
                                usuario.getId() + " - " +
                                        usuario.getNombre() + " - " +
                                        usuario.getEmail() + " - " +
                                        usuario.getCiudad());
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }

                } else if (opcion == 4) {

                    System.out.print("Ingrese el ID a eliminar: ");
                    long id = sc.nextLong();
                    sc.nextLine();

                    CRUDArchivos.eliminarUsuario(id);

                    System.out.println("Usuario eliminado.");

                }

            } catch (IOException e) {
                System.out.println("Error manejando el archivo.");
            }
        }

        sc.close();
    }

    
}