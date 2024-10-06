#include <iostream>
using namespace std;

int main() {
    int n, m;

    cin >> m;

    for(int i=0; i<m; i++){
        cin >> n;

        for(int j=0; ; j++){
            if(n == 1){
                cout << j << endl;
                break;
            }

            if(n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
        }
    }

    return 0;
}