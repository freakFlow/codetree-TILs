#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    int cnt = n;

    for(int i=0; i<2*n; i++){
        int iter = cnt;
        if(i % 2 == 1){
            iter = n - cnt + 1;
            cnt--;
        }

        for(int j=0; j<iter; j++){
            cout << "* ";
        }
        cout << endl;
    }

    return 0;
}