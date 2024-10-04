#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    int cnt = 0;
    for(int i=0; i<2*n-1; i++){
        for(int j=0; j<cnt*2; j++){
            cout << ' ';
        }
        for(int j=0; j<2*(n-cnt)-1; j++){
            cout << "* ";
        }
        cout << endl;

        if(i >= n-1) cnt--;
        else cnt++;
    }

    return 0;
}