import java.util.Random;

public class User {
    private String userName;
    private int pin;
    private int saldo;

    static Random random = new Random();

    public User(String userName, int pin) {
        this.userName = userName;
        this.pin = pin;
        this.saldo = random.nextInt(40000) + 1000;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getUserName() {
        return userName;
    }

    public  int mostrarSaldo() {
        return getSaldo();
    }

    public boolean retirarEfectivo(int cantidad) {
        if (cantidad < 100 || cantidad > saldo) {
            return false;
        }
        saldo -= cantidad;
        return true;
    }

}
