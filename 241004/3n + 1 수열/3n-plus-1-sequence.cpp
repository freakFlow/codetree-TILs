#include <iostream>
using namespace std;

int main() {
    int N;

    cin >> N;

    for(int i=0; ; i++){
        if(N == 1){
            cout << i;
            break;
        }

        if(N % 2 == 0){
            N /= 2;
        }else{
            N = N * 3 + 1;
        }
    }
    
    return 0;
}