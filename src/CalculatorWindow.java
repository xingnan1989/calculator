//����1 CalculatorWindow.java(����)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.io.*;

public class CalculatorWindow extends JFrame implements ActionListener
{
	MenuBar menuBar;
	Menu menuFile, menuFileEdit, menuFileHelp;
	MenuItem menusaveFile, menucopyFile, menuclearFile, menuEdit, menuHelp;
	NumberButton numberButton[];
	OperationButton operationButton[];
	JButton С�������, �����Ų���, �˸����, �ȺŲ���, �������, sin, cos, sqrt, tan, pow;
	JTextField resultShow; // ��ʾ������
	JTextField showComputerProcess; // ��ʾ��ǰ�������
	JTextArea saveComputerProcess; // ��ʾ���㲽��
	JButton saveButton, copyButton, clearButton;
	LinkedList<String> list; // ����������ŵ�һ����������������ź͵ڶ���������
	HandleDigit handleDigit; // ������ActionEvent�¼�
	HandleOperation handleOperation;
	HandleBack handleBack;
	HandleClear handleClear;
	HandleEquality handleEquality;
	HandleDot handleDot;
	HandlePOrN handlePOrN;
	HandleSin handleSin;
	HandleCos handleCos;
	HandleSqrt handleSqrt;
	HandleTan handleTan;
	HandlePow handlePow; // ������Щ��

