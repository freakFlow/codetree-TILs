#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    int a = 1;

    cout << a << ' ' << n << ' ';
    while(n <= 100){
        int nn = a + n;
        cout << nn << ' ';
        a = n;
        n = nn;
    }

    return 0;
}