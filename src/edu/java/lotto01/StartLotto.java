package edu.java.lotto01;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import edu.java.lotto01.Lotto;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
public class StartLotto extends JFrame {

	private JPanel contentPane;
	 

	public StartLotto() { 
		this.initialize();
		this.setVisible(true);
		
	}
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param parentComponent 
	 * @param mainLotto 
	 */
	
	public void initialize() {
		setTitle("로또 번호 선택");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 695, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("수동 LOTTO!!");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(14, 12, 696, 44);
		contentPane.add(lblNewLabel);
		
		JCheckBox no1 = new JCheckBox(" 1");
		no1.setFont(new Font("굴림", Font.BOLD, 15));
		no1.setBounds(14, 64, 53, 27);
		contentPane.add(no1);
		
		JCheckBox no2 = new JCheckBox(" 2");
		no2.setFont(new Font("굴림", Font.BOLD, 15));
		no2.setBounds(73, 64, 53, 27);
		contentPane.add(no2);
		
		JCheckBox no3 = new JCheckBox(" 3");
		no3.setFont(new Font("굴림", Font.BOLD, 15));
		no3.setBounds(132, 64, 53, 27);
		contentPane.add(no3);
		
		JCheckBox no4 = new JCheckBox(" 4");
		no4.setFont(new Font("굴림", Font.BOLD, 15));
		no4.setBounds(191, 64, 53, 27);
		contentPane.add(no4);
		
		JCheckBox no5 = new JCheckBox(" 5");
		no5.setFont(new Font("굴림", Font.BOLD, 15));
		no5.setBounds(250, 64, 53, 27);
		contentPane.add(no5);
		
		JCheckBox no6 = new JCheckBox(" 6");
		no6.setFont(new Font("굴림", Font.BOLD, 15));
		no6.setBounds(309, 64, 53, 27);
		contentPane.add(no6);
		
		JCheckBox no7 = new JCheckBox(" 7");
		no7.setFont(new Font("굴림", Font.BOLD, 15));
		no7.setBounds(368, 64, 53, 27);
		contentPane.add(no7);
		
		JCheckBox no8 = new JCheckBox(" 8");
		no8.setFont(new Font("굴림", Font.BOLD, 15));
		no8.setBounds(427, 64, 53, 27);
		contentPane.add(no8);
		
		JCheckBox no9 = new JCheckBox(" 9");
		no9.setFont(new Font("굴림", Font.BOLD, 15));
		no9.setBounds(486, 64, 53, 27);
		contentPane.add(no9);
		
		JCheckBox no10 = new JCheckBox(" 10");
		no10.setFont(new Font("굴림", Font.BOLD, 15));
		no10.setBounds(545, 64, 53, 27);
		contentPane.add(no10);
		
		JCheckBox no11 = new JCheckBox(" 11");
		no11.setFont(new Font("굴림", Font.BOLD, 15));
		no11.setBounds(604, 64, 53, 27);
		contentPane.add(no11);
		
		JCheckBox no12 = new JCheckBox(" 12");
		no12.setFont(new Font("굴림", Font.BOLD, 15));
		no12.setBounds(14, 107, 53, 27);
		contentPane.add(no12);
		
		JCheckBox no13 = new JCheckBox(" 13");
		no13.setFont(new Font("굴림", Font.BOLD, 15));
		no13.setBounds(73, 107, 53, 27);
		contentPane.add(no13);
		
		JCheckBox no14 = new JCheckBox(" 14");
		no14.setFont(new Font("굴림", Font.BOLD, 15));
		no14.setBounds(132, 107, 53, 27);
		contentPane.add(no14);
		
		JCheckBox no15 = new JCheckBox(" 15");
		no15.setFont(new Font("굴림", Font.BOLD, 15));
		no15.setBounds(191, 107, 53, 27);
		contentPane.add(no15);
		
		JCheckBox no16 = new JCheckBox(" 16");
		no16.setFont(new Font("굴림", Font.BOLD, 15));
		no16.setBounds(250, 107, 53, 27);
		contentPane.add(no16);
		
		JCheckBox no17 = new JCheckBox(" 17");
		no17.setFont(new Font("굴림", Font.BOLD, 15));
		no17.setBounds(309, 107, 53, 27);
		contentPane.add(no17);
		
		JCheckBox no18 = new JCheckBox(" 18");
		no18.setFont(new Font("굴림", Font.BOLD, 15));
		no18.setBounds(368, 107, 53, 27);
		contentPane.add(no18);
		
		JCheckBox no19 = new JCheckBox(" 19");
		no19.setFont(new Font("굴림", Font.BOLD, 15));
		no19.setBounds(427, 107, 53, 27);
		contentPane.add(no19);
		
		JCheckBox no20 = new JCheckBox(" 20");
		no20.setFont(new Font("굴림", Font.BOLD, 15));
		no20.setBounds(486, 107, 53, 27);
		contentPane.add(no20);
		
		JCheckBox no21 = new JCheckBox(" 21");
		no21.setFont(new Font("굴림", Font.BOLD, 15));
		no21.setBounds(545, 107, 53, 27);
		contentPane.add(no21);
		
		JCheckBox no26 = new JCheckBox(" 26");
		no26.setFont(new Font("굴림", Font.BOLD, 15));
		no26.setBounds(191, 148, 53, 27);
		contentPane.add(no26);
		
		JCheckBox no22 = new JCheckBox(" 22");
		no22.setFont(new Font("굴림", Font.BOLD, 15));
		no22.setBounds(604, 107, 53, 27);
		contentPane.add(no22);
		
		JCheckBox no25 = new JCheckBox(" 25");
		no25.setFont(new Font("굴림", Font.BOLD, 15));
		no25.setBounds(132, 148, 53, 27);
		contentPane.add(no25);
		
		JCheckBox no24 = new JCheckBox(" 24");
		no24.setFont(new Font("굴림", Font.BOLD, 15));
		no24.setBounds(73, 148, 53, 27);
		contentPane.add(no24);
		
		JCheckBox no23 = new JCheckBox(" 23");
		no23.setFont(new Font("굴림", Font.BOLD, 15));
		no23.setBounds(14, 148, 53, 27);
		contentPane.add(no23);
		
		JCheckBox no34 = new JCheckBox(" 34");
		no34.setFont(new Font("굴림", Font.BOLD, 15));
		no34.setBounds(14, 189, 53, 27);
		contentPane.add(no34);
		
		JCheckBox no35 = new JCheckBox(" 35");
		no35.setFont(new Font("굴림", Font.BOLD, 15));
		no35.setBounds(73, 189, 53, 27);
		contentPane.add(no35);
		
		JCheckBox no36 = new JCheckBox(" 36");
		no36.setFont(new Font("굴림", Font.BOLD, 15));
		no36.setBounds(132, 189, 53, 27);
		contentPane.add(no36);
		
		JCheckBox no37 = new JCheckBox(" 37");
		no37.setFont(new Font("굴림", Font.BOLD, 15));
		no37.setBounds(191, 189, 53, 27);
		contentPane.add(no37);
		
		JCheckBox no27 = new JCheckBox(" 27");
		no27.setFont(new Font("굴림", Font.BOLD, 15));
		no27.setBounds(250, 148, 53, 27);
		contentPane.add(no27);
		
		JCheckBox no38 = new JCheckBox(" 38");
		no38.setFont(new Font("굴림", Font.BOLD, 15));
		no38.setBounds(250, 189, 53, 27);
		contentPane.add(no38);
		
		JCheckBox no28 = new JCheckBox(" 28");
		no28.setFont(new Font("굴림", Font.BOLD, 15));
		no28.setBounds(309, 148, 53, 27);
		contentPane.add(no28);
		
		JCheckBox no39 = new JCheckBox(" 39");
		no39.setFont(new Font("굴림", Font.BOLD, 15));
		no39.setBounds(309, 189, 53, 27);
		contentPane.add(no39);
		
		JCheckBox no29 = new JCheckBox(" 29");
		no29.setFont(new Font("굴림", Font.BOLD, 15));
		no29.setBounds(368, 148, 53, 27);
		contentPane.add(no29);
		
		JCheckBox no40 = new JCheckBox(" 40");
		no40.setFont(new Font("굴림", Font.BOLD, 15));
		no40.setBounds(368, 189, 53, 27);
		contentPane.add(no40);
		
		JCheckBox no30 = new JCheckBox(" 30");
		no30.setFont(new Font("굴림", Font.BOLD, 15));
		no30.setBounds(427, 148, 53, 27);
		contentPane.add(no30);
		
		JCheckBox no41 = new JCheckBox(" 41");
		no41.setFont(new Font("굴림", Font.BOLD, 15));
		no41.setBounds(427, 189, 53, 27);
		contentPane.add(no41);
		
		JCheckBox no31 = new JCheckBox(" 31");
		no31.setFont(new Font("굴림", Font.BOLD, 15));
		no31.setBounds(486, 148, 53, 27);
		contentPane.add(no31);
		
		JCheckBox no42 = new JCheckBox(" 42");
		no42.setFont(new Font("굴림", Font.BOLD, 15));
		no42.setBounds(486, 189, 53, 27);
		contentPane.add(no42);
		
		JCheckBox no32 = new JCheckBox(" 32");
		no32.setFont(new Font("굴림", Font.BOLD, 15));
		no32.setBounds(545, 148, 53, 27);
		contentPane.add(no32);
		
		JCheckBox no43 = new JCheckBox(" 43");
		no43.setFont(new Font("굴림", Font.BOLD, 15));
		no43.setBounds(545, 189, 53, 27);
		contentPane.add(no43);
		
		JCheckBox no33 = new JCheckBox(" 33");
		no33.setFont(new Font("굴림", Font.BOLD, 15));
		no33.setBounds(604, 148, 53, 27);
		contentPane.add(no33);
		
		JCheckBox no44 = new JCheckBox(" 44");
		no44.setFont(new Font("굴림", Font.BOLD, 15));
		no44.setBounds(604, 189, 53, 27);
		contentPane.add(no44);
		
		JCheckBox no45 = new JCheckBox(" 45");
		no45.setFont(new Font("굴림", Font.BOLD, 15));
		no45.setBounds(14, 224, 53, 27);
		contentPane.add(no45);
		
		JButton btnStart = new JButton("응모하기!");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startgoodluck();
			}
		});
		btnStart.setFont(new Font("굴림", Font.BOLD, 20));
		btnStart.setBounds(106, 224, 256, 27);
		contentPane.add(btnStart);
		
		JButton btnCancle = new JButton("취 소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("굴림", Font.BOLD, 20));
		btnCancle.setBounds(401, 224, 256, 27);
		contentPane.add(btnCancle);
	}


	private void startgoodluck() {
		
		Set<Integer> myLotto = new TreeSet<Integer>();
		
		if(myLotto.size() != 6) {
			myLotto.removeAll(myLotto);
		}
			
		return;
	}
	
}
