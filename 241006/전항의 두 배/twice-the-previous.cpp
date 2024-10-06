#include <iostream>
using namespace std;

int main() {
    int n1, n2;

    cin >> n1 >> n2;

    cout << n1 << ' ' << n2 << ' ';
    for(int i=3; i<=10; i++){
        int next = 2 * n1 + n2;
        cout << next << ' ';
        n1 = n2;
        n2 = next;
    }

    return 0;
}