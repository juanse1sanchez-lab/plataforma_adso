package com.mycompany.programa_de_plataforma_adso.modelos;

public class Contenido {
    private int idContenido;
    private String tipo;
    private String nombre;
    private String descripcion;
    private int anio;
    private String categoria;
    private String estado;

    public Contenido() {
    }

    public int getIdContenido() { return idContenido; }
    public void setIdContenido(int idContenido) { this.idContenido = idContenido; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}