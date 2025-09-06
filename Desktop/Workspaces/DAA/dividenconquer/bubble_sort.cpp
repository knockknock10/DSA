#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

void bubble_sort(int arr[], int n) {
    int count = 0;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                count++;
            }
        }
    }cout<<"total no comaparisons is :"<<count<<endl;
}

void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    srand(time(0)); 
    int n = 5;     
    int arr[100];   
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 101; 
    }
    cout << "Original array: ";
    printArray(arr, n);
    bubble_sort(arr, n);
    cout << "Sorted array:   ";
    printArray(arr, n);

    return 0;
}
