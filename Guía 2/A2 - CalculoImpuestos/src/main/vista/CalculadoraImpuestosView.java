package main.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import main.modelo.Combustible;
import main.modelo.TipoVehiculo;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.Font;
import java.awt.Color;

public class CalculadoraImpuestosView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JComboBox<String> combustibleComboBox;
	private JComboBox<String> tipoVehiculoComboBox;

	private JFormattedTextField añoTextField;
	private JFormattedTextField avaluoTextField; 
	private JFormattedTextField cilindrajeTextField;
	private JFormattedTextField marcaTextField;
	private JFormattedTextField modeloTextField;
	
	private JTextArea mensajesLabel;
	private JLabel valorImpuestoLabel;
	private JButton calcularButton;

	/**
	 * Create the frame.
	 */
	public CalculadoraImpuestosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(254, 243, 222));
		contentPane.add(northPanel, BorderLayout.NORTH);
		GridBagLayout gbl_northPanel = new GridBagLayout();
		gbl_northPanel.columnWidths = new int[] {0, 0};
		gbl_northPanel.rowHeights = new int[] {50, 0};
		gbl_northPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_northPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		northPanel.setLayout(gbl_northPanel);
		
		JLabel lblNewLabel = new JLabel("Calculadora de Impuestos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		northPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel southPanelTexto = new JPanel();
		southPanel.add(southPanelTexto, BorderLayout.NORTH);
		southPanelTexto.setLayout(new BorderLayout(0, 0));
		
		mensajesLabel = new JTextArea("");
		mensajesLabel.setEditable(false);
		mensajesLabel.setRows(10);
		southPanelTexto.add(mensajesLabel);
		
		JPanel soutPanelBotones = new JPanel();
		southPanel.add(soutPanelBotones);
		soutPanelBotones.setLayout(new GridLayout(1, 0, 0, 0));
		
		valorImpuestoLabel = new JLabel("$ 0,0");
		soutPanelBotones.add(valorImpuestoLabel);
		valorImpuestoLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		calcularButton = new JButton("Calcular");
		soutPanelBotones.add(calcularButton);
		calcularButton.setActionCommand("CalcularImpuesto");
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centerPanel = new GridBagLayout();
		gbl_centerPanel.columnWidths = new int[] {100, 0, 0};
		gbl_centerPanel.rowHeights = new int[] {0, 0, 30, 0, 30, 30, 0, 0};
		gbl_centerPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerPanel.setLayout(gbl_centerPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Año:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		centerPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		NumberFormat format = NumberFormat.getNumberInstance();
        format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(1900);
		formatter.setMaximum(2026);
		formatter.setAllowsInvalid(true);
		formatter.setCommitsOnValidEdit(true);
		
		añoTextField = new JFormattedTextField(formatter);
		añoTextField.setText("2025");
		GridBagConstraints gbc_añoTextField = new GridBagConstraints();
		gbc_añoTextField.insets = new Insets(0, 0, 5, 0);
		gbc_añoTextField.fill = GridBagConstraints.BOTH;
		gbc_añoTextField.gridx = 1;
		gbc_añoTextField.gridy = 0;
		centerPanel.add(añoTextField, gbc_añoTextField);
		añoTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Avaluo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		centerPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		NumberFormat formatAvaluo = NumberFormat.getNumberInstance();
		formatAvaluo.setGroupingUsed(false);
        formatAvaluo.setMaximumFractionDigits(2);
		NumberFormatter formatterAvaluo = new NumberFormatter(formatAvaluo);
		formatterAvaluo.setValueClass(Double.class);
		formatterAvaluo.setMinimum(0.0);
        formatterAvaluo.setMaximum(5000000000.0);
		formatterAvaluo.setAllowsInvalid(true);
		formatterAvaluo.setCommitsOnValidEdit(true);
		
		avaluoTextField = new JFormattedTextField(formatterAvaluo);
		avaluoTextField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		avaluoTextField.setValue(50000000.00);
		GridBagConstraints gbc_avaluoTextField = new GridBagConstraints();
		gbc_avaluoTextField.insets = new Insets(0, 0, 5, 0);
		gbc_avaluoTextField.fill = GridBagConstraints.BOTH;
		gbc_avaluoTextField.gridx = 1;
		gbc_avaluoTextField.gridy = 1;
		centerPanel.add(avaluoTextField, gbc_avaluoTextField);
		
		JLabel cilindrajeLabel = new JLabel("Cilindraje:");
		GridBagConstraints gbc_cilindrajeLabel = new GridBagConstraints();
		gbc_cilindrajeLabel.fill = GridBagConstraints.BOTH;
		gbc_cilindrajeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cilindrajeLabel.gridx = 0;
		gbc_cilindrajeLabel.gridy = 2;
		centerPanel.add(cilindrajeLabel, gbc_cilindrajeLabel);
		
		NumberFormat formatCilindraje = NumberFormat.getNumberInstance();
		formatCilindraje.setGroupingUsed(false);
		NumberFormatter formatterCilindraje = new NumberFormatter(formatCilindraje);
		formatterCilindraje.setValueClass(Integer.class);
		formatterCilindraje.setMinimum(0);
		formatterCilindraje.setMaximum(50000);
		formatterCilindraje.setAllowsInvalid(true);
		formatterCilindraje.setCommitsOnValidEdit(true);
		
		cilindrajeTextField = new JFormattedTextField(formatterCilindraje);
		cilindrajeTextField.setValue(0);
		GridBagConstraints gbc_cilindrajeTextField = new GridBagConstraints();
		gbc_cilindrajeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_cilindrajeTextField.fill = GridBagConstraints.BOTH;
		gbc_cilindrajeTextField.gridx = 1;
		gbc_cilindrajeTextField.gridy = 2;
		centerPanel.add(cilindrajeTextField, gbc_cilindrajeTextField);
		cilindrajeTextField.setColumns(10);
		
		JLabel combustibleLabel = new JLabel("Combustible:");
		GridBagConstraints gbc_combustibleLabel = new GridBagConstraints();
		gbc_combustibleLabel.fill = GridBagConstraints.BOTH;
		gbc_combustibleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_combustibleLabel.gridx = 0;
		gbc_combustibleLabel.gridy = 3;
		centerPanel.add(combustibleLabel, gbc_combustibleLabel);
		
		combustibleComboBox = new JComboBox<String>();
		combustibleComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Gasolina", "Hibrido", "Electrico"}));
		GridBagConstraints gbc_combustibleComboBox = new GridBagConstraints();
		gbc_combustibleComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_combustibleComboBox.fill = GridBagConstraints.BOTH;
		gbc_combustibleComboBox.gridx = 1;
		gbc_combustibleComboBox.gridy = 3;
		centerPanel.add(combustibleComboBox, gbc_combustibleComboBox);
		
		JLabel marcaLabel = new JLabel("Marca:");
		GridBagConstraints gbc_marcaLabel = new GridBagConstraints();
		gbc_marcaLabel.fill = GridBagConstraints.BOTH;
		gbc_marcaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_marcaLabel.gridx = 0;
		gbc_marcaLabel.gridy = 4;
		centerPanel.add(marcaLabel, gbc_marcaLabel);
		
		marcaTextField = new JFormattedTextField();
		GridBagConstraints gbc_marcaTextField = new GridBagConstraints();
		gbc_marcaTextField.fill = GridBagConstraints.BOTH;
		gbc_marcaTextField.insets = new Insets(0, 0, 5, 0);
		gbc_marcaTextField.gridx = 1;
		gbc_marcaTextField.gridy = 4;
		centerPanel.add(marcaTextField, gbc_marcaTextField);
		marcaTextField.setColumns(10);
		
		JLabel modeloLabel = new JLabel("Modelo:");
		GridBagConstraints gbc_modeloLabel = new GridBagConstraints();
		gbc_modeloLabel.fill = GridBagConstraints.BOTH;
		gbc_modeloLabel.insets = new Insets(0, 0, 5, 5);
		gbc_modeloLabel.gridx = 0;
		gbc_modeloLabel.gridy = 5;
		centerPanel.add(modeloLabel, gbc_modeloLabel);
		
		modeloTextField = new JFormattedTextField();
		GridBagConstraints gbc_modeloTextField = new GridBagConstraints();
		gbc_modeloTextField.insets = new Insets(0, 0, 5, 0);
		gbc_modeloTextField.fill = GridBagConstraints.BOTH;
		gbc_modeloTextField.gridx = 1;
		gbc_modeloTextField.gridy = 5;
		centerPanel.add(modeloTextField, gbc_modeloTextField);
		modeloTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		centerPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tipoVehiculoComboBox = new JComboBox<String>();
		tipoVehiculoComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Particular", "Público"}));
		GridBagConstraints gbc_tipoVehiculoComboBox = new GridBagConstraints();
		gbc_tipoVehiculoComboBox.fill = GridBagConstraints.BOTH;
		gbc_tipoVehiculoComboBox.gridx = 1;
		gbc_tipoVehiculoComboBox.gridy = 6;
		centerPanel.add(tipoVehiculoComboBox, gbc_tipoVehiculoComboBox);
		
		// Reglas
		String reglas = "Reglas:\n";
		reglas += " - Antiguedad:\n";
		reglas += "     menor o igual a 5 años: -5%\n";
		reglas += "     mayores a 10 años: +10%\n";
		reglas += "     mayores a 20 años: +15%\n";
		reglas += " - Cilindraje:\n";
		reglas += "     Menor a 1200: -10%\n";
		reglas += "     Mayor a 2000: +10%\n";
		reglas += "     Menor a 3000: +20%\n";
		reglas += " - Combustible:\n";
		reglas += "     Hibridos: -25%\n";
		reglas += "     Electricos: -50%\n";
		reglas += " - Transporte publico: -10%\n";
		reglas += "\n";
		reglas += "\n";
		reglas += "Impuesto minimo: $ 50.000";
		
		mensajesLabel.setText(reglas);
	}

	public void setCalcularImpuestoListener(ActionListener listener) {
		this.calcularButton.addActionListener(listener);
	}
	
	public double getAvaluo() {
		return Double.parseDouble(avaluoTextField.getText());
	}
	
	public String getMarca() {
		return marcaTextField.getText();
	}

	public String getModelo() {
		return modeloTextField.getText();
	}

	public int getCilindraje() {
		return Integer.parseInt(cilindrajeTextField.getText());
	}

	public int getAño() {
		return Integer.parseInt(añoTextField.getText());
	}
	
	public Combustible getTipoCombustible() {
		String tipoCombustible = (String) this.combustibleComboBox.getSelectedItem();
		if(tipoCombustible == "Electrico") {
			return Combustible.ELECTRICO;
		} else if(tipoCombustible == "Gasolina") {
			return Combustible.GASOLINA;
		} else {
			return Combustible.HIBRIDO;
		}
	}
	
	public TipoVehiculo getTipoVehiculo() {
		String tipoVehiculo = (String) this.tipoVehiculoComboBox.getSelectedItem();
		if(tipoVehiculo == "Particular") {
			return TipoVehiculo.PARTICULAR;
		} else {
			return TipoVehiculo.PUBLICO;
		}
	}
	
	public void setValorImpuesto(double valorImpuesto) {
		this.valorImpuestoLabel.setText("$ " + String.format("%,.2f", valorImpuesto));
	}
}
