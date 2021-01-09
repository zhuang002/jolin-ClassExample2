import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int:Integer, double:Double, []:Array, boolean: Boolean;
		MyArrayList al = new MyArrayList();
		al.add(200);
		System.out.println(al);
		al.add(400);
		System.out.println(al);
		al.add(500);
		System.out.println(al);
		al.add(600);
		System.out.println(al);
		al.add(2, 59);
		System.out.println(al);
		al.remove(3);
		System.out.println(al);
		System.out.println("size=" + al.size());

		System.out.println(al.contains(59));
		System.out.println(al.contains(11));

		Object[] ar2 = (Object[]) al.toArray();
		printArray(ar2, ar2.length);

		Integer[] ar3 = new Integer[al.size()];
		al.toArray(ar3);
		printArray(ar3, ar3.length);

		al = new ArrayList<>(Arrays.asList(ar));
		System.out.println(al);

		String[] ar1 = { "sam", "andrew", "jolin" };
		Integer[] ar4 = { 400, 300, 100, 500 };
		MyArrayList al1 = new MyArrayList(Arrays.asList(ar1));
		MyArrayList al2 = new MyArrayList(Arrays.asList(ar4));

		al1.addAll(al2);
		System.out.println(al1);
		System.out.println(al2);

		al1 = new MyArrayList(Arrays.asList(ar1));
		al1.addAll(2, al2);
		System.out.println(al1);

		al1.remove("andrew");
		System.out.println(al1);

		al1.add(2);
		System.out.println(al1);
		al1.remove(2);
		System.out.println(al1);
		al1.remove((Object) 2);

		Arrays.sort(ar1);
		printArray(ar1, ar1.length);
		Collections.sort(al2);
		System.out.println(al2);

		al2.set(1, 200);
		System.out.println(al2);
		System.out.println(al2.get(1));

	}
	
	private static void printArray(Object[] ar, int size) {
		// TODO Auto-generated method stub
		for (int i=0;i<size;i++) {
			System.out.print(ar[i]+",");
		}
		System.out.println("size="+size+",leng="+ar.length);
	}



}

class MyArrayList {
	
	final int  CAPACITY=10;
	Object[] data=new Object[CAPACITY];
	int size=0;
	 
	public MyArrayList(List l) {
		if (l.size()>CAPACITY) {
			data=new Object[l.size()];
		}
		for (Object o:l) {
			this.add(o);
		}
	}
	
	public void addAll(int idx, MyArrayList al) {
		if (idx>=size) return;
		Object[] oldData=this.data;
		if (data.length<size+al.size()) {
			Object[] tmpdata=new Object[size+al.size()];
			for (int i=0;i<idx;i++) {
				tmpdata[i]=data[i];
			}
			
			this.data=tmpdata;
		}
		for (int i=0;i<al.size();i++) {
			this.data[i+idx]=al.get(i);
		}
		for (int i=0;i<size-idx;i++) {
			this.data[i+idx+al.size()]=oldData[idx+i];
		}
		size+=al.size();
		
	}

	public void addAll(MyArrayList al2) {
		// TODO Auto-generated method stub
		if (data.length<size+al2.size()) {
			Object[] tmpdata=new Object[size+al2.size()];
			for (int i=0;i<size;i++) {
				tmpdata[i]=data[i];
			}
			this.data=tmpdata;
		}
		for (int i=0;i<al2.size();i++) {
			this.add(al2.get(i));
		}
		
	}

	private Object get(int i) {
		// TODO Auto-generated method stub
		if (i>=this.size()) 
			return null;
		return data[i];
	}
	
	

	public void add(Object o) {
		if (size>=CAPACITY-1) return;
		data[size]=o;
		size++;
	}

	public void toArray(Object[] ar) {
		// TODO Auto-generated method stub
		int copyCount=size;
		if (copyCount>ar.length)
			copyCount=ar.length;
		for (int i=0;i<copyCount;i++) {
			ar[i]=data[i];
		}
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return this.data.clone();
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for (int i=0;i<size;i++) {
			if (data[i].equals(o))
				return true;
		}
		return false;
	}

	public void remove(Object o) {
		// TODO Auto-generated method stub
		int idx=0;
		for (int i=0;i<size;i++) {
			if (data[i].equals(o)) {
				remove(idx);
			}
		}
		
	}
	
	public void remove(int idx) {
		if (size<=0) return;
		for (int i=idx;i<size-1;i++) {
			data[i]=data[i+1];
		}
		size--;
	}

	public void add(int idx, Object o) {
		// TODO Auto-generated method stub
		if (size>=CAPACITY-1) return;
		
		for (int i=size-1;i>=idx;i--) {
			data[i+1]=data[i];
		}
		data[idx]=o;
		size++;
	}
	
	
	
}
