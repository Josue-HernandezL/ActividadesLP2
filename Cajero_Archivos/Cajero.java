import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cajero {

    public final String RESET = "\u001B[0m";
    public final String NEGRO = "\u001B[30m";
    public final String ROJO = "\u001B[31m";
    public final String VERDE = "\u001B[32m";
    public final String AMARILLO = "\u001B[33m";
    public final String AZUL = "\u001B[34m";
    public final String MORADO = "\u001B[35m";
    public final String CYAN = "\u001B[36m";
    public final String BLANCO = "\u001B[37m";

    Map<Integer, Integer> billetesDisponibles = new HashMap<>();
    public Cajero (){
        cargarBilletes();
    }

    private void inicializarBilletes() {
        billetesDisponibles.put(100, 100);
        billetesDisponibles.put(200, 100);
        billetesDisponibles.put(500, 20);
        billetesDisponibles.put(1000, 10);
    }

    private void cargarBilletes() {
        try {
            FileInputStream fileInputStream = new FileInputStream("billetes.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            billetesDisponibles = (Map<Integer, Integer>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        }catch (IOException | ClassNotFoundException e) {
            inicializarBilletes();
        }
    }

    public  boolean validacionDeCargaB(int cantidad) {
        for(Map.Entry<Integer, Integer> entry : billetesDisponibles.entrySet()) {
            int denomination = entry.getKey();
            int cantDisponible = entry.getValue();

            int billetesNecesarios = cantidad / denomination;

            if(billetesNecesarios > cantDisponible) {
                return false;
            }
            cantidad %= denomination;
        }
        return cantidad == 0;
    }

    public  boolean updateBilletes( int cantRetiro) {
        List<Integer> denominaciones = new ArrayList<>(billetesDisponibles.keySet());
        Collections.sort(denominaciones, Collections.reverseOrder());

        for(int billete : denominaciones) {
            int cantidadBilletes = billetesDisponibles.get(billete);
            int cantidadNecesaria = cantRetiro / billete;
            int cantidadEntregada = Math.min(cantidadBilletes, cantidadNecesaria);
            cantRetiro -= cantidadEntregada * billete;
            billetesDisponibles.put(billete, cantidadBilletes - cantidadEntregada);
        }
        saveBilletes();
        return true;
    }

    public void saveBilletes() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("billetes.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(billetesDisponibles);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void retirarEfectivo(User user, Cajero cajero) {
        System.out.println(CajeroAutomaticoMain.msgMontMin);
        System.out.println("Ingrese el monto de su retiro: $");
        int cantidadDeRetiro = CajeroAutomaticoMain.input.nextInt();
        if(cantidadDeRetiro < 100 || cantidadDeRetiro > user.getSaldo()) {
            System.out.println(ROJO + "Su saldo es insuficiente o menor a la cantidad minima" + RESET);
            cajero.saveRegister("Retirar", user.getUserName(), cantidadDeRetiro, "NO");
        } else {
            if(cajero.validacionDeCargaB(cantidadDeRetiro)) {
                if(user.retirarEfectivo(cantidadDeRetiro)) {
                    if(cajero.updateBilletes(cantidadDeRetiro)) {
                        System.out.printf(VERDE + "Retiro exitoso. Se ha entregado la cantidad de: $%s\n" + RESET, cantidadDeRetiro);
                        cajero.saveRegister("Retirar", user.getUserName(),cantidadDeRetiro, "SI");
                    } else{
                        System.out.println(ROJO + "No se pudieron entregar los billetes. Por favor, intente con otra cantidad." + RESET);
                        cajero.saveRegister("Retirar", user.getUserName(), cantidadDeRetiro, "NO");
                    }
                }
            } else {
                System.out.println(ROJO + "No hay suficientes billetes para el retiro. Por favor, intente con otra cantidad." + RESET);
                saveRegister("Retirar", user.getUserName(), cantidadDeRetiro, "NO");
            }
        }
    }


    public  void saveRegister(String accion, String userName, int cantidad, String seRealizo) {
        try {
            FileWriter fileWriter = new FileWriter("logs.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(accion + ", " + userName + ", " + cantidad+ ", " + seRealizo);
            printWriter.close();
            fileWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
