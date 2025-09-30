public class Oops{
    public class student{
        String name;
        int marks;
        int roll_no;
        void std(String name,int marks, int roll_no){
            this.name = name;
            this.marks = marks;
            this.roll_no = roll_no;
        }
        void displ(){
            System.out.println(this.name);
            
        }
        
    }
    
    public static void main(String[] args){
        student s = new student();
        s.std("kr",234,123);
    }
}
