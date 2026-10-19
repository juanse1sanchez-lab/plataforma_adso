package com.mycompany.programa_de_plataforma_adso.modelos;

public class Usuario {
    
    private int id;
    private String documento;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String password;
    private String rol;
    private String tokenRecuperacion;
    private String estadoCuenta;
    private int visualizacionesConsumidas;
    private String codigoDesbloqueo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTokenRecuperacion() {
        return tokenRecuperacion;
    }

    public void setTokenRecuperacion(String tokenRecuperacion) {
        this.tokenRecuperacion = tokenRecuperacion;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public int getVisualizacionesConsumidas() {
        return visualizacionesConsumidas;
    }

    public void setVisualizacionesConsumidas(int visualizacionesConsumidas) {
        this.visualizacionesConsumidas = visualizacionesConsumidas;
    }

    public String getCodigoDesbloqueo() {
        return codigoDesbloqueo;
    }

    public void setCodigoDesbloqueo(String codigoDesbloqueo) {
        this.codigoDesbloqueo = codigoDesbloqueo;
    }
}