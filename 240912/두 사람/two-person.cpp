#include <iostream>
using namespace std;

int main() {
    int a, b;
    char c, d;

    cin >> a >> c >> b >> d;

    cout << ((a >= 19 && c == 'M') || (b >= 19 && d == 'M'));

    return 0;
}