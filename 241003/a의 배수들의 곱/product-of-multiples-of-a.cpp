#include <iostream>
using namespace std;

int main() {
    int a, b;
    int mul = 1;

    cin >> a >> b;

    for(int i=1; i<=b; i++){
        if(i % a == 0) mul *= i;
    }

    cout << mul;

    return 0;
}