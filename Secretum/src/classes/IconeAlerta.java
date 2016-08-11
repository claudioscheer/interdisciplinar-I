package classes;

import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IconeAlerta {

    Dialog d;
    Window w;

    public IconeAlerta(Window w) {
        this.w = w;
    }

    public void alertar() {
        d = new Dialog(w);
        d.setUndecorated(true);
        d.setSize(0, 0);
        d.setModal(false);

        d.addWindowFocusListener(new WindowAdapter() {

            @Override
            public void windowGainedFocus(WindowEvent e) {
                w.requestFocus();
                d.setVisible(false);
                super.windowGainedFocus(e);
            }
        });

        w.addWindowFocusListener(new WindowAdapter() {

            @Override
            public void windowGainedFocus(WindowEvent e) {
                d.setVisible(false);
                super.windowGainedFocus(e);
            }
        });

        if (!w.isFocused()) {
            d.setVisible(false);
        }
        d.setLocation(0, 0);
        d.setLocationRelativeTo(w);
        d.setVisible(true);
    }
}
