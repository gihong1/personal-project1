package edu.java.lotto01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class SwingLottery implements ItemListener, ActionListener{
 private JFrame frame;
 private Container con;

 private ImageIcon titleImg;
 private JLabel titleLb;
 private JPanel titelPane;

 private ImageIcon[] normalBall;
 private ImageIcon[] pressedBall;
 private JCheckBox[] lotteryBall;
 private JPanel ballPane;

 private JLabel selectedNumLb;
 private JTextField[] selectedNumDisp;
 private Box selectedNumDispBox;
 private JLabel lotteryNumLb;
 private JTextField[] lotteryNumDisp;
 private Box lotteryNumDispBox;
 private JLabel winningNumLb;
 private JTextField[] winningNumDisp;
 private Box winningNumDispBox;
 private JButton goBt;
 private JButton initBt;
 private Box labelBox;
 private Box numBox;
 private Box buttonBox;
 private JPanel resultPane;

 private Dimension dim1;
 private Dimension dim2;
 private int xpos;
 private int ypos;

 private int buttonCount;

 private int[] selectedNum;
 private int[] lotteryNum;
 private int[] winningNum;

 private int temp;
 private int count;

 public SwingLottery(){
  this.frame = new JFrame("로또 추첨기");
  this.con = null;

  this.titleImg = new ImageIcon("titleImg.gif");
  this.titleLb = new JLabel(titleImg);
  this.titelPane = new JPanel();

  this.normalBall = new ImageIcon[45];
  this.pressedBall = new ImageIcon[45];
  this.lotteryBall = new JCheckBox[45];
  this.ballPane = new JPanel();

  this.selectedNumLb = new JLabel("선택번호:");
  this.selectedNumDisp = new JTextField[6];
  this.selectedNumDispBox = Box.createHorizontalBox();
  this.lotteryNumLb = new JLabel("추첨번호:");
  this.lotteryNumDisp = new JTextField[6];
  this.lotteryNumDispBox = Box.createHorizontalBox();
  this.winningNumLb = new JLabel("당첨번호:");
  this.winningNumDisp = new JTextField[6];
  this.winningNumDispBox = Box.createHorizontalBox();
  this.goBt = new JButton("시작");
  this.initBt = new JButton("초기화");
  this.labelBox = Box.createVerticalBox();
  this.numBox = Box.createVerticalBox();
  this.buttonBox = Box.createHorizontalBox();
  this.resultPane = new JPanel();

  frame.setSize(600, 600);
  this.dim1 = Toolkit.getDefaultToolkit().getScreenSize();
  this.dim2 = frame.getSize();
  this.xpos = (int)(dim1.getWidth() / 2 - dim2.getWidth() / 2);
  this.ypos = (int)(dim1.getHeight() / 2 - dim2.getHeight() / 2);

  init();
  start();
  frame.setLocation(xpos, ypos);
  frame.setVisible(true);

  this.buttonCount = 0;

  this.selectedNum = new int[6];
  this.lotteryNum = new int[6];
  this.winningNum = new int[]{0, 0, 0, 0, 0, 0};
 }

 public void init(){
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setResizable(false);
  con = frame.getContentPane();
  con.setLayout(new BorderLayout());

  //set title JLabel
  titelPane.add(titleLb);

  //set normalBall ImageIcon
  for(int i = 0; i < normalBall.length; i++){
   normalBall[i] = new ImageIcon("normal_lottery_ball" + i + ".gif");
  }

  //set pressedBall ImageIcon
  for(int i = 0; i < pressedBall.length; i++){
   pressedBall[i] = new ImageIcon("pressed_lottery_ball" + i + ".gif");
  }

  //set lotteryBall JCheckBox
  for(int i = 0; i < lotteryBall.length; i++){
   lotteryBall[i] = new JCheckBox(normalBall[i]);
   ballPane.add(lotteryBall[i]);
  }

  //set result Panel
  selectedNumLb.setFont(new Font("", Font.BOLD, 17));
  labelBox.add(selectedNumLb);
  labelBox.add(Box.createVerticalStrut(10));
  lotteryNumLb.setFont(new Font("", Font.BOLD, 17));
  labelBox.add(lotteryNumLb);
  labelBox.add(Box.createVerticalStrut(10));
  winningNumLb.setFont(new Font("", Font.BOLD, 17));
  labelBox.add(winningNumLb);
  for(int i = 0; i < selectedNumDisp.length; i++){
   selectedNumDisp[i] = new JTextField("0");
   selectedNumDisp[i].setEditable(false);
   selectedNumDisp[i].setPreferredSize(new Dimension(60, 25));
   selectedNumDisp[i].setFont(new Font("", Font.BOLD, 15));
   selectedNumDispBox.add(selectedNumDisp[i]);
  }
  numBox.add(selectedNumDispBox);
  numBox.add(Box.createVerticalStrut(10));
  for(int i = 0; i < lotteryNumDisp.length; i++){
   lotteryNumDisp[i] = new JTextField("0");
   lotteryNumDisp[i].setEditable(false);
   lotteryNumDisp[i].setPreferredSize(new Dimension(60, 25));
   lotteryNumDisp[i].setFont(new Font("", Font.BOLD, 15));
   lotteryNumDispBox.add(lotteryNumDisp[i]);
  }
  numBox.add(lotteryNumDispBox);
  numBox.add(Box.createVerticalStrut(10));
  for(int i = 0; i < winningNumDisp.length; i++){
   winningNumDisp[i] = new JTextField("0");
   winningNumDisp[i].setEditable(false);
   winningNumDisp[i].setPreferredSize(new Dimension(60, 25));
   winningNumDisp[i].setFont(new Font("", Font.BOLD, 15));
   winningNumDispBox.add(winningNumDisp[i]);
  }
  numBox.add(winningNumDispBox);
  goBt.setEnabled(false);
  buttonBox.add(goBt);
  buttonBox.add(Box.createHorizontalStrut(60));
  buttonBox.add(initBt);
  
  resultPane.add(labelBox);
  resultPane.add(numBox);
  resultPane.add(buttonBox);

  //set JPanels
  con.add(titelPane, BorderLayout.NORTH);
  con.add(ballPane, BorderLayout.CENTER);
  resultPane.setPreferredSize(new Dimension(600, 150));
  con.add(resultPane, BorderLayout.SOUTH);
 }

 public void start(){
  for(int i = 0; i < lotteryBall.length; i++){
   lotteryBall[i].setSelectedIcon(pressedBall[i]);
   lotteryBall[i].addItemListener(this);
  }

  goBt.addActionListener(this);
  initBt.addActionListener(this);
 }

 public void itemStateChanged(ItemEvent ie){
  for(int i = 0; i < lotteryBall.length; i++){
   if(ie.getSource() == lotteryBall[i]){
    if(lotteryBall[i].isSelected()){
     buttonCount++;
     selectedNumDisp[buttonCount - 1].setText(String.valueOf(i + 1));
     lotteryBall[i].setEnabled(false);
    }else{
     buttonCount--;
    }
   }
  }

  if(buttonCount > 5){
   for(int i = 0; i < lotteryBall.length; i++){
    lotteryBall[i].setEnabled(false);
    goBt.setEnabled(true);
    goBt.setBackground(Color.blue);
    goBt.setForeground(Color.white);
   }
  }
 }

 public void actionPerformed(ActionEvent ae){
  if(ae.getSource() == goBt){
   goBt.setEnabled(false);
   goBt.setBackground(initBt.getBackground());
   goBt.setForeground(initBt.getForeground());
   
   getLotteryNum();
   getWinningNum();
  }else if(ae.getSource() == initBt){
   goBt.setBackground(initBt.getBackground());
   goBt.setForeground(initBt.getForeground());

   for(int i = 0; i < selectedNumDisp.length; i++){
      selectedNumDisp[i].setText("0");
      lotteryNumDisp[i].setForeground(Color.black);
      lotteryNumDisp[i].setText("0");
      winningNumDisp[i].setForeground(Color.black);
      winningNumDisp[i].setText("0");
   }
   for(int i = 0; i < lotteryBall.length; i++){
    lotteryBall[i].setSelected(false);
    lotteryBall[i].setEnabled(true);
   }
  }
 }

 public void getLotteryNum(){
  //get lottery(random) numbers
  for(int i = 0; i < lotteryNum.length; i++){
   int num = (int)(Math.random()*50) + 1;
   lotteryNum[i] = num;

   if(num > 45){
    i--;
   }

   for(int j = 0; j < i; j++){
    if(num == lotteryNum[j]){
     i--;
     break;
    }
   }
  }

  for(int i = 0; i < lotteryNumDisp.length; i++){
   lotteryNumDisp[i].setText(String.valueOf(lotteryNum[i]));
  }
 }

 public void getWinningNum(){
  //get selected numbers
  for(int i = 0; i < selectedNumDisp.length; i++){
   lotteryNumDisp[i].setForeground(Color.blue);
   selectedNum[i] = Integer.parseInt(selectedNumDisp[i].getText());
  }

  //sort selected numbers
  temp = 0;
  for(int i = 0; i < selectedNum.length - 1; i++){
   for(int j = 0; j < selectedNum.length - 1; j++){
    if(selectedNum[j] > selectedNum[j + 1]){
     temp = selectedNum[j];
     selectedNum[j] = selectedNum[j + 1];
     selectedNum[j + 1] = temp;
    }
   }
  }

  //get winning numbers
  count = 0;
  for(int i = 0; i < winningNum.length; i++){
   for(int j = 0; j < winningNum.length; j++){
    int num = selectedNum[i];

    if(num == lotteryNum[j]){
     winningNum[count] = num;
     count++;
    }
   }
  }

  for(int i = 0; i < winningNumDisp.length; i++){
   if(winningNum[i] != 0){
    winningNumDisp[i].setForeground(Color.red);
   }
   winningNumDisp[i].setText(String.valueOf(winningNum[i]));
  }
 }

 public static void main(String[] args){
  JFrame.setDefaultLookAndFeelDecorated(true);
  new SwingLottery();
 }
}



