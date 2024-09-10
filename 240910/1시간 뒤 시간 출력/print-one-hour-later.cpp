#include <iostream>
using namespace std;

int main() {
    int h, m;

    cin >> h;
    cin.get();
    cin >> m;

    h = (h + 1) % 24;

    cout << h << ":" << m;

    return 0;
}