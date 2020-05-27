package EasyBooking.LP;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

 
public class JPanelConFondo extends JPanel {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Image imagen;
	 
	    public JPanelConFondo() {
	    }
	 
	    public JPanelConFondo(String nombreImagen) {
	        if (nombreImagen != null) {
	            imagen = new ImageIcon(nombreImagen).getImage();
	        }
	    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
                        this);
 
        setOpaque(false);
        super.paint(g);
    }
 

}