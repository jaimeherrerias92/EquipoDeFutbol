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
public class AddDefensa extends VentanaPadre {

	protected final JPanel contentPanel = new JPanel();
	protected JSpinner porteria0Spiner;
	protected JSpinner jugadCorSpinner;
	protected JSpinner panaltilesSpinner;

	/**
	 * Create the dialog.
	 */
	public AddDefensa() {
		super();
		diestroButton.setSelected(true);
		setTitle("Añadir defensa");
		super.alanteButton.setVisible(false);
		super.atrasButton.setVisible(false);
		super.mostrarButton.setVisible(false);
		super.eliminarButton.setVisible(false);
		setBounds(100, 100, 549, 301);
		getContentPane().setLayout(null);
		contentPanel.setBounds(5, 281, 505, 20);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		panaltilesSpinner = new JSpinner();
		panaltilesSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panaltilesSpinner.setBounds(476, 57, 29, 20);
		getContentPane().add(panaltilesSpinner);

		jugadCorSpinner = new JSpinner();
		jugadCorSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		jugadCorSpinner.setBounds(476, 97, 29, 20);
		getContentPane().add(jugadCorSpinner);

		porteria0Spiner = new JSpinner();
		porteria0Spiner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		porteria0Spiner.setBounds(476, 140, 29, 20);
		getContentPane().add(porteria0Spiner);

		JLabel lblNumeroPenaltis = new JLabel("Numero penaltis");
		lblNumeroPenaltis.setBounds(367, 60, 111, 14);
		getContentPane().add(lblNumeroPenaltis);

		JLabel jugadasSpinner = new JLabel("Jugadas cortadas");
		jugadasSpinner.setBounds(367, 100, 85, 14);
		getContentPane().add(jugadasSpinner);

		JLabel porteriaCeroSpinner = new JLabel("Porteria a cero");
		porteriaCeroSpinner.setBounds(367, 143, 85, 14);
		getContentPane().add(porteriaCeroSpinner);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 627, 270);
		getContentPane().add(label);
	}

	@Override
	protected void addFutbolista() {
		int numPenaltis = (Integer) panaltilesSpinner.getModel().getValue();
		int jugadCortadas = (Integer) jugadCorSpinner.getModel().getValue();
		int porteriaACero = (Integer) porteria0Spiner.getModel().getValue();

		try {
			Gestion.addDefensa(nombreText.getText(), apellidoText.getText(),
					(Integer) dorsalSpinner.getModel().getValue(), dniText.getText(), pieBueno(), apCombobox(),
					new Fecha(fechaText.getText()), extraerSalarioValido(), numPenaltis, jugadCortadas, porteriaACero);
			JOptionPane.showMessageDialog(this, "Defensa añadido correctamente", "Jugador añadido",
					JOptionPane.INFORMATION_MESSAGE);
			//Gestion.setModificado(true);
		} catch (NoEsDecimalException | DniInvalidoExceptions | CadenaVaciaException | AptitudNoValidaExecption
				| PieNoValidaExecption | NumeroNegativoException | FechaNegativoException | JugadorYaExisteExeption
				| JugadorNoExiste | FormatoNoValidoException | FechaNoValidaException e) {
			JOptionPane.showMessageDialog(this,e.getMessage(), "Error",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
