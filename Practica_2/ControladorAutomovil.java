public class ControladorAutomovil {
    public static void main(String[] args){
        Automovil auto = new Automovil("Ford", "Fiesta");
        auto.encenderMotor();
        auto.acelerar(50);
        auto.frenar(12);

        auto.acelerar(50);
        //Paso por valor
        auto.duplicarVelocidad(auto.velocidad);
        System.out.println("El auto se mueve a " + auto.verVelocidad() + " km/h");
        auto.color = "rojo";
        System.out.println("Mi auto es color " + auto.color);
        //Paso por referencia
        Automovil.pintar(auto);
        System.out.println("El color de mi auto ahora es " + auto.color);

        Automovil.Estereo radio = new Automovil.Estereo();
        radio.reproducirCancion("Guns n ' Roses - Nightrain");

        Automovil.Radiator radiator = auto.new Radiator();
        radiator.enfriar();
    }
}