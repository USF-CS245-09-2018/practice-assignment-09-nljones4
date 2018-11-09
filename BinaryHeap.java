public class BinaryHeap{
	private int [] a;
	private int size;
	
	public BinaryHeap(){
		size = 0;
		a = new int[10];
	}

	public void add(int pri){
		if(size >= a.length){
			grow_array();
		}
		a[size]=pri;
		++size;
		int index = size -1;
		int parent = (index-1)/2;
		while(index > 0 && a[index] < a[parent]){
			swap(a, index, parent);
			index = parent;
			parent = (index-1)/2;
		}
	}
	
	public int remove(){
		int pri = a[0];
		a[0] = a[size-1];
		--size;
		shiftDown(0);
		return pri;
	}

	public void shiftDown(int parent){
		int child = parent*2+1;
		if (child >= size){
			return;
		}
		
		if(a[child+1] < a[child]){
			child++;
		}
		if(a[child] < a[parent]){
			swap(a, child, parent);
			shiftDown(child);
		}
	
	}
	
	public void swap (int [] a, int child, int parent){
		int temp = a[child];
		a[child] = a[parent];
		a[parent] = temp; 
	}

	public void grow_array(){
		int[] newArray = new int[a.length*2];
		for(int i = 0; i < a.length; i++){
			newArray[i] = a[i];
		}
		a = newArray;
		
	}


}