package Moteurs.core;

import java.awt.event.KeyEvent;

/**
 * Interface liant les événements clavier au moteur noyau
 */
public interface CoreEngineEvent {

    void sendKeyEvent(KeyEvent keyEvent);

}
