#include <iostream>
using namespace std;

int main() {
    int sum = 0;

    for(int i=0; i<10; i++){
        int num;
        cin >> num;

        sum += num;
    }

    cout << sum;

    return 0;
}