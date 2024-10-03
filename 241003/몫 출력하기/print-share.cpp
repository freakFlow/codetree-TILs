#include <iostream>
using namespace std;

int main() {
    int num;
    int count = 3;

    while(count > 0){
        cin >> num;

        if(num % 2 == 0){
            cout << num / 2 << endl;
            count--;
        }
    }

    return 0;
}