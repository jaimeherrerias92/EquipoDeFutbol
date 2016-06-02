/**
 * 
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import equipo.Aptitud;
import equipo.Futbolista;
import equipo.Gestion;
import equipo.PieBueno;
import equipo.excepciones.AptitudNoValidaExecption;
import equipo.excepciones.CadenaVaciaException;
import equipo.excepciones.DniInvalidoExceptions;
import equipo.excepciones.FechaNegativoException;
import equipo.excepciones.NoEsDecimalException;
import equipo.excepciones.NoEsNumeroExeption;
import equipo.excepciones.NumeroNegativoException;
import equipo.excepciones.PieNoValidaExecption;
import utilesFechas.Fecha;
import utilesFechas.FechaNoValidaException;
import utilesFechas.FormatoNoValidoException;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class VentanaPadre extends JDialog {
	protected static JDialog dialog;
	protected final JPanel contentPanel = new JPanel();
	
	protected ButtonGroup botonPieGrupo = new ButtonGroup();
	protected JPanel contentPane;
	protected JTextField nombreText;
	protected JTextField apellidoText;
	protected JTextField dniText;
	protected JTextField fechaText;
	protected JTextField sueldoText;
	protected JLabel label;
	protected JLabel label_1;
	protected JLabel label_2;
	protected JLabel label_3;
	protected JLabel lblFechaDeRegistro;
	protected JSpinner dorsalSpinner;
	protected JLabel lblSueldoBase;
	protected JPanel panel;
	protected JRadioButton diestroButton;
	protected JRadioButton zurdoButton;
	protected JButton mostrarButton;
	protected JButton addButton;
	protected JRadioButton ambidiestroButton;
	protected JComboBox apComboBox; 
	protected JButton eliminarButton; 
	protected JButton alanteButton;
	protected JButton atrasButton;
	protected JButton salirButton;
	protected JLabel lblAptitud;
	protected JTextField sueltoFinalText;
	protected JLabel lblSueldoFinal;



	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
			setModal(true);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					setVisible(false);
				}
			});
			
			
			setResizable(false);
			setModalityType(DEFAULT_MODALITY_TYPE);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setBounds(100, 100, 551, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			label = new JLabel("Nombre");
			label.setBounds(10, 17, 46, 14);
			contentPane.add(label);

			nombreText = new JTextField();
			nombreText.setBounds(74, 14, 86, 20);
			nombreText.setColumns(10);
			contentPane.add(nombreText);

			label_1 = new JLabel("Apellido");
			label_1.setBounds(10, 52, 46, 14);
			contentPane.add(label_1);

			apellidoText = new JTextField();
			apellidoText.setBounds(74, 49, 86, 20);
			apellidoText.setColumns(10);
			contentPane.add(apellidoText);

			label_2 = new JLabel("DNI");
			label_2.setBounds(10, 92, 46, 14);
			contentPane.add(label_2);
			label_3 = new JLabel("Dorsal");
			label_3.setBounds(10, 124, 46, 14);
			contentPane.add(label_3);

			lblFechaDeRegistro = new JLabel("Fecha de registro");
			lblFechaDeRegistro.setBounds(141, 124, 127, 14);
			contentPane.add(lblFechaDeRegistro);

			dorsalSpinner = new JSpinner();
			dorsalSpinner.setBounds(74, 121, 46, 20);
			dorsalSpinner.setModel(new SpinnerNumberModel(1, 1, 99, 1));
			contentPane.add(dorsalSpinner);

			dniText = new JTextField();
			dniText.setBounds(74, 86, 86, 20);
			dniText.setColumns(10);
			contentPane.add(dniText);

			fechaText = new JTextField();
			fechaText.setBounds(278, 124, 86, 20);
			fechaText.setColumns(10);
			contentPane.add(fechaText);

			lblSueldoBase = new JLabel("Sueldo base");
			lblSueldoBase.setBounds(10, 164, 74, 14);
			contentPane.add(lblSueldoBase);

			sueldoText = new JTextField();
			sueldoText.setBounds(94, 161, 86, 20);
			sueldoText.setColumns(10);
			contentPane.add(sueldoText);

			panel = new JPanel();
			panel.setBounds(183, 14, 121, 98);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Pie Bueno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(panel);

			diestroButton = new JRadioButton("Diestro");

			diestroButton.setBounds(6, 16, 109, 23);
			panel.add(diestroButton);
			botonPieGrupo.add(diestroButton);

			zurdoButton = new JRadioButton("Zurdo");

			zurdoButton.setBounds(6, 42, 109, 23);
			panel.add(zurdoButton);
			botonPieGrupo.add(zurdoButton);

			ambidiestroButton = new JRadioButton("Ambidiestro");

			ambidiestroButton.setBounds(6, 68, 109, 23);
			panel.add(ambidiestroButton);
			botonPieGrupo.add(ambidiestroButton);

			apComboBox = new JComboBox();
			apComboBox.setBounds(384, 11, 121, 20);
			contentPane.add(apComboBox);
			apComboBox.setModel(new DefaultComboBoxModel<>(Aptitud.getValues()));

			addButton = new JButton("A\u00F1adir");
			addButton.setBounds(354, 226, 89, 23);
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addFutbolista();
				}

			});
			contentPane.add(addButton);
			
			lblAptitud = new JLabel("Aptitud");
			lblAptitud.setBounds(327, 14, 60, 14);
			contentPane.add(lblAptitud);
			
			
			
			salirButton = new JButton("Salir");
			salirButton.setBounds(446, 226, 89, 23);
			salirButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			contentPane.add(salirButton);
			 
			atrasButton = new JButton("<");
			atrasButton.setBounds(243, 226, 41, 23);
			contentPane.add(atrasButton);
		
			alanteButton = new JButton(">");
			alanteButton.setBounds(303, 226, 41, 23);
			contentPane.add(alanteButton);
			
			eliminarButton = new JButton("Eliminar");
			eliminarButton.setBounds(150, 226, 89, 23);
			contentPane.add(eliminarButton);
			
			mostrarButton = new JButton("Mostrar");
			mostrarButton.setBounds(51, 226, 89, 23);
			contentPane.add(mostrarButton);
			
			lblSueldoFinal = new JLabel("Sueldo final");
			lblSueldoFinal.setVisible(false);
			lblSueldoFinal.setBounds(10, 198, 74, 14);
			contentPane.add(lblSueldoFinal);
			
			sueltoFinalText = new JTextField();
			sueltoFinalText.setVisible(false);
			sueltoFinalText.setEnabled(false);
			sueltoFinalText.setEditable(false);
			sueltoFinalText.setColumns(10);
			sueltoFinalText.setBounds(94, 195, 86, 20);
			contentPane.add(sueltoFinalText);

		}

		protected void addFutbolista() {
			Futbolista f = null;
			try {
				f = new Futbolista(nombreText.getText(), apellidoText.getText(),
						(Integer) dorsalSpinner.getModel().getValue(), dniText.getText(), pieBueno(), apCombobox(),
						extraerSalarioValido(), new Fecha(fechaText.getText()));
			} catch ( DniInvalidoExceptions | CadenaVaciaException | AptitudNoValidaExecption
					| PieNoValidaExecption | NumeroNegativoException | FechaNegativoException | FormatoNoValidoException
					| FechaNoValidaException | NoEsDecimalException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		public double extraerSalarioValido() throws  NoEsDecimalException{
			double salario=0;
		try {
			salario = Double.parseDouble(sueldoText.getText());
		} catch ( NumberFormatException e)
		{
			throw new NoEsDecimalException("No es un decimal");
		}

			return  salario;
		}

		/**
		 * @return
		 */
		protected Aptitud apCombobox() {
			Aptitud ap = (Aptitud) apComboBox.getSelectedItem();
			if (ap == null)
				ap = Aptitud.DESTRUCTOR;
			return ap;
		}

		/**
		 * @return
		 */
		public PieBueno pieBueno() {
			
			if (zurdoButton.isSelected())
				return PieBueno.ZURDO;
			if (ambidiestroButton.isSelected())
				return PieBueno.AMBIDIESTRO;
			return PieBueno.DIESTRO;
		}
	}
