#include <iostream>
using namespace std;

int main() {
    int n;

    cin >> n;

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cout << i + 1 << " * " << j + 1 << " = " << (i + 1) * (j + 1);
            if(j < n-1) cout << ", ";
        }
        cout << endl;
    }

    return 0;
}