/**
 * 
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import equipo.Defensa;
import equipo.Futbolista;
import equipo.Gestion;
import equipo.Portero;
import equipo.excepciones.AptitudNoValidaExecption;
import equipo.excepciones.CadenaVaciaException;
import equipo.excepciones.DniInvalidoExceptions;
import equipo.excepciones.FechaNegativoException;
import equipo.excepciones.JugadorNoExiste;
import equipo.excepciones.JugadorYaExisteExeption;
import equipo.excepciones.NoEsDecimalException;
import equipo.excepciones.NumeroNegativoException;
import equipo.excepciones.PieNoValidaExecption;
import utilesFechas.Fecha;
import utilesFechas.FechaNoValidaException;
import utilesFechas.FormatoNoValidoException;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */

public class AddMedio extends VentanaPadre {

	protected final JPanel contentPanel = new JPanel();
	protected JSpinner jugadCorSpinner;
	protected JSpinner panaltilesSpinner;

	/**
	 * Create the dialog.
	 */
	public AddMedio() {
		super();
		diestroButton.setSelected(true);
		setTitle("Añadir centrocampista");
		super.alanteButton.setVisible(false);
		super.atrasButton.setVisible(false);
		super.mostrarButton.setVisible(false);
		super.eliminarButton.setVisible(false);

		setBounds(100, 100, 543, 301);
		getContentPane().setLayout(null);
		contentPanel.setBounds(5, 281, 505, 20);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		panaltilesSpinner = new JSpinner();
		panaltilesSpinner.setBounds(476, 57, 29, 20);
		panaltilesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		getContentPane().add(panaltilesSpinner);

		jugadCorSpinner = new JSpinner();
		jugadCorSpinner.setBounds(476, 97, 29, 20);
		jugadCorSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		getContentPane().add(jugadCorSpinner);

		JLabel numGolesJpiner = new JLabel("Numero de goles");
		numGolesJpiner.setBounds(367, 60, 111, 14);
		getContentPane().add(numGolesJpiner);

		JLabel jugadasSpinner = new JLabel("Numero de pases");
		jugadasSpinner.setBounds(367, 100, 111, 14);
		getContentPane().add(jugadasSpinner);
	}

	@Override
	protected void addFutbolista() {

		int numPases = (Integer) jugadCorSpinner.getModel().getValue();
		int numGoles = (Integer) panaltilesSpinner.getModel().getValue();

		try {
			Gestion.addMedio(nombreText.getText(), apellidoText.getText(),
					(Integer) dorsalSpinner.getModel().getValue(), dniText.getText(), pieBueno(), apCombobox(),
					new Fecha(fechaText.getText()), super.extraerSalarioValido(), numPases, numGoles);
			JOptionPane.showMessageDialog(this, "Medio añadido correctamente", "Jugador añadido",
					JOptionPane.INFORMATION_MESSAGE);
			//Gestion.setModificado(true);
		} catch (NoEsDecimalException | DniInvalidoExceptions | CadenaVaciaException | AptitudNoValidaExecption
				| PieNoValidaExecption | NumeroNegativoException | FechaNegativoException | JugadorYaExisteExeption
				| JugadorNoExiste | FormatoNoValidoException | FechaNoValidaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
