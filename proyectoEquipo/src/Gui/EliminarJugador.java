/**
 * 
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import equipo.Gestion;
import equipo.excepciones.CadenaVaciaException;
import equipo.excepciones.DniInvalidoExceptions;
import equipo.excepciones.JugadorNoExiste;
import equipo.excepciones.NumeroNegativoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class EliminarJugador extends MostrarUnJugador {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public EliminarJugador() {
		super(true);
		setTitle("Elimina un jugador");
		eliminarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarJugadorDni();
			}

		});
		super.eliminarButton.setVisible(true);
		super.salirButton.setVisible(true);
		setBounds(100, 100, 553, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}

	private void eliminarJugadorDni() {
		try {
			int op = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el jugador?", "Eliminado..", JOptionPane.YES_NO_OPTION);
			if (op == JOptionPane.YES_OPTION) {

				Gestion.eliminar(super.dniText.getText());
				limpiarCamposJugador();
				JOptionPane.showMessageDialog(this, "Jugador eliminado correctamente", "Jugador eliminado",
						JOptionPane.INFORMATION_MESSAGE);
				
				Gestion.setModificado(true);
			}
		} catch (JugadorNoExiste | NumeroNegativoException | DniInvalidoExceptions | CadenaVaciaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * 
	 */
	private void limpiarCamposJugador() {
		super.nombreText.setText("");
		//super.apellidoText.setText("");
		super.dniText.setText("");
		super.fechaText.setText("");
		super.dorsalSpinner.setValue(1);
		super.apComboBox.setSelectedIndex(-1);
		super.diestroButton.setSelected(false);
		super.zurdoButton.setSelected(false);
		super.ambidiestroButton.setSelected(false);
		super.primerJlabel.setVisible(false);
		super.segundoJLabel.setVisible(false);
		super.tercerJLabel.setVisible(false);
		super.primeroSpinner.setVisible(false);
		super.segundoSpinner.setVisible(false);
		super.tercerSpinner.setVisible(false);
	}
}
