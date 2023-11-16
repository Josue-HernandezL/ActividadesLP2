import  java.util.Scanner;
public class CajeroAutomaticoMain {
    static Scanner input = new Scanner(System.in);
    static String msgUser = "Ingrese su usuario: ";
    static String msgPassword = "Ingrese su PIN de 4 dijitos: ";
    static  String msgMontMin = "Monto minimo de : $100";
    public static void logIn() {
        System.out.println(msgUser);
        String userName = input.next();
        System.out.println(msgPassword);
        int pin = input.nextInt();

        if(userName.equalsIgnoreCase("admin") && pin == 3243){
            Admin.modeAdmin();
        } else {
            User user = new User(userName, pin);
            modoCajero(user);
        }
    }

    public  static  void modoCajero(User user) {
        Cajero cajero = new Cajero();

        System.out.println(cajero.AZUL + "Modo cajero" + cajero.RESET);
        System.out.printf("Hola %s Bienvenido\n", user.getUserName());
        while(true) {
            System.out.printf("Saldo disponible: $%s \n",user.getSaldo());
            System.out.println(msgMontMin);
            System.out.println("Seleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar efectivo");
            System.out.println("3. Salir del cajero");
            int option = input.nextInt();
            switch (option) {
                case 1 :
                    user.mostrarSaldo();
                    break;
                case 2:
                    cajero.retirarEfectivo(user, cajero);
                    break;
                case 3 :
                    cajero.saveBilletes();
                    cajero.saveRegister("Salir", user.getUserName(), user.getSaldo(), "SI");
                    System.out.println(cajero.AMARILLO + "¡Gracias por el uso del cajero. Vuelva pronto!" + cajero.RESET);
                    return;
                default: System.out.println(cajero.ROJO + "Opción no valida, seleccione un opcion valida" + cajero.RESET);
                return;
            }
        }
    }

    public static void main(String[] args) {
        CajeroAutomaticoMain.logIn();
    }

}