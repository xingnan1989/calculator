import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;

public class HandleDigit implements ActionListener
{
	LinkedList<String> list;
    JTextField resultShow,showComputerProcess;
    boolean bd=false;
	public HandleDigit(LinkedList<String> list, JTextField resultShow, JTextField showComputerProcess)
	{
		this.list=list;
		this.resultShow=resultShow;
		this.showComputerProcess=showComputerProcess;
	}

	public void actionPerformed(ActionEvent e)
	{
		NumberButton b = (NumberButton)e.getSource();
			if (list.size() == 0)            //�������û�нڵ�
			{
				int number = b.getNumber();    //��ȡ��ť�ϵ�����
				list.add(" " + number);          //��������ӵ�����
				resultShow.setText(" " + number);
				bd = false;
			}
			else if (list.size() == 1 && bd == false)   //���������һ���ڵ�
			{
				int number = b.getNumber();
				String num = (String)list.getFirst();
				String s = num.concat("" + number);   //������������β���
				list.set(0, s);
				resultShow.setText(" " + s);
			}
			else if (list.size() == 1 && bd == true)
			{
				int number = b.getNumber();
				list.removeFirst();
				list.add(" " + number);     //��������ӵ�����
				bd = false;
				resultShow.setText("" + number);
			}
			else if (list.size() == 2)     //���������2���ڵ�
			{
				int number = b.getNumber();
				list.add(" " + number);    //������ӵ������ڵ�
				resultShow.setText(" " + number);
			}
			else if (list.size() == 3)    //���������3���ڵ�
			{
				int number = b.getNumber();
				String num = (String)list.getLast();
				String s = num.concat("" + number);
				list.set(2, s);
				resultShow.setText("" + s);
			}

	}



}
