#include <iostream>
using namespace std;

int main() {
    int n;
    int count = 0;

    cin >> n;

    for(int i=1; i<=n; i++){
        if(i % 2 == 0 || i % 3 == 0 || i % 5 == 0) continue;

        count++;
    }

    cout << count;

    return 0;
}