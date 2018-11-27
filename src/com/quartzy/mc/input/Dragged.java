package com.quartzy.mc.input;

import java.awt.event.MouseEvent;

public interface Dragged {

    void dragged(MouseEvent e);
    void draggingFinished(MouseEvent e);

}
