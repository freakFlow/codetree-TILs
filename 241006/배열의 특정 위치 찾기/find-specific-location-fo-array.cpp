#include <iostream>
using namespace std;

int main() {
    int arr[10];
    int sum;

    for(int i=0; i<10; i++){
        cin >> arr[i];
    }

    for(int i=1; i<10; i+=2){
        sum += arr[i];
    }
    cout << sum << ' ';

    cout << fixed;
    cout.precision(1);
    cout << (double)(arr[2] + arr[5] + arr[8]) / 3;

    return 0;
}