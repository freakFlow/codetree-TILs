#include <iostream>
using namespace std;

int main() {
    int num, count = 0;

    for(int i=0; i<10; i++){
        cin >> num;
        if(num % 2 == 1) count++;
    }

    cout << count;

    return 0;
}