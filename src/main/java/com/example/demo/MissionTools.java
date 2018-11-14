package com.example.demo;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.demo.voice.VoiceTools;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MissionTools {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MissionTools window = new MissionTools();
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
	public MissionTools() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 407, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(209, 81, 93, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("开始时间");
		lblNewLabel.setBounds(74, 84, 110, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("开始任务");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(textField.getText());
				VoiceTools.speak("您输入了" + textField.getText());
			}
		});
		button.setBounds(134, 229, 93, 23);
		frame.getContentPane().add(button);
		
		JLabel lbls = new JLabel("间隔时间（s）");
		lbls.setBounds(74, 143, 110, 15);
		frame.getContentPane().add(lbls);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(209, 140, 93, 21);
		frame.getContentPane().add(textField_1);
	}
}
