package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana de ayuda en el proyecto
 * 
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Ayuda");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 589, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 573, 330);
		contentPanel.add(scrollPane);

		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.setContentType("text/html");
		editor.setText(
				"<h1>Ayuda para el equipo de futbol</h1><h2>Archivo:</h2><li>Contiene todo para la gestion de archivos</li><ol><b>Guardar</b>(Ctrl+g) Sobreescribe el archivo</ol><ol><b>Guardar Como</b>(Ctrl+o) Guarda el archivo </ol><ol><b>Abrir</b>(Ctrl+a) Abre el archivo guardado con anterioridad</ol><ol><b>Salir</b>(Ctrl+x)Sale y guarda el programa</ol><h2>Gestion:</h2><li>Gestionamos el equipo de futbol</li><ol><b>A&ntilde;adir jugador</b><ol><b>A&ntilde;adir portero</b>Agrega un jugador de tipo portero</ol><ol><b>A&ntilde;adir defensa</b>Agrega un jugador de tipo defensa</ol><ol><b>A&ntilde;adir medioCentro</b>Agrega un jugador de tipo mediocentro</ol><ol><b>A&ntilde;adir delantero</b>Agrega un jugador de tipo delantero</ol><ol><b>Eliminar</b> Elimina un jugador ya creado</ol><h2>Mostrar</h2><li>Muestra los jugadores segun decidamos</li><ol><b>Mostrar un jugador</b>Muestra todos los jugadores con dos botones siguientes y anterior</ol><ol><b>Mostrar por posicion</b>Muestra los jugadores en su posicion(delanteros, defensas etc) </ol><ol><b>Mostrar ranking por goleadores</b>Muestra el ranking de goleadores</ol><ol><b>Mostrar ranking de pasadores</b>Muestra el ranking de los jugadores con mayor pases</ol><ol><b>Mostrar un jugador</b>Muestra un jugador por dni</ol><ol><b>Muostrar  numero de jugadores</b>Muestra un jugador por dni</ol><h2>Ayuda</h2><ol><b>Ver ayuda</b> En donde estas ahora</ol><ol><b>Acerca de </b> version</ol>");
		scrollPane.setViewportView(editor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Atr\u00E1s");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
