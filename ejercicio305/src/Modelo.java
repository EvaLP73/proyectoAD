public class Modelo {
    
    //DEFINICIÓN DE LA FUNCIÓN DE SUMA
    private int resultadoSuma;

    public int getSuma(){
        return this.resultadoSuma;
    }

    public void sumar(int elemento1, int elemento2){
        this.resultadoSuma = elemento1 + elemento2;
    }
}
