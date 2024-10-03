#include <iostream>
using namespace std;

int main() {
    int a, b;
    int mul = 1;

    cin >> a >> b;

    for(int i=a; i<=b; i++){
        mul *= i;
    }

    cout << mul;

    return 0;
}