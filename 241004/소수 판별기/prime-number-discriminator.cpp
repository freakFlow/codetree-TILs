#include <iostream>
using namespace std;

int main() {
    int n;
    bool isP = true;

    cin >> n;

    for(int i=2; i<n; i++){
        if(n % i == 0){
            isP = false;
            break;
        }
    }

    cout << (isP ? "P" : "C");

    return 0;
}