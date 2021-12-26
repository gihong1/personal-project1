package edu.java.lotto01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.UIManager;
public class LottoMain {
	private static final String[] IMAGES_LOTTO = { "images/lotto1.png" };
	
	private static final String[] RESULT_NUM = {"One","Two","Three","Four","Five","Six","Bonus","Result"};
	
	private DefaultTableModel model;
	private JTable table;
	private JFrame frame;
	private int index;
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
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LottoMain lottoMain = this;
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LottoMain.class.getResource("/images/lotto1.png")));
		frame.setBounds(100, 100, 636, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblex = new JLabel();
		lblex.setForeground(Color.DARK_GRAY);
		lblex.setBackground(SystemColor.info);
		lblex.setText("<html>1부터 45 사이의 숫자 6가지를 입력하세요!<br>예)<p>사용자: [1], [2], [3], [4], [5], [6]<p>컴퓨터: [1], [2], [3], [4], [5], [6] 보너스: [7]<p>결과: 1등 당첨 입니다 축하합니다!!!!!</html> ");
		lblex.setVerticalAlignment(SwingConstants.TOP);
		lblex.setFont(new Font("함초롬바탕", Font.BOLD, 21));
		lblex.setBounds(14, 12, 590, 158);
		frame.getContentPane().add(lblex);
		
		JButton btnstart = new JButton("수동");
		btnstart.setForeground(Color.DARK_GRAY);
		btnstart.setBackground(Color.ORANGE);
		btnstart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "수동으로 응모 하시겠습니까?");
				if (confirm == JOptionPane.YES_OPTION) {
					
				
				if(startLotto == null) {
					startLotto = new StartLotto(lottoMain); // 인스턴스 생성
				}
				startLotto.initialize();
				int result = table.getSelectedRow();
				if (result == -1) {
			
				return;
				}
			}
			}
		});
		btnstart.setFont(new Font("굴림", Font.PLAIN, 25));
		btnstart.setBounds(14, 182, 184, 67);
		frame.getContentPane().add(btnstart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 261, 590, 191);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(model);
		table.setFont(new Font("휴먼모음T", Font.BOLD, 13));
		model = new DefaultTableModel(null,RESULT_NUM);
		scrollPane.setViewportView(table);
			
		JButton btnauto = new JButton("자동");
		btnauto.setForeground(Color.DARK_GRAY);
		btnauto.setBackground(Color.GREEN);
		btnauto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "자동으로 응모 하시겠습니까?");
				if (confirm == JOptionPane.YES_OPTION) {
					// '예'를 선택한 경우
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
					
			}

			
		});
		btnauto.setFont(new Font("굴림", Font.PLAIN, 25));
		btnauto.setBounds(212, 182, 189, 67);
		frame.getContentPane().add(btnauto);
		
		JButton btnlist = new JButton("나가기");
		btnlist.setForeground(new Color(255, 255, 255));
		btnlist.setBackground(new Color(0, 0, 0));
		btnlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnlist.setFont(new Font("굴림", Font.PLAIN, 25));
		btnlist.setBounds(415, 182, 189, 67);
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
	} // end autoLottoNumber
	
	public void setModelManually(Object[] lotto) {
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
	} // end setModelManually
}
