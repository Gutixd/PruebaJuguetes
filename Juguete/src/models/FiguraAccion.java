package models;

public class FiguraAccion extends Juguete {
    private String personaje;
    private String material;
    
    public FiguraAccion() {
        super(0, "", 0);

    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
    
    

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void imprimirInformacionFiguraAccion() {
        System.out.println("Personaje: " + personaje);
        System.out.println("Material: " + material);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        imprimirInformacionFiguraAccion();
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
