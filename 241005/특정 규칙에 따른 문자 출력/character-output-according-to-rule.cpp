#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    int cnt = 1;

    for(int i=0; i<2*n-1; i++){
        for(int j=0; j<n-i-1; j++){
            cout << "  ";
        }
        for(int j=0; j<cnt; j++){
            cout << "@ ";
        }
        cout << endl;

        if(i >= n-1) cnt--;
        else cnt++;
    }

    return 0;
}