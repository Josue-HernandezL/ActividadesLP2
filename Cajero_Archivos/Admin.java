import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


public class Admin {

    Cajero cajero = new Cajero();

    public  void viewRegisters() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("logs.txt"));
            String line;
            System.out.println(cajero.MORADO + "Registro de acciones: " + cajero.RESET);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(cajero.CYAN + line + cajero.RESET);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewBilletesDisponibles(Cajero cajero) {
        System.out.println(cajero.MORADO + "Cantidad de billetes disponibles: " + cajero.RESET);
        for(int billete : cajero.billetesDisponibles.keySet()) {
            int cantidad = cajero.billetesDisponibles.get(billete);
            System.out.printf(cajero.CYAN + "$%d: %s\n" + cajero.RESET, billete, cantidad);
        }
    }



    public static void modeAdmin() {
        Admin admin = new Admin();
        Cajero cajero = new Cajero();
        System.out.println(cajero.AZUL + "Modo Administrador"+ cajero.RESET);

        while(true) {
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Mostrar registros de acciones");
            System.out.println("2. Mostrar cantidad de billetes disponibles");
            System.out.println("3. Salir del modo administrador");
            int opcion = CajeroAutomaticoMain.input.nextInt();
            switch (opcion) {
                case 1:
                    admin.viewRegisters();
                    break;
                case 2:
                    admin.viewBilletesDisponibles(cajero);
                    break;
                case 3:
                    System.out.println(cajero.AMARILLO + "Saliendo del modo administrador..." + cajero.R);
                    return;
                default:
                    System.out.println(cajero.ROJO + "Opcion invalida. Por favor selecione una opcion valida." + cajero.RESET);
            }
        }

    }
}
