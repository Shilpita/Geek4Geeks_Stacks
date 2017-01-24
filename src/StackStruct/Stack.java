package StackStruct;

public class Stack {
	protected int top;
	protected int size;
	protected Stack next;
	
	public Stack(){
		this.top = -1;
		this.size= 0;
		this.next= new Stack();
	}
}
