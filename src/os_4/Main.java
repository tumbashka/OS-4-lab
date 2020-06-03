package os_4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	private JFrame frame;
	static JTextField textFieldId;
	private static JPanel panel;
	public static JTextArea textAreaWindow;
	private DataManager dataManager;
	private Block Memory=new Block();
	private JTextField textFieldSize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 796, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new Manager(Memory);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 480, 184);
		frame.getContentPane().add(panel);

		textFieldId = new JTextField();
		textFieldId.setBounds(173, 245, 32, 20);
		frame.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);

		JLabel labelWrite = new JLabel("Id");
		labelWrite.setBounds(148, 248, 26, 14);
		frame.getContentPane().add(labelWrite);

		JLabel labelCMD = new JLabel("Вывод");
		labelCMD.setBounds(513, 11, 126, 14);
		frame.getContentPane().add(labelCMD);

		textAreaWindow = new JTextArea();
		textAreaWindow.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textAreaWindow.setBackground(Color.WHITE);
		textAreaWindow.setForeground(Color.BLACK);
		textAreaWindow.setEnabled(false);
		textAreaWindow.setBounds(502, 38, 264, 363);
		frame.getContentPane().add(textAreaWindow);

		dataManager = new DataManager();

		JButton buttonCreate = new JButton("Создать");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataManager.CreateFile(Integer.parseInt(textFieldSize.getText()));
				panel.repaint();
			}
		});
		buttonCreate.setBounds(10, 208, 126, 23);
		frame.getContentPane().add(buttonCreate);

		JButton buttonDel = new JButton("Удалить");
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataManager.DeleteFile(Integer.parseInt(textFieldId.getText()));
				panel.repaint();
			}
		});
		buttonDel.setBounds(10, 244, 126, 23);
		frame.getContentPane().add(buttonDel);

		JLabel lblSize = new JLabel("Размер");
		lblSize.setBounds(148, 211, 50, 14);
		frame.getContentPane().add(lblSize);

		textFieldSize = new JTextField();
		textFieldSize.setColumns(10);
		textFieldSize.setBounds(215, 208, 32, 20);
		frame.getContentPane().add(textFieldSize);
	}
}