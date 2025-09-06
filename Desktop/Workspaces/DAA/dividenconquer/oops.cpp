#include<iostream>
#include<string>
using namespace std;
// class teacher{
//     private:
//         int salary;
//     public:
//         //properties/attributes
//         string name;
//         string dept;
//         string subj;
//         //methods //member function
//         void chaneg_dept(string newdept){
//             dept = newdept;
//         }
//         //seters
//         void change_salary(int newsal){
//             salary = newsal;
//         }
//         //geters
//         int getsalry(){
//             return salary;
//         }
// };
// class account{
//     private:
//         string password;
//         int balance;          // data hiding
//     public:
//         string usernmae;
//         string account_id;
// };

void swapvalues(int &a,int &b){
    int temp = a;
    a = b;
    b = temp;
}

class teachers{
    public:
    //constructor
        teachers(string n,string dept){  //parametarized constructor
            name=n;
            department=dept;
        }
        string name;
        string department;
        void getinfo(){
            cout<<"name :"<<name<<endl;
            cout<<"dept : "<<department<<endl;
        }
};
const double pi = 3.12;
int main(){
    teachers t1("sanjeev","cs");//parametarized
    t1.getinfo();
   // teacher t1;
    // t1.name = "sanjeev";
    // t1.subj = "C++";
    // cout<< t1.name<<endl;
    // t1.change_salary(20000);
    // cout<<t1.getsalry()<<endl;

    // int age =18;
  
    // int bod = 2023;
    // cout<<age<<bod<<endl;
    // cout<<pi;
    int num1,num2;
    cout<<"enter the first num";
    return 0;
}