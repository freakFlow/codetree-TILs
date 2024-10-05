#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    int cnt = 1;
    for(int i=0; i<2*n; i++){
        int iter = cnt;
        if(i % 2 == 1) iter = n - cnt + 1;

        for(int j=0; j<iter; j++){
            cout << "* ";
        }
        cout << endl;

        if(i % 2 == 1) cnt++;
    }

    return 0;
}