/**
 * 
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import equipo.Aptitud;
import equipo.Defensa;
import equipo.Delantero;
import equipo.Equipo;
import equipo.Futbolista;
import equipo.Gestion;
import equipo.MedioCentro;
import equipo.PieBueno;
import equipo.Portero;
import equipo.excepciones.CadenaVaciaException;
import equipo.excepciones.DniInvalidoExceptions;
import equipo.excepciones.JugadorNoExiste;
import equipo.excepciones.NumeroNegativoException;
import utilesFechas.Fecha;
import utilesFechas.FechaFuturaException;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class MostrarUnJugador extends VentanaPadre {
	protected JTextField tipoJugadorText;

	protected JLabel jugadorText;
	protected JLabel primerJlabel;
	protected JSpinner primeroSpinner;
	protected JLabel segundoJLabel;
	protected JSpinner segundoSpinner;
	protected JLabel tercerJLabel;
	protected JSpinner tercerSpinner;
	protected Futbolista f;
	protected ListIterator<Futbolista> it;
	//private String[] posiciones;
	
	/**
	 * Create the dialog.
	 */
	public MostrarUnJugador(boolean unJugador) {
		
		
		alanteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adelante();
			}
		});
		atrasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anterior();
			}
		});
		
		
		int itemCount = super.apComboBox.getItemCount();

		super.apComboBox.removeAllItems();
		super.sueltoFinalText.setVisible(true);
		
		super.alanteButton.setVisible(false);
		super.atrasButton.setVisible(false);
		super.eliminarButton.setVisible(false);
		super.addButton.setVisible(false);
		ambidiestroButton.setEnabled(false);
		zurdoButton.setEnabled(false);
		diestroButton.setEnabled(false);
		apComboBox.setEnabled(false);
		dorsalSpinner.setEnabled(false);
		fechaText.setEditable(false);
		sueldoText.setEditable(false);
		apellidoText.setEditable(false);
		nombreText.setEditable(false);
	
		diestroButton.setSelected(false);

		setBounds(100, 100, 548, 300);
		getContentPane().setLayout(null);

		jugadorText = new JLabel("Tipo de jugador");
		jugadorText.setBounds(193, 163, 107, 14);
		getContentPane().add(jugadorText);

		tipoJugadorText = new JTextField();
		tipoJugadorText.setEditable(false);
		tipoJugadorText.setBounds(279, 160, 86, 20);
		getContentPane().add(tipoJugadorText);
		tipoJugadorText.setColumns(10);

		primerJlabel = new JLabel("Goles encajados");
		primerJlabel.setVisible(false);
		primerJlabel.setBounds(376, 60, 111, 14);
		getContentPane().add(primerJlabel);
		

		primeroSpinner = new JSpinner();
		primeroSpinner.setEnabled(false);
		primeroSpinner.setVisible(false);
		primeroSpinner.setBounds(493, 57, 39, 20);
		getContentPane().add(primeroSpinner);

		segundoJLabel = new JLabel("Numero de paradas");
		segundoJLabel.setEnabled(false);
		segundoJLabel.setVisible(false);
		segundoJLabel.setBounds(376, 100, 123, 14);
		getContentPane().add(segundoJLabel);

		segundoSpinner = new JSpinner();
		segundoSpinner.setEnabled(false);
		segundoSpinner.setVisible(false);
		segundoSpinner.setBounds(493, 97, 39, 20);
		getContentPane().add(segundoSpinner);

		tercerJLabel = new JLabel("Porteria a cero");
		tercerJLabel.setVisible(false);
		tercerJLabel.setBounds(376, 143, 111, 14);
		getContentPane().add(tercerJLabel);

		tercerSpinner = new JSpinner();
		tercerSpinner.setEnabled(false);
		tercerSpinner.setVisible(false);
		tercerSpinner.setBounds(493, 140, 39, 20);
		getContentPane().add(tercerSpinner);
		
		JLabel lblSueloFinal = new JLabel("Suelo final");
		lblSueloFinal.setBounds(10, 202, 91, 14);
		getContentPane().add(lblSueloFinal);
		
		if (unJugador) {
			setTitle("Mostrar un jugador");
			mostrarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarUnJugador();
				}

			});
		} else {
			setTitle("Todos los jugadores");
			listaJugadores();
		}
		
	}



	protected void listaJugadores() {
		alanteButton.setVisible(true);
		atrasButton.setVisible(true);
		mostrarButton.setVisible(false);
		
		super.dniText.setEditable(false);
		it= Gestion.getEquipo().getFutbolistas().listIterator();
		f=it.next();
		mostrarDatos();
		if (it.hasNext())
			alanteButton.setEnabled(true);
		else
			alanteButton.setEnabled(false);
		atrasButton.setEnabled(false);
	}

	/**
	 * 
	 */
	protected void anterior() {
		Futbolista fAux=f;
		f=it.previous();
		
		if(fAux.equals(f))
			f=it.previous();
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
	protected void adelante() {
		Futbolista fAux=f;
		f=it.next();
		if(fAux.equals(f))
			f=it.next();
		
		mostrarDatos();
		if (it.hasNext()) {
			alanteButton.setEnabled(true);
		}	
		else
			alanteButton.setEnabled(false);
		atrasButton.setEnabled(true);
		
	}

	protected void mostrarUnJugador() {

		try {
				
			try {
				
				f = Gestion.getFutbolista(dniText.getText());

			} catch (JugadorNoExiste e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			mostrarDatos();
		} catch (NumeroNegativoException | DniInvalidoExceptions | CadenaVaciaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void mostrarDatos() {
		rellenarCamposComunes();
		if (f.getClass() == Portero.class) {
			tipoJugadorText.setText("Portero");
		
			rellenarCampoPortero();
		} else if (f.getClass() == Defensa.class) {
			tipoJugadorText.setText("Defensa");
	
			rellenarCampoDefensa();
		} else if (f.getClass() == MedioCentro.class) {
			tipoJugadorText.setText("MedioCentro");

			rellenarCampoMedioCentro();
		} else if (f.getClass() == Delantero.class) {
			tipoJugadorText.setText("Delantero");
		
			rellenarCampoDelantero();
		}
	}

	/**
	 * 
	 */
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
	protected void rellenarCampoMedioCentro() {
		MedioCentro m = (MedioCentro) f;
		
		primeroSpinner.setVisible(true);
		segundoSpinner.setVisible(true);
		primerJlabel.setVisible(true);
		segundoJLabel.setVisible(true);


		primerJlabel.setText("Numero de pases");
		segundoJLabel.setText("Numero de goles");

		primeroSpinner.setValue(m.getNumGoles());
		segundoSpinner.setValue(m.getNumPases());
		
		try {
			super.sueltoFinalText.setText(String.valueOf(m.getSalarioTotal()));
		} catch (FechaFuturaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	
	protected void rellenarCampoDelantero() {
		Delantero del= (Delantero) f;
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
	/**
	 * 
	 */
	protected void rellenarCamposComunes() {
		super.nombreText.setText(f.getNombre());
		super.apellidoText.setText(f.getApellido());
		super.dniText.setText(f.getDni());
		super.fechaText.setText(f.getFecha().toString());
		super.sueldoText.setText(String.valueOf(f.getSueldoBase()));
		
		super.dorsalSpinner.setValue(f.getDorsal());
		addPie();
		super.apComboBox.removeAllItems();
		super.apComboBox.addItem(f.getAptitud());
	}

	
	protected void addPie() {
		if (f.getPie() == PieBueno.DIESTRO)
			super.diestroButton.setSelected(true);
		else if (f.getPie() == PieBueno.ZURDO)
			super.zurdoButton.setSelected(true);
		else if (f.getPie() == PieBueno.AMBIDIESTRO)
			super.ambidiestroButton.setSelected(true);

	}
}