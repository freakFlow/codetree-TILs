#include <iostream>
using namespace std;

int main() {
    int n, m;
    int cnt = 0;

    cin >> n >> m;

    for(int i=0; i<n; i++){
        int num;
        cin >> num;
        if(num == m) cnt++;
    }

    cout << cnt;

    return 0;
}