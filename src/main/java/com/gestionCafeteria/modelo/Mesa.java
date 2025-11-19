package com.gestionCafeteria.modelo;

public class Mesa {
    private int numMesa;
    private int cantidadSillas;

    public Mesa(int numMesa, int cantidadSillas) {
        this.numMesa = numMesa;
        this.cantidadSillas = cantidadSillas;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getCantidadSillas() {
        return cantidadSillas;
    }

    public void setCantidadSillas(int cantidadSillas) {
        this.cantidadSillas = cantidadSillas;
    }
}
