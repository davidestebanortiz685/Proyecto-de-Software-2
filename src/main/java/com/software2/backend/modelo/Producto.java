package com.software2.backend.modelo;

public class Producto {
    private Long id;
    private String nombrep;
    private int precio;
    private String peso;

    public Producto() {
    }

    public Producto(Long id, String nombrep, int precio, String peso) {
        this.id = id;
        this.nombrep = nombrep;
        this.precio = precio;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    
  
   

    
    
}

