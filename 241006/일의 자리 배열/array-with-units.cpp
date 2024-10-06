#include <iostream>
using namespace std;

int main() {
    int num1, num2;

    cin >> num1 >> num2;

    cout << num1 << ' ' << num2 << ' ';
    for(int i=3; i<=10; i++){
        int temp = (num1 + num2) % 10;
        cout << temp << ' ';
        num1 = num2;
        num2 = temp;
    }

    return 0;
}