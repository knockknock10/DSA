// #include <iostream>
// using namespace std;
// void calac(int a, int b, char ch)
// {
//     (a > b) ? cout << "a is greater" : cout << "b is greater";
//     (a == b) ? cout << "both are equal" : cout << " ";
//     (a < b) ? cout << "a is smaller" : cout << "b is smaller";
//     switch (ch)
//     {
//     case '+':
//         cout << a + b;
//         break;
//     case '-':
//         cout << a - b;
//         break;
//     case '*':
//         cout << a * b;
//         break;
//     case '/':
//         cout << a / b;
//         break;

//     default:
//         cout << "wrong input";
//         break;
//     }
// }
// static int high_score= 1000;
// int main(){
//     int a ,b;
//     char ch = '+';
//     cin>>a;
//     cin>>b;
//     calac(a,b,ch);
//     return 0;
    
// }
#include <iostream>
using namespace std;

int float calculateSI(float principal, int time = 5, float rate = 0.1) {
    return (principal * time * rate);
}

int main() {
    float p;
    cout << "Enter principal amount: ";
    cin >> p;
    cout << "SI (only principal): " << calculateSI(p) << endl;
    cout << "SI (principal+time): " << calculateSI(p, 3) << endl;
    cout << "SI (principal+rate+time): " << calculateSI(p, 3, 0.05) << endl;

    return 0;
}