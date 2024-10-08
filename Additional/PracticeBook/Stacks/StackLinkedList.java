
public class StackLinkedList implements MyStack {
	private CDLinkedList theList;
	
	public StackLinkedList(){ // create an empty stack
		theList = new CDLinkedList();
	}
	
	public StackLinkedList(CDLinkedList l) throws Exception {
		super();
		DListIterator iparam = new DListIterator(l.header);
		DListIterator ithis = new DListIterator(theList.header);
		while (iparam.hasNext()) {
			int v = iparam.next();
			if (iparam.currentNode == l.header)
				return;
			theList.insert(v, ithis);
			ithis.next();
		}	
	}
	
	public CDLinkedList getTheList() {
		return theList;
	}

	public void setTheList(CDLinkedList theList) {
		this.theList = theList;
	}

	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public boolean isFull(){
		return false;
	}
	
    @Override
	public void makeEmpty(){
		theList.makeEmpty();
	}
	
        @Override
	public int top() throws MyStackException{
		if(isEmpty())
			throw new MyStackException();
		return theList.header.nextNode.data;
	}
	@Override
	public void pop() throws MyStackException{
		if(isEmpty())
			throw new MyStackException();
		Iterator itr = new DListIterator(theList.header);
		theList.remove(itr);
	}
	@Override
	public void push(int data) throws Exception{
		Iterator itr = new DListIterator(theList.header);
		theList.insert(data, itr);
	}
	
	private DListIterator findPos(int i) throws Exception {
		DListIterator iPos = new DListIterator(theList.header);
		for(int k =0;k<= i;k++) {
			iPos.next();
		}
		return iPos;
	}
	@Override
	public int size() {
		return theList.size;
	}
	

	public int removeBottom() throws MyStackException, Exception {

        StackLinkedList tempStack = new StackLinkedList();

        while (!isEmpty()) {
            tempStack.push(top());
            pop();
        }

        int bottom = tempStack.top();
        tempStack.pop();

        while (!tempStack.isEmpty()) {
            push(tempStack.top());
            tempStack.pop();
        }

        return bottom;
    }
}
