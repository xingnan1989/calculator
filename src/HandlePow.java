//����14 HandlePow.java
import java.util.LinkedList;
import java.lang.Math.*;
import javax.swing.*;
import java.awt.event.*;
public class HandlePow implements ActionListener{
    LinkedList<String> list;
    JTextField resultShow,showComputerProcess;          
    JTextArea saveComputerProcess; 
    HandlePow(LinkedList<String> list,JTextField t1,JTextField t2,
                    JTextArea t3){
        this.list=list;
        resultShow=t1;
        showComputerProcess=t2; 
        saveComputerProcess=t3;
    }
public void actionPerformed(ActionEvent e){
	if(list.size()==1||list.size()==2){
           String numOne=list.getFirst();
           try{  double x=Double.parseDouble(numOne);
                 double result=Math.pow(x,2);
                 String str=String.valueOf(result);
                 list.set(0,str);
                 resultShow.setText(str);
                 String proccess="pow("+numOne+")="+result;
                 showComputerProcess.setText(proccess);
                 saveComputerProcess.append(" "+proccess+"\n");
                 if(list.size()==2)
                    list.removeLast(); //�Ƶ�������� 
              }
           catch(Exception ee){}
       } 
       else if(list.size()==3){
           String numTwo=list.getLast();
           try{  double x=Double.parseDouble(numTwo);
                 double result=Math.pow(x,2);
                 String str=String.valueOf(result);
                 list.set(0,str);
                 resultShow.setText(str);
                 String proccess="pow("+numTwo+")="+result;
                 showComputerProcess.setText(proccess);
                 saveComputerProcess.append(" "+proccess+"\n");
                 list.removeLast(); //�Ƶ���2�������� 
                 list.removeLast(); //�Ƶ�������� 
              }
           catch(Exception ee){}
        }
}
}

