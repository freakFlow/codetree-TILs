#include <iostream>
using namespace std;

int main() {
    int N;

    cin >> N;

    for(int i=1; ; i++){
        N /= 2;

        if(N == 1){
            cout << i;
            break;
        }
    }

    return 0;
}