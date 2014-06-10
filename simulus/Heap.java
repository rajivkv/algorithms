
int heap[];
int size;
public void buildHeap(int a[){
heap = new int[a.length+ a.length-1];
size = [a.length+ a.length-2;
//O(n) heap build
for(int i=a.length-2 ; i >=0; i--){
	insert()
}



void insert(int n){
	int child1= 2*n;
	int child2= 2*n + 1;
	heap[n]= child1<child2:a[child1]:a[child2]
}

void insert(int element){

	heap[++size] = element;

	int i = size;
	int parent = a[size/2];
	while(a[parent]>a[i]){
		swap(a[parent],a[i]);
		i = parent;
		parent = i/2;
	}

}

public Pair getMin(){
	int min = size>=0 ? heap[0] : null;

	heap[0]=heap[size];
	siz-1;
	int i = 0;
	while(1){
		if(2*i > size){
			break;
		}
		int child = 2*i;
		child = 2*i + 1 <= size &&  2*i + 1 < 2*i ? 2*i+1 : 2*i;
		if(a[i]<a[child]){
			break;
		}
		swap(a[i],a[child]);
		i = child;
	}
	return min;

}
void int sortedSum(int sort1[], int sort2[]){
	int sortedSum[] = new int[sort1.length + sort2.length];
	insert(sort1[a1]+sort2[b2]);
	int ind;
	while((min=getMin())!=null){
		sortedSum[ind++] = a[min.x] + b[min.y];
		if(min.y!=sort2.length-1){
			//if not already inserted, insert again
			insert(new Pair(min.x,min.y+1));
		}
		if(min.x!=sort1.length-1 && (i`){
			insert(new Pair(min.x+1,min.y));
		}
	}
}

}
