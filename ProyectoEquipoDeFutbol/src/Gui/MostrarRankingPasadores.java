/**
 * 
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import equipo.Futbolista;
import equipo.Gestion;
import equipo.Goleadores;
import equipo.MedioCentro;

/**
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class MostrarRankingPasadores extends MostrarUnJugador {
	/**
	 * @param unJugador
	 */
	public MostrarRankingPasadores(boolean unJugador) {
		super(unJugador);
		// TODO Auto-generated constructor stub
	}

	private ListIterator<MedioCentro> it;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public MostrarRankingPasadores() {
		super(false);
		setTitle("Ranking de pasadores");
		setBounds(100, 100, 571, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}
	@Override
	protected void listaJugadores(){
		alanteButton.setVisible(true);
		atrasButton.setVisible(true);
		mostrarButton.setVisible(false);
		
		super.dniText.setEditable(false);
		it= Gestion.getEquipo().maximosPasadores().listIterator();
		super.f=it.next();
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
	@Override
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
	@Override
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
}
