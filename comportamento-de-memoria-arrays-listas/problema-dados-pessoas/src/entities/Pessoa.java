package entities;

public class Pessoa {

    private float altura;
    private char sexo;

    public Pessoa(float altura, char sexo) {
        this.altura = altura;
        this.sexo = sexo;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
