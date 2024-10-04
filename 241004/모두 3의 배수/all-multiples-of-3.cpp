#include <iostream>
using namespace std;

int main() {
    int num;
    bool isOne = true;

    for(int i=0; i<5; i++){
        cin >> num;

        if(num % 3 > 0){
            isOne = false;
        }
    }

    cout << (isOne ? 1 : 0);

    return 0;
}