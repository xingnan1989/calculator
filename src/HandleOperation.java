import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HandleOperation implements ActionListener
{

    LinkedList<String> list;
    JTextField resultShow,showComputerProcess;          
    JTextArea saveComputerProcess; 
	public HandleOperation(LinkedList<String> list, JTextField resultShow, JTextField showComputerProcess, JTextArea saveComputerProcess)
	{
		this.list=list;
		this.resultShow=resultShow;
		this.showComputerProcess=showComputerProcess;
		this.saveComputerProcess=saveComputerProcess;
	}

	public void actionPerformed(ActionEvent e)
	{
		OperationButton b = (OperationButton)e.getSource();    //���������3���ڵ�
		if (list.size() == 1)
		{
			String fuhao = b.getOperator();
			list.add(fuhao);    //����ڶ����ڵ��Ų�������
			resultShow.setText(fuhao);
		}
		else if (list.size() == 2)
		{
			String fuhao = b.getOperator();
			list.set(1, fuhao);   //�Ļ��ڶ��ڵ�ķ���
			resultShow.setText(fuhao);
		}
		else if (list.size() == 3)
		{
			String fuhao = b.getOperator();
			String number1 = (String)list.getFirst();  //��ȡ�������һ���ڵ����ֵ
			String number2 = (String)list.getLast();   //��ȡ���������һ���ڵ����ֵ
			String fuhao1 = (String)list.get(1);       //��ȡ�������2���ڵ�ķ���
			double n1 = Double.parseDouble(number1);  //����1���ڵ��ֵת��Ϊdouble��
			double n2 = Double.parseDouble(number2);   //�������ڵ��ֵת��Ϊdouble��
			double n = 0;
			if (fuhao1.equals("+"))
			{
				n = n1 + n2;
			}
			else if (fuhao1.equals("-"))
			{
				n = n1 - n2;
			}
			else if (fuhao1.equals("*"))
			{
				n = n1 * n2;
			}
			else if (fuhao1.equals("/"))
			{
				n = n1 / n2;
			}
			list.clear();      //�������
			list.add(" " + n);   //�������n
			list.add(fuhao);       //��ӷ���
			resultShow.setText(" " + n);
	}
	}
}
