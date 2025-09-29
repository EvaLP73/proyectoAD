public class main {
    
    public static void main(String[] args) {
        
        // INSTANCIAR EL MODELO, LA VISTA Y EL CONTROLADOR
        // el modelo:
        Modelo modelo = new Modelo();
        // la vista:
        Vista vista = new Vista();
        // y el control:
        Controlador control = new Controlador (vista, modelo);

        // ARRANCAR LA VISTA Y ESTABLECERLE EL CONTROLADOR
        // y arranca la interfaz (vista):
        vista.arranca();
        // configura la vista
        vista.setControlador(control);
        
    }
}
