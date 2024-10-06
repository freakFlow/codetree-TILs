#include <iostream>
using namespace std;

int main() {
    double num, sum = 0;

    for(int i=0; i<8; i++){
        cin >> num;
        sum += num;
    }

    cout << fixed;
    cout.precision(1);

    cout << sum / 8;

    return 0;
}