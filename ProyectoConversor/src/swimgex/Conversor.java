package swimgex;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;


public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	// Tasas de cambio fijas
	private static final double DOLAR = 1.0;
	private static final double PESO_ARGENTINO = 202.53; // 1 dolar = 98.78 pesos argentinos
	private static final double REAL = 5.3; // 1 dolar = 5.26 reales
	private static final double YEN = 133.08; // 1 dolar = 109.47 yenes
	private static final double EURO = 0.95; // 1 dolar = 0.85 euros

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public Conversor() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Conversor.class.getResource("/swimgex/ImgenConversor.jpg")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Conversor de Moneda");
		setBounds(100, 100, 893, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        String[] monedas = {"Dólar", "Peso Argentino", "Real", "Yen", "Euro"};
        JComboBox comboBoxMonedaOrigen = new JComboBox(monedas);
        comboBoxMonedaOrigen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBoxMonedaOrigen.setBounds(186,127,147,48);
        contentPane.add(comboBoxMonedaOrigen);

        JComboBox comboBoxMonedaDestino = new JComboBox(monedas);
        comboBoxMonedaDestino.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBoxMonedaDestino.setBounds(459,126,147,51);
        contentPane.add(comboBoxMonedaDestino);

        textField = new JTextField();
        textField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
        textField.setBounds(187,206,130,40);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setBackground(Color.YELLOW);
        lblResultado.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        lblResultado.setForeground(new Color(0, 0, 0));
        lblResultado.setBounds(461,205,200,40);
        contentPane.add(lblResultado);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBackground(Color.WHITE);
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSalir.setBounds(335, 341, 157, 71);
        contentPane.add(btnSalir);
        
        JLabel lblImagen = new JLabel("");
        lblImagen.setIcon(new ImageIcon(Conversor.class.getResource("/swimgex/ImgenConversor.jpg")));
        lblImagen.setBounds(0, 0, 877, 476);
        contentPane.add(lblImagen);
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        		if (respuesta == JOptionPane.YES_OPTION) {
        			System.exit(0);
        		}
        	}
        });

        comboBoxMonedaOrigen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		double valorOrigen = Double.parseDouble(textField.getText());
        		double tasaCambioOrigen = getTasaCambio(comboBoxMonedaOrigen.getSelectedItem().toString());
        		double tasaCambioDestino = getTasaCambio(comboBoxMonedaDestino.getSelectedItem().toString());
        		double valorDestino = valorOrigen * (tasaCambioDestino / tasaCambioOrigen);
        		lblResultado.setText(String.format("%.2f", valorDestino));
        	}
        });

        comboBoxMonedaDestino.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		double valorOrigen = Double.parseDouble(textField.getText());
        		double tasaCambioOrigen = getTasaCambio(comboBoxMonedaOrigen.getSelectedItem().toString());
        		double tasaCambioDestino = getTasaCambio(comboBoxMonedaDestino.getSelectedItem().toString());
        		double valorDestino = valorOrigen * (tasaCambioDestino / tasaCambioOrigen);
        		lblResultado.setText(String.format("%.2f", valorDestino));
        	}
        });
        }

        private double getTasaCambio(String moneda) {
        	switch(moneda) {
        	case "Dólar":
        	return DOLAR;
        	case "Peso Argentino":
        	return PESO_ARGENTINO;
        	case "Real":
        	return REAL;
        	case "Yen":
        	return YEN;
        	case "Euro":
        	return EURO;
        	default:
        	return 1.0;
        }
      }
   }

