#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    cout << n * n;
    if(n < 5) cout << "\ntiny";

    return 0;
}