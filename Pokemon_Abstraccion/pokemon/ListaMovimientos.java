import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>(); 

    public ListaMovimientos() {
        movimientos.add(new Movimiento("Acua aro", 40, 30, Tipo.AGUA));
        movimientos.add(new Movimiento("Acua cola", 50, 40, Tipo.AGUA));

        movimientos.add(new Movimiento("Anillo ígneo", 150, 20, Tipo.FUEGO));
        movimientos.add(new Movimiento("Ascuas", 40, 30, Tipo.FUEGO));

        movimientos.add(new Movimiento("Terra Temblor", 60, 20, Tipo.TIERRA));
        movimientos.add(new Movimiento("Excavar", 80, 10, Tipo.TIERRA));

        movimientos.add(new Movimiento("Meteoros", 60, 20, Tipo.NORMAL));


    }

    public Movimiento buscarMovimientoPorNombre (String nombre) {
        for(Movimiento movimiento : movimientos) {
            if(movimiento.getNombre().equals(nombre)) {
                return movimiento;
            }
        }
        return null;
    }


    
}
