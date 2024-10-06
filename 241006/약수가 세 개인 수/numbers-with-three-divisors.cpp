#include <iostream>
using namespace std;

int main() {
    int start, end;
    int ans = 0;

    cin >> start >> end;

    for(int i=start; i<=end; i++){
        int count = 0;
        for(int j=1; j<=i; j++){
            if(i % j == 0) count++;
        }

        if(count == 3) ans++;
    }

    cout << ans;

    return 0;
}