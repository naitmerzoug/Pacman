package Moteurs;

import Moteurs.core.CoreEntity;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public interface Game {

    void getKeyEvent(KeyEvent keyEvent);

    void sendCollisionList(CoreEntity coreEntity, ArrayList<CoreEntity> coreEntities);

}
