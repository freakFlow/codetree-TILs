#include <iostream>
using namespace std;

int main() {
    int n;
    bool isC = false;

    cin >> n;

    for(int i=2; i<n; i++){
        if(n % i == 0){
            isC = true;
            break;
        }
    }

    cout << (isC ? "C" : "N");

    return 0;
}