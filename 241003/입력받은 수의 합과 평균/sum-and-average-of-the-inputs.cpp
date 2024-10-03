#include <iostream>
using namespace std;

int main() {
    int n;
    int num;
    int sum = 0;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num;
        sum += num;
    }

    cout << fixed;
    cout.precision(1);

    cout << sum << ' ' << (double)sum / n;

    return 0;
}