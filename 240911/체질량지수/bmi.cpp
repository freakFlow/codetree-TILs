#include <iostream>
using namespace std;

int main() {
    int h, w;
    int b;

    cin >> h >> w;

    b = 10000 * w / (h * h);

    cout << b;
    if(b >= 25) cout << "\nObesity";

    return 0;
}