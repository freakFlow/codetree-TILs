#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    for(int i=1; i<=n; i++){
        int num = i;
        if(num % 3 == 0){
            cout << 0 << ' ';
            continue;
        }

        while(num > 0){
            int digit = num % 10;
            if(digit == 3 || digit == 6 || digit == 9){
                cout << 0 << ' ';
                break;
            }

            num /= 10;
        }

        if(num == 0) cout << i << ' ';
    }

    return 0;
}