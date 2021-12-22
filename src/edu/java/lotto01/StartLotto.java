package edu.java.lotto01;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;


import edu.java.lotto01.Lotto;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
public class StartLotto extends JFrame {

	private JPanel contentPane;
	private Component parentComponent;
	private LottoMain mainApp;
	Set<Integer> myLotto;

	
	public StartLotto(Component parentComponent, LottoMain mainApp) { 
		this.parentComponent = parentComponent;
		this.mainApp = mainApp;
		this.initialize();
		this.setVisible(true);
		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void showFrame(Component parentComponent, LottoMain mainApp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartLotto sLotto = new StartLotto(parentComponent, mainApp);
					sLotto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param parentComponent 
	 * @param mainLotto 
	 */
	
	public void initialize() {
		myLotto = new HashSet<>();
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
		
		for(int i = 0; i < 45; i++) {
			JCheckBox checkbox = new JCheckBox(" "+(i+1));
			checkbox.setFont(new Font("굴림", Font.BOLD, 15));
			checkbox.setBounds(14+(i%10)*60, 64+40*(i/10) , 53, 27);
			checkbox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {
						// trim (스트링 앞 뒤 공백 제거)
						myLotto.add(Integer.parseInt(((JCheckBox)e.getItem()).getText().trim()));
					} else {
						myLotto.remove(Integer.parseInt(((JCheckBox)e.getItem()).getText().trim()));
					}
					
				}
			});
			contentPane.add(checkbox);
		}
		
		JButton btnStart = new JButton("응모하기!");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startgoodluck();
			}
		});
		btnStart.setFont(new Font("굴림", Font.BOLD, 20));
		btnStart.setBounds(14, 252, 310, 27);
		contentPane.add(btnStart);
		
		JButton btnCancle = new JButton("취 소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("굴림", Font.BOLD, 20));
		btnCancle.setBounds(353, 252, 310, 27);
		contentPane.add(btnCancle);
	}


	private void startgoodluck() {
		
		System.out.println(myLotto.toString());
		
		if(myLotto.size() != 6) {
			myLotto.removeAll(myLotto);
		
			JOptionPane.showMessageDialog(this, "6개만 선택하세요");
		}
			
		return;
	}
	
}
