#include <iostream>
using namespace std;

int main() {
    int n, a, b;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> a >> b;

        int mul = 1;
        for(int j=a; j<=b; j++){
            mul *= j;
        }
        cout << mul << endl;
    }
    
    return 0;
}