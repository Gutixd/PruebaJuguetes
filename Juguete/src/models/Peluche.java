package models;

public class Peluche extends Juguete {
    private String tipoPeluche;
    private String color;

    public Peluche() {
        super(0, "", 0);

    }

    public String getTipoPeluche() {
        return tipoPeluche;
    }

    public void setTipoPeluche(String tipoPeluche) {
        this.tipoPeluche = tipoPeluche;
    }
    

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void imprimirInformacionPeluche() {
        System.out.println("Tipo de Peluche: " + tipoPeluche);
        System.out.println("Color: " + color);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        imprimirInformacionPeluche();
    }
     @Override
    public  int totalPagar(int cant){
      return 0;
    }
    @Override
    public  boolean existencia(int cant){
      return true;
    }
}

