import java.awt.*;
import java.util.Stack;
import java.awt.event.*;
class Calculate{
	int priority(char c){
		switch(c){
			case '+':return 3;
			case '-':return 3;
			case '*':return 2;
			case '/':return 2;
			case '^':return 1;
			default: return 4;
			}
	}
	String[] convertToArray(String s){
		String[] array=new String[s.length()+3];
		int start=0,last=-1,skip=0;
		for (int i=0;i<s.length();i++){
			if (skip>0){
				skip--;
			}
			else if (s.charAt(i)=='('){
				array[++last]="(";
				start=i+1;
			}	
			else  if (s.charAt(i)==')'){
				array[++last]=s.substring(start,i);
				array[++last]=")";
				start=i+1;
			}
			else if (s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/' || s.charAt(i)=='^'){
				if (s.charAt(i-1)!=')')
					array[++last]=s.substring(start,i);
				array[++last]=s.substring(i,i+1);
				start=i+1;
				if (s.charAt(i+1)=='-')
					skip++;
			}		
	    

		}
		if (last==-1 || array[last].equals(")")==false)
			array[++last]=s.substring(start,s.length());
	    	array[++last]="\0";
		return array;
	}
    	String infixToPostfix(String str){
		Stack stack=new Stack();
		String[] s=convertToArray(str);
		StringBuffer postfix=new StringBuffer();
		for(int i=0;s[i].equals("\0")==false;i++){
			if (s[i].equals("+") || s[i].equals("-") || s[i].equals("*") || s[i].equals("/") || s[i].equals("^")){
				while (stack.empty()==false && priority(String.valueOf(stack.peek()).charAt(0))<=priority(s[i].charAt(0)))
					postfix.append(String.valueOf(stack.pop())+" ");
				stack.push(String.valueOf(s[i]));
				}
			else if (s[i].equals("("))
				stack.push("(");
			else if(s[i].equals(")")){
				while(String.valueOf(stack.peek()).equals("(")==false)
					postfix.append(stack.pop()+" ");
				stack.pop();
				}
			else
				postfix.append(s[i]+" ");
			}
			while(stack.empty()==false)
				postfix.append(stack.pop()+" ");
		return new String(postfix);

	}
	String postfixToValue(String s){
		String postfix[]=s.split(" ");
		Stack stack=new Stack();
		for(int i=0;i<postfix.length;i++){
			if (postfix[i].equals("+") || postfix[i].equals("-") || postfix[i].equals("*") || postfix[i].equals("/") || postfix[i].equals("^")){
				Object o2=stack.pop();
				Object o1=stack.pop();	
				String op2=o2.toString();
				String op1=o1.toString();
				double temp;
				if (postfix[i].equals("+")){
					temp=Double.valueOf(op1)+Double.valueOf(op2);}
				else if (postfix[i].equals("-")){
					temp=Double.valueOf(op1)-Double.valueOf(op2);}
				else if (postfix[i].equals("*")){
					temp=Double.valueOf(op1)*Double.valueOf(op2);}
				else if (postfix[i].equals("/")){
					temp=Double.valueOf(op1)/Double.valueOf(op2);}
				else{
					temp=Math.pow(Double.valueOf(op1),Double.valueOf(op2));}
				stack.push(String.valueOf(temp));
				}
			else{
				stack.push(postfix[i]);}
				
			}	
		return String.valueOf(stack.peek());
	}
}
public class Calculator extends Frame implements ActionListener{
Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,br1,br2,bc,p,a,s,m,d,e,c;
TextField t1,t2;
Calculator(){
	setSize(500,500);
	setTitle("Calculator");
	t1=new TextField("",20);
	t2=new TextField(10);
	add(t1);
	add(new Label());
	add(new Label());
	add(t2);
	add(new Label());
	b0=new Button("0");
	b1=new Button("1");
	b2=new Button("2");
	b3=new Button("3");
	b4=new Button("4");
	b5=new Button("5");
	b6=new Button("6");
	b7=new Button("7");
	b8=new Button("8");
	b9=new Button("9");
	a=new Button("+");
	s=new Button("-");
	m=new Button("*");
	d=new Button("/");
	e=new Button("=");
	br1=new Button("(");
	br2=new Button(")");
	bc=new Button("<-");
	p=new Button("^");
	c=new Button("clear");
	Button[] button_array={a,s,m,d,c,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,br1,br2,p,bc,e};
	for (int i=0;i<button_array.length;i++){
		add(button_array[i]);
		button_array[i].addActionListener(this);
	}
	setLayout(new GridLayout(5,4));
	addWindowListener(new SomeWindow());
	setVisible(true);
}
public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==c){
	t1.setText(null);
	t2.setText(null);
	}
	else if (ae.getSource()==bc){
	String str=t1.getText();
	if (str.length()!=0)
		t1.setText(str.substring(0,str.length()-1));	
	}
	else if (ae.getSource()==e){
	Calculate obj=new Calculate();
	try{
		String prefix=obj.infixToPostfix(t1.getText());
		String result=obj.postfixToValue(prefix);
		t2.setText(result);	
	}
	catch (Exception e){t2.setText("Invalid Expression");}
	}
	else{
	StringBuffer sb=new StringBuffer(t1.getText());
	sb.append(ae.getActionCommand());
	t1.setText(new String(sb));	
	}
	
}
class SomeWindow extends WindowAdapter{
public void windowClosing(WindowEvent e){
	System.exit(0);
	}
}public static void main(String[] ad){
	new Calculator();
	}
}
