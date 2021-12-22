package edu.java.lotto01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import edu.java.lotto01.Lotto;
public class LottoMain {
	private static final String[] RESULT_NUM = {"1번","2번","3번","4번","5번","6번","보너스","응모 결과" };
	private LottoDao dao;
	private DefaultTableModel model;
	private JTable table;
	private JFrame frame;
	
	private StartLotto startLotto;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoMain window = new LottoMain();
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
	public LottoMain() {
		dao = LottoDaoImpl.getInstance();
		initialize();
		
	}

	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblex = new JLabel();
		lblex.setText("<html>1부터 45 사이의 숫자 6가지를 입력하세요!<br>예)<p>본인: [1], [2], [3], [4], [5], [6]<p>컴퓨터: [1], [2], [3], [4], [5], [6] 보너스: [7]<p>결과: 1등 당첨 입니다 축하합니다!!!!!</html> ");
		lblex.setVerticalAlignment(SwingConstants.TOP);
		lblex.setFont(new Font("굴림", Font.BOLD, 21));
		lblex.setBounds(14, 12, 590, 135);
		frame.getContentPane().add(lblex);
		
		JButton btnstart = new JButton("수동");
		btnstart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(frame, "수동으로 응모 하시겠습니까?");
				startLotto = new StartLotto();
				int result = table.getSelectedRow();
				if (result == -1) {
			
				return;
				}
				StartLotto.showFrame(frame, LottoMain.this);
				
			}
		
		});
		btnstart.setFont(new Font("굴림", Font.PLAIN, 25));
		btnstart.setBounds(14, 182, 185, 67);
		frame.getContentPane().add(btnstart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 261, 583, 191);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(model);
		model = new DefaultTableModel(null,RESULT_NUM);
		scrollPane.setViewportView(table);
			
		JButton btnauto = new JButton("자동");
		btnauto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "자동으로 응모 하시겠습니까?",
						"자동응모",JOptionPane.YES_NO_OPTION);
				if (confirm == -1) {
					System.exit(confirm);
				} else if (confirm == JOptionPane.YES_OPTION) {
					// '예'를 선택한 경우
				} else {
					// 아니오를 선택한 경우
				}
					
					
				Object[] lotto = autoLottoNumber();
				Object[] com = autoLottoNumberCom();
				int cont = 0;
				for (int i = 0; i<6; i++) {
					for(int j = 0; j<6; j++) {
						if(lotto[i] == com[j]) {
							cont++;
						}
					}
				}
				if (cont == 0) {
					com[com.length-1] = "다음기회에";
				} else if (cont == 1) {
					com[com.length-1] = "다음기회에";
				} else if (cont == 2) {
					com[com.length-1] = "5등 당첨!!";
				} else if (cont == 3) {
					com[com.length-1] = "4등 당첨!!";
				} else if (cont == 4) {
					com[com.length-1] = "3등 당첨!!";
				} else if (cont == 5) {
					com[com.length-1] = "2등 당첨!!";
				} else if (cont == 6) {
					com[com.length-1] = "1등 당첨!!";
				}
				
				model.addRow(lotto);
				model.addRow(com);
				
				table.setModel(model);
			}

			
		});
		btnauto.setFont(new Font("굴림", Font.PLAIN, 25));
		btnauto.setBounds(213, 182, 185, 67);
		frame.getContentPane().add(btnauto);
		
		JButton btnlist = new JButton("나가기");
		btnlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnlist.setFont(new Font("굴림", Font.PLAIN, 25));
		btnlist.setBounds(412, 182, 185, 67);
		frame.getContentPane().add(btnlist);
	}



	private Object[] autoLottoNumberCom() {
		Object com [] = new Object [8]; // 컴퓨터 자동 번호 + 보너스 번호
		
		
		for(int i=0; i<7; i++) {
			com[i] = (int)(Math.random()* 45) + 1;
			if(i == 6)
				break;
			for(int j = 0; j<i; j++) {
				if(com[i] == com[j]) {
					i--;
					break; 
				} 
				
			} 
		}
		
		return com;
	}

	private Object[] autoLottoNumber() {
		Object[] lotto = new Object [8]; // 유저 자동 번호.
			for(int i =0; i<6; i++) {
				lotto[i] = (int)(Math.random()* 45) + 1;
				
				for(int j = 0; j<i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}
				
			}
		
			
		return lotto;	
		
			
	}
}
