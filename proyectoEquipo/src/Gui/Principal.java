/**
 * 
 */
package Gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.filechooser.FileNameExtensionFilter;

import equipo.Equipo;
import equipo.Fichero;
import equipo.Gestion;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;

/**
 * 
 * @author Jaime Herrerias
 * @version 1.0
 *
 */
public class Principal extends javax.swing.JFrame {

	private JFileChooser guardar = new JFileChooser();

	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos .eqp", "eqp");

	private File file;

	public Principal() {
		
		initComponents();
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				salir();
				
			}
		});
	}

	private void initComponents() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\icon.png"));
		
		jFrame1 = new javax.swing.JFrame();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenuBar3 = new javax.swing.JMenuBar();
		jMenu5 = new javax.swing.JMenu();
		jMenu6 = new javax.swing.JMenu();
		jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		nuevo = new javax.swing.JMenuItem();
		nuevo.setMnemonic('N');
		jMenuItem1 = new javax.swing.JMenuItem();
		guardado = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JPopupMenu.Separator();
		salir = new javax.swing.JMenuItem();

		javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
		jFrame1.getContentPane().setLayout(jFrame1Layout);
		jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE));
		jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE));

		jMenuItem5.setText("jMenuItem5");

		jMenu3.setText("File");
		jMenuBar2.add(jMenu3);

		jMenu4.setText("Edit");
		jMenuBar2.add(jMenu4);

		jMenu5.setText("File");
		jMenuBar3.add(jMenu5);

		jMenu6.setText("Edit");
		jMenuBar3.add(jMenu6);

		jCheckBoxMenuItem2.setSelected(true);
		jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("SinTitulo.eqp");

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		jMenu1.setText("Archivo");

		nuevo.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
		nuevo.setText("Nuevo");
		nuevo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nuevoActionPerformed(evt);
			}
		});
		jMenu1.add(nuevo);

		jMenuItem1.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem1.setText("Guardar");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		guardado.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
		guardado.setText("GuardarComo");
		guardado.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				guardadoActionPerformed(evt);
			}
		});
		jMenu1.add(guardado);

		jMenuItem3.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem3.setText("Abrir");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);
		jMenu1.add(jSeparator1);

		salir.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
		salir.setText("Salir");
		salir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				salirActionPerformed(evt);
			}
		});
		jMenu1.add(salir);

		jMenuBar1.add(jMenu1);

		mnGestion = new JMenu();
		mnGestion.setText("Gestion");
		jMenuBar1.add(mnGestion);

		mnNewMenu = new JMenu("A\u00F1adir jugadores");
		mnGestion.add(mnNewMenu);

		addPortero = new JMenuItem();
		mnNewMenu.add(addPortero);
		addPortero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPorteros(e);
			}

		});
		addPortero.setText("A\u00F1adir portero");

		mntmAadirDefensa = new JMenuItem();
		mntmAadirDefensa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDefensa(arg0);
			}

		});
		mnNewMenu.add(mntmAadirDefensa);
		mntmAadirDefensa.setText("A\u00F1adir defensa");

		mntmAadirDefensa_1 = new JMenuItem();
		mntmAadirDefensa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMedioCampiista(arg0);
			}

		});
		mntmAadirDefensa_1.setText("A\u00F1adir centrocampista");
		mnNewMenu.add(mntmAadirDefensa_1);

		mntmAadirCentrocampista = new JMenuItem();
		mntmAadirCentrocampista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDelantero(e);
			}
		});
		mntmAadirCentrocampista.setText("A\u00F1adir delantero");
		mnNewMenu.add(mntmAadirCentrocampista);

		eliminarJugadorButton = new JMenuItem();
		eliminarJugadorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarFutbolista();
			}

		});
		eliminarJugadorButton.setText("Eliminar jugador");
		mnGestion.add(eliminarJugadorButton);

		setJMenuBar(jMenuBar1);
		
		mnMostrar = new JMenu();
		mnMostrar.setText("Mostrar");
		jMenuBar1.add(mnMostrar);
		
				mostrarListaMenu = new JMenuItem();
				mnMostrar.add(mostrarListaMenu);
				mostrarListaMenu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						mostrarListaJugadores(arg0);
					}

				});
				mostrarListaMenu.setText("Mostrar todos los jugadores");
				
				mostrarPosicion = new JMenuItem();
				mnMostrar.add(mostrarPosicion);
				mostrarPosicion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						mostrarPorPosicion(arg0);
					}

					
				});
				mostrarPosicion.setText("Mostrar por posicion");
				
				maximGoleadores = new JMenuItem();
				mnMostrar.add(maximGoleadores);
				maximGoleadores.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						mostrarRanking(arg0);
					}

					
				});
				maximGoleadores.setText("Mostrar ranking de goleadores");
				
				mntmMostrarRankingDe = new JMenuItem();
				mnMostrar.add(mntmMostrarRankingDe);
				mntmMostrarRankingDe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						mostrarRankingPasadores(arg0);
					}

					
				});
				mntmMostrarRankingDe.setText("Mostrar ranking de pasadores");
				
						mostrarButton = new JMenuItem();
						mnMostrar.add(mostrarButton);
						mostrarButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								mostrarJugadorPorDni();
							}

						});
						mostrarButton.setText("Mostrar un jugador");
						
								mostrarNButton = new JMenuItem();
								mnMostrar.add(mostrarNButton);
								mostrarNButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										numeroDeJugadores(arg0);
									}

								});
								mostrarNButton.setText("Mostrar numero de jugadores");
								jMenu8 = new javax.swing.JMenu();
								numero1 = new javax.swing.JMenuItem();
								numero2 = new javax.swing.JMenuItem();
								
										jMenu8.setText("Ayuda");
										
												numero1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
												numero1.setText("Ver ayuda");
												numero1.addActionListener(new java.awt.event.ActionListener() {
													public void actionPerformed(java.awt.event.ActionEvent evt) {
														numero1ActionPerformed(evt);
													}

												});
												jMenu8.add(numero1);
												
														numero2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
														numero2.setText("Acerca de ...");
														numero2.addActionListener(new java.awt.event.ActionListener() {
															public void actionPerformed(java.awt.event.ActionEvent evt) {
																numero2ActionPerformed(evt);
															}
														});
														jMenu8.add(numero2);
														
																jMenuBar1.add(jMenu8);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/fondoPrincipal1.jpg")));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		guardar();

	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void guardadoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_guardadoActionPerformed
		guardarComo();

	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		actionAbrir();
	}// GEN-LAST:event_jMenuItem3ActionPerformed

	private void salirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_salirActionPerformed

		salir();
	}// GEN-LAST:event_salirActionPerformed

	private void numero2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_numero2ActionPerformed
		new Acerca().setVisible(true);

	}// GEN-LAST:event_numero2ActionPerformed

	private void numero1ActionPerformed(ActionEvent evt) {
		new Ayuda().setVisible(true);

	}

	private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nuevoActionPerformed
		nuevo();
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosed
		salir();
	}// GEN-LAST:event_formWindowClosed

	/**
	 * @param args
	 *            the command line arguments
	 */

	private void numeroDeJugadores(ActionEvent arg0) {
		String cadena = "El numero de jugadores es " + Gestion.numFutbolistas() + "\nEl numero de porteros es "
				+ Gestion.mostrarNumeroDePorteros() + "\nEl numero de defensas es " + Gestion.mostrarNumeroDeDefensas()
				+ "\nEl numero de medios es " + Gestion.mostrarNumeroDeMedios() + "\nEl numero de delanteros es "
				+ Gestion.mostrarNumeroDeDelanteros();
		JOptionPane.showMessageDialog(this, cadena, "Numero de futbolistas", JOptionPane.INFORMATION_MESSAGE);

	}

	private void addPorteros(ActionEvent e) {
		new AddPortero().setVisible(true);

	}

	private void addDefensa(ActionEvent arg0) {
		new AddDefensa().setVisible(true);

	}

	private void addMedioCampiista(ActionEvent arg0) {
		new AddMedio().setVisible(true);

	}

	private void addDelantero(ActionEvent arg0) {
		new AddDelantero().setVisible(true);

	}

	private void mostrarListaJugadores(ActionEvent arg0) {
		if (Gestion.numFutbolistas() == 0)
			JOptionPane.showMessageDialog(this, "Aun no has añadido ningun jugador a la lista", "Error",
					JOptionPane.ERROR_MESSAGE);
		else
			new MostrarUnJugador(false).setVisible(true);

	}
	private void mostrarRankingPasadores(ActionEvent arg0) {
		
			if (Gestion.numPasadores() == 0)
				JOptionPane.showMessageDialog(this, "Aun no hay jugadores en la lista", "Error",
						JOptionPane.ERROR_MESSAGE);
			else
				new MostrarRankingPasadores().setVisible(true);
			
		

		
	}
	private void mostrarRanking(ActionEvent arg0) {
		if (Gestion.numGoleadores() == 0)
			JOptionPane.showMessageDialog(this, "Aun no hay jugadores en la lista", "Error",
					JOptionPane.ERROR_MESSAGE);
		else
			new MostrarRankingGoleadores().setVisible(true);
		
	}

	private void mostrarJugadorPorDni() {
		if (Gestion.numFutbolistas() == 0)
			JOptionPane.showMessageDialog(this, "Aun no has añadido ningun jugador a la lista", "Error",
					JOptionPane.ERROR_MESSAGE);
		else
			new MostrarUnJugador(true).setVisible(true);

	}

	private void eliminarFutbolista() {
		if (Gestion.numFutbolistas() == 0)
			JOptionPane.showMessageDialog(this, "Aun no has añadido ningun jugador a la lista", "Error",
					JOptionPane.ERROR_MESSAGE);
		else
			new EliminarJugador().setVisible(true);
	}
	
	private void mostrarPorPosicion(ActionEvent arg0) {
		if (Gestion.numFutbolistas() == 0)
			JOptionPane.showMessageDialog(this, "Aun no has añadido ningun jugador a la lista", "Error",
					JOptionPane.ERROR_MESSAGE);
		else
			new MostrarListaPorPosicion().setVisible(true);
		
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				Principal equipo = new Principal();
				equipo.setLocationRelativeTo(null);
				equipo.setVisible(true);
			}
		});

	}
	
	
	private void salir() {
		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo, "¿Deseas guardar el equipo?");
			if (opcion == JOptionPane.YES_OPTION) {
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(this);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					
					try {
						Fichero.guardar(Gestion.getEquipo(), file);
						System.exit(0);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(this, "El archivo no se ha encontrado", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(this, "Error en lectura o escritura del fichero", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (opcion == JFileChooser.CANCEL_OPTION)
					nuevo.setVisible(false);
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else if(opcion ==3)
				nuevo.setVisible(false);
		} else
			System.exit(0);
	}

	
	private void nuevo() {

		Equipo equipoFutbol = Gestion.getEquipo();

		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo, "¿Deseas guardar el equipo?");
			if (opcion == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(this);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(Gestion.getEquipo(), file);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(this, "El archivo no se ha encontrado", "Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(this, "Error en lectura o escritura del fichero", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (opcion == JFileChooser.CANCEL_OPTION)
					nuevo.setVisible(false);
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else {
				equipoFutbol = new Equipo();
				setTitle("SinTítulo.eqp");
			}
		} else {
			equipoFutbol = new Equipo();
			setTitle("SinTítulo.eqp");
		}
	}

	private void actionAbrir() {
		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo, "¿Deseas guardar el equipo?");
			if (opcion == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(this);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(Gestion.getEquipo(), file);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(this, "El archivo no se ha encontrado", "Error",
								JOptionPane.ERROR_MESSAGE);
					
						
						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(this, "Error en lectura o escritura del fichero", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (opcion == JFileChooser.CANCEL_OPTION)
					nuevo.setVisible(false);
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else {
				abrir();
			}
		} else {
			abrir();
		}
	}

	private void abrir() {
		Equipo equipoFutbol = Gestion.getEquipo();
		JFileChooser abrir = new JFileChooser();
		abrir.setFileFilter(filtro);
		int opcion = abrir.showOpenDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			file = abrir.getSelectedFile();
			try {
				equipoFutbol = (Equipo) Fichero.leer(file);
				setTitle(file.getName());
				Gestion.setEquipo(equipoFutbol);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this, "El archivo no se ha encontrado", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(this, "El fichero no pertenece a este proyecto", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Error en lectura o escritura del fichero", "Error", JOptionPane.ERROR_MESSAGE);
			}
			Gestion.setModificado(false);
		}
	}

	private void guardar() {
		if (Gestion.getArchivoSeleccionado() == null) {
			JFileChooser guardar = new JFileChooser();
			guardar.setFileFilter(filtro);
			int opcion = guardar.showSaveDialog(this);
			if (opcion == JFileChooser.APPROVE_OPTION) {
				file = guardar.getSelectedFile();
				try {
					Fichero.guardar(Gestion.getEquipo(), file);
					this.setTitle(file.getName());
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(this, "El archivo no se ha encontrado", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(this, "Error en lectura o escritura del fichero " + e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				Gestion.setModificado(false);
				Gestion.setArchivoSeleccionado(file);
			} else if (opcion == JFileChooser.CANCEL_OPTION)
				nuevo.setVisible(false);
		} else
			try {
				Fichero.guardar(Gestion.getEquipo(), file);
				Gestion.setModificado(false);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Error en lectura o escritura del fichero", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}

	private void guardarComo() {
		JFileChooser guardarComo = new JFileChooser();
		guardarComo.setFileFilter(filtro);
		int opcion = guardarComo.showSaveDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			file = guardarComo.getSelectedFile();
			try {
				if (deseaSobreescribir()) {
					Fichero.guardar(Gestion.getEquipo(), file);
					this.setTitle(file.getName());
					Gestion.setModificado(false);
				}
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "El archivo no se ha encontrado", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "Error en lectura o escritura del fichero", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private boolean deseaSobreescribir() {
		if (file.exists()) {
			int sobreescribir = JOptionPane.showConfirmDialog(nuevo, "¿Deseas sobrescribir el archivo?");
			if (sobreescribir == 0) {
				return true;
			} else {
				nuevo.setVisible(false);
				return false;
			}
		}
		return true;
	}

	

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenuItem guardado;
	private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
	private javax.swing.JFrame jFrame1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu8;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuBar jMenuBar3;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JPopupMenu.Separator jSeparator1;
	private javax.swing.JMenuItem nuevo;
	private javax.swing.JMenuItem numero1;
	private javax.swing.JMenuItem numero2;
	private javax.swing.JMenuItem salir;
	private JMenu mnGestion;
	private JMenuItem addPortero;
	private JMenuItem mostrarNButton;
	private JMenu mnNewMenu;
	private JMenuItem mntmAadirDefensa;
	private JMenuItem mntmAadirDefensa_1;
	private JMenuItem mntmAadirCentrocampista;
	private JMenuItem eliminarJugadorButton;
	private JMenuItem mostrarButton;
	private JMenuItem mostrarListaMenu;
	private JMenuItem maximGoleadores;
	private JMenuItem mostrarPosicion;
	private JMenuItem mntmMostrarRankingDe;
	private JMenu mnMostrar;
	private JLabel lblNewLabel;
}
