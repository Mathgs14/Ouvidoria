package util;

import entities.Usuario;


public class Auth {
    private Usuario currentActive;

    public Usuario getCurrentActive() {
        return currentActive;
    }

    public void setCurrentActive(Usuario currentActive) {
        this.currentActive = currentActive;
    }


}
