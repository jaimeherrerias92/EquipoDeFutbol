/**
 * 
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import equipo.Defensa;
import equipo.Delantero;
import equipo.Futbolista;
import equipo.Gestion;
import equipo.Goleadores;
import equipo.MedioCentro;
import equipo.PieBueno;
import equipo.Portero;
import utilesFechas.FechaFuturaException;

import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerNumberModel;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class MostrarListaPorPosicion extends MostrarUnJugador {
	
	private int posicionFutbolista = 4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected Futbolista f;
	private ListIterator<Futbolista> it;
	protected JRadioButton medioButton;

	protected JRadioButton defensaButton;
	protected JRadioButton delanteroButton;
	protected JRadioButton porteroButton;

	/**
	 * Create the dialog.
	 */
	public MostrarListaPorPosicion() {

		super(false);
		dorsalSpinner.setModel(new SpinnerNumberModel(1, 1, 101, 1));
		setTitle("Mostrar jugadores por posicion");
		limpiarCampos();
		super.alanteButton.setEnabled(false);

		super.mostrarButton.setVisible(false);

		super.jugadorText.setVisible(false);
		super.tipoJugadorText.setVisible(false);
		super.mostrarButton.setBounds(354, 261, 89, 23);
		super.salirButton.setBounds(446, 261, 89, 23);
		alanteButton.setBounds(303, 261, 41, 23);
		atrasButton.setBounds(243, 261, 41, 23);
		setBounds(100, 100, 571, 338);

		JPanel posicionJugador = new JPanel();

		posicionJugador.setLayout(null);
		posicionJugador
				.setBorder(new TitledBorder(null, "Posicion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		posicionJugador.setBounds(191, 149, 230, 75);
		getContentPane().add(posicionJugador);

		defensaButton = new JRadioButton("Defensa");
		defensaButton.addMouseListener(new MouseAdapter() {

		});

		buttonGroup.add(defensaButton);
		defensaButton.setBounds(6, 48, 93, 23);
		posicionJugador.add(defensaButton);
		defensaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarDefensa();
			}
		});
		medioButton = new JRadioButton("Medio");
		buttonGroup.add(medioButton);
		medioButton.setBounds(102, 19, 66, 23);
		posicionJugador.add(medioButton);

		medioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarMedio();
			}
		});

		delanteroButton = new JRadioButton("Delantero");

		buttonGroup.add(delanteroButton);
		delanteroButton.setBounds(101, 48, 94, 23);
		posicionJugador.add(delanteroButton);
		delanteroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mmostrarDelantero();
			}

		});
		porteroButton = new JRadioButton("Portero");

		buttonGroup.add(porteroButton);
		porteroButton.setBounds(6, 20, 93, 23);
		posicionJugador.add(porteroButton);
		porteroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPortero();
			}

		});
	}

	/**
	 * 
	 */
	private void limpiarCampos() {
		super.nombreText.setText("");
		super.apellidoText.setText("");
		super.fechaText.setText("");
		super.ambidiestroButton.setSelected(false);
		super.diestroButton.setSelected(false);
		super.zurdoButton.setSelected(false);
		super.primeroSpinner.setVisible(false);
		super.primerJlabel.setVisible(false);
		super.segundoJLabel.setVisible(false);
		super.segundoSpinner.setVisible(false);
		super.tercerJLabel.setVisible(false);
		super.tercerSpinner.setVisible(false);
		super.sueltoFinalText.setText("");
		super.sueldoText.setText("");
		super.dniText.setText("");
		super.apComboBox.removeAllItems();
		super.dorsalSpinner.setValue(1);

	}

	@Override
	protected void listaJugadores() {
		alanteButton.setVisible(true);
		atrasButton.setVisible(true);
		mostrarButton.setVisible(false);

		super.dniText.setEditable(false);

		it = mostrarPosicion();
		f = it.next();
		mostrarDatos();
		if (it.hasNext())
			alanteButton.setEnabled(true);
		else
			alanteButton.setEnabled(false);
		atrasButton.setEnabled(false);
	}

	/**
	 * @return
	 */
	private ListIterator<Futbolista> mostrarPosicion() {
		if (posicionFutbolista == 1)
			return Gestion.getEquipo().obtenerDelanteros().listIterator();
		else if (posicionFutbolista == 2)
			return Gestion.getEquipo().obtenerMedios().listIterator();
		else if (posicionFutbolista == 3)
			return Gestion.getEquipo().mostrarDefensa().listIterator();

		return Gestion.getEquipo().mostrarPorteros().listIterator();
	}

	/**
	 * 
	 */
	@Override
	protected void anterior() {
		Futbolista fAux = f;
		f = it.previous();

		if (fAux.equals(f))
			f = it.previous();
		mostrarDatos();
		if (it.hasPrevious())
			atrasButton.setEnabled(true);
		else
			atrasButton.setEnabled(false);
		alanteButton.setEnabled(true);
	}

	/**
	 * 
	 */
	@Override
	protected void adelante() {
		Futbolista fAux = f;
		f = it.next();
		if (fAux.equals(f))
			f = it.next();

		mostrarDatos();
		if (it.hasNext()) {
			alanteButton.setEnabled(true);
		} else
			alanteButton.setEnabled(false);
		atrasButton.setEnabled(true);

	}

	private void mmostrarDelantero() {
		if (Gestion.mostrarNumeroDeDelanteros() == 0) {
			JOptionPane.showMessageDialog(this, "No hay delanteros para mostrar", "No hay delanteros",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCampos();
		} else {
			setTitle("Mostrando delanteros..");
			posicionFutbolista = 1;
			listaJugadores();
		}
		

	}

	private void mostrarDefensa() {

		if (Gestion.mostrarNumeroDeDefensas() == 0) {
			JOptionPane.showMessageDialog(this, "No hay defensas para mostrar", "No hay defensas",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCampos();
		} else {
			setTitle("Mostrando defensas..");
			posicionFutbolista = 3;
			listaJugadores();
		}

	}

	private void mostrarPortero() {

		if (Gestion.mostrarNumeroDePorteros() == 0) {
			JOptionPane.showMessageDialog(this, "No hay porteros para mostrar", "No hay porteros",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCampos();
		} else {
			setTitle("Mostrando porteros..");
			posicionFutbolista = 4;
			listaJugadores();
		}
	}

	private void mostrarMedio() {

		if (Gestion.mostrarNumeroDeMedios() == 0) {
			JOptionPane.showMessageDialog(this, "No hay medios para mostrar", "No hay medios",
					JOptionPane.INFORMATION_MESSAGE);
			limpiarCampos();
		} else {
			setTitle("Mostrando medios..");
			posicionFutbolista = 2;
			listaJugadores();
		}

	}

	@Override
	protected void mostrarDatos() {
		rellenarCamposComunes();
		if (f.getClass() == Portero.class)
			rellenarCampoPortero();
		else if (f.getClass() == Defensa.class)
			rellenarCampoDefensa();
		else if (f.getClass() == MedioCentro.class)
			rellenarCampoMedioCentro();
		else if (f.getClass() == Delantero.class)
			rellenarCampoDelantero();

	}

	@Override
	protected void rellenarCampoPortero() {
		Portero p = (Portero) f;

		primeroSpinner.setVisible(true);
		tercerSpinner.setVisible(true);
		segundoSpinner.setVisible(true);
		primerJlabel.setVisible(true);
		segundoJLabel.setVisible(true);
		tercerJLabel.setVisible(true);

		primeroSpinner.setValue(p.getGolesEncajados());
		segundoSpinner.setValue(p.getNumParadas());
		tercerSpinner.setValue(p.getPorteriaACero());

		try {
			super.sueltoFinalText.setText(String.valueOf(p.getSalarioTotal()));
		} catch (FechaFuturaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	protected void rellenarCampoDefensa() {
		Defensa def = (Defensa) f;

		primeroSpinner.setVisible(true);
		tercerSpinner.setVisible(true);
		segundoSpinner.setVisible(true);
		primerJlabel.setVisible(true);
		segundoJLabel.setVisible(true);
		tercerJLabel.setVisible(true);

		primerJlabel.setText("Numero de penaltis");
		segundoJLabel.setText("Jugadas cortadas");
		tercerJLabel.setText("Porteria a cero");
		primeroSpinner.setValue(def.getNumPenaltis());
		segundoSpinner.setValue(def.getJugCortadas());
		tercerSpinner.setValue(def.getPorteriaACero());

		try {
			super.sueltoFinalText.setText(String.valueOf(def.getSalarioTotal()));
		} catch (FechaFuturaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	protected void rellenarCampoMedioCentro() {
		MedioCentro m = (MedioCentro) f;

		primeroSpinner.setVisible(true);
		segundoSpinner.setVisible(true);
		primerJlabel.setVisible(true);
		segundoJLabel.setVisible(true);

		primerJlabel.setText("Numero de goles");
		segundoJLabel.setText("Numero de pases");

		primeroSpinner.setValue(m.getNumGoles());
		segundoSpinner.setValue(m.getNumPases());

		try {
			super.sueltoFinalText.setText(String.valueOf(m.getSalarioTotal()));
		} catch (FechaFuturaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void rellenarCampoDelantero() {
		Delantero del = (Delantero) f;
		primeroSpinner.setVisible(true);
		segundoSpinner.setVisible(true);
		primerJlabel.setVisible(true);
		segundoJLabel.setVisible(true);

		primerJlabel.setText("Numero de goles");
		segundoJLabel.setText("Numero de asistencias");

		primeroSpinner.setValue(del.getNumGoles());
		segundoSpinner.setValue(del.getNumAsistencias());
		try {
			super.sueltoFinalText.setText(String.valueOf(del.getSalarioTotal()));
		} catch (FechaFuturaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	protected void rellenarCamposComunes() {
		super.nombreText.setText(f.getNombre());
		super.apellidoText.setText(f.getApellido());
		super.dniText.setText(f.getDni());
		super.fechaText.setText(f.getFecha().toString());
		super.sueldoText.setText(String.valueOf(f.getSueldoBase()));
		addPie();
		super.dorsalSpinner.setValue(f.getDorsal());
		super.apComboBox.removeAllItems();
		super.apComboBox.addItem(f.getAptitud());
	}

	@Override

	protected void addPie() {
		if (f.getPie() == PieBueno.DIESTRO)
			super.diestroButton.setSelected(true);
		else if (f.getPie() == PieBueno.ZURDO)
			super.zurdoButton.setSelected(true);
		else if (f.getPie() == PieBueno.AMBIDIESTRO)
			super.ambidiestroButton.setSelected(true);

	}
}
