#include <iostream>
using namespace std;

int main() {
    char a, b, c;
    int d, e, f;

    cin >> a >> d >> b >> e >> c >> f;

    int i = 0;

    if(a == 'Y' && d >= 37) i++;
    if(b == 'Y' && e >= 37) i++;
    if(c == 'Y' && f >= 37) i++;

    cout << (i >= 2 ? 'E' : 'N');

    return 0;
}