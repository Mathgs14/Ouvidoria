/**
 * The Auth class represents the authentication system in the feedback system.
 * It holds information about the currently active user.
 */
package util;

import entities.Usuario;

public class Auth {
    private Usuario currentActive;

    /**
     * Retrieves the currently active user.
     * @return The currently active user
     */
    public Usuario getCurrentActive() {
        return currentActive;
    }

    /**
     * Sets the currently active user.
     * @param currentActive The user to be set as currently active
     */
    public void setCurrentActive(Usuario currentActive) {
        this.currentActive = currentActive;
    }
}
