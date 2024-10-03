#include <iostream>
using namespace std;

int main() {
    int num;
    int sum = 0, count = 0;

    while(true){
        cin >> num;

        if(num < 20 || num > 29){
            cout << fixed;
            cout.precision(2);

            cout << (double)sum / count;
            break;
        }

        sum += num;
        count++;
    }

    return 0;
}