#include <iostream>
using namespace std;

int main() {
    int n;
    int count = 0;

    cin >> n;

    for(int i=1; i<=n; i++){
        if(i % 4 > 0) continue;
        if(i % 100 == 0 && i % 400 > 0) continue;

        count++;
    }

    cout << count;

    return 0;
}