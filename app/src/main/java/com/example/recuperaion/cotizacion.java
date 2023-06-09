package com.example.recuperaion;

public class cotizacion {

    private int folio;
    private String descripcion;
    private double valorAuto;
    private double porEnganche;
    private int plazo;


    public cotizacion(int folio, String descripcion, double valorAuto, double porEnganche, int plazo) {
        this.folio = folio;
        this.descripcion = descripcion;
        this.valorAuto = valorAuto;
        this.porEnganche = porEnganche;
        this.plazo = plazo;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorAuto() {
        return valorAuto;
    }

    public void setValorAuto(double valorAuto) {
        this.valorAuto = valorAuto;
    }

    public double getPorEnganche() {
        return porEnganche;
    }

    public void setPorEnganche(double porEnganche) {
        this.porEnganche = porEnganche;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }





    public double calcularEnganche()
    {
        double enganche;
        double porcentaje;

        porcentaje=this.getPorEnganche()/100;
        enganche=porcentaje*this.valorAuto;

        return enganche;


    }

    public double calcularPagoMensual()
    {
        double pago;
        double mensual=0.0;
        pago=this.getValorAuto()-this.calcularEnganche();

        if(this.getPlazo()==1)
        {
            mensual=pago/12;
        } else if (this.getPlazo()==2) {
            mensual=pago/18;
        } else if (this.getPlazo()==3) {
            mensual=pago/24;

        } else if (this.getPlazo()==4) {
            mensual=pago/36;

        }
        return mensual;

    }
}
