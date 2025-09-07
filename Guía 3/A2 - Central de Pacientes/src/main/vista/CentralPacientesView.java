package main.vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.modelo.ListaEnlazadaSimple;
import main.modelo.Paciente;

import javax.swing.JScrollPane;

public class CentralPacientesView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nuevoPacienteIdentificacion;
	private JTable table;
	private DefaultTableModel tableModel;
	
	private JLabel errorMessageLabel;
	
	private JTextField nuevoPacienteNombre;
	private JTextField nuevoPacienteEdad;
	private JTextField nuevoPacienteClinica;
	private JTextField buscarPacienteIdentificacion;
	private JTextField eliminarPacienteIdentificacion;
	
	private JButton botonAgregar;
	private JButton botonBuscar;
	private JButton botonEliminar;

	/**
	 * Create the frame.
	 */
	public CentralPacientesView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(254, 243, 222));
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JLabel lblCentralDePacientes = new JLabel("Central de Pacientes");
		lblCentralDePacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentralDePacientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		northPanel.add(lblCentralDePacientes);
		
		JPanel centralPanel = new JPanel();
		contentPane.add(centralPanel, BorderLayout.CENTER);
		
		JPanel centralPanel_2 = new JPanel();
		centralPanel.add(centralPanel_2, BorderLayout.NORTH);
		centralPanel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		tableModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Identificaci\u00F3n", "Nombre", "Edad", "Clinica"
				}
			) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		centralPanel_2.add(scrollPane);
		
		errorMessageLabel = new JLabel("");
		centralPanel_2.add(errorMessageLabel, BorderLayout.SOUTH);
				
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(4, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Identificación:");
		southPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		southPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		southPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Clinica:");
		southPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		southPanel.add(lblNewLabel_4);
		
		nuevoPacienteIdentificacion = new JTextField();
		southPanel.add(nuevoPacienteIdentificacion);
		nuevoPacienteIdentificacion.setColumns(10);
		
		nuevoPacienteNombre = new JTextField();
		southPanel.add(nuevoPacienteNombre);
		nuevoPacienteNombre.setColumns(10);
		
		nuevoPacienteEdad = new JTextField();
		southPanel.add(nuevoPacienteEdad);
		nuevoPacienteEdad.setColumns(10);
		
		nuevoPacienteClinica = new JTextField();
		southPanel.add(nuevoPacienteClinica);
		nuevoPacienteClinica.setColumns(10);
		
		botonAgregar = new JButton("Agregar");
		botonAgregar.setActionCommand("AGREGAR");
		southPanel.add(botonAgregar);
		
		JLabel lblNewLabel_5 = new JLabel("Identificación ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		southPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("a buscar:");
		southPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		southPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Identificación ");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
		southPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("a eliminar:");
		southPanel.add(lblNewLabel_9);
		
		buscarPacienteIdentificacion = new JTextField();
		southPanel.add(buscarPacienteIdentificacion);
		buscarPacienteIdentificacion.setColumns(10);
		
		botonBuscar = new JButton("Buscar");
		botonBuscar.setActionCommand("BUSCAR");
		southPanel.add(botonBuscar);
		
		JLabel lblNewLabel_10 = new JLabel("");
		southPanel.add(lblNewLabel_10);
		
		eliminarPacienteIdentificacion = new JTextField();
		southPanel.add(eliminarPacienteIdentificacion);
		eliminarPacienteIdentificacion.setColumns(10);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setActionCommand("ELIMINAR");
		southPanel.add(botonEliminar);

	}
	
	public void actualizarTabla(ListaEnlazadaSimple<Paciente> pacientes) {
		try {
			List<String[]> datosPacientes = new ArrayList<String[]>();
			for (int i = 0; i < pacientes.size(); i++) {
				Paciente p = pacientes.get(i);
				datosPacientes.add(new String[] {p.getId(), p.getNombre(), p.getEdad() + "", p.getClinica()});
			}
			
			tableModel.setRowCount(0);
			
			for (int i = 0; i < datosPacientes.size(); i++) {
				tableModel.addRow(datosPacientes.get(i));
			}
		} catch (Exception e) {
			errorMessageLabel.setText("Ocurrio un error inesperado, por favor reinicie el programa");
		}
	}
	
	public void setErrorMessage(String mensaje) {
		errorMessageLabel.setText(mensaje);
	}

	public void setAgregarPacienteListener(ActionListener listener) {
		botonAgregar.addActionListener(listener);
	}

	public void setBuscarPacienteListener(ActionListener listener) {
		botonBuscar.addActionListener(listener);
	}

	public void setEliminarPacienteListener(ActionListener listener) {
		botonEliminar.addActionListener(listener);
	}
	
	public String getBuscarPacienteIdentificacion() {
		return this.buscarPacienteIdentificacion.getText();
	}
	
	public String getEliminarPacienteIdentificacion() {
		return this.eliminarPacienteIdentificacion.getText();
	}
	
	public String getNuevoPacienteClinica() {
		return this.nuevoPacienteClinica.getText();
	}
	
	public String getNuevoPacienteEdad() {
		return this.nuevoPacienteEdad.getText();
	}
	
	public String getNuevoPacienteIdentificacion() {
		return this.nuevoPacienteIdentificacion.getText();
	}
	
	public String getNuevoPacienteNombre() {
		return this.nuevoPacienteNombre.getText();
	}
}
