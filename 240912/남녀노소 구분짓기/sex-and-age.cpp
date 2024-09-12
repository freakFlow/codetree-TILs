#include <iostream>
using namespace std;

int main() {
    int a, b;

    cin >> a >> b;

    if(a == 0) cout << (b >= 19 ? "MAN" : "BOY");
    else cout << (b >= 19 ? "WOMAN" : "GIRL");

    return 0;
}