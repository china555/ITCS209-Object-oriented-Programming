
public class test_test {
		public static void main(String[] args) {
			int x[] = {1,9,52,107,257,987,1000,25,14,28,32,47,257,26,742,32,14,985,2647,226,3265,892,674,63,268,14,756};
			int y[] = {65,78,24,95,63,47,8965,35524,5,8658,8928,282,82,5654842,865,18451,26,49652,354155,15484121,4215484,218,2,568,68,7,5698,56,988,45,698,59,9,8,5,69,85,56,56,21,458121,45845,4};
			test_queue n = new test_queue(x.length);
			test_queue c = new test_queue(y.length);
			for(int i : x) { // for(i=0;i<x.length;i++)
				n.in(i);
			}
				n.display();
			for(int i=0;i<4;i++) {
				n.out();
			}
				n.display();
				
			for(int j=0;j<y.length;j++) {
				c.in(y[j]);
			}
				c.display();
			for(int i=0;i<10;i++) {
				c.out();
			}
				c.display();
				
			test_stack l = new test_stack(y.length+x.length);
			int countx =0,county =0;
			while(county<y.length) {
				if(countx<x.length) {
				l.push(x[countx]);
				countx++;
				}
				l.push(y[county]);
				county++;
			}
			l.display();
			for(int i =0;i<12;i++) {
				l.pop();
			}
			l.display();
		}
}