	public CalculatorWindow()
	{
		setTitle("������");
		menuBar = new MenuBar();
		this.setMenuBar(menuBar);
		menuFile = new Menu("File");
		menusaveFile = new MenuItem("Save As");
		menusaveFile.addActionListener(this);
		menucopyFile = new MenuItem("Copy");
		menucopyFile.addActionListener(this);
		menuclearFile = new MenuItem("Clear");
		menuclearFile.addActionListener(this);
		menuFileEdit = new Menu("FileEdit");
		menuEdit = new MenuItem("�鿴�༭");
		menuFileHelp = new Menu("Help");
		menuHelp = new MenuItem("Help Topics");
		menuFile.add(menusaveFile);
		menuFile.add(menucopyFile);
		menuFile.add(menuclearFile);
		menuFileEdit.add(menuEdit);
		menuFileHelp.add(menuHelp);
		menuBar.add(menuFile);
		menuBar.add(menuFileEdit);
		menuBar.add(menuFileHelp);
		JPanel panelLeft, panelRight;
		list = new LinkedList<String>();
		resultShow = new JTextField(10);
		resultShow.setHorizontalAlignment(JTextField.RIGHT);
		resultShow.setForeground(Color.blue);
		resultShow.setFont(new Font("TimesRoman", Font.BOLD, 16));
		resultShow.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		resultShow.setEditable(false);
		resultShow.setBackground(Color.white);
		showComputerProcess = new JTextField();
		showComputerProcess.setHorizontalAlignment(JTextField.CENTER);
		showComputerProcess.setFont(new Font("Arial", Font.BOLD, 16));
		showComputerProcess.setBackground(Color.cyan);
		showComputerProcess.setEditable(false);
		saveComputerProcess = new JTextArea();
		saveComputerProcess.setEditable(false);
		saveComputerProcess.setFont(new Font("����", Font.PLAIN, 20));
		numberButton = new NumberButton[10];
		handleDigit = new HandleDigit(list, resultShow, showComputerProcess);
		for (int i = 0; i <= 9; i++)
		{
			numberButton[i] = new NumberButton(i);
			numberButton[i].setFont(new Font("Arial", Font.BOLD, 20));
			numberButton[i].addActionListener(handleDigit);
		}
		operationButton = new OperationButton[4];
		handleOperation = new HandleOperation(list, resultShow, showComputerProcess, saveComputerProcess);
		String �������[] =
		{ "+", "-", "*", "/" };
		for (int i = 0; i < 4; i++)
		{
			operationButton[i] = new OperationButton(�������[i]);
			operationButton[i].setFont(new Font("Arial", Font.BOLD, 24));
			operationButton[i].addActionListener(handleOperation);
		}
		С������� = new JButton(".");
		handleDot = new HandleDot(list, resultShow, showComputerProcess);
		С�������.addActionListener(handleDot);
		�����Ų��� = new JButton("+/-");
		handlePOrN = new HandlePOrN(list, resultShow, showComputerProcess);
		�����Ų���.addActionListener(handlePOrN);
		�ȺŲ��� = new JButton("=");
		handleEquality = new HandleEquality(list, resultShow, showComputerProcess, saveComputerProcess);
		�ȺŲ���.addActionListener(handleEquality);
		sin = new JButton("sin");
		handleSin = new HandleSin(list, resultShow, showComputerProcess, saveComputerProcess);
		sin.addActionListener(handleSin);
		cos = new JButton("cos");
		handleCos = new HandleCos(list, resultShow, showComputerProcess, saveComputerProcess);
		cos.addActionListener(handleCos);
		sqrt = new JButton("��");
		handleSqrt = new HandleSqrt(list, resultShow, showComputerProcess, saveComputerProcess);
		sqrt.addActionListener(handleSqrt);
		tan = new JButton("tan");
		handleTan = new HandleTan(list, resultShow, showComputerProcess, saveComputerProcess);
		tan.addActionListener(handleTan);
		pow = new JButton("x^2");
		handlePow = new HandlePow(list, resultShow, showComputerProcess, saveComputerProcess);
		pow.addActionListener(handlePow);
		�˸���� = new JButton("�˸�");
		handleBack = new HandleBack(list, resultShow, showComputerProcess);
		�˸����.addActionListener(handleBack);
		������� = new JButton("C");
		handleClear = new HandleClear(list, resultShow, showComputerProcess);
		�������.addActionListener(handleClear);
		�������.setForeground(Color.red);
		�˸����.setForeground(Color.red);
		�ȺŲ���.setForeground(Color.red);
		sin.setForeground(Color.blue);
		cos.setForeground(Color.blue);
		sqrt.setForeground(Color.blue);
		tan.setForeground(Color.blue);
		pow.setForeground(Color.blue);
		�����Ų���.setForeground(Color.blue);
		С�������.setForeground(Color.blue);
		panelLeft = new JPanel();
		panelRight = new JPanel();
		panelLeft.setLayout(new BorderLayout());
		JPanel centerInLeft = new JPanel();
		panelLeft.add(resultShow, BorderLayout.NORTH);
		panelLeft.add(centerInLeft, BorderLayout.CENTER);
		centerInLeft.setLayout(new GridLayout(4, 6));
		centerInLeft.add(numberButton[1]);
		centerInLeft.add(numberButton[2]);
		centerInLeft.add(numberButton[3]);
		centerInLeft.add(operationButton[0]);
		centerInLeft.add(sqrt);
		centerInLeft.add(�������);
		centerInLeft.add(numberButton[4]);
		centerInLeft.add(numberButton[5]);
		centerInLeft.add(numberButton[6]);
		centerInLeft.add(operationButton[1]);
		centerInLeft.add(sin);
		centerInLeft.add(�˸����);
		centerInLeft.add(numberButton[7]);
		centerInLeft.add(numberButton[8]);
		centerInLeft.add(numberButton[9]);
		centerInLeft.add(operationButton[2]);
		centerInLeft.add(cos);
		centerInLeft.add(tan);
		centerInLeft.add(numberButton[0]);
		centerInLeft.add(�����Ų���);
		centerInLeft.add(С�������);
		centerInLeft.add(operationButton[3]);
		centerInLeft.add(pow);
		centerInLeft.add(�ȺŲ���);
		panelRight.setLayout(new BorderLayout());
		panelRight.add(showComputerProcess, BorderLayout.NORTH);
		saveButton = new JButton("����");
		copyButton = new JButton("����");
		clearButton = new JButton("���");
		saveButton.setToolTipText("���������̵��ļ�");
		copyButton.setToolTipText("����ѡ�еļ������");
		clearButton.setToolTipText("����������");
		saveButton.addActionListener(this);
		copyButton.addActionListener(this);
		clearButton.addActionListener(this);
		panelRight.add(new JScrollPane(saveComputerProcess), BorderLayout.CENTER);
		JPanel southInPanelRight = new JPanel();
		southInPanelRight.add(saveButton);
		southInPanelRight.add(copyButton);
		southInPanelRight.add(clearButton);
		panelRight.add(southInPanelRight, BorderLayout.SOUTH);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
		add(split, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 50, 530, 260);
		validate();
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == copyButton || e.getSource() == menucopyFile)
			saveComputerProcess.copy();
		if (e.getSource() == clearButton || e.getSource() == menuclearFile)
			saveComputerProcess.setText(null);
		if (e.getSource() == saveButton || e.getSource() == menusaveFile)
		{
			JFileChooser chooser = new JFileChooser();
			int state = chooser.showSaveDialog(null);
			File file = chooser.getSelectedFile();
			if (file != null && state == JFileChooser.APPROVE_OPTION)
			{
				try
				{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
					String timeStr = sdf.format(new Date());
					String content = saveComputerProcess.getText();
					StringReader read = new StringReader(content + timeStr);
					BufferedReader in = new BufferedReader(read);
					FileWriter outOne = new FileWriter(file);
					BufferedWriter out = new BufferedWriter(outOne);
					String str = null;
					while ((str = in.readLine()) != null)
					{
						out.write(str);
						out.newLine();
					}
					in.close();
					out.close();
				} catch (IOException e1)
				{
				}
			}
		}
	}

	public static void main(String args[])
	{
		new CalculatorWindow();
	}
}
