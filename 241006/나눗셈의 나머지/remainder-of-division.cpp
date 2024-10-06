#include <iostream>
using namespace std;

int main() {
    int count[9] = {};
    int a, b;

    cin >> a >> b;

    while(a > 1){
        count[a % b]++;
        a /= b;
    }

    int ans = 0;
    for(int i=0; i<b; i++){
        ans += count[i] * count[i];
    }

    cout << ans;

    return 0;
}