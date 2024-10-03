#include <iostream>
using namespace std;

int main() {
    int n;
    int mul = 1;

    cin >> n;

    for(int i=1; i<=10; i++){
        mul *= i;
        if(mul >= n){
            cout << i;
            break;
        }
    }

    return 0;
}