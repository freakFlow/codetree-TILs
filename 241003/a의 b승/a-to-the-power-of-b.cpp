#include <iostream>
using namespace std;

int main() {
    int a, b;
    int mul = 1;

    cin >> a >> b;

    for(int i=0; i<b; i++){
        mul *= a;
    }

    cout << mul;

    return 0;
}